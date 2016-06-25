package ru.tandemservice.uniclient.unimirea_code.migration;

import org.tandemframework.core.common.DBType;
import org.tandemframework.dbsupport.ddl.DBTool;
import org.tandemframework.dbsupport.ddl.schema.DBTable;
import org.tandemframework.dbsupport.ddl.schema.columns.DBColumn;
import org.tandemframework.dbsupport.migration.IndependentMigrationScript;
import org.tandemframework.dbsupport.migration.ScriptDependency;

/**
 * Автоматически сгенерированная миграция
 */
@SuppressWarnings({"unused", "deprecation"})
public class MS_unimirea_code_1x0x0_1to2 extends IndependentMigrationScript
{
    @Override
    public ScriptDependency[] getBoundaryDependencies()
    {
        return new ScriptDependency[]
		{
				 new ScriptDependency("org.tandemframework", "1.6.18"),
				 new ScriptDependency("org.tandemframework.shared", "1.10.0"),
				 new ScriptDependency("ru.tandemservice.nsiclient", "2.10.0"),
				 new ScriptDependency("ru.tandemservice.uni.product", "2.10.0"),
				 new ScriptDependency("ru.tandemservice.uni.project", "2.10.0")
		};
    }

    @Override
    public void run(DBTool tool) throws Exception
    {
		////////////////////////////////////////////////////////////////////////////////
		// сущность giveBadgeCommonListExtract

		// создана новая сущность
		{
			// создать таблицу
			DBTable dbt = new DBTable("givebadgecommonlistextract_t",
				new DBColumn("id", DBType.LONG).setNullable(false).setPrimaryKey("pk_givebadgecommonlistextract"),
				new DBColumn("course_id", DBType.LONG).setNullable(false),
				new DBColumn("group_id", DBType.LONG).setNullable(false)
			);
			tool.createTable(dbt);

			// гарантировать наличие кода сущности
			short entityCode = tool.entityCodes().ensure("giveBadgeCommonListExtract");

		}

		////////////////////////////////////////////////////////////////////////////////
		// сущность giveBadgeWithUSignListExtract

		// создана новая сущность
		{
			// создать таблицу
			DBTable dbt = new DBTable("gvbdgwthusgnlstextrct_t",
				new DBColumn("id", DBType.LONG).setNullable(false).setPrimaryKey("pk_325979e9"),
				new DBColumn("course_id", DBType.LONG).setNullable(false),
				new DBColumn("group_id", DBType.LONG).setNullable(false)
			);
			tool.createTable(dbt);

			// гарантировать наличие кода сущности
			short entityCode = tool.entityCodes().ensure("giveBadgeWithUSignListExtract");

		}


    }
}