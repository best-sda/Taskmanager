/*
 * This file is generated by jOOQ.
 */
package com.sda.taskmanager.entity;


import com.sda.taskmanager.entity.tables.Employee;
import com.sda.taskmanager.entity.tables.Task;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables in tasks.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index _EMPLOYEE_EMPLOYEE_ID_UINDEX = Internal.createIndex(DSL.name(" employee_employee_id_uindex"), Employee.EMPLOYEE, new OrderField[] { Employee.EMPLOYEE.EMPLOYEE_ID }, true);
    public static final Index TASK_TASK_ID_UINDEX = Internal.createIndex(DSL.name("task_task_id_uindex"), Task.TASK, new OrderField[] { Task.TASK.TASK_ID }, true);
}
