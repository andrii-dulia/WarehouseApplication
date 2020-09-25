package util;

import net.bytebuddy.asm.Advice;
import org.hibernate.Session;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class FirstMenu {


    Scanner in = new Scanner(System.in);
    String choice;
    String name;


    public void mainMenu(Session session) throws InterruptedException {
        System.out.println("WAREHOUSE MANAGEMENT APPLICATION");
        displayMenu();
        selectOption(session);
    }

    public void displayMenu() {

        System.out.println("1. To proceed like Administrator");
        System.out.println("2. To proceed like Warehouse Manager");
        System.out.println("x. Exit");
    }

    public void selectOption(Session session) throws InterruptedException {
        choice = in.next();

        switch (choice) {
            case "1":
                AdminMenu adminMenu = new AdminMenu();
                System.out.println("You are trying to log in as administrator:");
                System.out.println("Print your name");
                name = in.next();
                if (adminMenu.adminLogIn(name, in) == true) {
                    adminMenu.adminMenu1(session);
                } else {
                    System.out.println("YOU SHALL NOT PASS!!!");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("COME BACK TO THE SHADOW");
                    TimeUnit.SECONDS.sleep(3);
                    mainMenu(session);
                }
            case "2":
                System.out.println("Log as manager");
                ManagerMenu managerMenu = new ManagerMenu();
                if (managerMenu.logIn(session) == true) {
                    managerMenu.managerMenu(session);
                } else {
                    System.out.println(" You can not proceed as manager!!!");
                    mainMenu(session);
                }
            case "x":
                System.out.println("Bye Bye:)");
                System.exit(0);

            default:
                System.out.println("Incorrect choice");
                System.out.println("Try again");
                System.out.println();
                mainMenu(session);
        }

    }


}
