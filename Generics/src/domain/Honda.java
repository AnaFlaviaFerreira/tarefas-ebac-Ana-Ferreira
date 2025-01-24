package domain;

public class Honda extends Car implements Persistent {
    public Honda(Long id, String color, String type, String model) {
        super(id, color, type, model);
    }

    @Override
    public Long getId() {
        return super.id;
    }
}
