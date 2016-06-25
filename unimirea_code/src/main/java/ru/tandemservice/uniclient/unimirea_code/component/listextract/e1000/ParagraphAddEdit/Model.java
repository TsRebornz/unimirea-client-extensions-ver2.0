package ru.tandemservice.uniclient.unimirea_code.component.listextract.e1000.ParagraphAddEdit;

import org.tandemframework.tapsupport.component.selection.ISelectModel;
import ru.tandemservice.movestudent.component.listextract.abstractextract.ListParagraphAddEdit.AbstractListParagraphAddEditModel;
import ru.tandemservice.movestudent.utils.IGroupModel;
import ru.tandemservice.uni.entity.catalog.Course;
import ru.tandemservice.uni.entity.orgstruct.Group;
import ru.tandemservice.uniclient.unimirea_code.entity.GiveBadgeCommonListExtract;

/**
 * Created by ocean on 26.04.2016.
 */
public class Model extends AbstractListParagraphAddEditModel<GiveBadgeCommonListExtract> implements IGroupModel {

    private Course _course;
    private ISelectModel _groupListModel;
    private Group _group;

    public Course getCourse() {
        return _course;
    }

    public void setCourse(Course _course) {
        this._course = _course;
    }

    public ISelectModel getGroupListModel() {
        return _groupListModel;
    }

    public void setGroupListModel(ISelectModel _groupListModel) {
        this._groupListModel = _groupListModel;
    }

    public Group getGroup() {
        return _group;
    }

    public void setGroup(Group _group) {
        this._group = _group;
    }
}
