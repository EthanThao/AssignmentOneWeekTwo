// Ethan Thao 
// Week 2 Assignment Two
// 11/15/2021


// Now to import the necessary utilities and other components
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Then create the public class
public class AssignmentOnePetsDatabase {

    // Now for the file name 
    private String fileName;

    // Here is the array list
    private ArrayList<AssignmentOnePet> pets;

    // Then int size 
    private int number;

    public AssignmentOnePetsDatabase() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the input/output file name for pet data: ");
        
        this.fileName = scanner.nextLine().trim();

        this.pets = new ArrayList<>();

        this.number = 0;

    }

    // Then to load the data
    public void loadData() {

        Scanner fileReader;

        try {

            fileReader = new Scanner(new File(fileName));

            while (fileReader.hasNextLine()) {

                String line = fileReader.nextLine().trim();

                String[] data = line.split(",");

                String name = data[0];

                int age = Integer.parseInt(data[1]);

                this.pets.add(new AssignmentOnePet(name, age));
            }

            fileReader.close();

        } catch (FileNotFoundException fnfe) {

            System.out.println("Error: Cannot find " + fileName + ".\n");

            System.exit(1);
        }
    }

    // Now to view the pets
    public void viewAllPets() {

        if (this.pets.isEmpty())

            System.out.println("Error: Sorry, there are no pets to show!\n");

        else {

            System.out.println("+-----------------------+");

            System.out.printf("| %2s | %-10s | %3s |\n", "ID", "NAME", "AGE");

            System.out.println("+-----------------------+");

            for (int i = 0; i < number; i++) {


                System.out.printf("| %2d | %-10s | %3d |\n", i, this.pets.get(i).getName(), this.pets.get(i).getAge());

            }

            System.out.println("+-----------------------+\n" + number + " rows in set.\n");
        }
    }

    // Now to add the new pets
    public void addNewPets() {

        Scanner scanner = new Scanner(System.in);

        String petsFromUser;

        do {

            System.out.print("add pet (name, age): ");

            petsFromUser = scanner.nextLine().trim();

            if (petsFromUser.equalsIgnoreCase("done"))

                break;

            if (number >= 5) {

                System.out.println("Error: Database is full.\n");

                return;
            }

            String name;
            int age;

            while (petsFromUser.split(" ").length != 2 || isDigit(petsFromUser.split(" ")[0])
            
                    || (Integer.parseInt(petsFromUser.split(" ")[1]) < 1 || Integer.parseInt(petsFromUser.split(" ")[1]) > 20)) {

                if (petsFromUser.split(" ").length != 2) {

                    System.out.println("Error: " + petsFromUser + " is not a valid input.");

                    System.out.print("add pet (name, age): ");

                    petsFromUser = scanner.nextLine().trim();

                }

                if (isDigit(petsFromUser.split(" ")[0])) {

                    System.out.println("Error: " + petsFromUser.split(" ")[0] + " is not a valid input.");

                    System.out.print("add pet (name, age): ");

                    petsFromUser = scanner.nextLine().trim();

                }

                if (Integer.parseInt(petsFromUser.split(" ")[1]) < 1 || Integer.parseInt(petsFromUser.split(" ")[1]) > 20) {

                    System.out.println("Error: " + petsFromUser.split(" ")[1] + " is not a valid age.");

                    System.out.print("add pet (name, age): ");

                    petsFromUser = scanner.nextLine().trim();

                }
            }

            String[] data = petsFromUser.split(" ");
            name = data[0];
            age = Integer.parseInt(data[1]);

           
            this.pets.add(new AssignmentOnePet(name, age));

            number++;

        } while (!petsFromUser.equalsIgnoreCase("done"));

        System.out.println(number + " pets added.\n");

    }

    // Now to remove pets
    public void removeAPet() {

        viewAllPets();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the pet ID to remove: ");
        int Id = Integer.parseInt(scanner.nextLine().trim());

        if (Id < 0 || Id > number) {

            System.out.println("Error: ID " + Id + " does not exist.\n");

        } 
        else {

            String oldName = this.pets.get(Id).getName();

            int oldAge = this.pets.get(Id).getAge();

            this.pets.remove(Id);

            number--;

            System.out.println(oldName + " " + oldAge + " is removed.\n");
        }
    }

    // Now to write to the File
    public void writeToFile() {
        // FIle writer as fw
        // Printer writer as pw
        FileWriter fw;
        PrintWriter pw;

        try {

            fw = new FileWriter(new File(fileName));

            pw = new PrintWriter(fw);

            for (AssignmentOnePet pet : this.pets) {

                pw.write(pet.getName() + "," + pet.getAge() + System.lineSeparator());

            }

            pw.flush();

            fw.close();

            pw.close();

        } 
        catch (IOException ex) {

            System.out.println("Error: Writing to file " + fileName + " - " + ex.getMessage());

        }
    }

    private boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}