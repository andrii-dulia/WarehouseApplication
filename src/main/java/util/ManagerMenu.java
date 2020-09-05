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
                ProductService productService1=new ProductService();
               for(int i=0;i<productService1.getProducts().size();i++){
                   System.out.println(productService1.getProducts().get(i).toString());
               }

                //System.out.println("PRODUCTS");
               // ProductService productService1=new ProductService();
               // ListPrinter listPrinter=new ListPrinter();
               // listPrinter.productListPrint(productService1.getProducts());

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
                System.out.println("ADD  PRODUCT TO WAREHOUSE");
                WarehouseService warehouseService=new WarehouseService();
                warehouseService.addProductToWarehouse(warehouseService.createSinglePositionInWarehouse());

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
