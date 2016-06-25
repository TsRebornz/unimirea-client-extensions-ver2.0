package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic;


import org.tandemframework.caf.logic.handler.DefaultComboDataSourceHandler;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit;


/**
 * Created by ocean on 01.06.2016.
 */
public class EntParticipationUnitHandler extends DefaultComboDataSourceHandler {


    public EntParticipationUnitHandler(String ownerId) {
        super(ownerId, EntertainmentTypeUnit.class );
    }


}
