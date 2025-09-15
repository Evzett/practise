package com.model;

import java.util.List;           // (для работы с листами)


public class Tablet extends Laptop {
    // Список допустимых типов экранов для планшета
    public static final List<String> SCREEN_TYPES = List.of(
            "IPS", "AMOLED", "TFT", "PLS", "Retina", "LCD", "OLED"
    );
    private String screenType;
    // Разрешение основной камеры (МП)
    private int mainCameraResolution;
    

    public Tablet () {
        super();
        this.screenType = null;
        this.mainCameraResolution = 0;
    }

    public Tablet (String serialNumber, 
    double price, int storageSize,
    String operatingSystem, int usbPorts,
    String brand, String chassisMaterial,
    double batteryLife, String screenType,
    int mainCameraResolution) {
        super(serialNumber, 
        price, storageSize,
        operatingSystem, usbPorts,
        brand, chassisMaterial,
        batteryLife);

        setScreenType (screenType);
        setMainCameraResolution (mainCameraResolution);
    }

    public void setScreenType (String screenType) {
        if (this.SCREEN_TYPES.contains(screenType.trim().toUpperCase())) {
            this.screenType = screenType.toUpperCase();
        }
        else {
            System.out.println("You've entered the incorrect type of screen");
        }
    }

    public String getScreenType () {
        return this.screenType;
    }

    public void setMainCameraResolution (int mainCameraResolution) {
        if (mainCameraResolution <=0 || mainCameraResolution >= 30) {
            System.out.println("The resolution of the camera cannot be negative or be more than 30.");

        }
        else {
            this.mainCameraResolution = mainCameraResolution;
        }

    }

    public int getMainCameraResolution () {
        return this.mainCameraResolution;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tablet)) return false;
        if (!super.equals(obj)) return false;
        Tablet other = (Tablet) obj;
        return mainCameraResolution == other.mainCameraResolution &&
               ((screenType == null && other.screenType == null) ||
                (screenType != null && screenType.equals(other.screenType)));
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (screenType != null ? screenType.hashCode() : 0);
        result = 31 * result + mainCameraResolution;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
               "screenType='" + screenType + '\'' +
               ", mainCameraResolution=" + mainCameraResolution +
               '}';
    }

}
