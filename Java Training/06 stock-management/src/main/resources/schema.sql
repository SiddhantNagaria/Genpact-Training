create database inventory_db;

use inventory_db;

create table items(
	id bigint auto_increment primary key,
	name varchar(30) not null,
	description text,
	unit_price decimal(12,2) not null default 0.0,
	quantity int not null default 0,
	created_at timestamp default current_timestamp
)

alter table items created_at timestamp default current_timestamp on update current_timestamp

insert into items(name, description, unit_price, quantity)
values
("bluetooth mouse", "wireless mouse", 1500.00, 20),
("usb-c cable", "usb cable", 500.00, 100),
("AA Batteries Pack", "Pack of 4A Batteries", 600.00, 100);

