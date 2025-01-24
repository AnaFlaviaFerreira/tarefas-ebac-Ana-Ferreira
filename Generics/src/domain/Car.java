package domain;

public abstract class Car {
    protected Long id;
    protected String color;
    protected String type;
    protected String model;

    public Car(Long id, String color, String type, String model) {
        this.id = id;
        this.color = color;
        this.type = type;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
