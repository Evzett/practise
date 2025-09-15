package com.model;



public class ComputingMachine {
    protected String serialNumber;
    protected double price;

    public ComputingMachine () { 
        this.serialNumber = null;
        this.price = 0;
    }

    public ComputingMachine(String serialNumber, double price) {
        this.serialNumber = serialNumber;
        setPrice(price);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0  || price > 300000){
            System.out.println("Price cannot be negative or be higher than 3000000");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "serialNumber=" + serialNumber + ", price=" + price
                + ", getSerialNumber()=" + getSerialNumber() + ", getPrice()=" + getPrice()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((serialNumber == null) ? 0 : serialNumber.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ComputingMachine other = (ComputingMachine) obj;
        if (serialNumber == null) {
            if (other.serialNumber != null)
                return false;
        } else if (!serialNumber.equals(other.serialNumber))
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        return true;
    }
}
