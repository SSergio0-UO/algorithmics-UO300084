package algstudent.s3;

public class Subtraction4 {
	public static long rec4(int n) {
		long cont = 0;
		if (n <= 0)
			cont++;
		else {
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					cont++; 
			rec4(n - 1);
		}
		return cont;
	}

	public static void main(String arg[]) {
		long t1 = 0, t2 = 0, cont = 0;
		int n = 100;
		while (t1 - t2 < 60000) {
			t1 = System.currentTimeMillis();

			cont = rec4(n);

			t2 = System.currentTimeMillis();

			System.out.println("n=" + n + "**TIME=" + (t2 - t1) + "**cont=" + cont);
			
			n = n * 2;
		} // for
	} // main
} // class