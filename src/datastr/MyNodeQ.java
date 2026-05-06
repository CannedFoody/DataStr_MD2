package datastr;

public class MyNodeQ<TType> {
    private TType value;
    private MyNodeQ next_node = null;
    private MyNodeQ previous_node = null;

//    Getters

    public TType get_value(){
        return this.value;
    }

    public MyNodeQ get_next_node(){
        return this.next_node;
    }

    public MyNodeQ get_previous_node(){
        return this.previous_node;
    }
//    Setters

    public void set_value(TType value){
        if(value != null){
            this.value = value;
        }
        else{
            this.value = (TType) new Object();
        }
    }

    public void set_next_node(MyNodeQ next_node){
        this.next_node = next_node;
    }

    public void set_previous_node(MyNodeQ previous_node){
        this.previous_node = previous_node;
    }

//    Constructor
//    Again, no need for a default constructor, since we dont want a node without an element.

    public MyNodeQ(TType value){
        set_value(value);
    }

//    ToString
    public String toString(){
        return "Value: " + get_value();
    }
}
