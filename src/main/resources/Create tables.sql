create table projects
(
    id       serial not null,
    name     varchar(255),
    short_name varchar(50),
    describe text,
    primary key (id)
);

create table tasks
(
    id      serial not null,
    name varchar(255),
    work_time integer,
    start_date timestamp,
    end_date timestamp,
    status varchar(20),
    project_id int not null,
    primary key (id)
);

alter table tasks
    add constraint fk_project_id foreign key (project_id) references projects;
