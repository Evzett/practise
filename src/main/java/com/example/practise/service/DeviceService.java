package com.example.practise.service;

import com.model.ComputingMachine;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {
    private final List<ComputingMachine> devices = new ArrayList<>();

    public void add(ComputingMachine device) {
        if (device == null) throw new IllegalArgumentException("Device must not be null");
        devices.add(device);
    }

    public ComputingMachine removeAt(int index) {
        checkIndex(index);
        return devices.remove(index);
    }

    public List<ComputingMachine> listAll() {
        return List.copyOf(devices);
    }

    public boolean equalsByIndex(int i1, int i2) {
        checkIndex(i1);
        checkIndex(i2);
        return devices.get(i1).equals(devices.get(i2));
    }

    public int size() {
        return devices.size();
    }

    public ComputingMachine get(int index) {
        checkIndex(index);
        return devices.get(index);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= devices.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }
}
