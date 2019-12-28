package alpha.ch10.action;

public class GreenhouseControls extends Controller {

    private boolean light = false;
    public class LightOn extends Event{
        public LightOn(long delayTime){
            super(delayTime);
        }
        @Override
        public void action() {
            light = true;
        }
        public String toString(){
            return "Light is on";
        }
    }

    public class Bell extends Event{
        public Bell(long delayTime){
            super(delayTime);
        }
        public void action(){
            addEvent(new Bell(delayTime));
        }
        public String toString(){
            return "Bing!";
        }
    }
}
