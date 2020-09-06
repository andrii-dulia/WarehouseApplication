package util;

import java.util.Scanner;

public class ManagerMenu implements LogIn {

    Scanner in = new Scanner(System.in);
    String  choice;
    String back = "";
    ProductService productService=new ProductService();

    public void menuBack(){
        System.out.println("0. Previous menu");
        back = in.next();
        if (back=="0"){
            managerMenu();
        }else {
            System.out.println("try again!!!");
            menuBack();
        }
    }
    public void managerMenu(){
        displayMenu();
        selectManagerOption();
    }

    public void displayMenu(){
        System.out.println("Manager options:");
        System.out.println("1.List of the products");
        System.out.println("2.Add new products");
        System.out.println("3.List of warehouse items (products in warehouse with their attributes)");
        System.out.println("4.Add new item to warehouse");
        System.out.println("5.Orders menu");
        System.out.println("6.Back to previous menu");
        System.out.println("0.Exit");
    }

    public  void selectManagerOption(){

        choice = in.next();

        switch (choice){
            case "1":
                System.out.println("PRODUCTS");
                ListPrinter listPrinter=new ListPrinter();
                listPrinter.printList(productService.getProducts());
               menuBack();
            case "2":
                System.out.println("CREATE NEW PRODUCT");
                productService.addProduct(productService.createProduct());
                System.out.println("Product added");
                managerMenu();
            case "3":
                System.out.println("Items on storehouse");

                menuBack();
            case "4":
                System.out.println("Add item to storehouse");
                //ManagerService managerService=new ManagerService();
                //Manager manager=new Manager();
                //managerService.addNewManager(manager.createManager());

            case "0":
                System.out.println("Bye Bye:)");

                break;

            default:
                System.out.println("Incorrect choice");
                System.out.println("Try again");
                managerMenu();
        }


    }

    @Override
    public boolean logIn() {
        return false;
    }
}
