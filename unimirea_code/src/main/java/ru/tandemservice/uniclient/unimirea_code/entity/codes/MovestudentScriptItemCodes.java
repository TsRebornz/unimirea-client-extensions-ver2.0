package ru.tandemservice.uniclient.unimirea_code.entity.codes;

import com.google.common.collect.ImmutableSet;
import java.util.Set;

/**
 * Константы кодов сущности "Скрипты и шаблоны модуля «Движение студентов»"
 * Имя сущности : movestudentScriptItem
 * Файл data.xml : modularextract.data.xml
 */
public interface MovestudentScriptItemCodes
{
    /** Константа кода (code) элемента : Заполнение меток при печати приказов и выписок (title) */
    //String ORDERS_PRINT_MODIFIER = "orders.print.modifier";
    /** Константа кода (code) элемента : Заполнение меток при печати приказов и выписок (title) */
    String ORDERS_PRINT_MODIFIER = "orders.print.modifier";

    Set<String> CODES = ImmutableSet.of(ORDERS_PRINT_MODIFIER);
}
