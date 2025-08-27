public class ObservingStation implements Observer{
    private String name;
    private float temperature;

    public ObservingStation(String name) {
        this.name = name;
    }


    @Override
    public void update(float temperature) {
        this.temperature = temperature;
        System.out.println("Observing Station " + name + " updated temperature to: " + temperature + "°C");
    }
}
