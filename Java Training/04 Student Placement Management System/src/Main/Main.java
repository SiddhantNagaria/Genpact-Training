package Main;

import DAO.*;
import Models.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static final Scanner sc = new Scanner(System.in);
	private static final StudentDAO studentDAO = new StudentDAO();
	private static final CompanyDAO companyDAO = new CompanyDAO();
	private static final DriveDAO driveDAO = new DriveDAO();
	private static final PlacementDAO placementDAO = new PlacementDAO();
	private static final AdminDAO adminDAO = new AdminDAO();

	static {
		DBConnection.getConnection();
	}

	public static void main(String[] args) {
		while (true) {
			printMenu();
			int choice = readInt("Choose option: ");
			switch (choice) {
			case 1 -> studentMenu();
			case 2 -> companyMenu();
			case 3 -> driveMenu();
			case 4 -> placementMenu();
			case 5 -> adminMenu();
			case 0 -> {
				System.out.println("Exiting. Bye!");
				return;
			}
			default -> System.out.println("Invalid choice.");
			}
		}
	}

	private static void printMenu() {
		System.out.println("\n--- Student Placement Management ---");
		System.out.println("1. Student CRUD");
		System.out.println("2. Company CRUD");
		System.out.println("3. Drive CRUD");
		System.out.println("4. Placement CRUD");
		System.out.println("5. Admin CRUD");
		System.out.println("0. Exit");
	}

	// Student menu
	private static void studentMenu() {
		System.out.println("\n-- Student Menu --");
		System.out.println("1. Create Student");
		System.out.println("2. View Student by ID");
		System.out.println("3. View All Students");
		System.out.println("4. Update Student");
		System.out.println("5. Delete Student");
		System.out.println("0. Back");
		int ch = readInt("Choice: ");
		switch (ch) {
		case 1 -> createStudentCLI();
		case 2 -> {
			int id = readInt("student id: ");
			Student s = studentDAO.getStudentById(id);
			if (s != null)
				printStudent(s);
		}
		case 3 -> {
			List<Student> list = studentDAO.getAllStudents();
			list.forEach(Main::printStudent);
		}
		case 4 -> updateStudentCLI();
		case 5 -> {
			int id = readInt("student id to delete: ");
			studentDAO.deleteStudent(id);
		}
		default -> System.out.println("Back.");
		}
	}

	private static void createStudentCLI() {
		String roll = readStr("Roll No: ");
		String name = readStr("Full name: ");
		String email = readStr("Email: ");
		String branch = readStr("Branch: ");
		int year = readInt("Year: ");
		Student s = new Student(roll, name, email, branch, year);
		studentDAO.createStudent(s);
	}

	private static void updateStudentCLI() {
		int id = readInt("Student id to update: ");
		Student s = studentDAO.getStudentById(id);
		if (s == null)
			return;
		String roll = readStr("Roll No (" + s.getRollNo() + "): ");
		if (!roll.isBlank())
			s.setRollNo(roll);
		String name = readStr("Full name (" + s.getFullName() + "): ");
		if (!name.isBlank())
			s.setFullName(name);
		String email = readStr("Email (" + s.getEmail() + "): ");
		if (!email.isBlank())
			s.setEmail(email);
		String branch = readStr("Branch (" + s.getBranch() + "): ");
		if (!branch.isBlank())
			s.setBranch(branch);
		String yr = readStr("Year (" + s.getYear() + "): ");
		if (!yr.isBlank())
			s.setYear(Integer.parseInt(yr));
		String status = readStr("Status (" + s.getStatus() + "): ");
		if (!status.isBlank())
			s.setStatus(status);
		studentDAO.updateStudent(s);
	}

	// Company menu
	private static void companyMenu() {
		System.out.println("\n-- Company Menu --");
		System.out.println("1. Create Company");
		System.out.println("2. View Company by ID");
		System.out.println("3. View All Companies");
		System.out.println("4. Update Company");
		System.out.println("5. Delete Company");
		System.out.println("0. Back");
		int ch = readInt("Choice: ");
		switch (ch) {
		case 1 -> {
			String name = readStr("Name: ");
			String website = readStr("Website: ");
			String email = readStr("Contact email: ");
			Company c = new Company(name, website, email);
			companyDAO.createCompany(c);
		}
		case 2 -> {
			int id = readInt("Company id: ");
			Company c = companyDAO.getCompanyById(id);
			if (c != null)
				printCompany(c);
		}
		case 3 -> {
			List<Company> list = companyDAO.getAllCompanies();
			list.forEach(Main::printCompany);
		}
		case 4 -> {
			int id = readInt("Company id to update: ");
			Company c = companyDAO.getCompanyById(id);
			if (c == null)
				return;
			String name = readStr("Name (" + c.getName() + "): ");
			if (!name.isBlank())
				c.setName(name);
			String website = readStr("Website (" + c.getWebsite() + "): ");
			if (!website.isBlank())
				c.setWebsite(website);
			String email = readStr("Contact email (" + c.getContactEmail() + "): ");
			if (!email.isBlank())
				c.setContactEmail(email);
			companyDAO.updateCompany(c);
		}
		case 5 -> {
			int id = readInt("Company id to delete: ");
			companyDAO.deleteCompany(id);
		}
		default -> System.out.println("Back.");
		}
	}

	// Drive menu
	private static void driveMenu() {
		System.out.println("\n-- Drive Menu --");
		System.out.println("1. Create Drive");
		System.out.println("2. View Drive by ID");
		System.out.println("3. View All Drives");
		System.out.println("4. Update Drive");
		System.out.println("5. Delete Drive");
		System.out.println("0. Back");
		int ch = readInt("Choice: ");
		switch (ch) {
		case 1 -> {
			String title = readStr("Title: ");
			int companyId = readInt("Company id: ");
			String dateStr = readStr("Scheduled date (yyyy-mm-dd): ");
			Date d = Date.valueOf(dateStr);
			String adminIdStr = readStr("Admin id (optional): ");
			Integer adminId = adminIdStr.isBlank() ? null : Integer.parseInt(adminIdStr);
			Drive drv = new Drive(title, companyId, d, adminId);
			driveDAO.createDrive(drv);
		}
		case 2 -> {
			int id = readInt("Drive id: ");
			Drive drv = driveDAO.getDriveById(id);
			if (drv != null)
				printDrive(drv);
		}
		case 3 -> {
			List<Drive> list = driveDAO.getAllDrives();
			list.forEach(Main::printDrive);
		}
		case 4 -> {
			int id = readInt("Drive id to update: ");
			Drive drv = driveDAO.getDriveById(id);
			if (drv == null)
				return;
			String title = readStr("Title (" + drv.getTitle() + "): ");
			if (!title.isBlank())
				drv.setTitle(title);
			String companyIdStr = readStr("Company id (" + drv.getCompanyId() + "): ");
			if (!companyIdStr.isBlank())
				drv.setCompanyId(Integer.parseInt(companyIdStr));
			String dateStr = readStr("Scheduled date (" + drv.getScheduledDate() + "): ");
			if (!dateStr.isBlank())
				drv.setScheduledDate(Date.valueOf(dateStr));
			String adminIdStr = readStr("Admin id (" + drv.getAdminId() + "): ");
			if (!adminIdStr.isBlank())
				drv.setAdminId(Integer.parseInt(adminIdStr));
			driveDAO.updateDrive(drv);
		}
		case 5 -> {
			int id = readInt("Drive id to delete: ");
			driveDAO.deleteDrive(id);
		}
		default -> System.out.println("Back.");
		}
	}

	// Placement menu
	private static void placementMenu() {
		System.out.println("\n-- Placement Menu --");
		System.out.println("1. Create Placement");
		System.out.println("2. View Placement by ID");
		System.out.println("3. View All Placements");
		System.out.println("4. Update Placement");
		System.out.println("5. Delete Placement");
		System.out.println("0. Back");
		int ch = readInt("Choice: ");
		switch (ch) {
		case 1 -> {
			int studentId = readInt("Student id: ");
			int companyId = readInt("Company id: ");
			int driveId = readInt("Drive id: ");
			String role = readStr("Role: ");
			String status = readStr("Status (Selected/Rejected/On Hold): ");
			String pkg = readStr("Package (LPA) optional (e.g., 6.5): ");
			java.math.BigDecimal packageLpa = pkg.isBlank() ? null : new BigDecimal(pkg);
			Placement p = new Placement(studentId, companyId, driveId, role, status, packageLpa);
			placementDAO.createPlacement(p);
		}
		case 2 -> {
			int id = readInt("Placement id: ");
			Placement p = placementDAO.getPlacementById(id);
			if (p != null)
				printPlacement(p);
		}
		case 3 -> {
			List<Placement> list = placementDAO.getAllPlacements();
			list.forEach(Main::printPlacement);
		}
		case 4 -> {
			int id = readInt("Placement id to update: ");
			Placement p = placementDAO.getPlacementById(id);
			if (p == null)
				return;
			String studentIdStr = readStr("Student id (" + p.getStudentId() + "): ");
			if (!studentIdStr.isBlank())
				p.setStudentId(Integer.parseInt(studentIdStr));
			String companyIdStr = readStr("Company id (" + p.getCompanyId() + "): ");
			if (!companyIdStr.isBlank())
				p.setCompanyId(Integer.parseInt(companyIdStr));
			String driveIdStr = readStr("Drive id (" + p.getDriveId() + "): ");
			if (!driveIdStr.isBlank())
				p.setDriveId(Integer.parseInt(driveIdStr));
			String role = readStr("Role (" + p.getRole() + "): ");
			if (!role.isBlank())
				p.setRole(role);
			String status = readStr("Status (" + p.getStatus() + "): ");
			if (!status.isBlank())
				p.setStatus(status);
			String pkg = readStr("Package (" + p.getPackageLpa() + "): ");
			if (!pkg.isBlank())
				p.setPackageLpa(new BigDecimal(pkg));
			placementDAO.updatePlacement(p);
		}
		case 5 -> {
			int id = readInt("Placement id to delete: ");
			placementDAO.deletePlacement(id);
		}
		default -> System.out.println("Back.");
		}
	}

	// Admin menu
	private static void adminMenu() {
		System.out.println("\n-- Admin Menu --");
		System.out.println("1. Create Admin");
		System.out.println("2. View Admin by ID");
		System.out.println("3. View All Admins");
		System.out.println("4. Update Admin");
		System.out.println("5. Delete Admin");
		System.out.println("0. Back");
		int ch = readInt("Choice: ");
		switch (ch) {
		case 1 -> {
			String username = readStr("Username: ");
			String pass = readStr("Password: ");
			String name = readStr("Full name: ");
			String email = readStr("Email: ");
			Admin a = new Admin(username, pass, name, email);
			adminDAO.createAdmin(a);
		}
		case 2 -> {
			int id = readInt("Admin id: ");
			Admin a = adminDAO.getAdminById(id);
			if (a != null)
				printAdmin(a);
		}
		case 3 -> {
			List<Admin> list = adminDAO.getAllAdmins();
			list.forEach(Main::printAdmin);
		}
		case 4 -> {
			int id = readInt("Admin id to update: ");
			Admin a = adminDAO.getAdminById(id);
			if (a == null)
				return;
			String username = readStr("Username (" + a.getUsername() + "): ");
			if (!username.isBlank())
				a.setUsername(username);
			String pass = readStr("Password (hidden): ");
			if (!pass.isBlank())
				a.setPassword(pass);
			String name = readStr("Full name (" + a.getFullName() + "): ");
			if (!name.isBlank())
				a.setFullName(name);
			String email = readStr("Email (" + a.getEmail() + "): ");
			if (!email.isBlank())
				a.setEmail(email);
			adminDAO.updateAdmin(a);
		}
		case 5 -> {
			int id = readInt("Admin id to delete: ");
			adminDAO.deleteAdmin(id);
		}
		default -> System.out.println("Back.");
		}
	}

	// Helper I/O and printing
	private static int readInt(String prompt) {
		System.out.print(prompt);
		try {
			return Integer.parseInt(sc.nextLine().trim());
		} catch (Exception e) {
			return -1;
		}
	}

	private static String readStr(String prompt) {
		System.out.print(prompt);
		return sc.nextLine().trim();
	}

	private static void printStudent(Student s) {
		System.out.printf("Student[id=%d, roll=%s, name=%s, email=%s, branch=%s, year=%d, status=%s]%n",
				s.getStudentId(), s.getRollNo(), s.getFullName(), s.getEmail(), s.getBranch(), s.getYear(),
				s.getStatus());
	}

	private static void printCompany(Company c) {
		System.out.printf("Company[id=%d, name=%s, website=%s, email=%s]%n", c.getCompanyId(), c.getName(),
				c.getWebsite(), c.getContactEmail());
	}

	private static void printDrive(Drive d) {
		System.out.printf("Drive[id=%d, title=%s, company_id=%d, date=%s, admin_id=%s]%n", d.getDriveId(), d.getTitle(),
				d.getCompanyId(), d.getScheduledDate(), d.getAdminId() == null ? "null" : d.getAdminId().toString());
	}

	private static void printPlacement(Placement p) {
		System.out.printf(
				"Placement[id=%d, student_id=%d, company_id=%d, drive_id=%d, role=%s, status=%s, package=%s]%n",
				p.getPlacementId(), p.getStudentId(), p.getCompanyId(), p.getDriveId(), p.getRole(), p.getStatus(),
				p.getPackageLpa());
	}

	private static void printAdmin(Admin a) {
		System.out.printf("Admin[id=%d, username=%s, name=%s, email=%s]%n", a.getAdminId(), a.getUsername(),
				a.getFullName(), a.getEmail());
	}
}
