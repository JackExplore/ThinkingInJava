package alpha.ch17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class FailFast {
    public static void main(String[] args) {
//        Collection<String> c = Collections.synchronizedList(new ArrayList<String>());

        Collection<String> c = new ArrayList<String>();
        Iterator<String> it = c.iterator();
        c.add("An object");
        try{
            String  s = it.next();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
