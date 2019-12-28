package alpha.ch11;

import java.util.*;

public class AddingGroups {

    public static void main(String[] args) {

        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        Integer[] moreInts = {6,7,8,9,10};
        collection.addAll(Arrays.asList(moreInts));

        Collections.addAll(collection, 11,12,13,14,15);
        Collections.addAll(collection, moreInts);

        List<Integer> arrayList = new ArrayList<Integer>();
        List<Integer> linkedList = new LinkedList<Integer>();

        ListIterator<Integer> listIterator = arrayList.listIterator();

//        Queue<Integer> queue = new Q  // Queue is interface
        Stack<Integer> stack = new Stack<Integer>();


    }
}
