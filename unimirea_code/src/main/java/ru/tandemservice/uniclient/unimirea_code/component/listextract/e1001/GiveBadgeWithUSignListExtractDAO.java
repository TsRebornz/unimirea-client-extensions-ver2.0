package ru.tandemservice.uniclient.unimirea_code.component.listextract.e1001;

import ru.tandemservice.movestudent.MoveStudentDefines;
import ru.tandemservice.movestudent.dao.MoveStudentDaoFacade;
import ru.tandemservice.uni.dao.UniBaseDao;
import ru.tandemservice.uni.entity.employee.OrderData;
import ru.tandemservice.uni.entity.employee.Student;
import ru.tandemservice.uniclient.unimirea_code.entity.GiveBadgeWithUSignListExtract;
import ru.tandemservice.unimove.dao.IExtractComponentDao;

import java.util.Map;

/**
 * Created by ocean on 26.04.2016.
 */
public class GiveBadgeWithUSignListExtractDAO extends UniBaseDao implements IExtractComponentDao<GiveBadgeWithUSignListExtract> {

    @Override
    public void doCommit(GiveBadgeWithUSignListExtract extract, Map parameters)
    {
        //save print form
        MoveStudentDaoFacade.getMoveStudentDao().saveListExtractText(extract, MoveStudentDefines.LIST_EXTRACT_TEXT_CODE);

        // заполняем номер и дату приказа
        if (null == extract.getParagraph() || null == extract.getParagraph().getOrder())
            return;
        Student student = extract.getEntity();
        OrderData orderData = get(OrderData.class, OrderData.L_STUDENT, student);
        if (null == orderData)
        {
            orderData = new OrderData();
            orderData.setStudent(student);
        } else
        {
            extract.setPrevOrderDate(orderData.getGraduateDiplomaOrderDate());
            extract.setPrevOrderNumber(orderData.getGraduateDiplomaOrderNumber());
        }
//        orderData.setGraduateDiplomaOrderDate(extract.getParagraph().getOrder().getCommitDate());
//        orderData.setGraduateDiplomaOrderNumber(extract.getParagraph().getOrder().getNumber());
        getSession().saveOrUpdate(orderData);
    }

    @Override
    public void doRollback(GiveBadgeWithUSignListExtract extract, Map parameters)
    {
        // возвращаем предыдущие номер и дату приказа
        Student student = extract.getEntity();
        OrderData orderData = get(OrderData.class, OrderData.L_STUDENT, student);
        if (null == orderData)
        {
            orderData = new OrderData();
            orderData.setStudent(student);
        }
//        orderData.setGraduateDiplomaOrderDate(extract.getPrevOrderDate());
//        orderData.setGraduateDiplomaOrderNumber(extract.getPrevOrderNumber());
        getSession().saveOrUpdate(orderData);
    }

}
