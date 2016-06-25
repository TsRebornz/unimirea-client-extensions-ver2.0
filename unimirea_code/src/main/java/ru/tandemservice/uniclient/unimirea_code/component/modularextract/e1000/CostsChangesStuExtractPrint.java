package ru.tandemservice.uniclient.unimirea_code.component.modularextract.e1000;

import org.tandemframework.core.view.formatter.DateFormatter;
import org.tandemframework.rtf.document.RtfDocument;
import org.tandemframework.rtf.io.RtfReader;
import org.tandemframework.rtf.modifiers.RtfInjectModifier;
import org.tandemframework.shared.commonbase.base.util.IPrintFormCreator;
import ru.tandemservice.movestudent.component.modularextract.CommonExtractPrint;
import ru.tandemservice.movestudent.dao.MoveStudentDaoFacade;
import ru.tandemservice.movestudent.entity.TransferDevCondExtStuExtract;
import ru.tandemservice.uni.UniDefines;
import ru.tandemservice.uni.entity.catalog.Qualifications;
import ru.tandemservice.uni.entity.catalog.codes.QualificationsCodes;
import ru.tandemservice.uni.util.rtf.UniRtfUtil;
import ru.tandemservice.uniclient.unimirea_code.entity.CostsChangesStuExtract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ocean on 18.01.2016.
 */
public class CostsChangesStuExtractPrint implements IPrintFormCreator<CostsChangesStuExtract> {

    private static final Map<String, String[]> DEVELOP_CONDITION_MALE_SEX_CASES_ARRAY = new HashMap<>();
    private static final Map<String, String[]> DEVELOP_CONDITION_FEMALE_SEX_CASES_ARRAY = new HashMap<>();
    private static final List<String> SPEC_QUALIFICATION_CODES = new ArrayList<>();

    static
    {
        SPEC_QUALIFICATION_CODES.add(QualificationsCodes.SPETSIALIST);
        SPEC_QUALIFICATION_CODES.add(QualificationsCodes.BAZOVYY_UROVEN_S_P_O);
        SPEC_QUALIFICATION_CODES.add(QualificationsCodes.POVYSHENNYY_UROVEN_S_P_O);
        DEVELOP_CONDITION_MALE_SEX_CASES_ARRAY.put(UniDefines.DEVELOP_CONDITION_FULL_TIME, new String[]{"полный", "полного", "полному", "полный", "полным", "полном"});
        DEVELOP_CONDITION_MALE_SEX_CASES_ARRAY.put(UniDefines.DEVELOP_CONDITION_SHORT, new String[]{"сокращенный", "сокращенного", "сокращенному", "сокращенный", "сокращенным", "сокращенном"});
        DEVELOP_CONDITION_MALE_SEX_CASES_ARRAY.put(UniDefines.DEVELOP_CONDITION_FAST, new String[]{"ускоренный", "ускоренного", "ускоренному", "ускоренный", "ускоренным", "ускоренном"});
        DEVELOP_CONDITION_MALE_SEX_CASES_ARRAY.put(UniDefines.DEVELOP_CONDITION_SHORT_FAST, new String[]{"сокращенный ускоренный", "сокращенного ускоренного", "сокращенному ускоренному", "сокращенный ускоренный", "сокращенным ускоренным", "сокращенном ускоренном"});
        DEVELOP_CONDITION_FEMALE_SEX_CASES_ARRAY.put(UniDefines.DEVELOP_CONDITION_FULL_TIME, new String[]{"полная", "полной", "полной", "полную", "полной", "полной"});
        DEVELOP_CONDITION_FEMALE_SEX_CASES_ARRAY.put(UniDefines.DEVELOP_CONDITION_SHORT, new String[]{"сокращенная", "сокращенной", "сокращенной", "сокращенную", "сокращенной", "сокращенной"});
        DEVELOP_CONDITION_FEMALE_SEX_CASES_ARRAY.put(UniDefines.DEVELOP_CONDITION_FAST, new String[]{"ускоренная", "ускоренной", "ускоренной", "ускоренную", "ускоренной", "ускоренной"});
        DEVELOP_CONDITION_FEMALE_SEX_CASES_ARRAY.put(UniDefines.DEVELOP_CONDITION_SHORT_FAST, new String[]{"сокращенная ускоренная", "сокращенной ускоренной", "сокращенной ускоренной", "сокращенную ускоренную", "сокращенной ускоренной", "сокращенной ускоренной"});
    }

    @Override
    public RtfDocument createPrintForm(byte[] template, CostsChangesStuExtract extract) {
        //Создаем документ по шаблону
        final RtfDocument document = new RtfReader().read(template);

        /*
            Создаем инстанс в котором уже большая часть меток заполнена.
            Далее мы добавляем в этот инстанс логику заполнения своих меток, с помощью метода .put("название метки","текст")
            Весьма мощный инструмент, который проделывает большую часть работы, знать бы только  метки , которые он использует
         */
        RtfInjectModifier modifier = CommonExtractPrint.createModularExtractInjectModifier(extract);

        Qualifications qualification = MoveStudentDaoFacade.getCommonExtractUtil().getQualification(extract.getEntity().getEducationOrgUnit().getEducationLevelHighSchool().getEducationLevel());

        if (null != qualification && SPEC_QUALIFICATION_CODES.contains(qualification.getCode()))
        {
            modifier.put("eduLevelTextAlt", "вышеуказанной специальности");
        } else
        {
            modifier.put("eduLevelTextAlt", "вышеуказанному направлению");
        }

        for (int i = 0; i < UniRtfUtil.CASE_POSTFIX.size(); i++)
        {
            String casePostfix = UniRtfUtil.CASE_POSTFIX.get(i);
            String[] oldMaleCases = DEVELOP_CONDITION_MALE_SEX_CASES_ARRAY.get(extract.getEducationOrgUnitOld().getDevelopCondition().getCode());
            String[] oldFemaleCases = DEVELOP_CONDITION_FEMALE_SEX_CASES_ARRAY.get(extract.getEducationOrgUnitOld().getDevelopCondition().getCode());
            String[] newMaleCases = DEVELOP_CONDITION_MALE_SEX_CASES_ARRAY.get(extract.getEducationOrgUnitNew().getDevelopCondition().getCode());
            String[] newFemaleCases = DEVELOP_CONDITION_FEMALE_SEX_CASES_ARRAY.get(extract.getEducationOrgUnitNew().getDevelopCondition().getCode());
            modifier.put("developConditionOld" + casePostfix, (null != oldMaleCases ? oldMaleCases[i] : ""));
            modifier.put("developConditionOld" + casePostfix + "F", (null != oldFemaleCases ? oldFemaleCases[i] : ""));
            modifier.put("developConditionNew" + casePostfix, (null != newMaleCases ? newMaleCases[i] : ""));
            modifier.put("developConditionNew" + casePostfix + "F", (null != newFemaleCases ? newFemaleCases[i] : ""));
        }

        modifier.put("developPeriodNew", extract.getEducationOrgUnitNew().getDevelopPeriod().getTitle());

        if (extract.getEducationOrgUnitNew().getEducationLevelHighSchool().getEducationLevel().getLevelType().isHigh())
        {
            modifier.put("eduLevelType", "высшее");
            modifier.put("eduLevelType_G", "высшего");
            modifier.put("eduLevelType_D", "высшему");
            modifier.put("eduLevelType_A", "высшее");
            modifier.put("eduLevelType_I", "высшим");
            modifier.put("eduLevelType_P", "высшем");
        } else
        {
            modifier.put("eduLevelType", "среднее");
            modifier.put("eduLevelType_G", "среднего");
            modifier.put("eduLevelType_D", "среднему");
            modifier.put("eduLevelType_A", "среднее");
            modifier.put("eduLevelType_I", "средним");
            modifier.put("eduLevelType_P", "среднем");
        }


        //Метод с дополнительными вставками, сюда как я понимаю засовыем свои решения
        additionalModify(modifier, extract);
        modifier.modify(document);
        CommonExtractPrint.createFefuVisasTableModifier(extract).modify(document);
        return document;
    }

    public void additionalModify(RtfInjectModifier modifier, CostsChangesStuExtract extract)
    {
        modifier.put("changeDate", DateFormatter.DEFAULT_DATE_FORMATTER.format(extract.getDate()));
    }

}
