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
public class MS_unimirea_code_1x0x0_9to10 extends IndependentMigrationScript
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
		// сущность entertainmentTypeUnit



		// создано обязательное свойство title
		{
			// создать колонку
			tool.createColumn("entertainmenttypeunit_t", new DBColumn("title_p", DBType.createVarchar(255)));



			// задать значение по умолчанию
			tool.executeUpdate("update entertainmenttypeunit_t set title_p=titile_p where title_p is null");

			// сделать колонку NOT NULL
			tool.setColumnNullable("entertainmenttypeunit_t", "title_p", false);

		}
		
		// удалено свойство titile
		{
			// удалить колонку
			tool.dropColumn("entertainmenttypeunit_t", "titile_p");

		}


    }
}
