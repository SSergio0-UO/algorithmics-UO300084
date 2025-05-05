package algstudent.s2;

public class QuicksortInsertionTimes {
	static int[] v;

	public static void main(String arg[]) {
		long t1, t2;
		int[] k = {5,10,20,30,50,100,200,500,1000};
		int n = 16000000;//16M
		for (int ki : k){
			v = new int[n];

			Vector.randomSorted(v);

			t1 = System.currentTimeMillis();

			QuicksortInsertion.quicksortInsertion(v, ki);

			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + (t2 - t1) + "\t" + "k=" +ki);
		}
	}
}
