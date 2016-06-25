package ru.tandemservice.uniclient.unimirea_code.component.modularextract.e1000.AddEdit;

import org.tandemframework.shared.commonbase.base.bo.Declinable.logic.GrammaCase;
import ru.tandemservice.movestudent.component.modularextract.abstractextract.CommonModularStudentExtractAddEdit.CommonModularStudentExtractAddEditDAO;
import ru.tandemservice.movestudent.dao.MoveStudentDaoFacade;
import ru.tandemservice.uni.entity.catalog.DevelopPeriod;
import ru.tandemservice.uniclient.unimirea_code.entity.CostsChangesStuExtract;

/**
 * Created by ocean on 29.12.2015.
 */
public class DAO extends CommonModularStudentExtractAddEditDAO<CostsChangesStuExtract, Model> implements IDAO {
    @Override
    protected GrammaCase getStudentTitleCase() {
        return GrammaCase.ACCUSATIVE;
    }

    @Override
    protected CostsChangesStuExtract createNewInstance() {
        return new CostsChangesStuExtract();
    }

    public Model updateEduModel(Model model){
        if (model.isAddForm())
        {
            model.getEduModel().setCourse(model.getExtract().getEntity().getCourse());
            model.getEduModel().setGroup(model.getExtract().getEntity().getGroup());
            model.getEduModel().setCompensationType(model.getExtract().getEntity().getCompensationType());
            model.getEduModel().setFormativeOrgUnit(model.getExtract().getEntity().getEducationOrgUnit().getFormativeOrgUnit());
            model.getEduModel().setTerritorialOrgUnit(model.getExtract().getEntity().getEducationOrgUnit().getTerritorialOrgUnit());
            model.getEduModel().setEducationLevelsHighSchool(model.getExtract().getEntity().getEducationOrgUnit().getEducationLevelHighSchool());
            model.getEduModel().setDevelopForm(model.getExtract().getEntity().getEducationOrgUnit().getDevelopForm());
            model.getEduModel().setDevelopTech(model.getExtract().getEntity().getEducationOrgUnit().getDevelopTech());
            //Custom properties
            model.getEduModel().setDevelopCondition(model.getExtract().getEntity().getEducationOrgUnit().getDevelopCondition());
            DevelopPeriod devPeriod = model.getExtract().getEntity().getEducationOrgUnit().getDevelopPeriod();
            model.getEduModel().setDevelopPeriod(model.getExtract().getEntity().getEducationOrgUnit().getDevelopPeriod());

        }
        return model;
    }

    @Override
    public void prepare(Model model)
    {
        super.prepare(model);
        model.setEduModel(MoveStudentDaoFacade.getCommonExtractUtil().createEduModel(model.isAddForm(), model.getExtract(), true));
        updateEduModel(model);

    }

    @Override
    public void update(Model model){
        MoveStudentDaoFacade.getCommonExtractUtil().update(model.getEduModel(), model.getExtract());
        super.update(model);
    }
}
