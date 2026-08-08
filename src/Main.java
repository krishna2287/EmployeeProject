import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int choice = 0;

        while (choice != 5) {
            System.out.println("1. Add Employee");
            System.out.println("2. Read Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = input.nextInt();

            if (choice == 1) {
                try {
                    FileWriter fw = new FileWriter("employee.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    input.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = input.nextLine();

                    bw.write(name);
                    bw.newLine();

                    bw.close();

                    System.out.println("Employee Added.");

                } catch (Exception e)
                {
                    System.out.println("Error.");
                }

            }

            else if (choice == 2) {

                try {
                    BufferedReader br = new BufferedReader(new FileReader("employee.txt"));
                    String line;
                    System.out.println("\nEmployees:");

                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }

                    br.close();

                } catch (Exception e)

                {
                    System.out.println("No Employees Found.");
                }

            }

            else if (choice == 3) {

                try {

                    input.nextLine();

                    System.out.print("Enter Employee Name to Update: ");
                    String oldName = input.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = input.nextLine();

                    File oldFile = new File("employee.txt");
                    File newFile = new File("temp.txt");

                    BufferedReader br = new BufferedReader(new FileReader(oldFile));
                    BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));

                    String line;

                    while ((line = br.readLine()) != null) {

                        if (line.equals(oldName)) {

                            bw.write(newName);

                        } else {
                            bw.write(line);
                        }

                        bw.newLine();
                    }

                    br.close();
                    bw.close();

                    //oldFile.delete();
                    //newFile.renameTo(oldFile);

                    System.out.println("Employee Updated.");

                } catch (Exception e)
                {
                    System.out.println("Error.");
                }

            }

            else if (choice == 4) {

                try {

                    input.nextLine();

                    System.out.print("Enter Employee Name to Delete: ");
                    String deleteName = input.nextLine();

                    File oldFile = new File("employee.txt");
                    File newFile = new File("temp.txt");

                    BufferedReader br = new BufferedReader(new FileReader(oldFile));
                    BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));

                    String line;

                    while ((line = br.readLine()) != null) {

                        if (!line.equals(deleteName)) {

                            bw.write(line);
                            bw.newLine();

                        }

                    }

                    br.close();
                    bw.close();

                    //oldFile.delete();
                    //newFile.renameTo(oldFile);

                    System.out.println("Employee Deleted.");

                } catch (Exception e)
                {
                    System.out.println("Error.");
                }

            }

            else if (choice == 5)
            {
                System.out.println("Exit!");
            }

            else
            {
                System.out.println("Invalid Choice.");
            }

        }

        input.close();

    }

}