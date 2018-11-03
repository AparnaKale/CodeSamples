class LRUCache {
     Map<Integer,ArrayList<Integer>> queue = new HashMap<Integer,ArrayList<Integer>>();
	 int capacity =10;
	 int elements = 0;
     int priority = 0; 
    
    public LRUCache(int capacity) {
         this.capacity = capacity;
    }
    
    public int get(int key) {
       List<Integer> obj =  queue.get(key);
	       try {
	       obj.set(1,this.priority++);
	       }catch(Exception e) {return -1;}
	       return obj.get(0); 
    }
    
    public void put(int key, int value) {
         
        if((capacity)<(this.queue.size()+1) && !queue.containsKey(key))
	    	{
	    		Integer max = 99999999;
	    		int tem= 0;
	    		//remove item with lowest priority
	    		Set<Integer>keys = queue.keySet();
	    		for(Integer k : keys)
	    		{
	    		   List<Integer> priority = queue.get(k);
	    		   if(max>priority.get(1)) {tem = k; max = priority.get(1);};
	    		}
	    		queue.remove(tem);
	    		
	    	}
         List<Integer> obj = new ArrayList<Integer>(2);
	    	obj.add(0,value);
	    	obj.add(1, this.priority++);
           
	        queue.put(key, (ArrayList<Integer>) obj);
      
	    	
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
