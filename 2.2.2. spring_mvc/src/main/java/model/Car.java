package model;

public class Car {

    private String name;
    private Long licensePlate;

    public Car(String name, Long licensePlate) {
        this.name = name;
        this.licensePlate = licensePlate;
    }

    public Car() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(Long licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", licensePlate=" + licensePlate +
                '}';
    }
}
