import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import util.FirstMenu;

public class Application {
    public static void main(String[] args) throws InterruptedException {

        final StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder().configure().build();
        try (
                SessionFactory sessionFactory = new MetadataSources(standardServiceRegistry)
                        .buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            //   ****  connection to DataBase and create all tables  ****   //

//        final StandardServiceRegistry standardServiceRegistry=
//                new StandardServiceRegistryBuilder().configure().build();
//
//        try (SessionFactory sessionFactory=new MetadataSources(standardServiceRegistry)
//                .buildMetadata().buildSessionFactory()){
//            Session session=sessionFactory.openSession();
//            session.close();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }


//
//        // test - order details
//        OrderDetailsService orderDetailsService=new OrderDetailsService();
//        orderDetailsService.addProductasOrderDetail(orderDetailsService.createSinglePositionInOrder());
//        //System.out.println(orderDetailsService.createSinglePositionInOrder().toString());
//
//        // test add product to warehouse
//        WarehouseService warehouseService=new WarehouseService();
//        warehouseService.addProductToWarehouse(warehouseService.createSinglePositionInWarehouse());

            // connection to DataBase and create all tables directly in main method


// display  application menus and choosing option from menus


            FirstMenu fm = new FirstMenu();
            fm.mainMenu(session);


            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
