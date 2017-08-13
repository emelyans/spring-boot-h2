drop table IF EXISTS user;

create table user2(
  id int,
  first_name varchar2(20),
  last_name varchar2(20)
);

insert into user2 values(1, 'John', 'Smith');