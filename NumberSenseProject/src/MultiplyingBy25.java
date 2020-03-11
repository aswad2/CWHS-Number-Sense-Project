
public class MultiplyingBy25 extends ProblemTemplate {
	public Problem genProblem() {
		int random = (int)(Math.random() * 1000);
		String question = String.format("What is %d x 25?", random);
		String ans = "" + (random * 25);
		return new Problem(question, ans);
	}
	public String getName() {
		return "Multiplying by 25";
	}
}
