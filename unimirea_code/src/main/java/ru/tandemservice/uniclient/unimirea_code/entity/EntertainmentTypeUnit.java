package ru.tandemservice.uniclient.unimirea_code.entity;

import org.tandemframework.core.entity.dsl.EntityDSLSupport;
import org.tandemframework.core.view.formatter.DateFormatter;
import ru.tandemservice.uniclient.unimirea_code.entity.gen.*;

/** @see ru.tandemservice.uniclient.unimirea_code.entity.gen.EntertainmentTypeUnitGen */
public class EntertainmentTypeUnit extends EntertainmentTypeUnitGen
{

    public static final String P_PERIOD = "period";
    @EntityDSLSupport
    public String getPeriod(){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(DateFormatter.DEFAULT_DATE_FORMATTER.format(this.getDateBegin()));
        if (null != getDateEnd()){
            strBuilder.append("-");
            strBuilder.append(DateFormatter.DEFAULT_DATE_FORMATTER.format(this.getDateEnd()));
        }
        return strBuilder.toString();
    }

}