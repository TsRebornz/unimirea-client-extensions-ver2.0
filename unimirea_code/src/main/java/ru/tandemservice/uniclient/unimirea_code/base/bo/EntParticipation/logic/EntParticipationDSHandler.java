package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic;

import org.apache.commons.lang.StringUtils;
import org.tandemframework.caf.command.io.DSInput;
import org.tandemframework.caf.command.io.DSOutput;
import org.tandemframework.caf.logic.ExecutionContext;
import org.tandemframework.caf.logic.datasource.output.DQLSelectOutputBuilder;
import org.tandemframework.caf.logic.handler.DefaultSearchDataSourceHandler;
import org.tandemframework.core.CoreStringUtils;
import org.tandemframework.core.entity.EntityOrder;
import org.tandemframework.core.entity.dsl.EntityPath;
import org.tandemframework.hibsupport.builder.OrderDescription;
import org.tandemframework.hibsupport.dql.DQLExpressions;
import org.tandemframework.hibsupport.dql.DQLOrderDescriptionRegistry;
import org.tandemframework.hibsupport.dql.DQLSelectBuilder;
import org.tandemframework.shared.employeebase.base.entity.EmployeePost;
import org.tandemframework.shared.organization.base.entity.OrgUnit;
import ru.tandemservice.uni.util.FilterUtils;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.List.EntParticipationList;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.List.EntParticipationListUI;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption;

import java.util.List;

import static org.tandemframework.hibsupport.dql.DQLExpressions.likeUpper;
import static org.tandemframework.hibsupport.dql.DQLExpressions.property;
import static org.tandemframework.hibsupport.dql.DQLExpressions.value;

/**
 * Created by ocean on 15.10.2015.
 */
public class EntParticipationDSHandler extends DefaultSearchDataSourceHandler
{
    public static final String TYPEUNIT = "entName";
    public static final String LAST_NAME = "lastName";
    public static final String FIRST_NAME = "firstName";
    public static final String MID_NAME = "midName";
    public static final Long POST_RELATION_ID = null;

    public EntParticipationDSHandler(String ownerId){
        super(ownerId);
    }

    protected DSOutput execute(DSInput input, ExecutionContext context) {

        String entTypeUnit = context.get(TYPEUNIT);
        String lastName = context.get(LAST_NAME);
        String firstName = context.get(FIRST_NAME);
        String midName = context.get(MID_NAME);
        OrgUnit orgUnit = context.get(EntParticipationListUI.ORG_UNIT);
        List postList = context.get(EntParticipationListUI.PROP_POST_LIST);

        String alias = "e";
        DQLSelectBuilder dql = new DQLSelectBuilder().fromEntity(EntertainmentPrtcption.class, alias);
        dql.column(DQLExpressions.property(alias));

        /*
            пример фильтра по входящим буквам и значениям
            builder.where(likeUpper(property(UniMireaPlace.title().fromAlias("pl")), value(CoreStringUtils.escapeLike((String)title))));
         */

        if(StringUtils.isNotEmpty(entTypeUnit)  ){
              dql.where(likeUpper(property(EntertainmentPrtcption.unit().title().fromAlias(alias)), value(CoreStringUtils.escapeLike(entTypeUnit))));

        }
        // At the Mountains of Madness
        if (null != orgUnit){
            if( null!= orgUnit.getId() ){
                dql.where(DQLExpressions.eq(DQLExpressions.property(alias, EntertainmentPrtcption.employee().orgUnit()), DQLExpressions.commonValue(orgUnit)));
            }
        }


        FilterUtils.applySimpleLikeFilter(dql, alias, EntertainmentPrtcption.employee().employee().person().identityCard().firstName() , firstName );
        FilterUtils.applySimpleLikeFilter(dql, alias, EntertainmentPrtcption.employee().employee().person().identityCard().middleName() , midName  );
        FilterUtils.applySimpleLikeFilter(dql, alias, EntertainmentPrtcption.employee().employee().person().identityCard().lastName() , lastName );

        if(null != postList && !postList.isEmpty()){
            dql.where(DQLExpressions.in(DQLExpressions.property(alias, EntertainmentPrtcption.employee().postRelation().s()),postList ));
        }

        // .order problem shit

        final EntityOrder entityOrder = input.getEntityOrder();
        DQLOrderDescriptionRegistry registry = new DQLOrderDescriptionRegistry(EntertainmentPrtcption.class,alias);
        OrderDescription entertainmetTitle = new OrderDescription(EntertainmentPrtcption.unit().title());
        OrderDescription entertainmetType = new OrderDescription(EntertainmentPrtcption.unit().type());
        OrderDescription employeeFirstName = new OrderDescription(EntertainmentPrtcption.employee().person().identityCard().firstName());
        OrderDescription employeeMidName = new OrderDescription(EntertainmentPrtcption.employee().person().identityCard().middleName());
        OrderDescription employeeLastName = new OrderDescription(EntertainmentPrtcption.employee().person().identityCard().lastName());

        registry.setOrders(EntertainmentPrtcption.P_FULL_ENTERTAINMENT_NAME ,entertainmetTitle,entertainmetType);
        registry.setOrders(EntertainmentPrtcption.employee().person().identityCard().fullFio(), employeeFirstName,employeeMidName,employeeLastName);

        registry.applyOrder(dql, entityOrder);

        DSOutput output = DQLSelectOutputBuilder.get(input, dql, this.getSession()).pageable(true).build();

        return output;
    }
}
