package RestaurantCafeBillGenerator;

import java.util.Scanner;

/*
Proje: Restaurant Fiş Üretme Uygulaması(BillGenerator)
       1-Bir restaurantın online sipariş sisteminde hesabı
       yazdıran uygulama tasarlayınız.

       2-Restauranttaki yiyecekler bir listte tutulsun.
         Yiyeceklerin kodu, ismi ve ücreti olsun.

       3-Yiyecek menüsü gösterme, sipariş oluşturma/iptal ve hesap
         oluşturma için seçim menüsü gösterilsin.

       4-Yiyecek menü:Listedeki yiyecekler menü şeklinde listelensin
         Sipariş girme:Yiyeceğin kodu ve istenilen adet girilerek sipariş oluşturulsun
                       Her sipariş için kod üretilsin(başlangıç 1000 artarak devam eder)
                       Her bir yiyecek siparişi için tutar hesaplansın

         Sipariş iptal:Sipariş kodu girilerek sipariş silinsin
         Hesap oluşturma: Tutarları ile birlikte tüm siparişleri ve
                          toplam tutarı gösteren bir hesap fişi yazdırılsın.
*/


/*
ÖDEV: Şirket büyüdü, cafe kısmı açıldı.
      Aynı uygulama cafe kısmında da kullanılsın.
      Cafede farklı menü var.
        Dish dish1=new Dish(401,"Tiramisu",35.0);
        Dish dish2=new Dish(402,"Dondurma",25.0);
        Dish dish3=new Dish(402,"Profiterol",25.0);
        Dish dish4=new Dish(403,"Kahve",17.5);
        Dish dish5=new Dish(404,"Çay",7.5);
        Dish dish6=new Dish(405,"Portakal Suyu",25.5);
      Uygulama başladığında restaurant/cafe seçeneği olsun.

*/



public class RestaurantCafeBillGenerator {

    public static void main(String[] args) {

        start();

    }

    public static void start(){
        Scanner inp=new Scanner(System.in);
        OrderService orderService=new OrderService();
        DishService dishService;
        int option;
        do {
            option=getOption(inp);//1,2,0
            switch (option){
                case 1:
                    dishService=new DishService();//restaurantdaki yemekler
                    break;
                case 2:
                    dishService=new CafeDishService();//cafeDishServicedeki filldishlist
                    break;
                case 0:
                    System.out.println("Sistemden çıkış yapıldı.");
                    dishService=null;
                    break;
                default:
                    System.out.println("Hatalı giriş");
                    dishService=null;
                    break;
            }
            getSelectionMenu(dishService,orderService);
        }while (option!=0);


    }

    public static int getOption(Scanner scan){
        System.out.println("Merhaba, ");
        System.out.println("1-Restaurant");
        System.out.println("2-Kafeterya");
        System.out.println("0-ÇIKIŞ");
        System.out.println("Seçiminiz : ");
        return scan.nextInt();
    }




    public static void getSelectionMenu(DishService dishService,OrderService orderService){
        Scanner inp=new Scanner(System.in);

        if (dishService!=null){

            int select=-1;
            while (select!=0){
                System.out.println("-----------------------------------------------");
                System.out.println(" *** Lezzet Restaurant ve Cafe Sipariş Uygulaması *** ");
                System.out.println("1-Menü");
                System.out.println("2-Sipariş Gir");
                System.out.println("3-Sipariş İptal");
                System.out.println("4-Hesap Oluştur");
                System.out.println("0-ÇIKIŞ");
                System.out.println("Seçiminiz : ");
                select=inp.nextInt();
                System.out.println("------------------------------------------------");

                switch (select){
                    case 1:
                        dishService.showMenu();
                        break;
                    case 2:
                        //sipariş gir
                        orderService.createOrder(dishService);
                        break;
                    case 3:
                        //sipariş iptal
                        orderService.deleteOrder();
                        break;
                    case 4:
                        //hesap oluşturalım
                        orderService.printBill();
                        break;
                    case 0:
                        System.out.println("İyi günler dileriz.");
                        break;
                    default:
                        System.out.println("Hatalı giriş!");
                        break;
                }

            }
        }


    }


}