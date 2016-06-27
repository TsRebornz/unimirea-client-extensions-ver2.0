package ru.tandemservice.uniclient.unimirea_code.component.modularextract.e1000.AddEdit;

import ru.tandemservice.movestudent.component.modularextract.CommonExtractModel;
import ru.tandemservice.movestudent.component.modularextract.abstractextract.CommonModularStudentExtractAddEdit.CommonModularStudentExtractAddEditModel;
import ru.tandemservice.uniclient.unimirea_code.entity.CostsChangesStuExtract;

/**
 * Created by ocean on 29.12.2015.
 */
public class Model extends CommonModularStudentExtractAddEditModel<CostsChangesStuExtract> {

    private CommonExtractModel _eduModel;

    public CommonExtractModel getEduModel() {
        return _eduModel;
    }

    public void setEduModel(CommonExtractModel _eduModel) {
        this._eduModel = _eduModel;
    }

}
