package util;

import java.util.Scanner;

public class FirstMenu {

    public void displayMenu(){
        System.out.println("To proceed like Administrator enter -1");
        System.out.println("To proceed like Warehouse Manager enter -2");
        System.out.println("Enter 'q' to quite");

    }

    public  void selectOption(){

        Scanner myScanner= new Scanner(System.in);

        String  choice=myScanner.nextLine();

        switch (choice){
            case "1":
                System.out.println("You are trying to log in as administrator:");
                AdminMenu adminMenu=new AdminMenu();

                if (adminMenu.adminLogIn()==true){
                    adminMenu.displayMenu();
                    adminMenu.selectAdminOption();
                } else {
                    System.out.println(" You can not procced as administator!!!");


                }



                break;
            case "2":
                System.out.println("You are trying to log in  as manager");



                ManagerMenu managerMenu=new ManagerMenu();
                if (managerMenu.logIn()==true){
                    managerMenu.displayMenu();
                    managerMenu.selectManagerOption();
                } else {
                    System.out.println(" You can not procced as manager!!!");
                    FirstMenu fm=new FirstMenu();
                    fm.displayMenu();
                    fm.selectOption();
                }


                //managerMenu.displayMenu();
                //managerMenu.selectManagerOption();

                break;

            case "q":
                System.out.println("Are you really want to quite???");

                break;

            default:
                System.out.println("Incorrect choice");
        }




    }





}
