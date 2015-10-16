public class TwoSum {
    ArrayList<Integer> nums=new ArrayList<Integer>();
    boolean sorted=false;
    // Add the number to an internal data structure.
	public void add(int number) {
	   sorted=false;
	   nums.add(number);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    if(!sorted){
	        Collections.sort(nums);
	        sorted=true;
	    }
	    int start=0, end=nums.size()-1;
	    while(start<end){
	        if(nums.get(start)+nums.get(end)==value) return true;
	        else if(nums.get(start)+nums.get(end)>value) end--;
	        else start++;
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
