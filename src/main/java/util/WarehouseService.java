package util;

import model.OrderDetails;
import model.Product;
import model.Warehouse;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Scanner;

public class WarehouseService {

    //  create product to warehouse by Id

    public Warehouse createSinglePositionInWarehouse(){

        Scanner scanner=new Scanner(System.in);
        System.out.println("Please provide product id");

        int providedId=scanner.nextInt();
        ProductService productService=new ProductService();
        Product product=productService.getProductById(providedId);

        System.out.println("Please provide quantity of products which will be added to warehouse");

        int quantity=scanner.nextInt();

        Warehouse warehouseItem=new Warehouse(product,quantity);



        return warehouseItem;

    }

    // add warehouse item
    public void addProductToWarehouse(Warehouse warehouseItem){

        final StandardServiceRegistry standardServiceRegistry=
                new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory=new MetadataSources(standardServiceRegistry)
                .buildMetadata().buildSessionFactory()){
            Session session=sessionFactory.openSession();

            Transaction transaction=null;
            try{
                transaction=session.beginTransaction();
                session.save(warehouseItem);
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
