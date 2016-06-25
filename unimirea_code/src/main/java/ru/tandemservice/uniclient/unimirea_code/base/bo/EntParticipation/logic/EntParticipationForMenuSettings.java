package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic;

/**
 * Created by ocean on 19.05.2016.
 */
public class EntParticipationForMenuSettings implements IEntParticipationSettings {

    private boolean _postListIsVisible;
    private boolean _editDeleteColumnsIsVisible;

    private String _permissionView;
    private String _permissionAdd;
    private String _permissionEdit;
    private String _permissionDelete;

    public EntParticipationForMenuSettings() {
        this._postListIsVisible = false;
        this._editDeleteColumnsIsVisible = false;

        this._permissionEdit = "entertainmentEdit";
        this._permissionAdd = "entertainmentAdd";
        this._permissionView = "menuEntertainment";
        this._permissionDelete = "entertainmentDelete";
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
