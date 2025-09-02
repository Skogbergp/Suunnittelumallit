
public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        ObservingStation weatherApp = new ObservingStation("WeatherApp");
        ObservingStation homeDisplay = new ObservingStation("HomeDisplay");

        weatherStation.addObserver(weatherApp);
        weatherStation.addObserver(homeDisplay);

        Thread t = new Thread(weatherStation);
        t.start();


    }
}