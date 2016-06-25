package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.AddEdit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tandemframework.caf.logic.ExecutionContext;
import org.tandemframework.caf.logic.handler.IDefaultComboDataSourceHandler;
import org.tandemframework.caf.ui.config.BusinessComponentManager;
import org.tandemframework.caf.ui.config.presenter.PresenterExtPoint;
import org.tandemframework.hibsupport.dql.DQLExpressions;
import org.tandemframework.hibsupport.dql.DQLJoinType;
import org.tandemframework.hibsupport.dql.DQLSelectBuilder;
import org.tandemframework.hibsupport.entity.EntityHolder;
import org.tandemframework.shared.commonbase.base.util.DQLFullCheckSelectModel;
import org.tandemframework.shared.commonbase.base.util.ui.EntityComboDataSourceHandler;
import org.tandemframework.shared.employeebase.base.entity.Employee;
import org.tandemframework.shared.employeebase.base.entity.EmployeePost;
import org.tandemframework.shared.organization.base.entity.OrgUnit;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.EntParticipationManager;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit;

/**
 * Created by ocean on 05.11.2015.
 */
@Configuration
public class EntParticipationAddEdit extends BusinessComponentManager
{
    public static final String UNIT_DS ="unitDS";
    public static final String EMPLOYEE_DS ="employeeDS";


    @Override
    @Bean
    public PresenterExtPoint presenterExtPoint()
    {
        return presenterExtPointBuilder()
                .addDataSource(selectDS(UNIT_DS, EntParticipationManager.instance().createUnitHandler() ).addColumn(EntertainmentTypeUnit.title().s()    )   )
                .addDataSource(this.selectDS(EMPLOYEE_DS, this.employeeDSHandler()  ).addColumn(EmployeePost.fullTitle().s()    )   )
                .create();
    }

    @Bean
    public IDefaultComboDataSourceHandler employeeDSHandler(){
        return (new EntityComboDataSourceHandler(this.getName(),EmployeePost.class){
            protected void applyWhereConditions(String alias, DQLSelectBuilder dql, ExecutionContext context) {
                super.applyWhereConditions(alias,dql,context);
                OrgUnit orgUnit = context.get("orgUnitDS");
                if (null != orgUnit.getId()){
                    dql.where(DQLExpressions.eq(DQLExpressions.property(alias,EmployeePost.orgUnit()),DQLExpressions.commonValue(context.get("orgUnitDS"))));
                }else{
                    dql.where(
                            like(EmployeePost.person().identityCard().fullFio().fromAlias(alias), "")
                    );
                }
            }
        }).order(EmployeePost.person().identityCard().fullFio());
    }
}
