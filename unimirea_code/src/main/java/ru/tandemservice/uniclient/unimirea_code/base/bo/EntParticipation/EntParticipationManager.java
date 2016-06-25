package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tandemframework.caf.bo.config.BusinessObjectManager;
import org.tandemframework.caf.logic.handler.IDefaultComboDataSourceHandler;
import org.tandemframework.caf.ui.datasource.UIDataSourceConfig;
import org.tandemframework.hibsupport.DataAccessServices;
import org.tandemframework.shared.employeebase.base.entity.EmployeePost;
import ru.tandemservice.uni.entity.catalog.Course;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic.EntParticipationDAO;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic.EntParticipationUnitHandler;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic.IEntParticipationDAO;
import ru.tandemservice.unictr.entity.contractor.Contractor;

/**
 * Created by ocean on 14.10.2015.
 */
@Configuration
public class EntParticipationManager extends BusinessObjectManager
{
    public static final String POST_DS = "postDS";


    public static EntParticipationManager instance(){
        // Singleton
        return instance(EntParticipationManager.class);
    }

    public void method(Long customerId ){
        Contractor contractor = DataAccessServices.dao().get(Contractor.class , customerId);
        String lastname =  contractor.getLeader().getLastName();
    }

    @Bean
    public IDefaultComboDataSourceHandler createUnitHandler()
    {
        return new EntParticipationUnitHandler(getName());
    }

    @Bean
    public IEntParticipationDAO _entParticipationDAO()
    {
        return new EntParticipationDAO();
    }


    @Bean
    public EntParticipationExcelReport _entParticipationExcelReport(){
        return new EntParticipationExcelReport();
    }

    @Bean
    public EntParticipationRtfReport _entParticipationRtfReport(){
        return new EntParticipationRtfReport();
    }

}
