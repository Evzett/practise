package com.model;



public class Laptop extends Computer {
    protected String chassisMaterial;
    protected double batteryLife;

    public Laptop(){
        super();
        this.chassisMaterial = null;
        this.batteryLife = 0;
    }

    public Laptop(String serialNumber, 
    double price, int storageSize,
    String operatingSystem, int usbPorts,
    String brand, String chassisMaterial,
    double batteryLife) {
        super(serialNumber, price, storageSize, operatingSystem, 
        usbPorts, brand);
        setBatteryLife(batteryLife);
        setChassisMaterial(chassisMaterial);
        
    }

    public void setChassisMaterial(String chassisMaterial) {
        if (chassisMaterial == null || chassisMaterial.trim().isEmpty()) {
            System.out.println("The chassis material cannot be empty.");
        }
        else {
            this.chassisMaterial = chassisMaterial;
        }
    }

    public String getChassisMaterial()
    {
        return this.chassisMaterial;
    }

      public void setBatteryLife (double batteryLife) {
        if (batteryLife <=0 || batteryLife >= 20) {
            System.out.println("The battery life of laptop cannot be negative or be more than 20 hours.");

        }
        else {
            this.batteryLife = batteryLife;
        }
    }
    
    public double getBatteryLife () {
        return this.batteryLife;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Laptop laptop = (Laptop) obj;
        return Double.compare(laptop.batteryLife, batteryLife) == 0 &&
            java.util.Objects.equals(chassisMaterial, laptop.chassisMaterial) &&
            super.equals(obj);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), chassisMaterial, batteryLife);
    }

    @Override
    public String toString() {
        return 
                super.toString() +
                ", chassisMaterial='" + chassisMaterial + '\'' +
                ", batteryLife=" + batteryLife +
                '}';
    }
}
