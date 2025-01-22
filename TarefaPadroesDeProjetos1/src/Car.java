public abstract class Car {
    private String color;
    private String type;
    private String model;

    public Car(String color, String type, String model) {
        this.color = color;
        this.type = type;
        this.model = model;
    }

    public void sendCar(){
        System.out.println("Está pronto o carro do modelo: " + model + ", da cor: " + color + ", do tipo: " + type);
    }
}
