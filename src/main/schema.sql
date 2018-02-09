CREATE TABLE reservation (
  id   IDENTITY,
  NAME VARCHAR(50),
  DETAILS VARCHAR(50),
  amount DECIMAL(10,3),
  expenseCategory VARCHAR(10),
  approved VARCHAR(1)
);

create table city(id int, name varchar(20));
