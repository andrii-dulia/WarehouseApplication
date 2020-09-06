package util;

import model.Manager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;
import java.util.Scanner;

public class ManagerService {

    public Manager createManager() {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide manager name");
        manager.setName(scanner.nextLine());
        System.out.println("Password is automatically setted - '1111'!");

        return manager;
    }

    public void addNewManager(Manager manager) {
        manager = new Manager();
        final StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(standardServiceRegistry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(manager);
            transaction.commit();


            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // get list of managers

    public List<Manager> getManagersList() {

        final StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder().configure().build();


        List<Manager> managers = null;


        try (SessionFactory sessionFactory = new MetadataSources(standardServiceRegistry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();
                managers = session.createQuery("from Manager").list();
                transaction.commit();

            } catch (HibernateException e) {
                if (transaction != null) transaction.rollback();
                e.printStackTrace();
            }

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return managers;
    }
}
