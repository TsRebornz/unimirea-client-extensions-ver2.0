package ru.tandemservice.uniclient.unimirea_code.component.listextract.e1001.ParagraphAddEdit;

import org.tandemframework.hibsupport.builder.MQBuilder;
import org.tandemframework.hibsupport.builder.expression.MQExpression;
import ru.tandemservice.movestudent.component.listextract.abstractextract.ListParagraphAddEdit.AbstractListParagraphAddEditDAO;
import ru.tandemservice.movestudent.utils.GroupSelectModel;
import ru.tandemservice.uni.entity.employee.Student;
import ru.tandemservice.uniclient.unimirea_code.entity.GiveBadgeWithUSignListExtract;

/**
 * Created by ocean on 26.04.2016.
 */
public class DAO extends AbstractListParagraphAddEditDAO<GiveBadgeWithUSignListExtract, Model> implements IDAO {

    @Override
    public void prepare(Model model)
    {
        super.prepare(model);
        model.setGroupListModel(new GroupSelectModel(model, model.getParagraph().getOrder().getOrgUnit()));

        // заполняем поля по умолчанию
        if (model.getParagraphId() != null)
        {
            GiveBadgeWithUSignListExtract extract = model.getFirstExtract();
            extract.setCourseStr(model.getCourse().toString());
            extract.setGroupStr(model.getGroup().toString());
        }
    }

    @Override
    protected void patchListDataSource(MQBuilder builder, Model model)
    {
        builder.add(MQExpression.eq(STUDENT_ALIAS, Student.L_GROUP, model.getGroup()));
    }

    @Override
    protected GiveBadgeWithUSignListExtract createNewInstance(Model model) {
        return new GiveBadgeWithUSignListExtract();
    }

    @Override
    protected void fillExtract(GiveBadgeWithUSignListExtract extract, Student student, Model model) {
        extract.setCourseStr(student.getCourse().toString());
        extract.setGroupStr(student.getGroup().toString());
        extract.setEducationLevelHighSchoolStr(student.getGroup().getEducationOrgUnit().getEducationLevelHighSchool().getConfigurableTitle());
        extract.setFormativeOrgUnitStr(student.getGroup().getEducationOrgUnit().getFormativeOrgUnit().getFullTitle());
        extract.setTerritorialOrgUnitStr(student.getGroup().getEducationOrgUnit().getTerritorialOrgUnit().getTerritorialFullTitle());
    }


}
