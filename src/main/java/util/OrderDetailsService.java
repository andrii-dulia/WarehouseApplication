package util;

import model.OrderDetails;
import model.Product;

import java.util.Scanner;

public class OrderDetailsService {

    public OrderDetails createSinglePositionInOrder(){

        //OrderDetails orderDetails=new OrderDetails();

        Scanner scanner=new Scanner(System.in);
        System.out.println("Please provide product id");

        int providedId=scanner.nextInt();
        ProductService productService=new ProductService();
        Product product=productService.getProductById(providedId);

        System.out.println("Please provide quantity");

        int quantity=scanner.nextInt();

        OrderDetails orderDetails1=new OrderDetails(product,quantity);








        return null;

    }
}
