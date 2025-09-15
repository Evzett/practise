package com.model;


public class Computer extends ComputingMachine {
    public int storageSize; 
    public String operatingSystem; 
    public int usbPorts; 
    public String brand;

    public Computer () {
        super();
        storageSize = 0;
        operatingSystem = null;
        usbPorts = 0;
        brand = null;
    }

    public Computer(String serialNumber, 
    double price, int storageSize,
    String operatingSystem, int usbPorts,
    String brand) {
        super(serialNumber, price);
        setStorageSize(storageSize);
        setOperatingSystem(operatingSystem);
        setUsbPorts(usbPorts);
        setBrand(brand);
    }

    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        if (storageSize <= 0 || storageSize > 5000) {
            System.out.println("The size of the memory cannot be negative or be higher than 5000");
        } else {
            this.storageSize = storageSize;
        }
    }

    public void setOperatingSystem(String operatingSystem) {
        if (operatingSystem == null || operatingSystem.trim().isEmpty()) {
            System.out.println("Operating system cannot be null or empty.");
        } else {
            this.operatingSystem = operatingSystem;
        }
    }

    public void setUsbPorts(int usbPorts) {
        if (usbPorts < 0 || usbPorts >= 30) {
            System.out.println("USB ports must be non-negative and less than 30.");
        } else {
            this.usbPorts = usbPorts;
        }
    }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            System.out.println("Brand cannot be null or empty.");
        } else {
            this.brand = brand;
        }
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public int getUsbPorts() {
        return usbPorts;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Computer)) return false;
        Computer other = (Computer) obj;
        return storageSize == other.storageSize &&
               usbPorts == other.usbPorts &&
               java.util.Objects.equals(operatingSystem, other.operatingSystem) &&
               java.util.Objects.equals(brand, other.brand) &&
               super.equals(obj);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), storageSize, operatingSystem, usbPorts, brand);
    }

    @Override
    public String toString() {
        return 
                "serialNumber='" + getSerialNumber() + '\'' +
                ", price=" + getPrice() +
                ", storageSize=" + storageSize +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", usbPorts=" + usbPorts +
                ", brand='" + brand + '\'' +
                '}';
    }
}