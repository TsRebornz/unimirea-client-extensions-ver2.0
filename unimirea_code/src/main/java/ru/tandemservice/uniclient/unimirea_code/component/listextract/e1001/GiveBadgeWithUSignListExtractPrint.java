package ru.tandemservice.uniclient.unimirea_code.component.listextract.e1001;

import org.tandemframework.rtf.document.RtfDocument;
import org.tandemframework.rtf.io.RtfReader;
import org.tandemframework.rtf.modifiers.RtfInjectModifier;
import org.tandemframework.rtf.modifiers.RtfTableModifier;
import org.tandemframework.shared.commonbase.base.util.IPrintFormCreator;
import ru.tandemservice.movestudent.component.listextract.CommonListExtractPrint;
import ru.tandemservice.movestudent.component.listextract.CommonListOrderPrint;
import ru.tandemservice.movestudent.component.listextract.IListParagraphPrintFormCreator;
import ru.tandemservice.movestudent.component.listextract.IStudentListParagraphPrintFormatter;
import ru.tandemservice.movestudent.component.modularextract.CommonExtractPrint;
import ru.tandemservice.uni.entity.employee.Student;
import ru.tandemservice.uniclient.unimirea_code.entity.GiveBadgeWithUSignListExtract;
import ru.tandemservice.unimove.IAbstractOrder;
import ru.tandemservice.unimove.IAbstractParagraph;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ocean on 26.04.2016.
 */
public class GiveBadgeWithUSignListExtractPrint implements IPrintFormCreator<GiveBadgeWithUSignListExtract>, IListParagraphPrintFormCreator<GiveBadgeWithUSignListExtract>,IStudentListParagraphPrintFormatter {
    @Override
    public void modifyOrderTemplate(RtfInjectModifier modifier, IAbstractOrder order, GiveBadgeWithUSignListExtract firstExtract) {

    }

    @Override
    public RtfInjectModifier createParagraphInjectModifier(IAbstractParagraph<? extends IAbstractOrder> paragraph, GiveBadgeWithUSignListExtract firstExtract) {
        return CommonListOrderPrint.createListOrderParagraphInjectModifier(paragraph, firstExtract);
    }

    @Override
    public RtfTableModifier createParagraphTableModifier(IAbstractParagraph<? extends IAbstractOrder> paragraph, GiveBadgeWithUSignListExtract firstExtract) {
        return null;
    }

    @Override
    public RtfDocument createPrintForm(byte[] template, GiveBadgeWithUSignListExtract extract) {
        final RtfDocument document = new RtfReader().read(template);
        RtfInjectModifier modifier = createParagraphInjectModifier(extract.getParagraph(), extract);
        CommonListExtractPrint.injectCommonListExtractData(modifier, extract);
        modifier.modify(document);
        CommonExtractPrint.createFefuVisasTableModifier(extract).modify(document);
        return document;
    }

    @Override
    public String formatSingleStudent(Student student, int extractNumber) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("\\par ").append(extractNumber).append(".  ");
        buffer.append(student.getPerson().getFullFio());
        int birDateYear = (DateToCalendar(student.getPerson().getIdentityCard().getBirthDate())).get(Calendar.YEAR);
        buffer.append("(").append(birDateYear).append(" г.р)");
        return buffer.toString();
    }

    public static Calendar DateToCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
}
