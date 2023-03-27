package misc;

public class main_misc {

	public static void main(String[] args) {
		//
		int [] v = {1,2,7,4,3,3,1};
		System.out.println(min_candy(v));
		
	}	
	//The ideia here is to iterate using the from min to max scores
	
	//Sort the array storing the indexes
	private static int sum(int[]v) {
		int s  = 0;
		for(int i = 0;i < v.length;i++) {
			s+= v[i];
		}
		return s;
	}
	private static int[][] organize(int[]v){
		
		int[][]r = new int[v.length][2];
		for(int i = 0;i < v.length;i++) {
			r[i][0] = v[i];
			r[i][1] = i;
		}		
		return r;
		
	}
	private static void  swap(int[][]v,int i,int j) {
		int a = v[i][1];
		int b = v[i][0];
		v[i][1] = v[j][1];
		v[i][0] = v[j][0];
		v[j][1] = a;
		v[j][0] = b;
		
	}
	private static void quickSort(int[][]v,int strt,int end) {
		if(strt >= end) {
			return;
		}
		int p = v[end][0];
		int l = strt;
		int r = end;
		while(l < r) {
			while(v[l][0] <= p && l < r) {
				l++;
			}
			while(v[r][0] >= p && l < r) {
				r--;
			}
			swap(v,l,r);
		}
		if(v[l][0] >= v[end][0]) {		
			swap(v,l,end);
		}
		else {
			l = end;
		}
		quickSort(v,strt,l-1);
		quickSort(v,l+1,end);
	}
	
	private static int min_candy(int[]v) {
		//
		int [][] r = organize(v);
		int []c = new int[r.length];
		quickSort(r,0,r.length-1);
		for(int i = 0;i < r.length;i++) {
			c[i] = 1;
			//r[1]
			if(r[i][1] == 0 && v[r[i][1]] > v[r[i][1]+1]) {
				c[i]++;
			}
			else if(r[i][1] == v.length-1 && v[r[i][1]] > v[r[i][1]-1]) {
				c[i]++;
			}
			else if(r[i][1] != v.length-1 && r[i][1] != 0) {
				//System.out.println("--"+v[r[i][1]]);
				if(v[r[i][1]] > v[r[i][1] -1]) {
					c[i]++;
					//System.out.println("--");
				}
				if(v[r[i][1]] > v[r[i][1] +1]) {
					c[i]++;
					//System.out.println("--");
				}
			}
		}
		return sum(c);
		
	
	}
	
}
