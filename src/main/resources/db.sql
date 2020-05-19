show databases;
use mysql_learning_db; 
CREATE TABLE EMPLOYEE(
                         id INT NOT NULL auto_increment,
                         name VARCHAR(50) NOT NULL,
                         role VARCHAR(50) NOT NULL,
                         joining_date DATE NOT NULL,
                         salary DOUBLE NOT NULL,
                         ssn VARCHAR(30) NOT NULL UNIQUE,
                         PRIMARY KEY (id)
);

create table stock (
                       stock_id serial not null primary key,
                       stock_name varchar(20) DEFAULT NULL,
                       symbol varchar(20) DEFAULT NULL,
                       company varchar(20) DEFAULT NULL,
                       favorite varchar(20) DEFAULT NULL,
                       start_year date DEFAULT NULL,
                       market_cap integer DEFAULT NULL
);

CREATE TABLE USER(
						 id INT NOT NULL auto_increment,
                         user_id VARCHAR(50) NOT NULL,
                         user_name VARCHAR(50) NOT NULL,
                         user_role VARCHAR(50) NOT NULL,
                         user_status VARCHAR(50) NOT NULL,
                         password VARCHAR(50) NOT NULL,
                         date DATETIME DEFAULT CURRENT_TIMESTAMP,
                         PRIMARY KEY (id)
);

drop table user;
select * from employee;
select * from stock;
select * from user;