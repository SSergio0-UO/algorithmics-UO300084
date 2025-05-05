package alglab7;


public class NullPathTimesBB {
	public static void main(String arg[]) {
		long t1, t2;
		NullPathBB mp;
		for(int i = 3; i < Integer.MAX_VALUE; i+=1) {
			t1 = System.currentTimeMillis();
			for(int j=0; j<100; j++) {
				mp = new NullPathBB(i);
			}
			t2 = System.currentTimeMillis();
			System.out.println("Time for " + i + ":\t" + (t2 - t1)/100);
		}
	}
}
