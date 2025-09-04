

public class Car{
    int powerSource;
    int id;
    float pricePerDay;

    public static void main(String[] args){

    }

    public Car(int id, int powerSource, float pricePerDay){
        this.powerSource = powerSource;
        this.id = id;
        this.pricePerDay = pricePerDay;
    }

    public int getId(){
        return id;
    }


    public int setId(int newId){
        id = newId;
        return id;
    }
    

    public int getPowerSource(){
        return powerSource;
    }


    public int setPowerSource(int newPowerSource){
        powerSource = newPowerSource;
        return powerSource;
    }


    public float getPricePerDay(){
        return pricePerDay;
    }

    public float setPricePerDay(float newPricePerDay){
        pricePerDay = newPricePerDay;
        return pricePerDay;
    }


}