package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.AddEdit;

import org.tandemframework.caf.ui.UIPresenter;
import org.tandemframework.caf.ui.datasource.IUIDataSource;
import org.tandemframework.core.component.Bind;
import org.tandemframework.core.component.Input;
import org.tandemframework.hibsupport.DataAccessServices;
import org.tandemframework.hibsupport.dql.DQLSelectBuilder;
import org.tandemframework.hibsupport.entity.EntityHolder;
import org.tandemframework.shared.commonbase.base.util.DQLFullCheckSelectModel;
import org.tandemframework.shared.employeebase.base.entity.EmployeePost;
import org.tandemframework.shared.organization.base.entity.OrgUnit;
import org.tandemframework.tapsupport.component.selection.ISelectModel;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.EntParticipationManager;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit;

import static org.tandemframework.hibsupport.dql.DQLExpressions.property;

/**
 * Created by ocean on 05.11.2015.
 */

@Input({
        @Bind(key = "programId", binding = "programHolderId"),
        @Bind(key = "orgUnitId", binding = "orgUnitId")
})
public class EntParticipationAddEditUI extends UIPresenter
{
    public static final String UNIT ="unit";
    public static final String EMPLOYEE ="employee";

    private Long _programHolderId;
    private Long orgUnitId;

    private EntertainmentPrtcption _entertainmentPrtcption;
    private OrgUnit _orgUnit;

    @Override
    public void onComponentRefresh()
    {
        boolean isEdit = (null != _programHolderId);
        boolean isFilter = (null != orgUnitId) ;
        _entertainmentPrtcption = new EntertainmentPrtcption();
        _orgUnit = new OrgUnit();
        if (isFilter) {
            _orgUnit = DataAccessServices.dao().get(this.getOrgUnitId());
        }
        if (isEdit) {
            _entertainmentPrtcption = DataAccessServices.dao().get(this.getProgramHolderId());
        }
    }

    @Override
    public void onBeforeDataSourceFetch(IUIDataSource dataSource){
        super.onBeforeDataSourceFetch(dataSource);
        dataSource.put("orgUnitDS", this.getOrgUnit());
    }

    public void onClickApply()
    {
        EntParticipationManager.instance()._entParticipationDAO().saveOrUpdateEntParticipation(_entertainmentPrtcption);
        deactivate();
    }

    //getters and setters

    public EntertainmentPrtcption getEntertainmentPrtcption()
    {
        return _entertainmentPrtcption;
    }

    public void setEntertainmentPrtcption(EntertainmentPrtcption entertainmentPrtcption)
    {
        _entertainmentPrtcption = entertainmentPrtcption;
    }

    public Long getProgramHolderId() {
        return _programHolderId;
    }

    public void setProgramHolderId(Long _programHolderId) {
        this._programHolderId = _programHolderId;
    }

    public Long getOrgUnitId() {
        return orgUnitId;
    }

    public void setOrgUnitId(Long orgUnitId) {
        this.orgUnitId = orgUnitId;
    }

    public OrgUnit getOrgUnit() {
        return _orgUnit;
    }

    public void setOrgUnit(OrgUnit _orgUnit) {
        this._orgUnit = _orgUnit;
    }
}
