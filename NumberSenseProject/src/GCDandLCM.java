
public class GCDandLCM extends ProblemTemplate {
	static int GcdLcm = -1;
	public Problem genProblem() {
		GcdLcm++;
		if (GcdLcm % 2 == 0) {
			int random1 = 1, random2 = 1;
			while (isPrime(random1)) {
				random1 = (int)(Math.random() * 100) + 1;
			}
			while (isPrime(random2)) {
				random2 = (int)(Math.random() * 100) + 1;
			}
			String question = String.format("What is the GCD of %d and %d?", random1, random2);
			String ans = "" + gcd(random1, random2);
			return new Problem(question, ans);
		}
		else {
			int random1 = (int)(Math.random() * 50) + 1, random2 = (int)(Math.random() * 50) + 1;
			String question = String.format("What is the LCM of %d and %d?", random1, random2);
			String ans = (random1 * random2 / gcd(random1, random2)) + "";
			return new Problem(question, ans);
		}
	}
	public String getName() {
		return "GCD and LCM";
	}
	public int gcd(int a, int b) {
		if (a == 0) return b;
		return gcd(b % a, a);
	}
	public boolean isPrime(int n) {
		if (n == 0 || n == 1) return true;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
}
