public abstract class ProblemTemplate {
	public abstract Problem genProblem();
}
class Problem {
	private String question, ans;
	public Problem(String q, String a) {
		question = q;
		ans = a;
	}
	public boolean checkAnswer(String a) {
		return ans.equals("Answer: " + a);
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