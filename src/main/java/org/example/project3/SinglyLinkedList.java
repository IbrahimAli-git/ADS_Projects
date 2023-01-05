package org.example.project3;

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

    public void searchForNeighbours(String cityName) {
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
            System.out.println(head.next4.next1);
        }
    }
    public Node searchForCity(String nameOfCity) {
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

    public void calculateDistance(String name) {
        int total = 0;
        Node node = new Node("New York");
        node.next1 = new Node("Chicago", 75);
        node.next1.next1 = new Node("San Francisco", 25);

        total += node.next1.pricePerDistance;
        total += node.next1.next1.pricePerDistance;
        System.out.println("$" + total);
    }

    public void initPrice(String name1, String name2) {
        int total = 0;
        Node node = searchForCity(name1);
        total = total + (node.next1 != null && (!node.next1.name.equals(name2))? node.pricePerDistance : 0);
        total = total + (node.next2 != null && (!node.next2.name.equals(name2)) ? node.pricePerDistance : 0);
        total = total + (node.next3 != null && (!node.next3.name.equals(name2)) ? node.pricePerDistance : 0);
        total = total + (node.next4 != null && (!node.next4.name.equals(name2)) ? node.pricePerDistance : 0);
        System.out.println("$" + total);
    }

    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.initHead();
        list1.initNodes();

        Scanner sc = new Scanner(System.in);
        String userInput = "";
        do {
            System.out.println("Enter in city name: ");
            userInput = sc.nextLine();

            list1.calculateDistance(userInput);
        } while (!userInput.equals("exit"));
    }
}
