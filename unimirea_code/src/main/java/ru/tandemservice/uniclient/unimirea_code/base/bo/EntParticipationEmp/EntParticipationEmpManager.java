package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipationEmp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tandemframework.caf.bo.config.BusinessObjectManager;
import org.tandemframework.hibsupport.DataAccessServices;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic.EntParticipationDAO;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic.IEntParticipationDAO;
import ru.tandemservice.unictr.entity.contractor.Contractor;

/**
 * Created by ocean on 28.04.2016.
 */

@Configuration
public class EntParticipationEmpManager extends BusinessObjectManager {

    public static EntParticipationEmpManager instance(){
        //Singleton another
        return instance(EntParticipationEmpManager.class);
    }

    //Это зачем?
    public void method(Long customerId ){
        Contractor contractor = DataAccessServices.dao().get(Contractor.class , customerId);
        String lastname =  contractor.getLeader().getLastName();
    }

    @Bean
    public IEntParticipationDAO _entParticipationDAO()
    {
        return new EntParticipationDAO();
    }

}
