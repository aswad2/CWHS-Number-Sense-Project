import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ProblemManager {
	Stage stage;
	ProblemTemplate[] templates;

	public ProblemManager(Stage s) {
		stage = s;
	}

	public void loadNewProblemTemplates(ProblemTemplate... pt) {
		templates = pt;
	}

	public void onCorrect() {
		TextField correctAnswer = new TextField("Correct! :)");
		correctAnswer.setFont(new Font("Arial", 40));
		correctAnswer.setEditable(false);
		Scene correct = new Scene(correctAnswer);
		stage.setScene(correct);
		new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Platform.runLater(this::loadNewProblem);
		}).start();
	}

	public void onIncorrect(Problem p) {
		TextField incorrectAnswer = new TextField("Incorrect. :( Correct answer was " + p.getAns());
		incorrectAnswer.setFont(new Font("Arial", 40));
		incorrectAnswer.setEditable(false);
		Scene incorrect = new Scene(incorrectAnswer);
		stage.setScene(incorrect);
		stage.setWidth(500);
		stage.setHeight(200);
		new Thread(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Platform.runLater(this::loadNewProblem);
		}).start();
	}

	public ProblemTemplate pickRandomTemplate() {
		return templates[(int) (templates.length * Math.random())];
	}

	public void handleSubmit(Problem p, String ans) {
		if (p.checkAnswer(ans)) {
			onCorrect();
		}
		else {
			onIncorrect(p);
		}
	}

	public void loadNewProblem() {
		Problem p = pickRandomTemplate().genProblem();
		TextArea ptext = new TextArea(p.getQuestion());
		ptext.setFont(new Font("Arial", 16));
		ptext.setEditable(false);
		TextField atext = new TextField("Answer: ");
		atext.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER)
				handleSubmit(p, atext.getText());
		});
		VBox displayProblem = new VBox();
		displayProblem.getChildren().add(ptext);
		displayProblem.getChildren().add(atext);
		stage.setScene(new Scene(displayProblem));
		atext.requestFocus();
		//set preferred width and height of new problem here
	}
}
