package util;

import model.Manager;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class ManagerMenu {

    Scanner in = new Scanner(System.in);
    String  choice;
    String back = "";
    FirstMenu firstMenu = new FirstMenu();
    ProductService productService=new ProductService();
    WarehouseService warehouseService=new WarehouseService();
    ManagerService ms = new ManagerService();
    Session session;
    public void managerMenu(Session session) throws InterruptedException {
        displayMenu();
       selectManagerOption(session);
    }
    public void menuBack() throws InterruptedException {
        System.out.println("x. Previous menu");
        back = in.next();
        if (back=="x"){
            firstMenu.mainMenu(session);
        }else {
            System.out.println("try again!!!");
            menuBack();
        }
    }
    public void displayMenu(){
        System.out.println("Manager options:");
        System.out.println("1. Create order");
        System.out.println("2. List of the products");
        System.out.println("3. Shipment");
        System.out.println("4. stuff on magazine");
        System.out.println("5. Back to previous menu");
        System.out.println("x. Exit");
    }

    public  void selectManagerOption(Session session) throws InterruptedException {
        choice = in.next();
        switch (choice){
            case "1":

                menuBack();
            case "2":

                managerMenu(session);
            case "3":
                System.out.println("Items on storehouse");

                menuBack();
            case "4":
                System.out.println("ADD  PRODUCT TO WAREHOUSE");
                warehouseService.addProductToWarehouse(warehouseService.createSinglePositionInWarehouse());
                System.out.println("Product added");
                managerMenu(session);

            case "5":
                firstMenu.mainMenu(session);

            case "x":
                System.out.println("Bye Bye:)");
                System.exit(0);
            default:
                System.out.println("Incorrect choice");
                System.out.println("Try again");
                managerMenu(session);
        }


    }

    public boolean logIn(Session session) {

        System.out.println("Managers:");
        System.out.println();
        List<Manager> managerList = ms.getManagersList(session, Manager.class);
        System.out.println(managerList);
        System.out.println("Please provide manager id");
        System.out.println();
        boolean managerIn=false;
        Long id= in.nextLong();
        String pass;
        Manager manager = session.find(Manager.class, id);
        System.out.println("password:");
        pass = in.next();
        if (manager!=null&manager.getPassword().equals(pass)){
            managerIn=true;
        }else {
            System.out.println("wrong id or password");
            logIn(session);
        }
        return managerIn;
    }
}
