package RestaurantBillGenerator;

import java.util.ArrayList;
import java.util.List;

//4-Dish objeleri ile ilgili işlemler
public class DishService {

    //5-yiyecekleri bir listeye koyalım

    private List<Dish> dishList=new ArrayList<>();

    //5-a-yiyecekleri oluşturup listeye ekleme
    public DishService(){
        fillDishList();
    }

    private void fillDishList() {
        Dish dish1=new Dish(100,"Adana Kebabı",250.99);
        Dish dish2=new Dish(101,"Urfa Kebabı",200.0);
        Dish dish3=new Dish(102,"Çökertme Kebabı",200.0);
        Dish dish4=new Dish(200,"Baklava",100.0);
        Dish dish5=new Dish(201,"Kadayıf",85.0);
        Dish dish6=new Dish(202,"Künefe",75.0);
        Dish dish7=new Dish(300,"Yayık Ayranı",30.0);
        Dish dish8=new Dish(301,"Kola",35.0);
        Dish dish9=new Dish(302,"Çay",15.0);
        Dish dish10=new Dish(303,"Su",7.5);
        this.dishList.add(dish1);
        this.dishList.add(dish2);
        this.dishList.add(dish3);
        this.dishList.add(dish4);
        this.dishList.add(dish5);
        this.dishList.add(dish6);
        this.dishList.add(dish7);
        this.dishList.add(dish8);
        this.dishList.add(dish9);
        this.dishList.add(dish10);
    }

    //6-yemek menüsünü gösterme
    public void showMenu(){
        System.out.println("           *** Lezzetlerimiz ***                ");
        System.out.printf("%-3s    %-20s    %-6s     \n","Kod","Adı","Fiyat");
        System.out.printf("%-3s    %-20s    %-6s     \n","***","****","************");

        for (Dish dish:dishList){

            System.out.printf("%-3s    %-20s    %-6s  Lira\n",dish.getCode(),dish.getName(),dish.getPrice());

        }
    }

    //12-kodu verilen yemeği listeden bulalım
    public Dish findDishByCode(int code){//500
        if (code==0){
            System.out.println("Ana menüye yönlendiriliyorsunuz.");
        }else {
            for (Dish dish:dishList){
                if (dish.getCode()==code){
                    return dish;//metod biter
                }
            }
            System.out.println("Ürün bulunamadı!");
        }
        return null;
    }
















}