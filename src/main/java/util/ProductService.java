package util;

import model.Client;
import model.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    Scanner in = new Scanner(System.in);


    public Product getProductById(Long id){

        return null;
    }

    // create product


    public void createProduct(Session session){
        Transaction transaction = session.beginTransaction();
        Product product=new Product();
        System.out.println("Please provide product name");
        product.setName(in.nextLine());
        System.out.println("Please provide product price");
        product.setPrice(in.nextLong());

        session.save(product);
        transaction.commit();

    }


        public List<Product> getProducts(Session session, Class<Product> productClass){

            Query<Product> query = session.createQuery("FROM products");
            ArrayList<Product> products = (ArrayList<Product>) query.list();

            return products;

    }



}
