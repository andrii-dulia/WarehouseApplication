package util;

import model.Address;
import model.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ClientService {

    Scanner in = new Scanner(System.in);


    public void addNewClient(Session session) {
        Transaction transaction = session.beginTransaction();
        Client client = new Client();
        System.out.println("Please provide company short name");
        client.setCompanyName(in.next());
        System.out.println("Please provide company full name");
        client.setFullName(in.next() + " " + in.next() + " " + in.next());
        System.out.println();
        System.out.println("Address:");
        client.setAddress(addClientAddress(session,Address.class,client));

        session.save(client);
        transaction.commit();
    }

    public Address addClientAddress(Session session, Class<Address> addressClass, Client client) {
        Address address = new Address();
        System.out.println("Country");
        address.setCountry(in.next());
        System.out.println("City");
        address.setCity(in.next());
        System.out.println("Post code");
        address.setPost_code(in.next());
        System.out.println("Street");
        address.setStreet(in.next());
        System.out.println("Number:");
        address.setNumber(in.nextLong());
        address.setClient(client);
        session.save(address);

        return address;
    }

    public List<Client> getClientList(Session session, Class<Client> clientClass) {

        Query<Client> query = session.createQuery("FROM clients");
        ArrayList<Client> clients = (ArrayList<Client>) query.list();
        return clients;
    }
    // get list of clients

    public void removeClient(Session session, Long id) {
        Transaction transaction = session.beginTransaction();

        Client client = session.find(Client.class, id);
        if (Objects.nonNull(client)) {
            session.delete(client);
        }
        transaction.commit();
    }

}

