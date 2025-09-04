import java.util.List;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Mergesort {
    public static void main(String[] args){
    }
    
    
    static LinkedList<Integer> sort(LinkedList<Integer> ll){
        if (ll.size() <= 1){
            return ll;
        }
        int mid = ll.size() / 2;
        
        LinkedList<Integer> left = makeNewList(ll, 0, mid);
        LinkedList<Integer> right = makeNewList(ll, mid, ll.size());

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }
    static LinkedList<Integer> makeNewList(LinkedList<Integer> original, int fromHere, int toHere){
        LinkedList<Integer> newList = new LinkedList<>();

        for (int i = fromHere; i < toHere; i++) {
            newList.add(original.get(i));
        }

        return newList;
    }
            
    

    static LinkedList<Integer> merge (LinkedList<Integer> a, LinkedList<Integer> b){
        LinkedList<Integer> newList = new LinkedList<>();

        while (!a.isEmpty() && !b.isEmpty()) {
            if (a.getFirst() <= b.getFirst()) {
                newList.add(a.poll());
            } else {
                newList.add(b.poll());
            }
        }

        while (!a.isEmpty()) {
            newList.add(a.poll());
        }

        while (!b.isEmpty()) {
            newList.add(b.poll());
        }

        return newList;
    }
}






