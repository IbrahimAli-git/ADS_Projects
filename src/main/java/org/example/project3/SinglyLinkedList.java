package org.example.project3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

// https://www.javatpoint.com/travelling-salesman-problem-in-java#:~:text=Steps%20to%20implement%20Travelling%20Salesman%20Problem&text=In%20the%20DFS%20way%2C%20we,the%20permutation%20with%20minimum%20cost.
public class SinglyLinkedList {
    private int[] link = {1, 2, 3, 4, 5, 6, 7, 8};
    private String[] data =
            {"San Francisco", "L.A.", "San Diego", "Denver",
                    "Chicago", "Dallas", "New York", "Miami"};

    private ArrayList<Integer> list;
    Node head;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    class Node {
        String name;
        int pricePerDistance;
        Node next1;
        Node next2;
        Node next3;
        Node next4;

        public Node(String name) {
            this.name = name;
        }

        public Node(String name, int price) {
            this.name = name;
            this.pricePerDistance = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Node getNext1() {
            return next1;
        }

        public void setNext1(Node next1) {
            this.next1 = next1;
        }

        public Node getNext2() {
            return next2;
        }

        public void setNext2(Node next2) {
            this.next2 = next2;
        }

        public Node getNext3() {
            return next3;
        }

        public void setNext3(Node next3) {
            this.next3 = next3;
        }

        public Node getNext4() {
            return next4;
        }

        public void setNext4(Node next4) {
            this.next4 = next4;
        }

        public int getPricePerDistance() {
            return pricePerDistance;
        }

        public void setPricePerDistance(int pricePerDistance) {
            this.pricePerDistance = pricePerDistance;
        }
    }

    public void initHead() {
        head = new Node("New York");
        head.next1 = new Node("Chicago", 75);
        head.next2 = new Node("Denver", 100);
        head.next3 = new Node("Dallas", 125);
        head.next4 = new Node("Miami", 90);
    }

    public void initNodes() {
        // Chicago
        head.next1.next1 = new Node("San Francisco", 25);
        head.next1.next2 = new Node("Denver", 20);
        // Denver
        head.next2.next1 = new Node("Chicago", 20);
        head.next2.next2 = new Node("San Francisco", 75);
        head.next2.next3 = new Node("L.A.", 100);
        // Dallas
        head.next3.next1 = new Node("Miami", 50);
        head.next3.next2 = new Node("L.A.", 80);
        head.next3.next3 = new Node("San Diego", 90);
        // Miami
        head.next4.next1 = new Node("Dallas", 50);
    }

    public void searchForNeighbours() throws IOException {
        String cityName;
        System.out.println("Please enter in city name: ");
        cityName = br.readLine();

        System.out.println("Cities on Route: ");
        if (head.name.equals(cityName)) {
            // NY
            System.out.println(head.next1.name);
            System.out.println(head.next2.name);
            System.out.println(head.next3.name);
            System.out.println(head.next4.name);
        } else if (head.next1.name.equals(cityName)) {
            // Chicago
            System.out.println(head.next1.next1.name);
            System.out.println(head.next1.next2.name);
        } else if (head.next2.name.equals(cityName)) {
            // Denver
            System.out.println(head.next2.next1.name);
            System.out.println(head.next2.next2.name);
            System.out.println(head.next2.next3.name);
        } else if (head.next3.name.equals(cityName)) {
            // Dallas
            System.out.println(head.next3.next1.name);
            System.out.println(head.next3.next2.name);
            System.out.println(head.next3.next3.name);
        } else if (head.next4.name.equals(cityName)) {
            // Miami
            System.out.println(head.next4.next1.name);
        }
    }

    public Node searchForCity() throws IOException {
        String nameOfCity;
        System.out.println("Please enter in city name: ");
        nameOfCity = br.readLine();

        Node current = null;
        if (head.name.equals(nameOfCity)) {
            // NY
            current = head;
        } else if (head.next1.name.equals(nameOfCity)) {
            // Chicago
            current = head.next1;
        } else if (head.next2.name.equals(nameOfCity)) {
            // Denver
            current = head.next2;
        } else if (head.next3.name.equals(nameOfCity)) {
            // Dallas
            current = head.next3;
        } else if (head.next4.name.equals(nameOfCity)) {
            // Miami
            current = head.next4;
        } else if (head.next1.next1.name.equals(nameOfCity)) {
            // San francisco
            current = head.next1.next1;
        } else if (head.next2.next3.name.equals(nameOfCity)) {
            // L.A.
            current = head.next2.next3;
        } else if (head.next3.next3.name.equals(nameOfCity)) {
            current = head.next3.next3;
        }
        return current;
    }

    public void calculateDistance() throws IOException {
        String name;
        String name2;
        System.out.println("Enter in City Names: ");
        name = br.readLine();
        name2 = br.readLine();
        int total = 0;
        Node node = new Node("New York");
        node.next1 = new Node("Chicago", 75);
        node.next1.next1 = new Node("San Francisco", 25);

        total += node.next1.pricePerDistance;
        total += node.next1.next1.pricePerDistance;
        System.out.println("$" + total);
    }

    public void initPrice(String name1, String name2) throws IOException {
        int total = 0;
        Node node = searchForCity();
        total = total + (node.next1 != null && (!node.next1.name.equals(name2)) ? node.pricePerDistance : 0);
        total = total + (node.next2 != null && (!node.next2.name.equals(name2)) ? node.pricePerDistance : 0);
        total = total + (node.next3 != null && (!node.next3.name.equals(name2)) ? node.pricePerDistance : 0);
        total = total + (node.next4 != null && (!node.next4.name.equals(name2)) ? node.pricePerDistance : 0);
        System.out.println("$" + total);
    }

    public static void main(String[] args) throws IOException {
        SinglyLinkedList list = new SinglyLinkedList();
        list.initHead();
        list.initNodes();
        menu(list);
    }

    public static void menu(SinglyLinkedList list) throws IOException {
        int userInput;

        do {

            System.out.println("1. Search For City");
            System.out.println("2. Search For Neighbours");
            System.out.println("3. Calculate Distance");
            System.out.println("9. Exit");
            userInput = Integer.parseInt(br.readLine());

            switch (userInput) {
                case 1:
                    Node node = list.searchForCity();
                    System.out.println(node != null ? node.name : "Doesn't Exist");
                    break;
                case 2:
                    list.searchForNeighbours();
                    break;
                case 3:
                    list.calculateDistance();
                    break;
                case 9:
                    break;
            }
        } while (userInput != 9);
    }
}
