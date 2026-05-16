package service;

import datastr.MyNodeS;
import datastr.MyStack;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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

//        System.out.println(check_syntax(new File("Task_1_files/Student.java")));

        System.out.println(labyrinth_traversal(new File("Task_2_files/labirints2.txt")));
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
                    if(i+1 < code_line.length() && code_line.charAt(i) == '/' && code_line.charAt(i+1) == '/'){
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

    public static String labyrinth_traversal(File file){
//      This was incredibly useful!
//      https://www.youtube.com/watch?v=pBasV9jlQ0w

        int steps_taken = 0;

        MyStack labyrinth_stack = new MyStack();

//      https://stackoverflow.com/questions/13151714/reading-text-file-into-a-char-array-in-java
        ArrayList<String> lines = new ArrayList<>();

        try(Scanner my_scanner = new Scanner(file)){
            while(my_scanner.hasNextLine()){
                lines.add(my_scanner.nextLine());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        char[][] maze_arr = new char[lines.size()][];
        ArrayList<int[]> visited_spots = new ArrayList<>();

        for(int i=0; i < lines.size(); i++){
            maze_arr[i] = lines.get(i).toCharArray();
        }

        int maze_start_x = 0, maze_start_y = 0;

        for(int x=0; x<maze_arr.length; x++){
            System.out.println();
            for(int y=0; y<maze_arr[x].length; y++){
                if(maze_arr[x][y] == 'S'){
                    maze_start_x = y;
                    maze_start_y = x;
                }

                System.out.print(maze_arr[x][y]);
            }
        }

        System.out.println();

        int[] starting_pos = {maze_start_x, maze_start_y};

        try{
            labyrinth_stack.push(starting_pos);
            while(!labyrinth_stack.is_empty()){
                boolean visited = false;

                MyNodeS popped_pos = labyrinth_stack.pop();
                int[] pos = (int[]) popped_pos.get_value();

                for(int i=0; i<visited_spots.size(); i++){
                    if(Arrays.equals(pos, visited_spots.get(i))){
                        visited = true;
                        break;
                    }
                }

                if(visited){
                    continue;
                }
                else{
                    visited_spots.add(pos);
                    steps_taken += 1;
                }

                int[] right_pos = {pos[0]+1, pos[1]}, left_pos = {pos[0]-1, pos[1]}, up_pos = {pos[0], pos[1]-1}, down_pos = {pos[0], pos[1]+1};
                int[][] temp_arr = {right_pos, left_pos, up_pos, down_pos};

                for(int i=0; i<temp_arr.length; i++){
                    if(maze_arr[temp_arr[i][0]][temp_arr[i][1]] == 'E'){
                        return "The path has been found! Step's taken: " + steps_taken;
                    }
                    else if(maze_arr[temp_arr[i][0]][temp_arr[i][1]] == '.'){
                        labyrinth_stack.push(temp_arr[i]);
                    }
                }

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return "No valid path can be found...";
    }
}
