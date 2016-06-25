package ru.tandemservice.uniclient.unimirea_code.component.modularextract.e1000.AddEdit;

import org.tandemframework.core.component.IBusinessComponent;
import ru.tandemservice.movestudent.component.modularextract.abstractextract.CommonModularStudentExtractAddEdit.CommonModularStudentExtractAddEditController;
import ru.tandemservice.movestudent.dao.MoveStudentDaoFacade;
import ru.tandemservice.uniclient.unimirea_code.entity.CostsChangesStuExtract;

/**
 * Created by ocean on 29.12.2015.
 */
public class Controller extends CommonModularStudentExtractAddEditController<CostsChangesStuExtract, IDAO, Model> {
    public void onChangeGroup(IBusinessComponent component)
    {
        MoveStudentDaoFacade.getCommonExtractUtil().handleGroupChange(getModel(component).getEduModel());
    }
}
