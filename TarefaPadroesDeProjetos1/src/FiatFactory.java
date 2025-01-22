public class FiatFactory  implements Factory{

    @Override
    public Car createCar(String color,String model) {
        System.out.println("Selecionado carro Fiat.");
        return new Hatch(color, "hatch", model);

    }
}
