//package datastr;
//
//public class MyDeque<TType> extends MyQueue{
//
//    public void add_back(TType value) throws Exception{
//        if(is_full()){
//            throw new Exception("Deque is full, cannot add element");
//        }
//
//        if(value == null){
//            throw new Exception("Cannot add null value to deque...");
//        }
//
//        if(MyQueue.get_rear_node() != null){
//            MyNodeD temp_node = this.last_node;
//            this.last_node = new MyNodeD(value);
//            this.last_node.set_next_node(temp_node);
//            temp_node.set_previous_node(this.first_node);
//            size += 1;
//        }
//        else {
//            this.last_node = new MyNodeD(value);
//            this.first_node = this.last_node;
//            size += 1;
//        }
//    }
//
//
//    public void remove_back() throws Exception{
//        if(is_empty()){
//            throw new Exception("Deque is empty, nothing to remove...");
//        }
//
//        if(this.last_node == this.first_node){
//            empty();
//        }
//        else {
//            this.last_node = this.last_node.get_next_node();
//            this.last_node.set_previous_node(null);
//            this.size -= 1;
//            System.gc();
//        }
//    }
//
//
//
//}
