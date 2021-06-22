insert into projects
values (1, 'Java test task', 'JT', 'Test task for Java junior developers');
insert into projects
values (2, 'JavaScript test task', 'JST', 'Test task for JavaScript junior developers');
insert into projects
values (3, 'Android test task', 'AT', 'Test task for Android junior developers');

insert into tasks
values (1,'Create database', 2, NULL, NULL, 'NOT_STARTED', 1);
insert into tasks
values (2,'Create controllers', 24, '2021-04-02 00:00:00.000000', NULL, 'PROCESSING', 1);
insert into tasks
values (3,'Fix bugs', 8, '2021-04-02 00:00:00.000000', '2021-04-02 00:00:00.000000', 'ENDED', 2);
insert into tasks
values (4,'Update project', 10, '2021-04-02 00:00:00.000000', NULL, 'POSTPONED', 3);
insert into tasks
values (5,'Add tests', 24, '2021-04-02 00:00:00.000000', NULL, 'PROCESSING', 3);
