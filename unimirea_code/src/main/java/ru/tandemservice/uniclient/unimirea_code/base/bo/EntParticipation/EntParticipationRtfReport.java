package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.tandemframework.hibsupport.DataAccessServices;
import org.tandemframework.hibsupport.dao.ICommonDAO;
import org.tandemframework.rtf.document.RtfDocument;
import org.tandemframework.rtf.io.RtfReader;
import org.tandemframework.rtf.modifiers.RtfTableModifier;
import org.tandemframework.shared.employeebase.catalog.entity.EmployeeRosterTemplateDocument;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption;
import ru.tandemservice.uniclient.unimirea_code.entity.catalog.RtfReportTemplate;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by ocean on 11.11.2015.
 */
public class EntParticipationRtfReport
{
    protected final Log logger = LogFactory.getLog(getClass());

    private final String templatePath = "C:\\TandemWS\\mirea\\unimirea_210r1\\unimirea\\unimirea_code\\src\\main\\resources\\unimirea_code\\templates\\EntertainmentParticipation.rtf";

    public RtfDocument initRtfDocument(){
        //templatePath = File.

        ICommonDAO dao = DataAccessServices.dao();
        String path = getPathToTemplate();
        //RtfDocument document = new RtfDocument();
        RtfDocument document = new RtfReader().read(dao.getByCode(RtfReportTemplate.class,"unimireaEntertainmentReport").getContent());
        if(null== document){
            try{
                document = new RtfReader().read(templatePath);
            }catch (Exception ex){
                logger.warn("Problems with loading template by path "+templatePath+" " + ex.getMessage());
            }
        }
        List<EntertainmentPrtcption> list = DataAccessServices.dao().getList(EntertainmentPrtcption.class);
        RtfTableModifier tableModifier = new RtfTableModifier();
        tableModifier.put("T", getEntParticipationTableData(list));
        tableModifier.modify(document);

        return document;
    }

    public String[][] getEntParticipationTableData(List<EntertainmentPrtcption> list){
        List<String[]> lines = new ArrayList<>();
        Iterator<EntertainmentPrtcption> entityListIterator = list.iterator();
        while(entityListIterator.hasNext()){
            EntertainmentPrtcption entPart = entityListIterator.next();
            List<String> cells = new ArrayList<>();
            cells.add(entPart.getUnit().getTitle());
            cells.add(entPart.getUnit().getDateBegin().toString());
            if (null != entPart.getUnit().getDateEnd()){
                cells.add(entPart.getUnit().getDateEnd().toString());
            }else{
                cells.add("-");
            }
            cells.add(entPart.getEmployee().getEmployee().getFullFio());
            cells.add(entPart.getOverseerAsString());
            lines.add(cells.toArray(new String[cells.size()]));
        }
        return lines.toArray(new String[lines.size()][6]);
    }

    public String getAbsolutePath(){
        File file = new File("");   //Dummy file
        String  abspath=file.getAbsolutePath();
        return abspath;
    }

    public String getPathToTemplate(){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(getAbsolutePath());
        return strBuilder.toString();
    }


}
