package datastr;

public class MyDeque<TType> extends MyQueue{

    public void enqueue_back(TType value) throws Exception{
        if(is_full()){
            throw new Exception("Deque is full, cannot add element");
        }

        if(value == null){
            throw new Exception("Cannot add null value to deque...");
        }


        if(get_rear_node() != null){
            MyNodeQ temp_node = get_rear_node();
            set_rear_node(new MyNodeQ(value));
            get_rear_node().set_next_node(temp_node);
            get_rear_node().set_previous_node(null);
            temp_node.set_previous_node(get_rear_node());
            set_size(size() + 1);
        }
        else {
            set_rear_node(new MyNodeQ(value));
            set_front_node(get_rear_node());
            set_size(size()+1);
        }
    }


    public void dequeue_back() throws Exception{
        if(is_empty()){
            throw new Exception("Deque is empty, nothing to remove...");
        }

        if(get_front_node() == get_rear_node()){
            empty();
        }
        else {
            set_rear_node(get_rear_node().get_next_node());
            get_rear_node().set_previous_node(null);
            set_size(size()-1);
            System.gc();
        }
    }

    public String print_b(){
        String return_string = "";
        MyNodeQ current_node = get_rear_node();

        while(current_node != null){
            return_string = return_string + "\n" + current_node.get_value();
            current_node = current_node.get_next_node();
        }

        return return_string;
    }

}
