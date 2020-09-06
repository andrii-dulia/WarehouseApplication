import util.DataBaseCreator;
import util.FirstMenu;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("WAREHOUSE MANAGEMENT APPLICATION");


        // connection to DataBase and create all tables
        DataBaseCreator dataBaseCreator=new DataBaseCreator();
        dataBaseCreator.createDataBase();

        // test - order details
//        OrderDetailsService orderDetailsService=new OrderDetailsService();
//        orderDetailsService.addProductasOrderDetail(orderDetailsService.createSinglePositionInOrder());
        //System.out.println(orderDetailsService.createSinglePositionInOrder().toString());

        // test add product to warehouse
//        WarehouseService warehouseService=new WarehouseService();
//        warehouseService.addProductToWarehouse(warehouseService.createSinglePositionInWarehouse());

        // connection to DataBase and create all tables directly in main method

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


        // display  application menus and choosing option from menus

        FirstMenu fm=new FirstMenu();
        fm.menu1();
    }
}
