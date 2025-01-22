public class HyundaiFactory implements Factory{

    @Override
    public Car createCar(String color,String model) {
        System.out.println("Selecionado carro Hyundai.");
        return new Sedan(color, "sedan", model);
    }
}
