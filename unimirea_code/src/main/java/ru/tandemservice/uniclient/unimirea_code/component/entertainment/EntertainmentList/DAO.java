package ru.tandemservice.uniclient.unimirea_code.component.entertainment.EntertainmentList;


import org.tandemframework.core.view.list.source.DynamicListDataSource;
import org.tandemframework.hibsupport.DataAccessServices;
import org.tandemframework.hibsupport.builder.MQBuilder;
import org.tandemframework.hibsupport.builder.OrderDescription;
import org.tandemframework.hibsupport.builder.OrderDescriptionRegistry;
import org.tandemframework.hibsupport.dql.DQLExpressions;
import org.tandemframework.hibsupport.dql.DQLSelectBuilder;
import org.tandemframework.hibsupport.dql.util.DQLSelectColumnNumerator;
import org.tandemframework.shared.commonbase.base.util.CommonBaseSearchListUtil;
import ru.tandemservice.uni.dao.UniDao;
import ru.tandemservice.uni.entity.employee.Student;
import ru.tandemservice.unibase.UniBaseUtils;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit;
import ru.tandemservice.uniclient.unimirea_code.entity.catalog.EntertainmentType;

import java.util.List;

/**
 * Created by ocean on 13.10.2015.
 */
public class DAO extends UniDao<Model> implements IDAO
{
    @Override
    public void prepareListDataSource(Model model)
    {
        DynamicListDataSource<EntertainmentTypeUnit> dataSource = model.getDataSource();
        MQBuilder builder = new MQBuilder(EntertainmentTypeUnit.ENTITY_CLASS, "e");
        OrderDescriptionRegistry _orderSettings = new OrderDescriptionRegistry("e");
        _orderSettings.applyOrder(builder,dataSource.getEntityOrder());
        CommonBaseSearchListUtil.createPage(dataSource, builder);
    }

}
