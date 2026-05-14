package service;

import datastr.MyQueue;
import datastr.MyStack;
import datastr.Student;

import java.io.File;
import java.util.Scanner;

public class MainServiceStack {
    public static void main(String[] args){
//        Stack model class testing code.

//        MyStack char_stack = new MyStack();
//        MyStack student_stack = new MyStack();
//
//        Character stack testing
//
//        try {
//            char_stack.push('A');
//            char_stack.push('B');
//            char_stack.push('C');
//
//            System.out.println(char_stack.print());
//
//            char_stack.pop();
//            char_stack.pop();
//            char_stack.pop();
//            System.out.println(char_stack.print());
//
//            char_stack.empty();
//            System.out.println(char_stack.is_empty());
//            System.out.println(char_stack.is_full());
//
//
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//        try {
//            student_stack.push(new Student());
//            student_stack.push(new Student("Gustavs", "Vistins", 22));
//            student_stack.push(new Student("John", "Smith", 40));
//
//            System.out.println(student_stack.print());
//
//            student_stack.pop();
//            student_stack.pop();
//            student_stack.pop();
//            student_stack.empty();
//            System.out.println(student_stack.is_empty());
//            System.out.println(student_stack.is_full());
//
//
//            System.out.println(student_stack.print());
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }

        System.out.println(check_syntax(new File("Task_1_files/Student.java")));
    }

    public static int check_syntax(File file){
        int current_line = 0;
        boolean is_text = false;

        MyStack syntax_stack = new MyStack();

        try(Scanner my_scanner = new Scanner(file)){
            // THIS DOESNT WORK AND I DONT KNOW WHY, it always returns 10 which is a correct line....
            while(my_scanner.hasNextLine()){
                is_text = false;
                current_line += 1;
                String code_line = my_scanner.nextLine();
                for(int i = 0; i < code_line.length(); i++){
                    if(i + 1 < code_line.length() && code_line.charAt(i) == '/' && code_line.charAt(i + 1) == '/'){
                        break;
                    }

                    if(code_line.charAt(i) == '"' || code_line.charAt(i) == '\''){
                        is_text = !is_text;
                    }

                    if(!is_text) {
                        switch (code_line.charAt(i)){
                            case '(', '[', '{':
                                syntax_stack.push(code_line.charAt(i));
                                break;
                            case ')', ']', '}':
                                if(syntax_stack.is_empty()) {
                                    System.out.println("No opening bracket found...");
                                }
                                else if(syntax_stack.top().get_value().equals(code_line.charAt(i))){
                                    syntax_stack.pop();
                                }
                                else{
                                    return current_line;
                                }
                                break;
                        }
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return -1;
    }
}
