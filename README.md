# Тестовое задание в компанию Qulix.

#### Чтобы подключиться к проекту, необходимо:
1) Скачать и установить базу данных **PostgreSQL** с сайта
https://www.postgresql.org/download/
2) При помощи утилиты **pgAdmin.exe**, которая была установлена вместе с базой данных, перейти в администрирование баз данных.
3) Создать базу данных с именем **qulix_test**.
4) Задать созданной базе данных пользователя **postgres** с паролем **postgres**.
5) В Intellij IDEA создать проект с имеющегося репозитория: **File -> New -> Project from Version Control**. 
6) Скачать и распаковать контейнер серверов **TomCat** по ссылке
https://ftp.byfly.by/pub/apache.org/tomcat/tomcat-9/v9.0.48/bin/apache-tomcat-9.0.48.zip
7) После создания проекта в Intellij IDEA перейти в меню **Edit configurations...** для настройки **TomCat**:
    + **Add new configuration -> TomCat Server Local**;
    + указать путь к папке с распакованым **TomCat**;
    + нажать на кнопку **Fix** и выбрать артефакт *qulix_test_task:war exploded*;
    + нажать **Apply** и **Ok**.
8) В папке **resources** исполнить два SQL файла для заполнения базы данных тестовыми данными в порядке их нумерации.

