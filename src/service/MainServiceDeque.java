package service;

import datastr.MyDeque;

public class MainServiceDeque {
    public static void main(String[] args){
        MyDeque char_deque = new MyDeque();
        MyDeque student_deque = new MyDeque();

        try{
            char_deque.enqueue_back('a');
            char_deque.enqueue_back('b');
            char_deque.enqueue('c');
            char_deque.dequeue_back();

            System.out.println(char_deque.print());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
