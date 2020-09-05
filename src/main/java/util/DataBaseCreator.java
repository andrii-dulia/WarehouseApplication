package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DataBaseCreator {

    public void createDataBase(){

        // connection to DataBase and create all tables

        final StandardServiceRegistry standardServiceRegistry=
                new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory=new MetadataSources(standardServiceRegistry)
                .buildMetadata().buildSessionFactory()){
            Session session=sessionFactory.openSession();
            session.close();
        }
        //comment
        catch (Exception e){
            e.printStackTrace();
        }

    }


}
