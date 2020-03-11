
public abstract class ProblemTemplate {
	public abstract String getName();
	public abstract Problem genProblem();
}
class Problem {
	private String question, ans;
	public Problem(String q, String a) {
		question = q;
		ans = a;
	}
	public boolean checkAnswer(String a) {
		return a.equals("Answer: " + ans);
	}
	public String getQuestion() {
		return question;
	}
	public String getAns() {
		return ans;
	}
	public String correctAnswer() {
		String r = "Correct! :)";
		return r;
	}
}