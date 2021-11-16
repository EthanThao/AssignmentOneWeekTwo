// Ethan Thao 
// Week 2 Assignment Two
// 11/15/2021 


// We need to import the scanner 
import java.util.Scanner;

public class AssignmentOnePetsDatabaseApplication {

    public static void main(String[] args) {

        // New scanner
        Scanner scanner = new Scanner(System.in);

        // Choose which database to find
        AssignmentOnePetsDatabase petDB = new AssignmentOnePetsDatabase();

        // Get the number from the user to identify their decision
        int userNumber;


        System.out.println();

        // A do loop is used here 
        do {

            printMenu();
            userNumber = Integer.parseInt(scanner.nextLine().trim());
            switch (userNumber) {
            

            // If 1 then view all the pets
            case 1: {

                System.out.println();

                petDB.viewAllPets();

                break;
            }

            // If 2 then add pets 
            // But remember that the database can only have 5 entries
            case 2: {

                System.out.println();

                petDB.addNewPets();

                break;
            }

            // 3 for removing a pet 
            case 3: {

                System.out.println();

                petDB.removeAPet();

                break;

            }

            // 4 for leaving the application
            case 4: {

                petDB.writeToFile();

                System.out.println("\nGoodbye!\n");

                System.exit(0);

            }

            // A default message
            default:

                System.out.println("\nInvalid choice!\n");
            }

        } while (userNumber != 4);
    }

    // Now to print out the menu
    private static void printMenu() {
        System.out.print("What would you like to do?\n" + "1. View all pets\n" + "2. Add new pets\n"
                + "3. Remove a pet\n" + "4. Exit program\n" + "Your choice: ");
    }
}