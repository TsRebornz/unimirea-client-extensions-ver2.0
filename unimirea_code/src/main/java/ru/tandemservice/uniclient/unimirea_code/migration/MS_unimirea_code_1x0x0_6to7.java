package ru.tandemservice.uniclient.unimirea_code.migration;

import org.tandemframework.dbsupport.ddl.DBTool;
import org.tandemframework.dbsupport.migration.IndependentMigrationScript;
import org.tandemframework.dbsupport.migration.ScriptDependency;

/**
 * Автоматически сгенерированная миграция
 */
@SuppressWarnings({"unused", "deprecation"})
public class MS_unimirea_code_1x0x0_6to7 extends IndependentMigrationScript
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

		// удалено свойство editDate
		{



			// удалить колонку
			tool.dropColumn("rtfreporttemplate_t", "editdate_p");

		}

		// удалено свойство comment
		{


			// удалить колонку
			tool.dropColumn("rtfreporttemplate_t", "comment_p");

		}


    }
}