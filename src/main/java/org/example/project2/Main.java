package org.example.project2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.example.project2.Stack;

// Fix add all method

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<Plate> plateList = new ArrayList<>();
    private static ArrayList<ZincPlate> zincPlateList = new ArrayList<>();
    private static Stack<Plate> plateStack;
    private static Stack<ZincPlate> zincPlateStack;



    public static void main(String[] args) throws IOException {
        menu(br);
        initStacks();
//        sortPlateStack();
//        sortZincPlateStack();
        printPlates();
    }

    // This is a menu system to interact with the user
    public static void menu(BufferedReader br) throws IOException {
        System.out.println("Welcome!!");
        String userInput = "";

        while (true) {
            System.out.println("Enter yes to continue and no to end");
            userInput = br.readLine();
            if (userInput.equals("no")) break;

            System.out.println("Please enter from the following: Zinc Plate, Dinner Plate, Dessert Plate and Appetizer Plate");
            String plate = br.readLine();
            System.out.println("Please enter diameter: ");
            int diameter = Integer.parseInt(br.readLine());
            if (diameter <= 0) {
                System.out.println("Please enter again");
                continue;
            }

            switch (plate) {
                case "Zinc Plate":
                    ZincPlate zincPlate = new ZincPlate(diameter);
                    zincPlateList.add(zincPlate);
                    break;
                case "Dinner Plate":
                    DinnerPlate dinnerPlate = new DinnerPlate(diameter);
                    plateList.add(dinnerPlate);
                    break;
                case "Dessert Plate":
                    DessertPlate dessertPlate = new DessertPlate(diameter);
                    plateList.add(dessertPlate);
                    break;
                case "Appetizer Plate":
                    AppetizerPlate appetizerPlate = new AppetizerPlate(diameter);
                    plateList.add(appetizerPlate);
                    break;
                default:
                    System.out.println("Please enter again");
                    break;
            }
        }
    }

    public static void initStacks(){
        plateStack = new Stack<>(plateList.size());
        zincPlateStack = new Stack<>(zincPlateList.size());
        for (Plate plate : plateList) {
            plateStack.push(plate);
        }
        for (ZincPlate zincPlate : zincPlateList) {
            zincPlateStack.push(zincPlate);
        }
    }

    // https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/
    // For sorting the plate stack
    public static void sortPlateStack() {
        Stack<Plate> tempStack = new Stack<>();
        while (!plateStack.isEmpty()) {
            Plate temp = plateStack.pop();
            int t = temp.getDiameter();

            while (!tempStack.isEmpty() && tempStack.peek().getDiameter() > t) {
                plateStack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        plateStack.clear();
        plateStack.addAll(tempStack);
    }

    // https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/
    // For sorting the zinc plate stack
    public static void sortZincPlateStack() {
        Stack<ZincPlate> tempStack = new Stack<>();
        while (!zincPlateStack.isEmpty()) {
            ZincPlate temp = zincPlateStack.pop();
            int t = temp.getDiameter();

            while (!tempStack.isEmpty() && tempStack.peek().getDiameter() > t) {
                zincPlateStack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        zincPlateStack.clear();
        zincPlateStack.addAll(tempStack);
    }

    // Prints out the elements of each stack
    public static void printPlates() {
        System.out.println("Plates... ");
        plateStack.printPlates();

        System.out.println("Zinc Plates");
        zincPlateStack.printPlates();

    }
}