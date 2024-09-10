package урок6.hw;
import java.util.*;

public class Laptop {
    private String brand;
    private int ram;
    private int storage;
    private String os;
    private String color;


    public Laptop(String brand, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }


    public String getBrand() { return brand; }
    public int getRam() { return ram; }
    public int getStorage() { return storage; }
    public String getOs() { return os; }
    public String getColor() { return color; }


    public String toString() {
        return String.format("Brand: %s, RAM: %d, Storage: %d, OS: %s, Color: %s",
                brand, ram, storage, os, color);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return ram == laptop.ram &&
                storage == laptop.storage &&
                Objects.equals(brand, laptop.brand) &&
                Objects.equals(os, laptop.os) &&
                Objects.equals(color, laptop.color);
    }

    public int hashCode() {
        return Objects.hash(brand, ram, storage, os, color);
    }
}

