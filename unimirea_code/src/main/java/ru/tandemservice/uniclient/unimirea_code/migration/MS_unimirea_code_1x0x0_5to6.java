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
public class MS_unimirea_code_1x0x0_5to6 extends IndependentMigrationScript
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
		// сущность rtfReportTemplate

		// создана новая сущность
		{
			// создать таблицу
			DBTable dbt = new DBTable("rtfreporttemplate_t",
				new DBColumn("id", DBType.LONG).setNullable(false).setPrimaryKey("pk_rtfreporttemplate"),
				new DBColumn("discriminator", DBType.SHORT).setNullable(false),
				new DBColumn("path_p", DBType.createVarchar(255)).setNullable(false),
				new DBColumn("document_p", DBType.BLOB),
				new DBColumn("editdate_p", DBType.TIMESTAMP),
				new DBColumn("comment_p", DBType.TEXT)
			);
			tool.createTable(dbt);

			// гарантировать наличие кода сущности
			short entityCode = tool.entityCodes().ensure("rtfReportTemplate");

		}


    }
}