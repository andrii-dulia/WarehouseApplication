package util;

import model.Client;
import model.Order;
import model.Product;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    Scanner in = new Scanner(System.in);
    Long id;
    Long qty;

    public void createOrder(Session session){
        Order order = new Order();
        Client client = new Client();
        System.out.println("Client Id:");
        id = in.nextLong();
        order.setClient(session.find(Client.class, id));




    }
    public List<Product> products(){
List<Product> productList = (List<Product>) new HashSet<Product>();
        System.out.println("product id:");
        id = in.nextLong();

        System.out.println("quantity:");
        qty = in.nextLong();
        return null;
    }


}
