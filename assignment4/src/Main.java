//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        ObservingStation weatherApp = new ObservingStation("WeatherApp");
        ObservingStation homeDisplay = new ObservingStation("HomeDisplay");

        weatherStation.addObserver(weatherApp);
        weatherStation.addObserver(homeDisplay);

        Thread t = new Thread(weatherStation);
        t.start();

        while(true){
            System.out.println("hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}