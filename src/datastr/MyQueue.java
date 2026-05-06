package datastr;

public class MyQueue<TType>{
    private MyNodeQ front_node = null;
    private MyNodeQ rear_node = null;
    private int size = 0;

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
        if(is_empty()){
            throw new Exception("Cannot get queue size, the queue is empty.");
        }
        else{
            return this.size;
        }
    }

    public void empty(){
        this.front_node = null;
        this.rear_node = null;
        this.size = 0;
        System.gc();
    }

    public void enqueue(TType value) throws Exception{
        if(is_full()){
            throw new Exception("Cannot add a new element, the queue is full...");
        }

        MyNodeQ new_node = new MyNodeQ(value);

        if(this.rear_node == null){
            this.rear_node = new_node;
            this.front_node = new_node;
        }
        else{
            MyNodeQ temp_node = this.rear_node;
            this.rear_node = new_node;
            this.rear_node.set_next_node(temp_node);
            temp_node.set_previous_node(this.rear_node);
        }

        this.size += 1;
    }

    public void dequeue() throws Exception{
        if(is_empty()){
            throw new Exception("Cannot remove element from an empty queue...");
        }

        if(this.front_node == rear_node){
            this.front_node = null;
            this.rear_node = null;
        }
        else{
            MyNodeQ temp_node = this.front_node;
            this.front_node = temp_node.get_previous_node();
            this.front_node.set_next_node(null);
            temp_node.set_previous_node(null);
        }


        System.gc();
        this.size -= 1;
    }

    public String print(){
        String print_string = "Queue size: " + this.size;
        MyNodeQ current_node = this.rear_node;

        while(current_node != null){
            print_string = print_string + "\n" + current_node.toString();
            current_node = current_node.get_next_node();
        }

        return print_string;
    }



}
