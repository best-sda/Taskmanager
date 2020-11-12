create table if not exists tasks.employee
(
	employee_id serial not null
		constraint " employee_pk"
			primary key
		constraint manager
			references tasks.employee,
	full_name text not null,
	employee_position text not null,
	company_branch text
);

alter table tasks.employee owner to postgres;

create unique index if not exists " employee_employee_id_uindex"
	on tasks.employee (employee_id);

create table if not exists tasks.task
(
	task_id serial not null
		constraint task_pk
			primary key
		constraint task_performer
			references tasks.employee
				on update cascade on delete cascade,
	task_description text not null,
	task_priority integer not null
);

alter table tasks.task owner to postgres;

create unique index if not exists task_task_id_uindex
	on tasks.task (task_id);

create table if not exists tasks."databasechangelog "
(
);