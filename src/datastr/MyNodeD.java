package datastr;

public class MyNodeD<TType> {
    private TType value;
    private MyNodeD next_node = null;
    private MyNodeD previous_node = null;

//    Getters
    public TType get_value(){
        return this.value;
    }

    public MyNodeD get_next_node(){
        return this.next_node;
    }

    public MyNodeD get_previous_node(){
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

    public void set_next_node(MyNodeD next_node){
        this.next_node = next_node;
    }

    public void set_previous_node(MyNodeD previous_node){
        this.previous_node = previous_node;
    }

//    Constructor

    public MyNodeD(TType value){
        set_value(value);
    }

//    ToString

    public String toString(){
        return "Value: " + get_value();
    }
}
