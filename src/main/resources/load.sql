drop table IF EXISTS user;

create table user(
  id int,
  first_name varchar2(20),
  last_name varchar2(20)
);

insert into user values(1, 'John', 'Smith');