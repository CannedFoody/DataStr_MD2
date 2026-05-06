package datastr;

public class MyQueue {
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

//    public int size() throws Exception{
//        if(is_empty()){
//            throw new Exception("Cannot get queue size, the queue is empty.");
//        }
//
//    }



}
