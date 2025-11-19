-- create database
CREATE DATABASE IF NOT EXISTS placement_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE placement_db;

-- Admins table
CREATE TABLE admin (
  admin_id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  full_name VARCHAR(100),
  email VARCHAR(100),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Companies table
CREATE TABLE company (
  company_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(150) NOT NULL UNIQUE,
  website VARCHAR(255),
  contact_email VARCHAR(100),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Drives table (placement drives scheduled by admin for a company)
CREATE TABLE drive (
  drive_id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(150) NOT NULL,
  company_id INT NOT NULL,
  scheduled_date DATE,
  admin_id INT, -- who created the drive
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (company_id) REFERENCES company(company_id) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (admin_id) REFERENCES admin(admin_id) ON DELETE SET NULL ON UPDATE CASCADE
);

-- Students table
CREATE TABLE student (
  student_id INT AUTO_INCREMENT PRIMARY KEY,
  roll_no VARCHAR(50) NOT NULL UNIQUE,
  full_name VARCHAR(150) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  branch VARCHAR(50),
  year INT,
  status VARCHAR(30) DEFAULT 'Not Placed', -- Not Placed / Placed / Interviewed
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Placements (mapping student -> drive/company when placed/interviewed)
CREATE TABLE placement (
  placement_id INT AUTO_INCREMENT PRIMARY KEY,
  student_id INT NOT NULL,
  company_id INT NOT NULL,
  drive_id INT NOT NULL,
  role VARCHAR(100),
  status VARCHAR(30) DEFAULT 'Selected', -- Selected / Rejected / On Hold
  package_lpa DECIMAL(6,2),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (student_id) REFERENCES student(student_id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (company_id) REFERENCES company(company_id) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (drive_id) REFERENCES drive(drive_id) ON DELETE RESTRICT ON UPDATE CASCADE
);

-- TRIGGERS

-- 1) Before inserting a student, auto-normalize roll_no to uppercase (example)
DELIMITER //
CREATE TRIGGER before_student_insert
BEFORE INSERT ON student
FOR EACH ROW
BEGIN
  IF NEW.roll_no IS NOT NULL THEN
    SET NEW.roll_no = UPPER(NEW.roll_no);
  END IF;
END//
DELIMITER ;

-- 2) After inserting a placement, update student's status to 'Placed' (if selected)
DELIMITER //
CREATE TRIGGER after_placement_insert
AFTER INSERT ON placement
FOR EACH ROW
BEGIN
  IF NEW.status = 'Selected' THEN
    UPDATE student SET status = 'Placed' WHERE student_id = NEW.student_id;
  END IF;
END//
DELIMITER ;

-- 3) Before deleting company: prevent delete if company has drives (using SIGNAL)
DELIMITER //
CREATE TRIGGER before_company_delete
BEFORE DELETE ON company
FOR EACH ROW
BEGIN
  DECLARE cnt INT;
  SELECT COUNT(*) INTO cnt FROM drive WHERE company_id = OLD.company_id;
  IF cnt > 0 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot delete company with scheduled drives.';
  END IF;
END//
DELIMITER ;

--prevent duplicate placement for placed students
DELIMITER //
CREATE TRIGGER before_placement_insert
BEFORE INSERT ON placement
FOR EACH ROW
BEGIN
	DECLARE stu_status VARCHAR(50);
	SELECT status INTO stu_status FROM student WHERE student_id = NEW.student_id;
	IF stu_status = 'Placed' THEN
		SIGNAL SQLSTATE = '45000'
		SET MESSAGE_TEXT = 'Insertion denied. Student is already placed';
	END IF;
END //
DELIMITER ;
