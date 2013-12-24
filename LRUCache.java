import java.util.*;

public class LRUCache {

	private ArrayList<int[]> Cache= new ArrayList<int[]>();
	// array of three elements, key,value,frequency
    private int Cache_capacity;
    HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
    private int age;
    
    public LRUCache(int capacity) {
        Cache_capacity=capacity;
        age=0;			// record least recently used
    }
    
    public int get(int key) {
    	Integer i=hm.get(key);
    	if(i!=null) {age++; Cache.get(i)[2]=age; return Cache.get(i)[1];}
    	else {return -1;}
    }
    
    public void set(int key, int value) {
        Integer flag=null;
        if(Cache!=null){
       		flag=hm.get(key);
    		if(flag!=null){ // we got the key
    			age++;
    			Cache.get(flag)[2]=age;
    			Cache.get(flag)[1]=value;
    		}
    	}
    	if(flag==null){//we didn't find the element
    		if((Cache==null)||Cache.size()<Cache_capacity){
    			age++;
    			int[] temp={key,value,age};
    			Cache.add(temp);
    			hm.put(key,Cache.size()-1);// add the index of the element added to hash table
    		}
    		else{ //delete the least used element
    			int min_index=0;
    			int min=-1;
    			for(int i=0;i<Cache.size();i++){
    				if(min==-1){
    					min=Cache.get(i)[2];
    					min_index=i;
    				}	
    				else if(Cache.get(i)[2]<min){
    					min=Cache.get(i)[2];
    					min_index=i;
    				}//end of else if
    			}//end of for
    			hm.remove(Cache.get(min_index)[0]);
    			age++;
    			int[] temp={key,value,age};
    			Cache.set(min_index,temp);
    			hm.put(key,min_index);
    		}//end of if else
    	}//end of if flag
    	
    }
}