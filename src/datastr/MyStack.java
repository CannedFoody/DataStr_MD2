package datastr;

public class MyStack<TType>{
    private MyNodeS top_node = null;
    private int size = 0;

//    I dont think we need a constructor since we can just initialize a stack with it's default values and add elements to it later and the Object class has a built in constructor.

    public boolean is_empty(){
        return size == 0;
    }

    public boolean is_full(){
        try {
            new MyNodeS(new Object());
            return false;
        } catch(OutOfMemoryError e){
            e.printStackTrace();
            return true;
        }
    }

    public void empty() throws Exception{
        if(is_empty()){
            throw new Exception("Cannot empty stack since it is already empty...");
        }

        MyNodeS current_node = top();
        while(current_node != null){
            MyNodeS previous_node = current_node.get_previous_node();
            current_node = null;
            current_node = previous_node;
        }

        this.top_node = null;
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public void push(TType value) throws Exception{
        if(is_full()){
            throw new Exception("Cannot add new node, the stack is full...");
        }

        MyNodeS new_node = new MyNodeS(value);

        if(top_node == null){
            this.top_node = new_node;
            this.size += 1;
        }
        else{
             top_node.set_next_node(new_node);
             new_node.set_previous_node(top_node);
             this.top_node = new_node;
             this.size += 1;
        }
    }

    public void pop() throws Exception {
        if(is_empty()){
            throw new Exception("Cannot pop a stack element, the stack is empty...");
        }

//        Checks if the top node HAS a node beneath it and if it doesnt that means the top node is the last one in the stack and just gets rid of it.
        if(top().get_previous_node() != null) {
            this.top_node = top_node.get_previous_node();
            this.top_node.get_next_node().set_previous_node(null);
            this.top_node.set_next_node(null);
        }
        else{
            this.top_node = null;
        }

        this.size -= 1;
        System.gc();
    }

    public MyNodeS top() throws Exception{
        if(is_empty()){
            throw new Exception("Cannot access top node, the stack is empty...");
        }

        return this.top_node;
    }

    public String print(){
        MyNodeS current_node = this.top_node;

        String stack_values = "Stack Size = " + size();

        while(current_node != null){
            stack_values = stack_values + "\n" + current_node.toString();
            current_node = current_node.get_previous_node();
        }

        return stack_values;
    }

}
