package net.javaguides.__backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Scanner;

@SpringBootApplication(scanBasePackages = "net.javaguides.__backend")
public class Application implements CommandLineRunner {

	private final SystemService systemService;

	@Autowired
	public Application(SystemService systemService) {
		this.systemService = systemService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("===== Main Menu =====");
			System.out.println("1. View Available Lessons");
			System.out.println("2. Client Menu");
			System.out.println("3. Instructor Menu");
			System.out.println("4. Administrator Menu");
			System.out.println("5. Exit");

			System.out.print("Select an option: ");
			int option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
				case 1 -> systemService.displayAllLessons();
				case 2 -> clientMenu(scanner);
				case 3 -> instructorMenu(scanner);
				case 4 -> administratorMenu(scanner);
				case 5 -> {
					System.out.println("Exiting...");
					scanner.close();
					System.exit(option);
					;
				}
				default -> System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private void clientMenu(Scanner scanner) {
		System.out.println("===== Client Menu =====");
		System.out.println("1. Register as New Client");
		System.out.println("2. View Available Offerings");
		System.out.println("3. Make a Booking");
		System.out.println("4. View My Bookings");
		System.out.println("5. Cancel a Booking");
		System.out.println("6. Return to Main Menu");

		System.out.print("Select an option: ");
		int option = scanner.nextInt();
		scanner.nextLine();

		switch (option) {
			case 1 -> systemService.registerClient(scanner);
			case 2 -> systemService.displayActiveOfferings();
			case 3 -> systemService.makeBooking(scanner);
			case 4 -> systemService.viewMyBookings(scanner);
			case 5 -> systemService.cancelBooking(scanner);
			case 6 -> System.out.println("Returning to Main Menu");
			default -> System.out.println("Invalid choice. Please try again.");
		}
	}

	private void instructorMenu(Scanner scanner) {
		System.out.println("===== Instructor Menu =====");
		System.out.println("1. Create Instructor");
		System.out.println("2. View Available Offerings");
		System.out.println("3. Register for an Offering");
		System.out.println("4. View My Offerings");
		System.out.println("5. Return to Main Menu");

		System.out.print("Select an option: ");
		int option = scanner.nextInt();
		scanner.nextLine();

		switch (option) {
			case 1 -> systemService.createInstructor(scanner);
			case 2 -> systemService.instructorViewOfferings();
			case 3 -> systemService.registerOffering(scanner);
			case 4 -> systemService.viewMyOfferings(scanner);
			case 5 -> System.out.println("Returning to Main Menu");
			default -> System.out.println("Invalid choice. Please try again.");
		}
	}

	private void administratorMenu(Scanner scanner) {
		System.out.println("===== Administrator Menu =====");
		System.out.println("1. View All Clients");
		System.out.println("2. View All Instructors");
		System.out.println("3. View All Guardians");
		System.out.println("4. Delete a Client Account");
		System.out.println("5. Delete an Instructor Account");
		System.out.println("6. Delete a Guardian Account");
		System.out.println("7. Add New Offering");
		System.out.println("8. View All Bookings");
		System.out.println("9. Return to Main Menu");

		System.out.print("Select an option: ");
		int option = scanner.nextInt();
		scanner.nextLine();

		switch (option) {
			case 1 -> systemService.viewAllClients();
			case 2 -> systemService.viewAllInstructors();
			case 3 -> systemService.viewAllGuardians();
			case 4 -> systemService.deleteClient(scanner);
			case 5 -> systemService.deleteInstructor(scanner);
			case 6 -> systemService.deleteGuardian(scanner);
			case 7 -> systemService.addNewOffering(scanner);
			case 8 -> systemService.viewAllBookings();
			case 9 -> System.out.println("Returning to Main Menu");
			default -> System.out.println("Invalid choice. Please try again.");
		}
	}

}
