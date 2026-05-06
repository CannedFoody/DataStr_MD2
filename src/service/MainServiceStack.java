package service;

import datastr.MyStack;
import datastr.Student;

public class MainServiceStack {
    public static void main(String[] args){
        MyStack char_stack = new MyStack();
        MyStack student_stack = new MyStack();

//        Character stack testing

        try {
            char_stack.push('A');
            char_stack.push('B');
            char_stack.push('C');

//            System.out.println(char_stack.print());

//            char_stack.pop();
//            char_stack.pop();
//            char_stack.pop();
//            System.out.println(char_stack.print());

//            char_stack.empty();
//            System.out.println(char_stack.is_empty());
//            System.out.println(char_stack.is_full());


        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            student_stack.push(new Student());
            student_stack.push(new Student("Gustavs", "Vistins", 22));
            student_stack.push(new Student("John", "Smith", 40));

            System.out.println(student_stack.print());

            student_stack.pop();
            student_stack.pop();
            student_stack.pop();
//            student_stack.empty();
            System.out.println(student_stack.is_empty());
            System.out.println(student_stack.is_full());


            System.out.println(student_stack.print());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
