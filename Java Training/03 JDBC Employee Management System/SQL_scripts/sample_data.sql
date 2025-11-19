--insert data into employee table

INSERT INTO employee(name, email,is_active, salary,hire_date)
values
("Siddhant Nagaria","siddhant@gmail.com",true,65000.00,'2025-10-01'),
("rahul gupta","rahul@gmail.com",false,55000.00,'2025-09-01'),
("Aryan Gupta","aryan@gmail.com",true,61000.00,'2025-08-01'),
("Prakhar Agarwal","prakhar@gmail.com",true,57000.00,'2025-10-15'),
("Rishabh Soni","rishabh@gmail.com",false,45000.00,'2025-08-12');

INSERT INTO department (dept_name, dept_head) 
VALUES
('HR', 'Priya Sharma'),
('IT', 'Ravi Mehta'),
('Finance', 'Anjali Verma'),
('Sales', 'Amitabh Singh');

ALTER TABLE employee
ADD COLUMN dept_id INT;

ALTER TABLE employee
ADD CONSTRAINT fk_dept
FOREIGN KEY (dept_id)
REFERENCES department(dept_id);

UPDATE employee SET dept_id = 1 WHERE id = 1;
UPDATE employee SET dept_id = 2 WHERE id = 2;
UPDATE employee SET dept_id = 3 WHERE id = 3;
UPDATE employee SET dept_id = 4 WHERE id = 4;
UPDATE employee SET dept_id = 5 WHERE id = 5;
 