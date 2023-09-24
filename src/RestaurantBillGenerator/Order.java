package RestaurantBillGenerator;

public class Order {

    private static int count=999;//1000
    private int orderCode;
    private Dish dish;//100-Adana kebabı-250
    private int numberOfDish;//3
    private double orderPrice;//3*250

    //8-yemek ve adedini kullanarak order objemiz oluşsun

    public Order(Dish dish, int numberOfDish) {
        count++;//1000,1001
        this.orderCode=count;
        this.dish = dish;
        this.numberOfDish = numberOfDish;
    }

    //9-orderPrice ı hesaplayalım
    public void setOrderPrice(){
        this.orderPrice=this.dish.getPrice()*this.numberOfDish;
    }

    public void setNumberOfDish(int numberOfDish) {
        this.numberOfDish = numberOfDish;
    }

    //getter metodları


    public int getOrderCode() {
        return orderCode;
    }

    public Dish getDish() {
        return dish;
    }

    public int getNumberOfDish() {
        return numberOfDish;
    }

    public double getOrderPrice() {
        return orderPrice;
    }
}