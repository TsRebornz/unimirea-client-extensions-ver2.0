package ru.tandemservice.uniclient.unimirea_code.component.listextract.e1000.ParagraphAddEdit;

import org.tandemframework.core.component.IBusinessComponent;
import org.tandemframework.core.entity.OrderDirection;
import org.tandemframework.core.view.formatter.NoWrapFormatter;
import org.tandemframework.core.view.formatter.SimpleFormatter;
import org.tandemframework.core.view.list.column.SimpleColumn;
import org.tandemframework.core.view.list.source.DynamicListDataSource;
import ru.tandemservice.movestudent.component.listextract.abstractextract.ListParagraphAddEdit.AbstractListParagraphAddEditController;
import ru.tandemservice.uni.entity.employee.Student;
import ru.tandemservice.uni.ui.formatters.StudentCustomStateCollectionFormatter;
import ru.tandemservice.uniclient.unimirea_code.entity.GiveBadgeCommonListExtract;

/**
 * Created by ocean on 26.04.2016.
 */
public class Controller extends AbstractListParagraphAddEditController<GiveBadgeCommonListExtract, IDAO, Model> {
    @Override
    protected void prepareListDataSource(IBusinessComponent component, DynamicListDataSource<Student> dataSource)
    {
        dataSource.addColumn(new SimpleColumn("ФИО студента", Student.FIO_KEY, NoWrapFormatter.INSTANCE).setClickable(false));
        dataSource.addColumn(new SimpleColumn("Дополнительный статус", ru.tandemservice.movestudent.component.listextract.e5.ParagraphAddEdit.Model.P_STUDENT_ACTIVE_CUSTOME_STATES, new StudentCustomStateCollectionFormatter()).setClickable(false).setOrderable(false));
        dataSource.addColumn(new SimpleColumn("Пол", Student.person().identityCard().sex().shortTitle().s()).setClickable(false).setOrderable(false));
        dataSource.addColumn(new SimpleColumn("status", "Состояние", ru.tandemservice.movestudent.component.listextract.e6.ParagraphAddEdit.Model.STATUS_KEY, SimpleFormatter.INSTANCE).setClickable(false));
        dataSource.addColumn(new SimpleColumn("Курс", Student.course().title().s()).setClickable(false));
        dataSource.addColumn(new SimpleColumn("Контракт", Student.compensationType().shortTitle().s()).setClickable(false).setOrderable(false));
        dataSource.addColumn(new SimpleColumn(EDU_LVL_HS_COLUMN_TITLE, Student.educationOrgUnit().educationLevelHighSchool().configurableTitle().s()).setClickable(false));
        dataSource.setOrder("status", OrderDirection.asc);
    }
}
