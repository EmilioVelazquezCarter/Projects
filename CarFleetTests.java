import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.util.List;


public class CarFleetTests {
    
    @Test
    public void testEmptyRequestList() {
        CarFleet carFleet = new CarFleet();
        
        Queue<Integer> requestList = new Queue<>();
        List<Car> result = carFleet.processRequests(requestList);
    
        assertEquals(0, result.size()); 
    }
    

    @Test
    public void testNormalRequests() {
        CarFleet carFleet = new CarFleet();
        Car gasCar = new Car(1, 1, 50f);
        Car hybridCar = new Car(2, 2, 60f);
        Car electricCar = new Car(3, 3, 70f);
    
        carFleet.addCar(gasCar);
        carFleet.addCar(hybridCar);
        carFleet.addCar(electricCar);
    
        Queue<Integer> requestList = new Queue<>();
        requestList.enqueue(1);
        requestList.enqueue(2);
        requestList.enqueue(3);
    
        List<Car> result = carFleet.processRequests(requestList);
    
        assertEquals(3, result.size());
        assertEquals(gasCar, result.get(0)); 
        assertEquals(hybridCar, result.get(1));
        assertEquals(electricCar, result.get(2)); 
    }

    @Test
    public void testRequestsWithNoCarsAvailable() {
        CarFleet carFleet = new CarFleet();
    
        Queue<Integer> requestList = new Queue<>();
        requestList.enqueue(1);
        requestList.enqueue(2);
        requestList.enqueue(3);
    
        List<Car> result = carFleet.processRequests(requestList);
    
        assertEquals(3, result.size());
        assertEquals(0, result.get(0).getId()); 
        assertEquals(0, result.get(1).getId());
        assertEquals(0, result.get(2).getId());
    }
    
    
    @Test
    public void testMixedRequests() {
        Car gasCar = new Car(1, 1, 10f);    
        Car hybridCar = new Car(2, 2, 20f);
        
        CarFleet carFleet = new CarFleet();
        
    
        carFleet.addCar(gasCar);
        carFleet.addCar(hybridCar);

    
        Queue<Integer> requestList = new Queue<>();
        requestList.enqueue(1);
        requestList.enqueue(2);
        requestList.enqueue(3); 
    
        List<Car> result = carFleet.processRequests(requestList);
    
        assertEquals(3, result.size());
        assertEquals(gasCar, result.get(0));           
        assertEquals(hybridCar, result.get(1));         
        assertEquals(0, result.get(2).getId());          
    }

@Test
    public void testAddCar() {
        CarFleet carFleet = new CarFleet();

        Car gasCar = new Car(1, 1, 10f);     
        Car hybridCar = new Car(2, 2, 20f);  
        Car electricCar = new Car(3, 3, 30f);
        Car invalidCar = new Car(4, 4, 40f); 

        assertTrue(carFleet.addCar(gasCar));

        assertTrue(carFleet.addCar(hybridCar));

        assertTrue(carFleet.addCar(electricCar));

        assertFalse(carFleet.addCar(invalidCar));
    }



}

