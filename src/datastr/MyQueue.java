package datastr;

public class MyQueue<TType>{
    private MyNodeQ front_node = null;
    private MyNodeQ rear_node = null;
    private int size = 0;

//    Getters

    protected MyNodeQ get_front_node(){
        return this.front_node;
    }

    protected MyNodeQ get_rear_node(){
        return this.rear_node;
    }

    protected void set_rear_node(MyNodeQ rear_node){
        if(rear_node != null){
            this.rear_node = rear_node;
        }
    }

    protected void set_front_node(MyNodeQ front_node){
        if(front_node != null){
            this.front_node = front_node;
        }
    }

    protected void set_size(int size){
        this.size = size;
    }

//    Again, no need for a constructor since we usually make a blank queue anyway and the Object class has a built-in constructor.

    public boolean is_empty(){
        return size == 0;
    }

    public boolean is_full() throws Exception{
        try{
            new MyNodeQ(new Object());
            return false;
        }
        catch(OutOfMemoryError e){
            e.printStackTrace();
            return true;
        }
    }

    public int size() throws Exception{
            return size;
    }

    public void empty(){
        front_node = null;
        rear_node = null;
        size = 0;
        System.gc();
    }

    public void enqueue(TType value) throws Exception{
        if(is_full()){
            throw new Exception("Cannot add a new element, the queue is full...");
        }

        MyNodeQ new_node = new MyNodeQ(value);

        if(rear_node == null){
            rear_node = new_node;
            front_node = new_node;
        }
        else{
            MyNodeQ temp_node = front_node;
            front_node = new_node;
            front_node.set_previous_node(temp_node);
            temp_node.set_next_node(front_node);
        }

        size += 1;
    }

    public void dequeue() throws Exception{
        if(is_empty()){
            throw new Exception("Cannot remove element from an empty queue...");
        }

        if(front_node == rear_node){
            empty();
            return;
        }
        else{
            MyNodeQ temp_node = front_node;
            front_node = temp_node.get_previous_node();
            front_node.set_next_node(null);
            temp_node.set_previous_node(null);
        }


        System.gc();
        size -= 1;
    }

    public String print(){
        String print_string = "Queue size: " + size;
        MyNodeQ current_node = front_node;

        while(current_node != null){
            print_string = print_string + "\n" + current_node.toString();
            current_node = current_node.get_previous_node();
        }

        return print_string;
    }



}
