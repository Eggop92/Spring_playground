create database seguros_db;
create user 'springuser'@'localhost' identified by 'ThePassword';
grant all on seguros_db.* to 'springuser'@'localhost';