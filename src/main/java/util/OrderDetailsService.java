package util;

import model.OrderDetails;
import model.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Scanner;

public class OrderDetailsService {

    // create single position to order by providing product id
    public OrderDetails createSinglePositionInOrder(){

        Scanner in=new Scanner(System.in);
        System.out.println("Please provide product id");

        Long providedId = in.nextLong();
        ProductService productService=new ProductService();


        System.out.println("Please provide quantity");

        Long quantity=in.nextLong();



        return null;

    }

    // add positions of orders (table orders_details) to data base
    public void addProductsOrderDetail(OrderDetails orderDetails){

        final StandardServiceRegistry standardServiceRegistry=
                new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory=new MetadataSources(standardServiceRegistry)
                .buildMetadata().buildSessionFactory()){
            Session session=sessionFactory.openSession();

            Transaction transaction=null;
            try{
                transaction=session.beginTransaction();
                session.save(orderDetails);
                transaction.commit();
            } catch (HibernateException e){
                if (transaction!=null) transaction.rollback();
                e.printStackTrace();
            }

            session.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
