package com.epam.pihnastyi.task4.entity;


import java.util.Objects;

public class Drink extends Product {

    private boolean isSugar;
    private boolean isGas;
    private String packagingType;

    public Drink() {
    }

    public Drink(int id, String name, String color, double price, boolean isSugar, boolean isGas) {
        super(id, name, color, price);
        this.isSugar = isSugar;
        this.isGas = isGas;
    }

    public boolean isSugar() {
        return isSugar;
    }

    public void setSugar(boolean sugar) {
        this.isSugar = sugar;
    }

    public boolean isGas() {
        return isGas;
    }

    public void setGas(boolean gas) {
        this.isGas = gas;
    }

    public String getPackagingType() {
        return packagingType;
    }

    public void setPackagingType(String packagingType) {
        this.packagingType = packagingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Drink drink = (Drink) o;
        return isSugar == drink.isSugar &&
                isGas == drink.isGas &&
                Objects.equals(packagingType, drink.packagingType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isSugar, isGas, packagingType);
    }

    @Override
    public String toString() {
        return super.toString() + ", is sugar = " + isSugar + ", is gas = " + isGas + ", packaging type = " + packagingType + " ";
    }
}
