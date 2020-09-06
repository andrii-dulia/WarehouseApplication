package util;

import java.util.Scanner;

public class ManagerMenu implements LogIn {

    Scanner in = new Scanner(System.in);
    String  choice;
    String back = "";
    ProductService productService=new ProductService();
    WarehouseService warehouseService=new WarehouseService();

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
                ProductService productService1=new ProductService();
               for(int i=0;i<productService1.getProducts().size();i++){
                   System.out.println(productService1.getProducts().get(i).toString());
               }

                //System.out.println("PRODUCTS");
               // ProductService productService1=new ProductService();
               // ListPrinter listPrinter=new ListPrinter();
               // listPrinter.productListPrint(productService1.getProducts());
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
                System.out.println("ADD  PRODUCT TO WAREHOUSE");
                warehouseService.addProductToWarehouse(warehouseService.createSinglePositionInWarehouse());
                System.out.println("Product added");
                managerMenu();


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
        boolean result = true;
        System.out.println("Please provide your adminID");
        boolean managerNameIsCorrect=false;
  /*
        do{
            Scanner adScan=new Scanner(System.in);
            String tempId=adScan.nextLine();

            if (tempName.equals(adminID)){
                adminIdIsCorrect=true;
                System.out.println("Please provide your PIN(4digits)?");
                boolean pinIsCorrect=true;
                int counter=0;
                do {
                    String tempPin=adScan.nextLine();

                    if (tempPin.equals(adminPin)){
                        System.out.println("You have loged in as administrator!!!");
                        pinIsCorrect=true;
                        result=true;
                    }else {
                        pinIsCorrect=false;
                        result=false;
                        System.out.println("You have provided wrong PIN!!!Please provide again?");
                        counter++;
                        if (counter==1) System.out.println("You have 2 attempts!!!");
                        if (counter==2) System.out.println("last attempt!!!!");
                        if (counter==3) pinIsCorrect=true;
                    }
                }while (pinIsCorrect==false);

            }else{
                System.out.println("You have provided wrong adminID.Please provide again!");
                adminIdIsCorrect=false;
            }
        }while(managerNameIsCorrect==false);
*/
        return true;
    }
}
