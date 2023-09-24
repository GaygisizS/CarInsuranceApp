package biletRezervasyonApp;
/*
Project: Bilet Rezervasyon ve Bilet Fiyatı Hesaplama Uygulaması

    1-Uygulama mesafe ve kurallara göre otobüs bileti fiyatı hesaplar sonuç olarak bilet bilgisini verir
    2- Kullanıcıdan     mesafe (KM),
                        yolcu yaşı ,
                        yolculuk tipi (Tek Yön, Gidiş-Dönüş)
                        ve koltuk no bilgilerini alınır.
             NOT: Koltuk numaraları 1-32 aralığında olmalıdır.)
                  Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
                  Aksi halde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

    3-Fiyat hesaplama kuralları:
       -Mesafe başına ücret:
                  Tek yön: 1 Lira / km       Çift Yön(Gidiş-Dönüş): 2 Lira/km
       -Tekli Koltuk ücreti:
                  Koltuk no 3 veya 3 ün katı ise fiyat %20 daha fazladır(Tek yön: 1.2 Lira/km, Çift Yön:2.4 Lira/km).
       -İlk olarak seferin mesafe, yön ve koltuk no bilgisine göre fiyatı hesaplanır,
        sonrasında koşullara göre aşağıdaki indirimler uygulanır ;
                   i)-Çift Yön indirimi:
                               "Yolculuk Tipi" gidiş dönüş seçilmiş ise son bilet fiyatı üzerinden %20 indirim uygulanır.
                   ii)-Yaş indirimi:
                                Kişi 12 yaşından küçükse son bilet fiyatı üzerinden %50 indirim uygulanır.
                                Kişi 65 yaşından büyük ise son bilet fiyatı üzerinden %30 indirim uygulanır.

 */


import java.util.Scanner;

public class TicketReservationApp {

    public static void main(String[] args) {

        //1- bilet rezervasyonunu yapacağımız bir otobüse ihtiyacımız
        Bus bus=new Bus("34 ASD 789");//"1","2",...
        //2- bilet objesini oluşturalım.
        Ticket bilet=new Ticket();

        //7-uygulamayı başlatalım.
        start(bus,bilet);

    }

    private static void start(Bus bus, Ticket bilet) {
        Scanner inp=new Scanner(System.in);
        int select;///ÇIKIŞ için 0 seçiniz.
        do {
            //8-kullanıcıdan bilgileri alalım
            System.out.println("* Bilet Rezervasyon Sistemine Hoşgeldiniz *");

            System.out.println("Lütfen yaşınızı giriniz: ");
            int age=inp.nextInt();

            System.out.println("Lütfen gidilecek mesafe bilgisini KM olarak giriniz: ");
            int distance=inp.nextInt();

            System.out.println("Lütfen yolculuk tipini seçiniz :");
            System.out.println("1. Tek Yön");
            System.out.println("2. Gidiş-Dönüş");
            int type=inp.nextInt();

            System.out.println("Koltuk no seçiniz : ");
            System.out.println("Tekli koltuk ücreti %20 daha fazladır.");
            System.out.println(bus.seats);//mevcut koltuk noları:"1","2",..."32"
            String seat=inp.next();

            //seçilen koltuk no listede var mı,rezerve edilmiş mi
            boolean isReserved=!bus.seats.contains(seat);
            if (isReserved){//koltuk listede yoksa
                System.out.println("Seçilen koltuk rezerve edilmiştir.");
            }
            //girilen değerler geçerli mi
            if (age>0 && distance>0 && (type==1 || type==2) && !isReserved ){
                //koltuk no rezerve olacağı için listeden çıkaralım.
                bus.seats.remove(seat);
                //bileti oluşturalım
                bilet.distance=distance;
                bilet.typeNo=type;
                bilet.seatNo=seat;
                bilet.getTotalPrice(age);
                //bileti yazdıralım
                bilet.printTicket(bus);
            }else{
                System.out.println("Geçersiz giriş yaptınız.");
            }
            System.out.println("Yeni işlem için bir sayı girin, ÇIKIŞ için 0 giriniz:");
            select=inp.nextInt();


        }while (select!=0);
        System.out.println("İyi günler dileriz...");
    }


}








