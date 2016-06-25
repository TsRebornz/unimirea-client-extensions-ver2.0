package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic;

/**
 * Created by ocean on 19.05.2016.
 */
public interface IEntParticipationSettings {
    boolean getPostListIsVisible();
    boolean getEditDeleteColumnsIsVisible();

    String getPermissionView();
    String getPermissionAdd();
    String getPermissionEdit();
    String getPermissionDelete();
}


