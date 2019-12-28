package alpha.ch14.Pet;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
    private static String[] typeNames = {"com.demo.thinking.ch14.Pet.Dog", "com.demo.thinking.ch14.Pet.Mutt"};
    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    private static void loader(){
        try{
            for(String name : typeNames){
                types.add((Class<? extends Pet>)Class.forName(name));
            }
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

}
