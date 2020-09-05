package util;

import java.util.Scanner;

public class AdminMenu {
    public void AdminMenu1(){
        displayMenu();
        selectAdminOption();
    }

    public static void displayMenu(){
        System.out.println("Administrator options:");
        System.out.println("1.List of the clients");
        System.out.println("2.Add client- enter '2'");
        System.out.println("3.List of warehouse managers - enter '3'");
        System.out.println("4.Add new  warehouse manager- enter '4'");
        System.out.println("5.List of items - enter '5'");
        System.out.println("6.Add new item- enter '6'");
        System.out.println("7.Back to previous menu- enter 'q'");
        System.out.println("Please make your choise???");

    }
    public  void selectAdminOption(){

        Scanner myScanner= new Scanner(System.in);

        String  choice=myScanner.nextLine();

        switch (choice){
            case "1":
                System.out.println("CLIENTS");




                break;
            case "2":
                System.out.println("CREATE NEW CLIENT");

                break;

            case "3":
                System.out.println("MANAGERS");

                break;
            case "4":
                System.out.println("CREATE NEW MANAGER");
                ManagerService managerService=new ManagerService();
                managerService.addNewManager(managerService.createManager());
                FirstMenu fm=new FirstMenu();
                fm.displayMenu();
                fm.selectOption();
                System.out.println("Manager created");
                AdminMenu1();





            case "q":
                System.out.println("Are you really want to quite???");

                break;

            default:
                System.out.println("Incorrect choice");
                AdminMenu1();

        }




    }






    public static boolean adminLogIn(){
        boolean result = true;
        System.out.println("Please provide your name");
        Scanner scanner= new Scanner(System.in);
        String tempAdminName=scanner.nextLine();


        return result;



    }




}
