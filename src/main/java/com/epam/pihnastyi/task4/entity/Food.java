package com.epam.pihnastyi.task4.entity;

import java.util.Objects;

public class Food extends Product {

    private boolean isHealthy;
    private String country;

    public Food() {
    }

    public Food(int id, String name, String color, double price, boolean isHealthy, String country) {
        super(id, name, color, price);
        this.isHealthy = isHealthy;
        this.country = country;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Food food = (Food) o;
        return isHealthy == food.isHealthy &&
                Objects.equals(country, food.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isHealthy, country);
    }

    @Override
    public String toString() {
        return super.toString() + ", is healthy = " + isHealthy + ", country = " + country + " ";
    }
}
