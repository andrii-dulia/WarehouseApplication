package util;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class FirstMenu {

    Scanner in = new Scanner(System.in);
    String choice;
    String name;



    public void menu1() throws InterruptedException {
        displayMenu();
        selectOption();
    }

    public void displayMenu() {

        System.out.println("1. To proceed like Administrator");
        System.out.println("2. To proceed like Warehouse Manager");
        System.out.println("0. Exit");
    }

    public void selectOption() throws InterruptedException {
        choice = in.next();
        switch (choice) {
            case "1":
                AdminMenu adminMenu = new AdminMenu();
                System.out.println("You are trying to log in as administrator:");
                System.out.println("Print your name");
                name = in.next();
                if (adminMenu.adminLogIn(name, in) == true) {
                    adminMenu.adminMenu1();
                } else {
                    System.out.println("YOU SHALL NOT PASS!!!");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("COME BACK TO THE SHADOW");
                    TimeUnit.SECONDS.sleep(3);
                    menu1();
                }
            case "2":
                System.out.println("Log as manager");


                ManagerMenu managerMenu=new ManagerMenu();
                if (managerMenu.logIn()==true){
                    managerMenu.managerMenu();
                } else {
                    System.out.println(" You can not proceed as manager!!!");

                    menu1();
                }

            case "0":
                System.out.println("Bye Bye:)");
                break;

            default:
                System.out.println("Incorrect choice");
                System.out.println("Try again");
                menu1();
        }




    }





}
