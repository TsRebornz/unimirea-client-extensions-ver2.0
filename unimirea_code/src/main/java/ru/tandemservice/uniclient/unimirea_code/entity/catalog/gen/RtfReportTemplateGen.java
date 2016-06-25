package ru.tandemservice.uniclient.unimirea_code.entity.catalog.gen;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import java.util.Date;
import org.tandemframework.core.common.*;
import org.tandemframework.hibsupport.entity.*;
import ru.tandemservice.uniclient.unimirea_code.entity.catalog.RtfReportTemplate;
import org.tandemframework.core.view.formatter.DebugEntityFormatter;
import org.tandemframework.core.meta.entity.IEntityMeta;
import org.tandemframework.core.runtime.EntityRuntime;
import org.tandemframework.core.entity.*;
import org.tandemframework.core.entity.dsl.*;
import org.tandemframework.core.bean.*;

/**
 * Шаблон rtf отчетов
 */
@SuppressWarnings({"all", "unchecked", "unused", "deprecation"})
public abstract class RtfReportTemplateGen extends EntityBase
 implements INaturalIdentifiable<RtfReportTemplateGen>, org.tandemframework.common.catalog.entity.ICatalogItem{
    public static final IFastBean FAST_BEAN = new FastBean();

    public static final String ENTITY_CLASS = "ru.tandemservice.uniclient.unimirea_code.entity.catalog.RtfReportTemplate";
    public static final String ENTITY_NAME = "rtfReportTemplate";
    public static final int VERSION_HASH = -1832215705;
    private static IEntityMeta ENTITY_META;

    public static final String P_CODE = "code";
    public static final String P_PATH = "path";
    public static final String P_DOCUMENT = "document";
    public static final String P_EDIT_DATE = "editDate";
    public static final String P_COMMENT = "comment";
    public static final String P_TITLE = "title";

    private String _code;     // Системный код
    private String _path;     // Путь в classpath до шаблона по умолчанию
    private byte[] _document;     // Шаблон в zip текущий
    private Date _editDate;     // Дата редактирования
    private String _comment;     // комментарий
    private String _title;     // Название

    @Override
    public String toString() {
        return DebugEntityFormatter.INSTANCE.format(this);
    }

    public IEntityMeta getEntityMeta()
    {
        if( ENTITY_META==null )
        {
            ENTITY_META = EntityRuntime.getMeta(ENTITY_NAME);
        }
        return ENTITY_META;
    }

    /**
     * @return Системный код. Свойство не может быть null и должно быть уникальным.
     */
    @NotNull
    @Length(max=255)
    public String getCode()
    {
        return _code;
    }

    /**
     * @param code Системный код. Свойство не может быть null и должно быть уникальным.
     */
    public void setCode(String code)
    {
        dirty(_code, code);
        _code = code;
    }

    /**
     * @return Путь в classpath до шаблона по умолчанию. Свойство не может быть null и должно быть уникальным.
     */
    @NotNull
    @Length(max=255)
    public String getPath()
    {
        return _path;
    }

    /**
     * @param path Путь в classpath до шаблона по умолчанию. Свойство не может быть null и должно быть уникальным.
     */
    public void setPath(String path)
    {
        dirty(_path, path);
        _path = path;
    }

    /**
     * @return Шаблон в zip текущий.
     */
    public byte[] getDocument()
    {
        return _document;
    }

    /**
     * @param document Шаблон в zip текущий.
     */
    public void setDocument(byte[] document)
    {
        dirty(_document, document);
        _document = document;
    }

    /**
     * @return Дата редактирования.
     */
    public Date getEditDate()
    {
        return _editDate;
    }

    /**
     * @param editDate Дата редактирования.
     */
    public void setEditDate(Date editDate)
    {
        dirty(_editDate, editDate);
        _editDate = editDate;
    }

    /**
     * @return комментарий.
     */
    public String getComment()
    {
        return _comment;
    }

    /**
     * @param comment комментарий.
     */
    public void setComment(String comment)
    {
        dirty(_comment, comment);
        _comment = comment;
    }

    /**
     * @return Название.
     */
    @Length(max=1200)
    public String getTitle()
    {
        return _title;
    }

    /**
     * @param title Название.
     */
    public void setTitle(String title)
    {
        dirty(_title, title);
        _title = title;
    }

    public void update(IEntity another)
    {
        update(another, true);
    }

    public void update(IEntity another, boolean withNaturalIdProperties)
    {
        if (another instanceof RtfReportTemplateGen)
        {
            if (withNaturalIdProperties)
            {
                setCode(((RtfReportTemplate)another).getCode());
            }
            setPath(((RtfReportTemplate)another).getPath());
            setDocument(((RtfReportTemplate)another).getDocument());
            setEditDate(((RtfReportTemplate)another).getEditDate());
            setComment(((RtfReportTemplate)another).getComment());
            setTitle(((RtfReportTemplate)another).getTitle());
        }
    }

    public INaturalId<RtfReportTemplateGen> getNaturalId()
    {
        return new NaturalId(getCode());
    }

    public static class NaturalId extends NaturalIdBase<RtfReportTemplateGen>
    {
        private static final String PROXY_NAME = "RtfReportTemplateNaturalProxy";

        private String _code;

        public NaturalId()
        {}

        public NaturalId(String code)
        {
            _code = code;
        }

        public String getCode()
        {
            return _code;
        }

        public void setCode(String code)
        {
            _code = code;
        }

        public String getProxyName()
        {
            return PROXY_NAME;
        }

        @Override
        public boolean equals(Object o)
        {
            if( this == o ) return true;
            if( !(o instanceof RtfReportTemplateGen.NaturalId) ) return false;

            RtfReportTemplateGen.NaturalId that = (NaturalId) o;

            if( !equals(getCode(), that.getCode()) ) return false;
            return true;
        }

        @Override
        public int hashCode()
        {
            int result = 0;
            result = hashCode(result, getCode());
            return result;
        }

        @Override
        public String toString()
        {
            StringBuilder sb = new StringBuilder(PROXY_NAME);
            sb.append("/");
            sb.append(getCode());
            return sb.toString();
        }
    }

    @Override
    public IFastBean getFastBean()
    {
        return FAST_BEAN;
    }

    protected static class FastBean<T extends RtfReportTemplateGen> extends FastBeanGenBase<T>    {
        public Class<T> getBeanClass()
        {
            return (Class<T>) RtfReportTemplate.class;
        }

        public T newInstance()
        {
            return (T) new RtfReportTemplate();
        }
        @Override
        public Object getPropertyValue(T obj, String propertyName)
        {
            switch(propertyName)
            {
                case "id":
                    return obj.getId();
                case "code":
                    return obj.getCode();
                case "path":
                    return obj.getPath();
                case "document":
                    return obj.getDocument();
                case "editDate":
                    return obj.getEditDate();
                case "comment":
                    return obj.getComment();
                case "title":
                    return obj.getTitle();
            }
            return super.getPropertyValue(obj, propertyName);
        }

        @Override
        public void setPropertyValue(T obj, String propertyName, Object value)
        {
            switch(propertyName)
            {
                case "id":
                    obj.setId((Long) value);
                    return;
                case "code":
                    obj.setCode((String) value);
                    return;
                case "path":
                    obj.setPath((String) value);
                    return;
                case "document":
                    obj.setDocument((byte[]) value);
                    return;
                case "editDate":
                    obj.setEditDate((Date) value);
                    return;
                case "comment":
                    obj.setComment((String) value);
                    return;
                case "title":
                    obj.setTitle((String) value);
                    return;
            }
            super.setPropertyValue(obj, propertyName, value);
        }

        @Override
        public boolean isReadableProperty(String propertyName)
        {
            switch(propertyName)
            {
                case "id":
                        return true;
                case "code":
                        return true;
                case "path":
                        return true;
                case "document":
                        return true;
                case "editDate":
                        return true;
                case "comment":
                        return true;
                case "title":
                        return true;
            }
            return super.isReadableProperty(propertyName);
        }

        @Override
        public boolean isWritableProperty(String propertyName)
        {
            switch(propertyName)
            {
                case "id":
                    return true;
                case "code":
                    return true;
                case "path":
                    return true;
                case "document":
                    return true;
                case "editDate":
                    return true;
                case "comment":
                    return true;
                case "title":
                    return true;
            }
            return super.isWritableProperty(propertyName);
        }

        @Override
        public Class getPropertyType(String propertyName)
        {
            switch(propertyName)
            {
                case "id":
                    return Long.class;
                case "code":
                    return String.class;
                case "path":
                    return String.class;
                case "document":
                    return byte[].class;
                case "editDate":
                    return Date.class;
                case "comment":
                    return String.class;
                case "title":
                    return String.class;
            }
            return super.getPropertyType(propertyName);
        }
    }
    private static final Path<RtfReportTemplate> _dslPath = new Path<RtfReportTemplate>();

    public static Path as(String alias)
    {
        return _dslPath.forAlias(alias, "RtfReportTemplate");
    }
            

    /**
     * @return Системный код. Свойство не может быть null и должно быть уникальным.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.catalog.RtfReportTemplate#getCode()
     */
    public static PropertyPath<String> code()
    {
        return _dslPath.code();
    }

    /**
     * @return Путь в classpath до шаблона по умолчанию. Свойство не может быть null и должно быть уникальным.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.catalog.RtfReportTemplate#getPath()
     */
    public static PropertyPath<String> path()
    {
        return _dslPath.path();
    }

    /**
     * @return Шаблон в zip текущий.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.catalog.RtfReportTemplate#getDocument()
     */
    public static PropertyPath<byte[]> document()
    {
        return _dslPath.document();
    }

    /**
     * @return Дата редактирования.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.catalog.RtfReportTemplate#getEditDate()
     */
    public static PropertyPath<Date> editDate()
    {
        return _dslPath.editDate();
    }

    /**
     * @return комментарий.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.catalog.RtfReportTemplate#getComment()
     */
    public static PropertyPath<String> comment()
    {
        return _dslPath.comment();
    }

    /**
     * @return Название.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.catalog.RtfReportTemplate#getTitle()
     */
    public static PropertyPath<String> title()
    {
        return _dslPath.title();
    }

    public static class Path<E extends RtfReportTemplate> extends EntityPath<E>
    {
        private PropertyPath<String> _code;
        private PropertyPath<String> _path;
        private PropertyPath<byte[]> _document;
        private PropertyPath<Date> _editDate;
        private PropertyPath<String> _comment;
        private PropertyPath<String> _title;

        public Path()
        {
            super();
        }

        public Path(String path)
        {
            super(path);
        }

        public Path(String childEntityProperty, EntityPath path)
        {
            super(childEntityProperty, path);
        }

    /**
     * @return Системный код. Свойство не может быть null и должно быть уникальным.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.catalog.RtfReportTemplate#getCode()
     */
        public PropertyPath<String> code()
        {
            if(_code == null )
                _code = new PropertyPath<String>(RtfReportTemplateGen.P_CODE, this);
            return _code;
        }

    /**
     * @return Путь в classpath до шаблона по умолчанию. Свойство не может быть null и должно быть уникальным.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.catalog.RtfReportTemplate#getPath()
     */
        public PropertyPath<String> path()
        {
            if(_path == null )
                _path = new PropertyPath<String>(RtfReportTemplateGen.P_PATH, this);
            return _path;
        }

    /**
     * @return Шаблон в zip текущий.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.catalog.RtfReportTemplate#getDocument()
     */
        public PropertyPath<byte[]> document()
        {
            if(_document == null )
                _document = new PropertyPath<byte[]>(RtfReportTemplateGen.P_DOCUMENT, this);
            return _document;
        }

    /**
     * @return Дата редактирования.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.catalog.RtfReportTemplate#getEditDate()
     */
        public PropertyPath<Date> editDate()
        {
            if(_editDate == null )
                _editDate = new PropertyPath<Date>(RtfReportTemplateGen.P_EDIT_DATE, this);
            return _editDate;
        }

    /**
     * @return комментарий.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.catalog.RtfReportTemplate#getComment()
     */
        public PropertyPath<String> comment()
        {
            if(_comment == null )
                _comment = new PropertyPath<String>(RtfReportTemplateGen.P_COMMENT, this);
            return _comment;
        }

    /**
     * @return Название.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.catalog.RtfReportTemplate#getTitle()
     */
        public PropertyPath<String> title()
        {
            if(_title == null )
                _title = new PropertyPath<String>(RtfReportTemplateGen.P_TITLE, this);
            return _title;
        }

        public Class getEntityClass()
        {
            return RtfReportTemplate.class;
        }

        public String getEntityName()
        {
            return "rtfReportTemplate";
        }

        public Path as(String alias)
        {
            Path path = new Path(getPath());
            path.setAlias(alias);
            return path;
        }

        private Path forAlias(String alias, String root)
        {
            Path path = new Path();
            path.setAlias(alias, root);
            return path;
        }
    }
}
