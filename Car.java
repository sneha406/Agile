package com.Cartrader.Richinternet.dto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.concurrent.locks.Condition;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String make;
    @NotNull
    private String model;
    @NotNull
    private String colour;
    @NotNull
    private int year;
    @NotNull
    private double litre;
    @NotNull
    private double price;
    @NotNull
    private int mileage;
    @NotNull
    private String seller;
    @NotNull
    private Condition condition;

    Car() {
    }

    public Car(int id, String make, int mileage, String model, String colour, int year, String seller, double litre, double price, Condition condition) {

        this.id = id;
        this.make = make;
        this.mileage = mileage;
        this.model = model;
        this.colour = colour;
        this.year = year;
        this.seller = seller;
        this.litre = litre;
        this.price= price;
        this.condition = condition;
    }

    public Car(int i, String bmw_beast, int i1, String beast, String blue, int i2, int i3, int i4, String good) {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getLitre() {
        return litre;
    }

    public void setLitre(double litre) {
        this.litre = litre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", colour='" + colour + '\'' +
                ", price=" + price +
                ", condition='" + condition + '\'' +
                ", seller='" + seller + '\'' +
                ", litre='" + litre + '\'' +
                ", mileage='" + mileage + '\'' +
                '}';
    }
}
