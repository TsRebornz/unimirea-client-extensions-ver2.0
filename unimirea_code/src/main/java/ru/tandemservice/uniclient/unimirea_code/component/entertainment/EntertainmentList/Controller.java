package ru.tandemservice.uniclient.unimirea_code.component.entertainment.EntertainmentList;

import org.tandemframework.core.component.ComponentActivator;
import org.tandemframework.core.component.IBusinessComponent;
import org.tandemframework.core.component.impl.AbstractBusinessController;
import org.tandemframework.core.util.ParametersMap;
import org.tandemframework.core.view.list.column.ActionColumn;
import org.tandemframework.core.view.list.column.SimpleColumn;
import org.tandemframework.core.view.list.source.DynamicListDataSource;
import org.tandemframework.core.view.list.source.IListDataSourceDelegate;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit;

/**
 * Created by ocean on 13.10.2015.
 */
public class Controller extends AbstractBusinessController<IDAO, Model>
{
    public void onClickAddEntertainment(IBusinessComponent component){
        component.createDefaultChildRegion(new ComponentActivator(ru.tandemservice.uniclient.unimirea_code.component.entertainment.EntertainmentAddEdit.Controller.class.getPackage().getName(), new ParametersMap().add("entertainmentTypeId", null)));
    }

    public void onClickDeleteEntertainment(IBusinessComponent component){
        getDao().delete((Long)component.getListenerParameter());
    }

    public void onClickEditEntertainment(IBusinessComponent component){
        component.createDefaultChildRegion(new ComponentActivator(ru.tandemservice.uniclient.unimirea_code.component.entertainment.EntertainmentAddEdit.Controller.class.getPackage().getName(), new ParametersMap().add("entertainmentTypeId", component.getListenerParameter())));
    }

    @Override
    public void onRefreshComponent(IBusinessComponent iBusinessComponent)
    {
        getDao().prepare(getModel(iBusinessComponent));
        prepareDataSource(iBusinessComponent);

    }
    public void prepareDataSource(IBusinessComponent component){
        final Model model = getModel(component);
        if (model.getDataSource() != null)
        {
            return;
        }

        DynamicListDataSource<EntertainmentTypeUnit> dataSource = new DynamicListDataSource<EntertainmentTypeUnit>(component, new IListDataSourceDelegate()
        {
            @Override
            public void updateListDataSource(IBusinessComponent component)
            {
                getDao().prepareListDataSource(model);
            }
        }, 30);

        dataSource.addColumn(new SimpleColumn("Наименование", EntertainmentTypeUnit.title().s()));
        dataSource.addColumn(new SimpleColumn("Тип", EntertainmentTypeUnit.type().title().s()).setClickable(false));
        dataSource.addColumn(new SimpleColumn("Дата проведения", EntertainmentTypeUnit.period().s()).setClickable(false).setOrderable(false));
        dataSource.addColumn(new SimpleColumn("Описание", EntertainmentTypeUnit.description().s()).setClickable(false).setOrderable(false));
        dataSource.addColumn(new ActionColumn("Редактировать", ActionColumn.EDIT, "onClickEditEntertainment").setPermissionKey("entertainmentEdit"));
        dataSource.addColumn(new ActionColumn("Удалить", ActionColumn.DELETE, "onClickDeleteEntertainment", "Удалить мероприятие?").setPermissionKey("entertainmentDelete"));
        model.setDataSource(dataSource);
    }
}
