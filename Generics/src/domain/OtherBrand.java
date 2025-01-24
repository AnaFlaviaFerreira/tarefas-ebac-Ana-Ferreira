package domain;

public class OtherBrand extends Car implements Persistent{
    private String brandName;
    private String countryOrigin;

    public OtherBrand(Long id, String color, String type, String model, String brandName, String countryOrigin) {
        super(id, color, type, model);
        this.brandName = brandName;
        this.countryOrigin = countryOrigin;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    @Override
    public Long getId() {
        return super.id;
    }
}
