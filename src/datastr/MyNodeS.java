package datastr;

public class MyNodeS<TType>{
    private TType value;
    private MyNodeS next_node = null;
    private MyNodeS previous_node = null;

//    Getters

    public TType get_value(){
        return this.value;
    }

    public MyNodeS get_next_node(){
        return this.next_node;
    }

    public MyNodeS get_previous_node(){
        return this.previous_node;
    }

//    Setters

    public void set_value(TType value){
        if(value != null){
            this.value = value;
        }
        else {
            this.value = (TType) new Object();
        }
    }

    public void set_next_node(MyNodeS next_node){
         this.next_node = next_node;
    }

    public void set_previous_node(MyNodeS previous_node){
        this.previous_node = previous_node;
    }

//    Constructor
//    There's no need to make a default value constructor since we never want to make a node without a value.

    public MyNodeS(TType value){
        set_value(value);
    }

//    ToString

    public String toString(){
        return "Node value | " + get_value();
    }
}
