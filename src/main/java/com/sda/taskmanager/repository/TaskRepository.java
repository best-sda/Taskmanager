package com.sda.taskmanager.repository;

import com.sda.taskmanager.entity.Tables;
import com.sda.taskmanager.entity.tables.pojos.Employee;
import com.sda.taskmanager.entity.tables.pojos.Task;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.sda.taskmanager.entity.tables.Task.TASK;

@Repository
public class TaskRepository implements CrudRepository {

    final DSLContext dsl;
    final EmployeeRepository employeeRepository;

    public TaskRepository(DSLContext dsl, EmployeeRepository employeeRepository) {
        this.dsl = dsl;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Task insert(Object o) {
        return null;
    }

    @Override
    public Task update(Object o) {
        return null;
    }

    @Override
    public Task find(Long id) {
        return dsl.selectFrom(TASK).where(TASK.TASK_ID.eq(Math.toIntExact(id))).fetchAny().map(a -> {
            Task task = a.into(Task.class);
            task.setEmployee(employeeRepository.findAll(Tables.EMPLOYEE.EMPLOYEE_ID.eq(task.getTaskPerformer())).get(0));
            return task;
        });
    }

    @Override
    public List<Task> findAll(Condition condition) {
         List<Task> tasks = dsl.selectFrom(Tables.TASK).where(condition).fetchInto(Task.class);
         tasks.forEach(a -> a.setEmployee(dsl.selectFrom(Tables.EMPLOYEE).where(Tables.EMPLOYEE.EMPLOYEE_ID
                 .eq(a.getTaskPerformer())).fetchInto(Employee.class).get(0)));
         return tasks;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
