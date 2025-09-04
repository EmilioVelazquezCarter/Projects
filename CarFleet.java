import java.util.List;
import java.util.ArrayList;



public class CarFleet {
    
    Queue<Car> gasQueue = new Queue<Car>();
    Queue<Car> electicQueue = new Queue<Car>();
    Queue<Car> hybridQueue = new Queue<Car>();




    public static void main(String[] args){

        }



    public boolean addCar(Car car){
        if (car.getPowerSource() == 1){
            gasQueue.enqueue(car);
            return true;
        }

        if (car.getPowerSource() == 2){
            hybridQueue.enqueue(car);
            return true;

        }
    
        if (car.getPowerSource() == 3){
            electicQueue.enqueue(car);
            return true;

        }
        return false;

    }

    public List<Car> processRequests(Queue<Integer> requestList){
        List<Car> filled_list = new ArrayList<Car>();
        while (!requestList.isEmpty()) {
            int request = requestList.peek();  
            if (request == 1) {
                if (!gasQueue.isEmpty()) {
                    filled_list.add(gasQueue.dequeue());
                } else {
                    filled_list.add(new Car(0, 1, 0f));
                }
            } else if (request == 2) {
                if (!hybridQueue.isEmpty()) {
                    filled_list.add(hybridQueue.dequeue());
                } else {
                    filled_list.add(new Car(0, 2, 0f));
                }
            } else if (request == 3) {
                if (!electicQueue.isEmpty()) {
                    filled_list.add(electicQueue.dequeue());
                } else {
                    filled_list.add(new Car(0, 3, 0f));
                }
            }
            requestList.dequeue();
        
        }

        return filled_list;
           
    
    }


}