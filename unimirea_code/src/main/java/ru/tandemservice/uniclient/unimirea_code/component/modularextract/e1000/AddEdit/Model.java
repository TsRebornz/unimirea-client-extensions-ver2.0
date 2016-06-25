package ru.tandemservice.uniclient.unimirea_code.component.modularextract.e1000.AddEdit;

import ru.tandemservice.movestudent.component.modularextract.CommonExtractModel;
import ru.tandemservice.movestudent.component.modularextract.abstractextract.CommonModularStudentExtractAddEdit.CommonModularStudentExtractAddEditModel;
import ru.tandemservice.uniclient.unimirea_code.entity.CostsChangesStuExtract;

/**
 * Created by ocean on 29.12.2015.
 */
public class Model extends CommonModularStudentExtractAddEditModel<CostsChangesStuExtract> {

    private CommonExtractModel _eduModel;
//    private ISelectModel _compensationTypeModel;
//    private CompensationType _compensationType;

    public CommonExtractModel getEduModel() {
        return _eduModel;
    }

    public void setEduModel(CommonExtractModel _eduModel) {
        this._eduModel = _eduModel;
    }

    /*
    public ISelectModel getCompensationTypeModel() {

        return _compensationTypeModel;
    }

    public void setCompensationTypeModel(ISelectModel _compensationTypeModel) {
        this._compensationTypeModel = _compensationTypeModel;
    }

    public CompensationType getCompensationType() {
        return _compensationType;
    }

    public void setCompensationType(CompensationType _compensationType) {
        this._compensationType = _compensationType;
    }
    */

}
