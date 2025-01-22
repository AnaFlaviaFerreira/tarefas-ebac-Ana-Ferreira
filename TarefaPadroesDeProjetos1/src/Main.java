//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Factory factory1 = new FiatFactory();
        Car car1 = factory1.createCar("Red", "Ka");
        car1.sendCar();

        Factory factory2 = new HyundaiFactory();
        Car car2 = factory2.createCar("Gray", "Venue");
        car2.sendCar();
    }
}