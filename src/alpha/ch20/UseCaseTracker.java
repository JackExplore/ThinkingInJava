package alpha.ch20;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {

    public static void trackUseCases(List<Integer> useCases, Class<?> cl){
        for(Method m : cl.getDeclaredMethods()){
            UseCase uc = m.getAnnotation(UseCase.class);
            if(uc != null){
                System.out.println("Found UseCase : " + uc.id() + " " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for(int i : useCases){
            System.out.println("Warning  : Missing use case - " + i);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        System.out.println("list content1 : " + useCases);
        trackUseCases(useCases, PassWordUtils.class);
        System.out.println("list content2 : " + useCases);

        System.out.println("Testable methods: ");
        Class<?> c = Testable.class;
        for(Method m : c.getMethods()){
            System.out.println(m.getName());
        }

        Class.forName("com.demo.thinking.ch20.Testable");   // 会加载 static 域
    }
}
