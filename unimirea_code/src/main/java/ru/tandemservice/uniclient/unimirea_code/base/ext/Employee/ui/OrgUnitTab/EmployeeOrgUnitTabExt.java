package ru.tandemservice.uniclient.unimirea_code.base.ext.Employee.ui.OrgUnitTab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tandemframework.caf.ui.config.presenter.PresenterExtension;
import org.tandemframework.caf.ui.config.BusinessComponentExtensionManager;
import org.tandemframework.caf.ui.config.tab.TabPanelExtension;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.List.EntParticipationList;


/**
 * Created by ocean on 27.04.2016.
 */

@Configuration
public class EmployeeOrgUnitTabExt extends BusinessComponentExtensionManager {

    //Непонятно зачем unimirea_code+
    public static final String ADDON_NAME = "unimirea_code" + EmployeeOrgUnitTabExtUI.class.getSimpleName();
    public static final String ENT_PARTICIPATION_TAB = "entertainmentParticipationTab";

    @Autowired
    private org.tandemframework.shared.employeebase.base.bo.Employee.ui.OrgUnitTab.EmployeeOrgUnitTab _empOrgUnitTab;

    @Bean
    public PresenterExtension presenterExtension()
    {
        return presenterExtensionBuilder(_empOrgUnitTab.presenterExtPoint())
                .addAddon(uiAddon(ADDON_NAME,EmployeeOrgUnitTabExtUI.class))
                .create();
    }

    @Bean
    public TabPanelExtension tabPanelExtension()
    {
        //TODO Не забудь добавить права на вкладку тут типо того .permissionKey("ui:secModel.viewTabRestrictionAccessList")
        return tabPanelExtensionBuilder(_empOrgUnitTab.employeeTabPanelExtPoint())
                .addTab(componentTab(ENT_PARTICIPATION_TAB,EntParticipationList.class)
                .parameters("mvel:['orgUnitId':presenter.orgUnit.id]")
                .permissionKey("ui:secModel.orgUnit_viewEntParticipationTab"))
                .create();

    }

}
