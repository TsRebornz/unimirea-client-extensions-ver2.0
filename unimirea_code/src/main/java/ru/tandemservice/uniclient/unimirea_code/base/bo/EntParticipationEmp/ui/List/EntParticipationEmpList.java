package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipationEmp.ui.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tandemframework.caf.logic.handler.IDefaultSearchDataSourceHandler;
import org.tandemframework.caf.ui.config.BusinessComponentManager;
import org.tandemframework.caf.ui.config.datasource.ColumnListExtPoint;
import org.tandemframework.caf.ui.config.presenter.PresenterExtPoint;
import org.tandemframework.common.CommonDefines;
import org.tandemframework.core.component.PublisherActivator;
import org.tandemframework.core.entity.IEntity;
import org.tandemframework.core.util.ParametersMap;
import org.tandemframework.core.view.formatter.FormattedMessage;
import org.tandemframework.core.view.list.column.IPublisherLinkResolver;
import org.tandemframework.hibsupport.dql.DQLSelectBuilder;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic.EntParticipationDSHandler;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.View.EntParticipationView;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.View.EntParticipationViewUI;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption;

/**
 * Created by ocean on 28.04.2016.
 */
@Configuration
public class EntParticipationEmpList extends BusinessComponentManager {

    public static final String SELECT_ENT_DS = "selectEntDS";

    @Bean
    @Override
    public PresenterExtPoint presenterExtPoint()
    {
        //Регистрируем data source типа searchListDS c именем SELECT_ENT_DS
        return presenterExtPointBuilder().addDataSource(searchListDS(SELECT_ENT_DS, selectEntDS(), this.entParticipationDSHandler())).create();
    }

    @Bean
    public IDefaultSearchDataSourceHandler entParticipationDSHandler()
    {
        return new EntParticipationDSHandler(this.getName());
    }


    @Bean
    public ColumnListExtPoint selectEntDS()
    {
        final String alias = "a";
        final DQLSelectBuilder entPart = new DQLSelectBuilder().fromEntity(EntertainmentPrtcption.class, alias);
        //Сюда пишем привязку из i18n.properties
        return columnListExtPointBuilder(SELECT_ENT_DS)
                /*.addColumn(publisherColumn("entertainmentTypeUnit", EntertainmentPrtcption.unit().titile().s())
                .order().create())*/
                //EntertainmentPrtcption.overseer().s())


                .addColumn(publisherColumn("title", EntertainmentPrtcption.P_FULL_ENTERTAINMENT_NAME).publisherLinkResolver(new IPublisherLinkResolver()
                {
                    @Override

                    public Object getParameters(IEntity entity)
                    {
                        EntertainmentPrtcption entPrtcption = (EntertainmentPrtcption) entity;
                        return new ParametersMap().add(PublisherActivator.PUBLISHER_ID_KEY, entPrtcption != null ? entPrtcption.getId().toString() : null).add(EntParticipationViewUI.PUBLISHER_ID, entPrtcption.getId().toString());
                    }

                    @Override
                    public String getComponentName(IEntity entity)
                    {
                        return EntParticipationView.class.getSimpleName();
                    }
                }).order().permissionKey("entertainmentEmpEdit").create())
                .addColumn(textColumn("overseer", (EntertainmentPrtcption.overseerAsString())).create())
                .addColumn(actionColumn(EDIT_COLUMN_NAME, CommonDefines.ICON_EDIT, EDIT_LISTENER).permissionKey("entertainmentEmpEdit"))
                .addColumn(actionColumn(DELETE_COLUMN_NAME, CommonDefines.ICON_DELETE, DELETE_LISTENER,

                        FormattedMessage.with().template("selectEntDS.delete.alert")
                                .parameter(EntertainmentPrtcption.P_FULL_ENTERTAINMENT_NAME)
                                .create()
                ).permissionKey("entertainmentEmpDelete"))

                .create() ;
    }

}
