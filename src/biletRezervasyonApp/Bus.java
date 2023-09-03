package biletRezervasyonApp;

import java.util.ArrayList;
import java.util.List;

public class Bus {

    //2-plaka ve koltuk no
    public String numberPlate;

    public List<String> seats=new ArrayList<>();


    //3-otobüsü oluşturduğumda plaka ve koltuk nolar set edilsin
    public Bus(String plaka){
        this.numberPlate=plaka;
        for (int i=1;i<33;i++){
            this.seats.add(String.valueOf(i));
            // this.seats.add(i+"");
        }

    }

}