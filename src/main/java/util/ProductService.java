package util;

import model.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;
import java.util.Scanner;

public class ProductService {

    public Product getProductById(int id){

        final StandardServiceRegistry standardServiceRegistry=
                new StandardServiceRegistryBuilder().configure().build();

        Product product=null;

        try (SessionFactory sessionFactory=new MetadataSources(standardServiceRegistry)
                .buildMetadata().buildSessionFactory()){
            Session session=sessionFactory.openSession();
            Transaction transaction=null;

            try{
                transaction=session.beginTransaction();
                product=session.get(Product.class,id);
                transaction.commit();
            } catch (HibernateException e){
                if (transaction!=null) transaction.rollback();
                e.printStackTrace();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return product;

    }








    // create product


    public Product createProduct(){
        Product product=new Product();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please provide product name");
        product.setName(scanner.nextLine());
        System.out.println("Please provide product price");
        product.setPrice(scanner.nextInt());
        return product;

    }

    // add product to Data Base

    public void addProduct(Product product){

        final StandardServiceRegistry standardServiceRegistry=
                new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory=new MetadataSources(standardServiceRegistry)
                .buildMetadata().buildSessionFactory()){
            Session session=sessionFactory.openSession();

            Transaction transaction=null;
            try{
                transaction=session.beginTransaction();
                session.save(product);
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


        // get list of products

        public List<Product> getProducts(){




            final StandardServiceRegistry standardServiceRegistry=
                    new StandardServiceRegistryBuilder().configure().build();


        List<Product> products=null;


            try (SessionFactory sessionFactory=new MetadataSources(standardServiceRegistry)
                    .buildMetadata().buildSessionFactory()){
                Session session=sessionFactory.openSession();

                Transaction transaction=null;

                try{
                    transaction=session.beginTransaction();
                    products=session.createQuery("from Product").list();
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
            return products;

    }



}
