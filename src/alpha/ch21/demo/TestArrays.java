package alpha.ch21.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArrays {

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<Integer>();
        Integer[] tempList = new Integer[]{1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0};

        System.out.println("IntegerMax : " + Integer.MAX_VALUE);
        while(true){
            if(arrayList.size() < Integer.MAX_VALUE - 1000){
                arrayList.addAll(Arrays.asList(tempList));
            }else{
                arrayList.add(1);
            }
            System.out.println(arrayList.size());
        }
    }
}
