package ru.tandemservice.uniclient.unimirea_code.entity.gen;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import ru.tandemservice.movestudent.entity.ListStudentExtract;
import ru.tandemservice.uniclient.unimirea_code.entity.GiveBadgeCommonListExtract;
import org.tandemframework.core.view.formatter.DebugEntityFormatter;
import org.tandemframework.core.meta.entity.IEntityMeta;
import org.tandemframework.core.runtime.EntityRuntime;
import org.tandemframework.core.entity.*;
import org.tandemframework.core.entity.dsl.*;
import org.tandemframework.core.bean.*;

/**
 * Проект приказа «О выдаче обычных значков»
 */
@SuppressWarnings({"all", "unchecked", "unused", "deprecation"})
public abstract class GiveBadgeCommonListExtractGen extends ListStudentExtract
{
    public static final IFastBean FAST_BEAN = new FastBean();

    public static final String ENTITY_CLASS = "ru.tandemservice.uniclient.unimirea_code.entity.GiveBadgeCommonListExtract";
    public static final String ENTITY_NAME = "giveBadgeCommonListExtract";
    public static final int VERSION_HASH = -1535645150;
    private static IEntityMeta ENTITY_META;



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

    public void update(IEntity another)
    {
        update(another, true);
    }

    public void update(IEntity another, boolean withNaturalIdProperties)
    {
        super.update(another, withNaturalIdProperties);
        if (another instanceof GiveBadgeCommonListExtractGen)
        {
        }
    }

    @Override
    public IFastBean getFastBean()
    {
        return FAST_BEAN;
    }

    protected static class FastBean<T extends GiveBadgeCommonListExtractGen> extends ListStudentExtract.FastBean<T>    {
        public Class<T> getBeanClass()
        {
            return (Class<T>) GiveBadgeCommonListExtract.class;
        }

        public T newInstance()
        {
            return (T) new GiveBadgeCommonListExtract();
        }
    }
    private static final Path<GiveBadgeCommonListExtract> _dslPath = new Path<GiveBadgeCommonListExtract>();

    public static Path as(String alias)
    {
        return _dslPath.forAlias(alias, "GiveBadgeCommonListExtract");
    }
            

    public static class Path<E extends GiveBadgeCommonListExtract> extends ListStudentExtract.Path<E>
    {

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

        public Class getEntityClass()
        {
            return GiveBadgeCommonListExtract.class;
        }

        public String getEntityName()
        {
            return "giveBadgeCommonListExtract";
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
