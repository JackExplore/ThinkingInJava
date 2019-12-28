package alpha.ch5;

public class PassingThis {

    public static void main(String[] args) {

        Apple apple = new Apple();

        System.out.println("PassingThis : main() \t" + apple.toString());

        new Person().eat(apple);
    }
}


class Peeler{
    static Apple peel(Apple apple){
        // ... remove peel
        System.out.println("Peeler : peel() \t" + apple.toString());
        return apple;
    }
}

class Apple{
    Apple getPeeled(){
        System.out.println("Apple : getPeeled \t" + this.toString());
        return Peeler.peel(this);
    }
}

class Person{
    public void eat(Apple apple){
        System.out.println("Person : eat() \t" + apple.toString());
        Apple peeled = apple.getPeeled();
        System.out.println("Yummy");
    }
}

