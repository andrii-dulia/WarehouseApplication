package util;

import model.Product;

import java.util.List;

public class ListPrinter {

    ManagerService managerService = new ManagerService();
    public void productListPrint(List<Product> products){
        System.out.println("LIST of PRODUCTS");

        System.out.println("!"+"Number"+"!"+"Product name");

        for (int i=0;i<products.size();i++){
            System.out.println("!"+(i+1)+"!"+"      "+products.get(i).getName()+"!");
        }

    }
    public void printManagers(List<Product> products){
        System.out.println("List of managers");

        System.out.println("!"+"Number"+"!"+"Product name");

        for (int i=0;i<products.size();i++){
            System.out.println("!"+(i+1)+"!"+"      "+products.get(i).getName()+"!");
        }

    }
}
