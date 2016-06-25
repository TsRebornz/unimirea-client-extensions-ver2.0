package ru.tandemservice.uniclient.unimirea_code.migration;

import org.tandemframework.core.common.DBType;
import org.tandemframework.dbsupport.ddl.DBTool;
import org.tandemframework.dbsupport.ddl.schema.columns.DBColumn;
import org.tandemframework.dbsupport.migration.IndependentMigrationScript;
import org.tandemframework.dbsupport.migration.ScriptDependency;

/**
 * Автоматически сгенерированная миграция
 */
@SuppressWarnings({"unused", "deprecation"})
public class MS_unimirea_code_1x0x0_8to9 extends IndependentMigrationScript
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

		// создано свойство editDate
		{
			// создать колонку
			tool.createColumn("rtfreporttemplate_t", new DBColumn("editdate_p", DBType.TIMESTAMP));

		}

		// создано свойство comment
		{
			// создать колонку
			tool.createColumn("rtfreporttemplate_t", new DBColumn("comment_p", DBType.TEXT));

		}


    }
}