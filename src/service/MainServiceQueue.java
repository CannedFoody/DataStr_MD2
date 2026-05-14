package service;

import datastr.MyQueue;
import datastr.Student;
import java.util.Random;
import java.lang.Thread;

public class MainServiceQueue {
    public static void main(String[] args){
//        MyQueue char_queue = new MyQueue();
//        MyQueue student_queue = new MyQueue();
//
//        try{
//            This is the char queue testing try-catch.
//            char_queue.enqueue('A');
//            char_queue.enqueue('B');
//            char_queue.enqueue('C');

//            char_queue.dequeue();
//            char_queue.dequeue();
//            char_queue.dequeue();

//            char_queue.size();
//
//            char_queue.is_empty();
//            char_queue.is_full();

//            char_queue.empty();

//            System.out.println(char_queue.print());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        This is the Student class queue testing try-catch.
//        try{
//            student_queue.enqueue(new Student());
//            student_queue.enqueue(new Student("First_Name", "Last_Name", 22));
//            student_queue.enqueue(new Student("John", "Smith", 35));

//            student_queue.dequeue();
//            student_queue.dequeue();
//            student_queue.dequeue();

//            student_queue.empty();
//
//            System.out.println(student_queue.print());
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }

        call_centre();
    }
// I got the two thread idea from here :
//    https://stackoverflow.com/questions/57853553/how-can-i-sleep-one-thread-while-the-other-thread-is-running-in-java
//    https://techvidvan.com/tutorials/java-thread-run-method-with-examples/

    public static void call_centre(){
        MyQueue call_queue = new MyQueue();
        Random r = new Random();

        Thread call = new Thread(new Runnable(){
            public void run(){
                while(true){
                    try{
                        if(call_queue.size() <= 10){
                            int phone_num = r.nextInt(10000000, 99999999);
                            call_queue.enqueue(phone_num);
                            System.out.println(phone_num + " calling in...");
                            Thread.sleep(r.nextInt(1000, 5000));
                        }
                        else{
                            Thread.sleep(2000);
                        }
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread answer = new Thread(new Runnable(){
           public void run(){
               while(true){
                   try{
                       if(!call_queue.is_empty()){
                           Thread.sleep(r.nextInt(1000, 5000));
                           call_queue.dequeue();
                           System.out.println("Call answered!");
                           System.out.println("Calls remaining: " + call_queue.size());
                       }
                       else{
                           Thread.sleep(2000);
                       }
                   }
                   catch(Exception e){
                       e.printStackTrace();
                   }
               }
           }
        });

        call.start();
        answer.start();
    }
}
