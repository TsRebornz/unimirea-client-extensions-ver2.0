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
public class MS_unimirea_code_1x0x0_3to4 extends IndependentMigrationScript
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
		// сущность entertainmentPrtcption

		// удалено свойство type
		{

			// удалить колонку
			tool.dropColumn("entertainmentprtcption_t", "type_id");

		}

		// создано обязательное свойство employee
		{
			// создать колонку
			tool.createColumn("entertainmentprtcption_t", new DBColumn("employee_id", DBType.LONG));



			// задать значение по умолчанию
			Long defaultEmployee = 100000000l;
			tool.executeUpdate("update entertainmentprtcption_t set employee_id=? where employee_id is null", defaultEmployee);

			// сделать колонку NOT NULL
			tool.setColumnNullable("entertainmentprtcption_t", "employee_id", false);

		}


    }
}