package service;

import datastr.MyQueue;
import datastr.Student;

public class MainServiceQueue {
    public static void main(String[] args){
        MyQueue char_queue = new MyQueue();
        MyQueue student_queue = new MyQueue();

        try{
//            This is the char queue testing try-catch.
            char_queue.enqueue('A');
            char_queue.enqueue('B');
            char_queue.enqueue('C');

//            char_queue.dequeue();
//            char_queue.dequeue();
//            char_queue.dequeue();

//            char_queue.size();
//
//            char_queue.is_empty();
//            char_queue.is_full();

//            char_queue.empty();

//            System.out.println(char_queue.print());
        } catch (Exception e) {
            e.printStackTrace();
        }

//        This is the Student class queue testing try-catch.
        try{
            student_queue.enqueue(new Student());
            student_queue.enqueue(new Student("First_Name", "Last_Name", 22));
            student_queue.enqueue(new Student("John", "Smith", 35));

//            student_queue.dequeue();
//            student_queue.dequeue();
//            student_queue.dequeue();

            student_queue.empty();

            System.out.println(student_queue.print());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
