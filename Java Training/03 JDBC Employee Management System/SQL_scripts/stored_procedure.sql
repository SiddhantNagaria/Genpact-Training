
--create Statement Procedure get_salary_by_id
--two types of parameter - IN, OUT
--IN -> give that as an Input -> give id as input
-- OUT -> which SP return as an output
--SP -> inserting data -> IN

DELIMITER //
create procedure get_salary_by_id(
	in p_id int,
	out p_salary decimal(12,2)
)
BEGIN
	select salary into p_salary -- fetching salary and storig result in OUT parameter
	FROM Employee
	where id=p_id;
	
END //
DELIMITER ;