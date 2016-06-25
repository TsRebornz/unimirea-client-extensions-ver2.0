package ru.tandemservice.uniclient.unimirea_code.base.ext.Employee.ui.PostView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tandemframework.caf.ui.config.BusinessComponentExtensionManager;
import org.tandemframework.caf.ui.config.presenter.PresenterExtension;
import org.tandemframework.caf.ui.config.tab.TabPanelExtPoint;
import org.tandemframework.caf.ui.config.tab.TabPanelExtension;
import org.tandemframework.shared.employeebase.base.bo.Employee.ui.PostView.EmployeePostView;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipationEmp.ui.List.EntParticipationEmpList;

/**
 * Created by ocean on 22.06.2016.
 */
@Configuration
public class EmployeePostViewExt extends BusinessComponentExtensionManager  {
    public static final String ADDON_NAME = "unimirea_code" + EmployeePostViewExtUI.class.getSimpleName();
    public static final String ENT_PARTICIPATION_EMP_TAB = "entertainmentParticipationEmployeeTab";
    @Autowired
    public EmployeePostView _employeePostView;

    @Bean
    public PresenterExtension presenterExtension(){
        return presenterExtensionBuilder(_employeePostView.presenterExtPoint())
                .addAddon(this.uiAddon(ADDON_NAME,EmployeePostViewExtUI.class))
                .create();
    }

    @Bean
    public TabPanelExtension tabPanelExtension() {
        return this.tabPanelExtensionBuilder( this._employeePostView.employeePostTabPanelExtPoint())
                .addTab(componentTab(ENT_PARTICIPATION_EMP_TAB,EntParticipationEmpList.class )
                        .parameters("mvel:['employeeId':presenter.employeePost.id]")
                        .permissionKey("entertainmentEmpView"))
                .create();
    }

}
