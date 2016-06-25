package ru.tandemservice.uniclient.unimirea_code.migration;

import org.tandemframework.dbsupport.ddl.DBTool;
import org.tandemframework.dbsupport.migration.IndependentMigrationScript;
import org.tandemframework.dbsupport.migration.ScriptDependency;

/**
 * Автоматически сгенерированная миграция
 */
@SuppressWarnings({"unused", "deprecation"})
public class MS_unimirea_code_1x0x0_11to12 extends IndependentMigrationScript
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
		// сущность testStuExtract

		// сущность была удалена
		{
			// удалить таблицу
			tool.dropTable("teststuextract_t", false /* - не удалять, если есть ссылающиеся таблицы */);

			// удалить код сущности
			tool.entityCodes().delete("testStuExtract");

		}


    }
}