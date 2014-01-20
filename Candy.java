
public class Candy {
	public int candy(int[] ratings) {
		int total=0;
		if(ratings.length==0) return total;
		int[] ncandy=new int[ratings.length];
		ncandy[0]=1;
		for(int i=1;i<ratings.length;i++){
			ncandy[i]=1;
			if(ratings[i]>ratings[i-1]) ncandy[i]=ncandy[i-1]+1;
		}
		
		for(int i=ratings.length-1;i>0;i--){
			if(ratings[i-1]>ratings[i]) ncandy[i-1]=Math.max(ncandy[i]+1, ncandy[i-1]);			
		}
		
		for(int i=0;i<ncandy.length;i++) total+=ncandy[i];
		return total;
    }
}
