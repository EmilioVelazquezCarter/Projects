import java.util.List;
import java.util.ArrayList;


public class Queue<T> {

    public List<T> queue;

    public static void main(String[] args){

    }

    public Queue(){
        queue = new ArrayList<T>();

    }

    public List<T> enqueue(T value){
        
        queue.add(value);
        return queue;
    }

    public T dequeue(){
        return queue.remove(0);

    }


    public boolean isEmpty(){
        if (queue.size() == 0){
            return true;
        }
        return false;
    }

    public T peek(){

        return queue.get(0);
        
    }

    
}
