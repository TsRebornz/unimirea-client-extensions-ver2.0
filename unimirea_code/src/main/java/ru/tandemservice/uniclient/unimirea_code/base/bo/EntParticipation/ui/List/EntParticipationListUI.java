package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.List;

import org.tandemframework.caf.ui.UIPresenter;
import org.tandemframework.caf.ui.datasource.IUIDataSource;
import org.tandemframework.core.component.Bind;
import org.tandemframework.core.component.State;
import org.tandemframework.core.entity.IEntity;
import org.tandemframework.core.sec.ISecured;
import org.tandemframework.hibsupport.DataAccessServices;
import org.tandemframework.shared.employeebase.base.entity.OrgUnitTypePostRelation;
import org.tandemframework.shared.organization.base.entity.OrgUnit;
import org.tandemframework.shared.organization.base.entity.TopOrgUnit;
import org.tandemframework.shared.organization.base.util.OrgUnitSecModel;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic.*;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.AddEdit.EntParticipationAddEdit;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipationEmp.EntParticipationEmpManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ocean on 14.10.2015.
 */


@State({
        @Bind(key = EntParticipationListUI.ORG_UNIT_ID, binding = "orgUnit.id")
})
public class EntParticipationListUI extends UIPresenter
{
    public static final String ORG_UNIT_ID = "orgUnitId";
    public static final String ENT_UNIT = "entUnit";
    public static final String WITH_SUCCESS_DS = "withSuccessDS";
    public static final String ORG_UNIT = "orgUnit";
    public static final String PROGRAM_SUBJECT_DS = "programSubjectDS";
    public static final String PROP_POST_LIST="postList";
    public static final String PAGE_SETTEING = "pageSettings";

    public List _postList;

    public List getPostList() {
        return _postList;
    }

    public void setPostList(List _postList) {
        this._postList = _postList;
    }

    ISecured _secObj = null;

    public ISecured getSecObj() {
        return _secObj;
    }

    public void setSecObj(ISecured secObj) {
        this._secObj = secObj;
    }

    private IEntParticipationSettings _pageSettings = null;

    public IEntParticipationSettings getPageSettings() {
        return _pageSettings;
    }

    public void setPageSettings(IEntParticipationSettings pageSettings) {
        this._pageSettings = pageSettings;
    }

    private OrgUnit _orgUnit = new OrgUnit();

    public OrgUnit getOrgUnit() {
        return _orgUnit;
    }

    public void setOrgUnit(OrgUnit _orgUnit) {
        this._orgUnit = _orgUnit;
    }

    private OrgUnitSecModel _secModel;
    public OrgUnitSecModel getSecModel(){ return _secModel; }


    @Override
    public void onComponentRefresh()
    {

        if (null != _orgUnit.getId()){
            IEntity entity  = DataAccessServices.dao().getNotNull(_orgUnit.getId());
            _orgUnit = (OrgUnit)entity;
            _secObj = (ISecured) _orgUnit;
            _secModel = new OrgUnitSecModel(_orgUnit);
            _pageSettings = new EntPartipationForOrgUnitSetttings(_secModel);
        }else{
            _secObj = this.getSecuredObject();
            _pageSettings = new EntParticipationForMenuSettings();
        }

    }

    @Override
    public void onBeforeDataSourceFetch(IUIDataSource dataSource)
    {
        if(dataSource.getName().equals(EntParticipationList.SELECT_ENT_DS) || (dataSource.getName().equals(EntParticipationList.POST_RELATION_DS) )){
            super.onBeforeDataSourceFetch(dataSource);
            dataSource.putAll(getSettings().getAsMap(EntParticipationDSHandler.LAST_NAME, EntParticipationDSHandler.FIRST_NAME, EntParticipationDSHandler.MID_NAME, EntParticipationDSHandler.TYPEUNIT));
            dataSource.put(PAGE_SETTEING, _pageSettings);
            dataSource.put(ORG_UNIT, _orgUnit);
            if (null != _orgUnit.getId()){
                dataSource.put(PROP_POST_LIST, _uiSettings.get(PROP_POST_LIST));
            }

        }
    }

    public void onClickAddEntParticipation() throws Throwable {
        _uiActivation.asDialog(EntParticipationAddEdit.class)
                .parameter("orgUnitId" , _orgUnit.getId())
                .activate();
    }

    public void onEditEntityFromList()
    {
        _uiActivation.asRegion(EntParticipationAddEdit.class)
                .parameter("programId",getListenerParameterAsLong())
                .parameter("orgUnitId",_orgUnit.getId())
                .activate();
    }

    public void onDeleteEntityFromList()
    {
        EntParticipationEmpManager.instance()._entParticipationDAO().deleteEntParticipation(getListenerParameterAsLong());
    }

}
