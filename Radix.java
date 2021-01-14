public class Radix{
	public static int nth(int n, int col){
		return (int)((n / (Math.pow(10, col))) % 10);
	}

	public static int length(int n){
		if (n == 0){
			return 1;
		} else {
			return (int)Math.log10(n) + 1;
		}
	}
}
