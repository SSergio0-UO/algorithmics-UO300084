package algstudent.s3;

public class Subtraction5 {
	public static long rec5(int n) {
		long cont = 0;
		if (n <= 0)
			cont++;
		else {
			cont++;
			rec5(n - 2);
			rec5(n - 2);
			rec5(n - 2);
		}
		return cont;
	}

	public static void main(String arg[]) {
		long t1 = 0, t2 = 0, cont = 0;
		int n = 30;
		while (t1 - t2 < 60000) {
			t1 = System.currentTimeMillis();

			cont = rec5(n);

			t2 = System.currentTimeMillis();

			System.out.println("n=" + n + "**TIME=" + (t2 - t1) + "**cont=" + cont);
			
			n +=2;
		} // for
	} // main
} // class