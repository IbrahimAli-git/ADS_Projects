package org.example.project2;

import java.util.Arrays;

// https://www.techiedelight.com/stack-implementation-in-java/
public class Stack<T> {
    private T[] array;
    private int max;
    private static int top;


    public Stack() {
        top = 0;
        array = (T[]) new Object[max];
    }

    public Stack(int max) {
        this.max = max;
        top = 0;
        array = (T[]) new Object[max];
    }

    public void push(T t){
        if (isFull()){
            System.out.println("Stack is full");
            return;
        }
        array[top] = t;
        ++top;
    }

    public T pop(){
        if (isEmpty()){
            System.out.println("Stack is empty");
        }

        T t = array[max-1];
        array[max-1] = null;
        System.out.println(t.toString());
        top--;
        return t;
    }

    public void clear(){
        if (isEmpty()){
            System.out.println("Stack is empty!!");
        }

        Arrays.fill(array, null);
    }

    private void max(){
        ++max;
    }

    public boolean isEmpty(){
        return top < 0;
    }

    public boolean isFull(){
        return top == max;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public T peek() {
        return array[top];
    }

    public void addAll(Stack<T> tempStack) {
        T[] array1 = tempStack.getArray();
        System.arraycopy(array1, 0, array, 0, array.length);
    }

    public T[] getArray() {
        return array;
    }

    public void printPlates() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(this.getClass().getSimpleName() + " " + array[i]);
        }
    }
}
