package util;

import java.util.Scanner;

public class ManagerMenu implements LogIn {
    public void displayMenu(){
        System.out.println("Manager options:");
        System.out.println("1.List of the products-enter '1'");
        System.out.println("2.Add new products- enter '2'");
        System.out.println("3.List of warehouse items (products in warehouse with ther atributes) - enter '3'");
        System.out.println("4.Add new  warehouse item- enter '4'");
        System.out.println("5.Orders menu - enter '5'");
        System.out.println("6.Back to previous menu- enter 'q'");
        System.out.println("Please make your choise???");

    }

    public  void selectManagerOption(){

        Scanner myScanner= new Scanner(System.in);

        String  choice=myScanner.nextLine();

        switch (choice){
            case "1":
                System.out.println("PRODUCTS");
                ProductService productService1=new ProductService();
                ListPrinter listPrinter=new ListPrinter();
                listPrinter.printList(productService1.getProducts());

                ManagerMenu managerMenu=new ManagerMenu();
                managerMenu.displayMenu();
                managerMenu.selectManagerOption();




                break;
            case "2":
                System.out.println("CREATE NEW PRODUCT");
                ProductService productService=new ProductService();
                productService.addProduct(productService.createProduct());

                ManagerMenu managerMenu1=new ManagerMenu();
                managerMenu1.displayMenu();
                managerMenu1.selectManagerOption();

                break;

            case "3":
                System.out.println("MANAGERS");

                break;
            case "4":
                System.out.println("CREATE NEW MANAGER");
                //ManagerService managerService=new ManagerService();
                //Manager manager=new Manager();
                //managerService.addNewManager(manager.createManager());
                FirstMenu fm=new FirstMenu();
                fm.displayMenu();
                fm.selectOption();

                break;



            case "q":
                System.out.println("Are you really want to quite???");

                break;

            default:
                System.out.println("Incorrect choice");
        }


    }

    @Override
    public boolean logIn() {
        return false;
    }
}
