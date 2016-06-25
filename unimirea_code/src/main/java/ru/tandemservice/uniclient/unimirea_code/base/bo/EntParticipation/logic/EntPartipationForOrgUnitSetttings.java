package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic;

import org.tandemframework.shared.organization.base.util.OrgUnitSecModel;

/**
 * Created by ocean on 19.05.2016.
 */
public class EntPartipationForOrgUnitSetttings implements IEntParticipationSettings {

    private boolean _postListIsVisible;
    private boolean _editDeleteColumnsIsVisible;

    private String _permissionView;
    private String _permissionAdd;
    private String _permissionEdit;
    private String _permissionDelete;


    public EntPartipationForOrgUnitSetttings(OrgUnitSecModel secModel) {
        this._postListIsVisible = true;
        this._editDeleteColumnsIsVisible = true;
        this._permissionView = secModel.getPermission("orgUnit_viewEntParticipationTab");
        this._permissionAdd = secModel.getPermission("orgUnit_addEntParticipation");
        this._permissionEdit = secModel.getPermission("orgUnit_editEntParticipation");
        this._permissionDelete = secModel.getPermission("orgUnit_deleteEntParticipation");
    }

    @Override
    public boolean getEditDeleteColumnsIsVisible() {
        return _editDeleteColumnsIsVisible;
    }

    @Override
    public boolean getPostListIsVisible() {
        return _postListIsVisible;
    }

    @Override
    public String getPermissionView() {
        return _permissionView;
    }

    @Override
    public String getPermissionAdd() {
        return _permissionAdd;
    }

    @Override
    public String getPermissionEdit() {
        return _permissionEdit;
    }

    @Override
    public String getPermissionDelete() {
        return _permissionDelete;
    }
}
