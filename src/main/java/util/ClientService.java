package util;

import model.Client;
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

public class ClientService {
    Scanner in = new Scanner(System.in);
    public Client createClient() {


        System.out.println("Please provide client full name");
        Client clientToAdd = new Client(in.next());
        return clientToAdd;
    }

    public void addNewClient(Client client) {

        final StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(standardServiceRegistry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();


            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // get list of clients

    public List<Client> getClientList() {

        final StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder().configure().build();


        List<Client> clients = null;


        try (SessionFactory sessionFactory = new MetadataSources(standardServiceRegistry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();
                clients = session.createQuery("from client").list();
                transaction.commit();

            } catch (HibernateException e) {
                if (transaction != null) transaction.rollback();
                e.printStackTrace();
            }

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clients;
    }
}
