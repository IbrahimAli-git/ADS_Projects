package org.example.project2;

public abstract class Plate {
    private int diameter;

    public Plate() {
    }

    public Plate(int diameter) {
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
}
