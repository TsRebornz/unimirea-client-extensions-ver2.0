package ru.tandemservice.uniclient.unimirea_code.component.modularextract.e1000;

import ru.tandemservice.movestudent.MoveStudentDefines;
import ru.tandemservice.movestudent.dao.MoveStudentDaoFacade;
import ru.tandemservice.uni.dao.UniBaseDao;
import ru.tandemservice.uni.entity.employee.OrderData;
import ru.tandemservice.uni.entity.employee.Student;
import ru.tandemservice.uniclient.unimirea_code.entity.CostsChangesStuExtract;
import ru.tandemservice.unimove.dao.IExtractComponentDao;

import java.util.Map;

/**
 * Created by ocean on 18.01.2016.
 */
public class CostsChangesStuExtractDAO extends UniBaseDao implements IExtractComponentDao<CostsChangesStuExtract> {

    @Override
    public void doCommit(CostsChangesStuExtract costsChangesStuExtract, Map map) {
        //save print form
        MoveStudentDaoFacade.getMoveStudentDao().saveModularExtractText(costsChangesStuExtract, MoveStudentDefines.EXTRACT_TEXT_CODE);

        MoveStudentDaoFacade.getCommonExtractUtil().doCommitWithoutChangeStatus(costsChangesStuExtract);

        // заполняем номер и дату приказа
        if (null == costsChangesStuExtract.getParagraph() || null == costsChangesStuExtract.getParagraph().getOrder())
            return;
        Student student = costsChangesStuExtract.getEntity();
        OrderData orderData = get(OrderData.class, OrderData.L_STUDENT, student);
        if (null == orderData)
        {
            orderData = new OrderData();
            orderData.setStudent(student);
        } else
        {
            costsChangesStuExtract.setPrevOrderDate(orderData.getTransferOrderDate());
            costsChangesStuExtract.setPrevOrderNumber(orderData.getTransferOrderNumber());
        }
        orderData.setTransferOrderDate(costsChangesStuExtract.getParagraph().getOrder().getCommitDate());
        orderData.setTransferOrderNumber(costsChangesStuExtract.getParagraph().getOrder().getNumber());
        getSession().saveOrUpdate(orderData);


    }

    @Override
    public void doRollback(CostsChangesStuExtract costsChangesStuExtract, Map map) {
        MoveStudentDaoFacade.getCommonExtractUtil().doRollbackWithoutChangeStatus(costsChangesStuExtract);

        // возвращаем предыдущие номер и дату приказа
        Student student = costsChangesStuExtract.getEntity();
        OrderData orderData = get(OrderData.class, OrderData.L_STUDENT, student);
        if (null == orderData)
        {
            orderData = new OrderData();
            orderData.setStudent(student);
        }
        orderData.setTransferOrderDate(costsChangesStuExtract.getPrevOrderDate());
        orderData.setTransferOrderNumber(costsChangesStuExtract.getPrevOrderNumber());
        //MoveStudentDaoFacade.getCommonExtractUtil().doRollbackWithoutChangeStatus(costsChangesStuExtract);
        getSession().saveOrUpdate(orderData);
    }
}
