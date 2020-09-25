package util;

import model.Client;
import model.Manager;
import model.Product;
import org.hibernate.Session;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AdminMenu {


    public Scanner in = new Scanner(System.in);
    public String choice;
    String backMen;
    Long id;
    FirstMenu fm = new FirstMenu();
    ClientService cs = new ClientService();
    ManagerService ms = new ManagerService();
    ProductService productService = new ProductService();
    Manager manager = new Manager();

    public void adminMenu1(Session session) throws InterruptedException {
        displayMenu();

        selectAdminOption(session);

    }

    public static void displayMenu() {
        System.out.println("Administrator options:");
        System.out.println("1. Add client");
        System.out.println("2. Show clients");
        System.out.println("3. Remove client");
        System.out.println("4. Add new  warehouse manager");
        System.out.println("5. List of warehouse managers");
        System.out.println("6. Remove manager");
        System.out.println("7. Add new item");
        System.out.println("8. List of items");
        System.out.println("0. Back to previous menu");

    }

    public void selectAdminOption(Session session) throws InterruptedException {

        ManagerService managerService = new ManagerService();
        choice = in.next();
        switch (choice) {
            case "1":
                System.out.println("CREATE NEW CLIENT");
                cs.addNewClient(session);
                System.out.println("Client added");
                System.out.println();
                backMenu(session);
            case "2":
                System.out.println("Client List: ");
                System.out.println();
                List<Client> lista = cs.getClientList(session, Client.class);
                System.out.println(lista);
                System.out.println();

                backMenu(session);
            case "3":
                List<Client> clients = cs.getClientList(session, Client.class);
                System.out.println(clients);
                System.out.println();
                System.out.println("Print ID of company to delete");
                id = in.nextLong();
                Client client = session.find(Client.class, id);
                if (Objects.isNull(client)) {
                    System.out.println("no id like this");
                    backMenu(session);
                } else {
                    System.out.println("You really sure to delete client?");
                    System.out.println("y/n");
                    String yesOrNo = in.next();
                    switch (yesOrNo) {
                        case "y":
                            cs.removeClient(session, id);
                            backMenu(session);
                            System.out.println("Client removed");
                        case "n":
                            System.out.println("Client stay");
                            backMenu(session);
                        default:
                            System.out.println("try again later");
                            backMenu(session);
                    }
                }

            case "4":
                System.out.println("Create new manager");
                ms.createManager(session);
                System.out.println("manager added");
                System.out.println();
                backMenu(session);

            case "5":
                System.out.println("Managers:");
                System.out.println();
                List<Manager> managerList = ms.getManagersList(session, Manager.class);
                System.out.println(managerList);
                System.out.println();
                backMenu(session);
            case "6":

                List<Manager> managers = ms.getManagersList(session, Manager.class);
                System.out.println(managers);
                System.out.println();
                System.out.println("Print id manager to delete");
                id = in.nextLong();
                Manager manager = session.find(Manager.class, id);
                if (Objects.isNull(manager)) {
                    System.out.println("wrong name");
                    backMenu(session);
                }else {
                    System.out.println("You sure to delete " + manager.getName() + " ?");
                    System.out.println("y/n");
                    String sure = in.next();
                    switch (sure) {
                        case "y":
                            ms.removeManager(session, id);
                            System.out.println("manager is leaving company");
                            System.out.println();
                            backMenu(session);
                        case "n":
                            System.out.println("manager stay");
                            backMenu(session);
                        default:
                            System.out.println("try again");
                            backMenu(session);
                    }
                }
            case "7":
                System.out.println("new item:");
                System.out.println();
                productService.createProduct(session);
                System.out.println("Product added");

                backMenu(session);

            case "8":
                System.out.println("List of items:");
                System.out.println();
                List<Product> productList = productService.getProducts(session, Product.class);
                System.out.println(productList);
                backMenu(session);

            case "0":

                fm.mainMenu(session);

            default:
                System.out.println("Incorrect choice");
                backMenu(session);

        }
    }
    public void backMenu(Session session) throws InterruptedException {
        System.out.println("x. Back menu");
        backMen = in.next();
        if (backMen.equals("x")){
            adminMenu1(session);
        }else {
            backMenu(session);
        }
    }
    public static boolean adminLogIn(String name, Scanner in) {
        boolean result = false;
        switch (name) {
            case "p":
                result = true;
            case "Andrii":
                result = true;
            default:

        }
        return result;
    }
}
