
public class Gas_Station {
	int new_start;
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		new_start=0;
		while(new_start<gas.length){
			if(leftcircle(new_start,gas,cost)) return new_start;
		}
		return -1;
    }
	
	public boolean leftcircle(int start,int[] gas,int[] cost){
		int current=gas[start]-cost[start];
		for(int j=0;j<gas.length;j++){
			if(current<0) {new_start=new_start+j+1;return false;}
			else current=current-cost[(start+j+1)%gas.length]+gas[(start+j+1)%gas.length];
		}
		return true;
	}
	
}

