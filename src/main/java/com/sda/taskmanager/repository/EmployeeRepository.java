package com.sda.taskmanager.repository;

import com.sda.taskmanager.entity.Tables;
import com.sda.taskmanager.entity.tables.pojos.Employee;
import com.sda.taskmanager.entity.tables.pojos.Task;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository implements CrudRepository {

    final DSLContext dsl;

    public EmployeeRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public Object insert(Object o) {
        return null;
    }

    @Override
    public Object update(Object o) {
        return null;
    }

    @Override
    public Object find(Long id) {
        return dsl.selectFrom(Tables.EMPLOYEE).where(Tables.EMPLOYEE.EMPLOYEE_ID
                .eq(Math.toIntExact(id))).fetchOneInto(Employee.class);
    }

    @Override
    public List<Employee> findAll(Condition condition) {
        List<Employee> employees = dsl.selectFrom(Tables.EMPLOYEE).where(condition).fetchInto(Employee.class);
        employees.forEach(a -> {
            a.setTasks(dsl.selectFrom(Tables.TASK).where(Tables.TASK.TASK_PERFORMER
                    .eq(a.getEmployeeId())).fetchInto(Task.class));
            a.setTaskSumm(a.getTasks().size());
        });
        return employees;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}


