package misc;

public class main_misc {

	public static void main(String[] args) {
		//
	
	int [] v = {1,2,7,4,3,3,1};
	int[] l = min_candy(v);
	System.out.println("Output: " +sum(l));
	System.out.println("Explanation:");
	for(int i = 0;i <v.length;i++) {
		System.out.print(" "+l[i]);
	}
		
	
		

	}
	private static int sum(int[] v) {
		int s = 0;
		for(int i = 0;i < v.length;i++) {
			s += v[i];
		}
		return s;
	}
	private static int[] stage_one(int[] v) {
		int [] l = new int[v.length];
		for(int i = 0;i < v.length;i++) {
			int c = 1;
			if(i == 0) {
				if(v[i] > v[i+1]) {
					c++;
				}
				l[i] = c;
			}
			else if(i == v.length-1) {
				if(v[i] > v[i-1]) {
					c++;
				}
				l[i] = c;
			}
			else {
				if(v[i] > v[i+1] || v[i] > v[i-1]) {
					c++;
				}
				l[i] = c;
			}
		}
		return l;
	}	
	private static int[] min_candy(int[] v) {
		 //
		int [] l = stage_one(v);
		int on_off = 1;
		while(on_off == 1) {
			on_off = 0;
			for(int i = 0;i < v.length;i++) {
				if(i == 0) {
					if(v[i] > v[i+1] && l[i] <= l[i+1]) {
						l[i]++;
						on_off = 1;
					}
				}
				if(i == v.length-1 && i != 0){
					if(v[i] > v[i-1] && l[i] <= l[i-1]) {
						l[i]++;
						on_off = 1;
					}
				}
				else if(i != 0 && i != v.length-1){
					
					if(v[i] > v[i-1] && l[i] <= l[i-1]){
					
						l[i]++;
						on_off = 1;
					}
					if(v[i] > v[i+1] && l[i] <= l[i+1]) {
						l[i]++;
						on_off = 1;
					}
				}
			}
		}
		return l;
	}
	
}
