package util;

import model.Product;

import java.util.List;

public class ListPrinter {

    public void productListPrint(List<Product> products){
        System.out.println("LIST of PRODUCTS");

        System.out.println("!"+"Number"+"!"+"Product name");

        for (int i=0;i<products.size();i++){
            System.out.println("!"+(i+1)+"!"+"      "+products.get(i).getName()+"!");
        }

    }
}
