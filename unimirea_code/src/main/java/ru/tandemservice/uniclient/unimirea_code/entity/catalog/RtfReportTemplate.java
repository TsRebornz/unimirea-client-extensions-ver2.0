package ru.tandemservice.uniclient.unimirea_code.entity.catalog;

import org.tandemframework.shared.commonbase.base.util.CommonBaseUtil;
import org.tandemframework.shared.commonbase.base.util.ITemplateDocument;
import ru.tandemservice.uniclient.unimirea_code.entity.catalog.gen.*;

/** @see ru.tandemservice.uniclient.unimirea_code.entity.catalog.gen.RtfReportTemplateGen */
public class RtfReportTemplate extends RtfReportTemplateGen implements ITemplateDocument
{
    @Override
    public byte[] getContent() {
        return CommonBaseUtil.getTemplateContent(this);
    }

}