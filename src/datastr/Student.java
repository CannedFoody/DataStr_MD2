package datastr;

public class Student {
    private String name;
    private String surname;
    private int age;

//    Getters
    public String get_name(){
        return this.name;
    }

    public String get_surname(){
        return this.surname;
    }

    public int get_age(){
        return this.age;
    }

//    Setters

    public void set_name(String name){
        if(name != null){
            this.name = name;
        }
        else{
            this.name = "";
        }
    }

    public void set_surname(String surname){
        if(surname != null){
            this.surname = surname;
        }
        else {
            this.surname = "";
        }
    }

    public void set_age(int age){
        if(age >= 5 && age <= 100){
            this.age = age;
        }
        else {
            this.age = 0;
        }
    }

//    Constructor
    public Student(){
        set_name("Jane");
        set_surname("Doe");
        set_age(23);
    }

    public Student(String name, String surname, int age){
        set_name(name);
        set_surname(surname);
        set_age(age);
    }

//    String
    public String toString(){
        return get_name() + " " + get_surname() + " | " + get_age();
    }
}
