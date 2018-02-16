CREATE TABLE reservation (
  id   IDENTITY,
  name VARCHAR(50),
  details VARCHAR(50),
  amount DECIMAL(10,3),
  expense_category VARCHAR(10),
  approved BOOLEAN
);

create table city(id int, name varchar(20));
