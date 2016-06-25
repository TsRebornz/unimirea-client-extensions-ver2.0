package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipationEmp.ui.List;

import org.tandemframework.caf.ui.UIPresenter;
import org.tandemframework.caf.ui.datasource.IUIDataSource;
import org.tandemframework.core.component.Bind;
import org.tandemframework.core.component.State;
import org.tandemframework.hibsupport.DataAccessServices;
import org.tandemframework.shared.commonbase.base.util.Zlo;
import org.tandemframework.shared.employeebase.base.entity.Employee;
import org.tandemframework.shared.employeebase.base.entity.EmployeePost;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic.EntParticipationDSHandler;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.AddEdit.EntParticipationAddEdit;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipationEmp.EntParticipationEmpManager;

/**
 * Created by ocean on 28.04.2016.
 */

@State({
        @Bind(key = "employeeId", binding = "employeeID")
})
public class EntParticipationEmpListUI extends UIPresenter {

    public static final String ENT_UNIT = "entUnit";
    public static final String WITH_SUCCESS_DS = "withSuccessDS";
    public static final String ORG_UNIT_DS = "orgUnitDS";
    public static final String PROGRAM_SUBJECT_DS = "programSubjectDS";
    private Long _employeeID;


    @Override
    public void onComponentRefresh()
    {
        if (null != _employeeID) {
            EmployeePost employeePost = DataAccessServices.dao().get(getEmployeeID());
            getSettings().set(EntParticipationDSHandler.FIRST_NAME , employeePost.getPerson().getIdentityCard().getFirstName());
            getSettings().set(EntParticipationDSHandler.LAST_NAME , employeePost.getPerson().getIdentityCard().getLastName());
            //employee.get
        }

        super.onComponentRefresh();
    }

    @Override
    public void onBeforeDataSourceFetch(IUIDataSource dataSource)
    {
        if(dataSource.getName().equals(EntParticipationEmpList.SELECT_ENT_DS)){
            super.onBeforeDataSourceFetch(dataSource);
            dataSource.putAll(getSettings().getAsMap(EntParticipationDSHandler.LAST_NAME, EntParticipationDSHandler.FIRST_NAME, EntParticipationDSHandler.MID_NAME, EntParticipationDSHandler.TYPEUNIT));
        }
    }

    public void onEditEntityFromList()
    {

        _uiActivation.asRegion(EntParticipationAddEdit.class)
                .parameter("programId",getListenerParameterAsLong())
                .activate();

    }

    public void onDeleteEntityFromList()
    {
        EntParticipationEmpManager.instance()._entParticipationDAO().deleteEntParticipation(getListenerParameterAsLong());
    }


    public Long getEmployeeID() {
        return _employeeID;
    }

    public void setEmployeeID(Long _employeeID) {
        this._employeeID = _employeeID;
    }
}
