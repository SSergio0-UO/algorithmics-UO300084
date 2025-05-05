package labs.en._25.algstudent.s5;

public class MinimumPathsTimes {
	public static void main(String arg[]) {
		long t1, t2;
		MinimumPaths mp;
		for(int i = 200; i < Integer.MAX_VALUE; i*=2) {
			t1 = System.currentTimeMillis();
			mp = new MinimumPaths(i);
			t2 = System.currentTimeMillis();
			System.out.println("Time for " + i + ":\t" + (t2 - t1));
		}
	}
}
