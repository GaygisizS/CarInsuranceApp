package biletRezervasyonApp;

public class Ticket {
    //4-mesafe(km),koltuk no,fiyat,yolculuk tipi

    public double distance;

    public int typeNo;

    public String seatNo;

    private double price;//verilen bilgilere göre hesaplayacağız

    //5-bilet fiyatını hesaplama
    public void getTotalPrice(int age){
        double total=0;
        int seat=Integer.parseInt(this.seatNo);
        switch (this.typeNo){

            case 1://tek yön
                if (seat%3==0){
                    total=this.distance*1.2;
                }else {
                    total=this.distance*1;
                }
                System.out.println("Toplam tutar : "+total);
                break;
            case 2://çift yön:gidiş-dönüş
                if (seat%3==0){
                    total=this.distance*2.4;
                }else {
                    total=this.distance*2;
                }
                System.out.println("Toplam tutar : "+total);//100
                //çift yön indirimi
                total=total*0.8;//80
                System.out.println("Çift yön indirimli Toplam tutar : "+total);//80
                break;
        }
        //son tutardan yaş indirimi
        if(age<12){
            total=total*0.5;
            System.out.println("12 yaş altı indirimli Toplam tutar : "+total);//80
        }else if(age>65){
            total=total*0.7;//56
            System.out.println("65 yaş üstü indirimli Toplam tutar : "+total);//80
        }
        this.price=total;//56
    }



    //6-bileti yazdıralım
    public void printTicket(Bus bus){
        System.out.println("*".repeat(42));
        System.out.println("--- Bilet Detayı ---");
        System.out.println("Otobüs Plakası  :"+bus.numberPlate);
        System.out.println("Mesafe          :"+this.distance);
        System.out.println("Yolculuk Tipi   :"+(this.typeNo==1 ? "Tek Yön" : "Gidiş-Dönüş"));
        System.out.println("Koltuk No       :"+this.seatNo);
        System.out.println("Toplam Tutar    :"+this.price);
        System.out.println("Keyifli yolculuklar dileriz...");
        System.out.println("*".repeat(42));


    }








}