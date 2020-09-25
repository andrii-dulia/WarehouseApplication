package util;

import model.Address;
import model.Client;
import model.Manager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ManagerService {
    Scanner in = new Scanner(System.in);

    public void createManager(Session session) {
        Transaction transaction = session.beginTransaction();
        Manager manager = new Manager();
        System.out.println("Please provide manager name");
        manager.setName(in.next());
        System.out.println("Please provide password");
        manager.setPassword(in.next());
        if (manager.getPassword()==null||manager.getPassword()==""){
            manager.setPassword("1111");
        }

        session.save(manager);
        transaction.commit();
    }

    public List<Manager> getManagersList(Session session, Class<Manager> clientClass){
                Query<Manager> query = session.createQuery("from managers");
        ArrayList<Manager> managerList = (ArrayList<Manager>) query.list();
        return managerList;

    }
    public void removeManager(Session session, Long id) {
        Transaction transaction = session.beginTransaction();

        Manager manager = session.find(Manager.class, id);
        if (Objects.nonNull(manager)) {
            session.delete(manager);
        }
        transaction.commit();

    }
}
