package util;

import java.util.Scanner;

public class AdminMenu {
    public Scanner in = new Scanner(System.in);
    String choice;
    FirstMenu fm = new FirstMenu();
    ClientService cs = new ClientService();


    public void adminMenu1() throws InterruptedException {
        displayMenu();
        selectAdminOption();
    }

    public static void displayMenu() {
        System.out.println("Administrator options:");
        System.out.println("1.List of the clients");
        System.out.println("2.Add client");
        System.out.println("3.List of warehouse managers");
        System.out.println("4.Add new  warehouse manager");
        System.out.println("5.List of items");
        System.out.println("6.Add new item");
        System.out.println("0.Back to previous menu");

    }

    public void selectAdminOption() throws InterruptedException {
        ManagerService managerService = new ManagerService();
        choice = in.next();
        switch (choice) {
            case "1":
                System.out.println("CLIENTS");
                cs.getClientList();
                System.out.println("Empty list");
                System.out.println();

                adminMenu1();
            case "2":
                System.out.println("CREATE NEW CLIENT");
                cs.addNewClient(cs.createClient());


                adminMenu1();
            case "3":
                System.out.println("MANAGERS");
                managerService.getManagersList();
                adminMenu1();

            case "4":
                System.out.println("CREATE NEW MANAGER");

                managerService.addNewManager(managerService.createManager());
                System.out.println("Manager created");
                adminMenu1();


            case "0":
                System.out.println("Bye Bye");
               break;

            default:
                System.out.println("Incorrect choice");
                adminMenu1();

        }
    }

    public static boolean adminLogIn(String name, Scanner in){
        boolean result = false;
        switch (name){
            case "Piotrek":
                result = true;
            case "Andrii":
                result = true;
            default:

        }
        return result;
    }
}
