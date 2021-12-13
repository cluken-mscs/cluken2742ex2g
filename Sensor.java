package com.example.cluken2742ex2g1;

import java.util.ArrayList;
import java.util.Objects;

public class Sensor {
    private int sensorId;
    private int roomId;
    private int sensorTypeId;
    private String description;
//    private Room room;
//    private SensorType sensorType;
    private ArrayList<SensorReading> sensorReadings;

    public Sensor(int sensorId, int roomId, int sensorTypeId, String description) {
        this.sensorId = sensorId;
        this.roomId = roomId;
        this.sensorTypeId = sensorTypeId;
        this.description = description;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getSensorTypeId() {
        return sensorTypeId;
    }

    public void setSensorTypeId(int sensorTypeId) {
        this.sensorTypeId = sensorTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public domain.Room getRoom() {
//        return room;
//    }
//
//    public void setRoom(domain.Room room) {
//        this.room = room;
//    }
//
//    public domain.SensorType getSensorType() {
//        return sensorType;
//    }
//
//    public void setSensorType(domain.SensorType sensorType) {
//        this.sensorType = sensorType;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sensor)) return false;
        Sensor sensor = (Sensor) o;
        return sensorId == sensor.sensorId &&
                roomId == sensor.roomId &&
                sensorTypeId == sensor.sensorTypeId &&
                Objects.equals(description, sensor.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensorId, roomId, sensorTypeId, description);
    }

    @Override
    public String toString() {
        return Integer.toString(sensorId) +
                ", roomId=" + roomId +
                ", sensorTypeId=" + sensorTypeId +
                ", " + description;
    }

    public ArrayList<SensorReading> getSensorReadings() {
        return sensorReadings;
    }

    public void setSensorReadings(ArrayList<SensorReading> sensorReadings) {
        this.sensorReadings = sensorReadings;
    }

    public int findMinReadingIndex() {
        // create a sensor reading object that refers to element 0
        this.sensorReadings.get(0);
        float min = sensorReadings.get(0).getValue();
        int index = 0;

        for (int i = 1; i < this.sensorReadings.size(); i++) {
            if (this.sensorReadings.get(i).getValue() < min) {
                min = sensorReadings.get(i).getValue();
                index = i ;
            }
        }
        return index;
    }
    public int findMinReadingIndex(int startIndex, int endIndex) {
        this.sensorReadings.get(startIndex);
        this.sensorReadings.get(endIndex);
        float min = sensorReadings.get(startIndex).getValue();
        int index = 0;
//        endIndex = this.sensorReadings.size()-1;

        if ((startIndex > 0) && (endIndex < this.sensorReadings.size()-1) && (startIndex < endIndex)) {
            for (int i = startIndex; i < endIndex; i++) {
                if (this.sensorReadings.get(i).getValue() < min) {
                    min = sensorReadings.get(i).getValue();
                    index = i;
                }
            }
            return index;
        }
        else throw new IndexOutOfBoundsException("Index out of bounds: 0 - 117");
    }

    public int findMaxReadingIndex() {
        // create a sensor reading object that refers to element 0
        this.sensorReadings.get(0);
        float max = sensorReadings.get(0).getValue();
        int index = 0;

        for (int i = 1; i < this.sensorReadings.size(); i++) {
            if (this.sensorReadings.get(i).getValue() > max) {
                max = sensorReadings.get(i).getValue();
                index = i ;
            }
        }
        return index;
    }
    public int findMaxReadingIndex(int startIndex, int endIndex) {
        this.sensorReadings.get(startIndex);
        this.sensorReadings.get(endIndex);
        float max = sensorReadings.get(endIndex).getValue();
        int index = 0;

        if (startIndex > 0 && endIndex < this.sensorReadings.size()-1 && startIndex < endIndex) {
            for (int i = startIndex; i < endIndex; i++) {
                if (this.sensorReadings.get(i).getValue() > max) {
                    max = sensorReadings.get(i).getValue();
                    index = i;
                }
            }
            return index;
        }
        else throw new IndexOutOfBoundsException("Index out of bounds: 0 - 117");
    }
    public int findNextCycleMax(int startIndex) {
        SensorReading rMax = this.sensorReadings.get(startIndex);
        int i = startIndex + 1;

        for ( ; i < this.sensorReadings.size(); i++) {
            if (rMax.getValue() < this.sensorReadings.get(i).getValue())
                rMax = this.sensorReadings.get(i);
            else
                break;
        }
        return i - 1;
    }
    public int findNextCycleMin(int startIndex) {
        SensorReading rMin = this.sensorReadings.get(startIndex);
        int i = startIndex + 1;

        for ( ; i < this.sensorReadings.size()-1; i++) {
            if (rMin.getValue() > this.sensorReadings.get(i).getValue())
                rMin = this.sensorReadings.get(i);
            else
                break;
        }
        return i - 1;
    }
    public SensorReading getSensorReading(int index) {
        return this.sensorReadings.get(index);
    }
}
//        // create a SensorReading object that refers to element 0
//        SensorReading startIndex = this.sensorReadings.get(0);
//        SensorReading minIndex = startIndex;
////        SensorReading minIndex = this.sensorReadings.get(i);
//        // write a 'for loop' starting at 1 and have it loop to the end of the ArrayList
//        for (int i =1; i < this.sensorReadings.size(); i++) {
//            // inside of loop keep track of the index of the minimum value
//            // set it to the startIndex (0)
//            minIndex = startIndex;
//            // check to see if value of sensorReading(i) is lower than value of minimum sensorReading
//            if (this.sensorReadings.get(i).getValue() < minIndex.getValue())
//
//                // if i is lower then that becomes minimum value
//                minIndex = this.sensorReadings.get(i);
//
//        }
//        return minIndex();
//    }
//        this.sensorReadings.get(0);


// create a SensorReading object that refers to element 0
// go to sensorReadings collection and call 'get' and get the start Index

// write a 'for loop' starting at 1 and goes to the end of the ArrayList
// while in 'for loop' we need an index variable
// call it minIndex and set it to our startIndex