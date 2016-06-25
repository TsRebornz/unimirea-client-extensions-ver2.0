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
public class MS_unimirea_code_1x0x0_0to1 extends IndependentMigrationScript
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

		// создана новая сущность
		{
			// создать таблицу
			DBTable dbt = new DBTable("entertainmentprtcption_t",
				new DBColumn("id", DBType.LONG).setNullable(false).setPrimaryKey("pk_entertainmentprtcption"),
				new DBColumn("discriminator", DBType.SHORT).setNullable(false),
				new DBColumn("unit_id", DBType.LONG).setNullable(false),
				new DBColumn("type_id", DBType.LONG).setNullable(false),
				new DBColumn("overseer_p", DBType.BOOLEAN).setNullable(false)
			);
			tool.createTable(dbt);

			// гарантировать наличие кода сущности
			short entityCode = tool.entityCodes().ensure("entertainmentPrtcption");

		}

		////////////////////////////////////////////////////////////////////////////////
		// сущность entertainmentType

		// создана новая сущность
		{
			// создать таблицу
			DBTable dbt = new DBTable("entertainmenttype_t",
				new DBColumn("id", DBType.LONG).setNullable(false).setPrimaryKey("pk_entertainmenttype"),
				new DBColumn("discriminator", DBType.SHORT).setNullable(false),
				new DBColumn("code_p", DBType.createVarchar(255)).setNullable(false),
				new DBColumn("shorttitle_p", DBType.createVarchar(255)).setNullable(false),
				new DBColumn("title_p", DBType.createVarchar(1200))
			);
			tool.createTable(dbt);

			// гарантировать наличие кода сущности
			short entityCode = tool.entityCodes().ensure("entertainmentType");

		}

		////////////////////////////////////////////////////////////////////////////////
		// сущность entertainmentTypeUnit

		// создана новая сущность
		{
			// создать таблицу
			DBTable dbt = new DBTable("entertainmenttypeunit_t",
				new DBColumn("id", DBType.LONG).setNullable(false).setPrimaryKey("pk_entertainmenttypeunit"),
				new DBColumn("discriminator", DBType.SHORT).setNullable(false),
				new DBColumn("titile_p", DBType.createVarchar(255)).setNullable(false),
				new DBColumn("type_id", DBType.LONG),
				new DBColumn("datebegin_p", DBType.DATE).setNullable(false),
				new DBColumn("dateend_p", DBType.DATE),
				new DBColumn("description_p", DBType.TEXT)
			);
			tool.createTable(dbt);

			// гарантировать наличие кода сущности
			short entityCode = tool.entityCodes().ensure("entertainmentTypeUnit");

		}

		////////////////////////////////////////////////////////////////////////////////
		// сущность costsChangesStuExtract

		// создана новая сущность
		{
			// создать таблицу
			DBTable dbt = new DBTable("costschangesstuextract_t",
				new DBColumn("id", DBType.LONG).setNullable(false).setPrimaryKey("pk_costschangesstuextract"),
				new DBColumn("changedate_p", DBType.TIMESTAMP).setNullable(false),
				new DBColumn("cstschngscmpnstntyp_id", DBType.LONG).setNullable(false)
			);
			tool.createTable(dbt);

			// гарантировать наличие кода сущности
			short entityCode = tool.entityCodes().ensure("costsChangesStuExtract");

		}

		////////////////////////////////////////////////////////////////////////////////
		// сущность testStuExtract

		// создана новая сущность
		{
			// создать таблицу
			DBTable dbt = new DBTable("teststuextract_t",
				new DBColumn("id", DBType.LONG).setNullable(false).setPrimaryKey("pk_teststuextract"),
				new DBColumn("newcompensationtype_id", DBType.LONG).setNullable(false)
			);
			tool.createTable(dbt);

			// гарантировать наличие кода сущности
			short entityCode = tool.entityCodes().ensure("testStuExtract");

		}


    }
}