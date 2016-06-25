package ru.tandemservice.uniclient.unimirea_code.sec;

import org.tandemframework.hibsupport.DataAccessServices;
import org.tandemframework.sec.ISecurityConfigMetaMapModifier;
import org.tandemframework.sec.meta.*;
import org.tandemframework.shared.commonbase.sec.PermissionMetaUtil;
import org.tandemframework.shared.organization.base.entity.OrgUnit;
import org.tandemframework.shared.organization.catalog.entity.OrgUnitType;

import java.util.List;
import java.util.Map;

/**
 * Created by ocean on 29.04.2016.
 */
public class Unimirea_codePermissionModifier implements ISecurityConfigMetaMapModifier {
    @Override
    public void modify(Map<String, SecurityConfigMeta> securityConfigMetaMap) {
        SecurityConfigMeta config = new SecurityConfigMeta();
        config.setModuleName("unimirea_code");
        config.setName("unimirea_code-sec-config");
        config.setTitle("");

        ModuleGlobalGroupMeta moduleGlobalGroupMeta = PermissionMetaUtil.createModuleGlobalGroup(config, "orgstructModuleGlobalGroup", "Модуль «Орг. структура»");
        ModuleLocalGroupMeta moduleLocalGroupMeta = PermissionMetaUtil.createModuleLocalGroup(config, "orgstructLocalGroup", "Модуль «Орг. структура»");

        List<OrgUnitType> orgUnitTypeList = DataAccessServices.dao().getList(OrgUnitType.class, OrgUnitType.P_TITLE);
        for (OrgUnitType description : orgUnitTypeList)
        {
            String code = description.getCode();

            ClassGroupMeta globalClassGroup = PermissionMetaUtil.createClassGroup(moduleGlobalGroupMeta, code + "PermissionClassGroup", "Объект «" + description.getTitle() + "»", OrgUnit.class.getName());
            ClassGroupMeta localClassGroup = PermissionMetaUtil.createClassGroup(moduleLocalGroupMeta, code + "LocalClassGroup", "Объект «" + description.getTitle() + "»", OrgUnit.class.getName());

            // "Вкладка «Кадры»" на подразделении
            PermissionGroupMeta permissionGroupEmployeeTab = PermissionMetaUtil.createPermissionGroup(config, code + "EmployeeTabAllPermissionGroup", "Вкладка «Кадры»");
            addTabPermission(config, globalClassGroup, localClassGroup, permissionGroupEmployeeTab);

            //Вкладка "Участие во внеучебных мероприятих"
            PermissionGroupMeta permissionGroupEntParticipation = PermissionMetaUtil.createPermissionGroup(permissionGroupEmployeeTab, code + "EntertainmentTabPermissionGroup", "Вкладка «Участие во внеучебных мероприятих»");
            PermissionMetaUtil.createPermission(permissionGroupEntParticipation, "orgUnit_viewEntParticipationTab_" + code, "Просмотр");
            PermissionMetaUtil.createPermission(permissionGroupEntParticipation, "orgUnit_deleteEntParticipation_" + code, "Удаление");
            PermissionMetaUtil.createPermission(permissionGroupEntParticipation, "orgUnit_editEntParticipation_" + code, "Редактирование");
            PermissionMetaUtil.createPermission(permissionGroupEntParticipation, "orgUnit_addEntParticipation_" + code, "Добавление");

        }
        securityConfigMetaMap.put(config.getName(), config);
    }

    private void addTabPermission(SecurityConfigMeta config, ClassGroupMeta globalClassGroup, ClassGroupMeta localClassGroup, PermissionGroupMeta tab)
    {
        PermissionMetaUtil.createGroupRelation(config, tab.getName(), globalClassGroup.getName());
        PermissionMetaUtil.createGroupRelation(config, tab.getName(), localClassGroup.getName());
    }
}
