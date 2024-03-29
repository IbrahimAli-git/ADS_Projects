package org.example.project2;

import java.util.ArrayList;
import java.util.Arrays;

// https://sheffieldhallam-my.sharepoint.com/:w:/g/personal/cmsmo_hallam_shu_ac_uk/EebVkVr3KqxGnPvO0hWokmcB5JdLHZm634hWV7_WTJ145A?e=OZgSP4
public class Stack<T> {
    private ArrayList<T> list;
    private int max;
    private int top;


    public Stack() {
        top = 0;
        list = new ArrayList<>();
    }

    public void push(T t){
        if (isFull()){
            System.out.println("Stack is full");
            return;
        }
        list.set(top, t);
        ++top;
    }

    public T pop(){
        if (isEmpty()){
            System.out.println("Stack is empty");
        }

        T t = list.get(top);
        list.remove(top);
        --top;
        return t;
    }

    public boolean isEmpty(){
        return top < 0;
    }

    public boolean isFull(){
        return top == max;
    }

    public void addAll(Stack<T> stack){
        while (!stack.isEmpty()){
            push(stack.pop());
        }
    }

    public void clear(Stack<T> stack){
        while (!stack.isEmpty()){
            stack.pop();
        }
    }
}
