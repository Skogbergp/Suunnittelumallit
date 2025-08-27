import java.util.ArrayList;

public class WeatherStation implements Runnable {
    private float temperature = (float) (Math.random() * 50 -20); //initial temperature between -20 and 30

    private ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            float newTemperature = getTemperature() + (float) (Math.random() * 6 -3);
            if (newTemperature > -28 && newTemperature < 35) {
                setTemperature(newTemperature);
            }

        }
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public synchronized void setTemperature(float temperature){
        this.temperature = temperature;
        notifyObservers();
    }

    public float getTemperature(){
        return temperature;
    }


    public synchronized void notifyObservers(){
        for(Observer observer : observers){
            observer.update(getTemperature());
        }
    }


}
