package misc;

public class main_misc {

	public static void main(String[] args) {
		//
	
	int [] v = {1,3,1,1,7};
	System.out.println(min_candy(v));
		
	
		

	}
	private static int min_candy(int[] v) {
		int min = 0;
		for(int i = 0;i < v.length;i++) {
			int c = 1;
			if(i == 0) {
				if(v[i] > v[i+1]) {
					c++;
				}
				min += c;
			}
			else if(i == v.length-1) {
				if(v[i] > v[i-1]) {
					c++;
				}
				min += c;
			}
			else {
				if(v[i] > v[i+1]) {
					c++;
				}
				if(v[i] > v[i-1]) {
					c++;
				}
				min += c;
			}
		}
		return min;
	}
	
}
