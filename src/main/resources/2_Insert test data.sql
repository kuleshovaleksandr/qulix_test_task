insert into projects
values (99997, 'Java test task', 'JT', 'Test task for Java junior developers');
insert into projects
values (99998, 'JavaScript test task', 'JST', 'Test task for JavaScript junior developers');
insert into projects
values (99999, 'Android test task', 'AT', 'Test task for Android junior developers');

insert into tasks
values (99995,'Create database', 2, NULL, NULL, 'NOT_STARTED', 99997);
insert into tasks
values (99996,'Create controllers', 24, '2021-04-02 00:00:00.000000', NULL, 'PROCESSING', 99997);
insert into tasks
values (99997,'Fix bugs', 8, '2021-04-02 00:00:00.000000', '2021-04-02 00:00:00.000000', 'ENDED', 99998);
insert into tasks
values (99998,'Update project', 10, '2021-04-02 00:00:00.000000', NULL, 'POSTPONED', 99999);
insert into tasks
values (99999,'Add tests', 24, '2021-04-02 00:00:00.000000', NULL, 'PROCESSING', 99999);
