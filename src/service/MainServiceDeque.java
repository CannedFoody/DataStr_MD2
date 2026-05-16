package service;

import java.util.Scanner;
import datastr.MyDeque;

public class MainServiceDeque {
    public static void main(String[] args){
//        MyDeque char_deque = new MyDeque();
//        MyDeque student_deque = new MyDeque();
//
//        try{
//            char_deque.enqueue_back('a');
//            char_deque.enqueue_back('b');
//            char_deque.enqueue('c');
//            char_deque.dequeue_back();
//
//            System.out.println(char_deque.print());
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }

//        internet_history();
//        System.out.println(is_palindrome("majonēzi aizēnojam"));
    }

    public static void internet_history(){
        MyDeque history = new MyDeque();
        Scanner s = new Scanner(System.in);

        while(true){
            try{
                System.out.println(history.print());
                System.out.println("------------------------------------");
                System.out.println("Please input a web address: ");
                String user_input = s.next();

//              https://howtodoinjava.com/java/string/get-last-4-characters/

                if (user_input.length() > 4){
                    String last_4_chars = user_input.substring(user_input.length() - 4);

                    if(last_4_chars.contains(".com") || last_4_chars.contains(".net") || last_4_chars.contains(".org") || last_4_chars.contains(".lv")){
                        if(history.size() == 10){
                            history.dequeue_back();
                            history.enqueue(user_input);
                        }
                        else{
                            history.enqueue(user_input);
                        }
                    }
                    else{
                        System.out.println("Please input a valid web address...");
                    }

                }

            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static boolean is_palindrome(String value){
        String forward_string = null;
        String backward_string = null;

        MyDeque string = new MyDeque();
        for(int i = 0; i < value.length(); i++){
            try{
                string.enqueue(value.charAt(i));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        forward_string = string.print().replaceAll("\\n|\\s+", "").toLowerCase().trim();
        backward_string = string.print_b().replaceAll("\\n|\\s+", "").toLowerCase().trim();

        System.out.println(forward_string);
        System.out.println(backward_string);


        return backward_string.equals(forward_string);
    }
}
