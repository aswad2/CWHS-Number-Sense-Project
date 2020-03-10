	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//Categories: multiplyihg by 11, multiplying by 25, gcd/lcm, coordinates, which is bigger, Approximations, 2x2 multiplication, adding/subtracting, money problems, polynomials, set theory, equation solving, percentages, fraction addition/subtraction/multiplication, remainders
public class CyWoodsNumberSense extends Application {
	Problem curProblem;
	public void start(Stage primary) throws Exception {
		// TODO Auto-generated method stub
		primary.setTitle("Number Sense Practice");
		FileInputStream titlePhoto = new FileInputStream("NumberSenseTitleScreen.png");
		ImageView image = new ImageView(new Image(titlePhoto));
		VBox vbox = new VBox();
		Button multiplyingBy11s = new Button("Multiplying by 11");
		ProblemTemplate pt = new MultiplyingBy11();
		curProblem = pt.genProblem();
		multiplyingBy11s.setOnMousePressed(event -> {
			VBox displayProblem = new VBox();
			TextArea problem = new TextArea(curProblem.getQuestion());
			problem.setFont(new Font("Arial", 16));
			problem.setEditable(false);
			TextField answer = new TextField("Answer: ");
			displayProblem.getChildren().add(problem);
			displayProblem.getChildren().add(answer);
			answer.setOnKeyPressed(e -> {
				if (e.getCode() == KeyCode.ENTER) {
					// System.out.println(answer.getText());
					//if (answer.getText().equals("Answer: " + (random * 11) + "")) {
					//System.out.println(answer.getText());
					if(curProblem.checkAnswer(answer.getText())) {
						TextField correctAnswer = new TextField("Correct! :)");
						correctAnswer.setFont(new Font("Arial", 40));
						correctAnswer.setEditable(false);
						Scene correct = new Scene(correctAnswer);
						primary.setScene(correct);
						Runnable run = new Runnable() {
							@Override
							public void run() {
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								Platform.runLater(new Runnable() {
									@Override
									public void run() {
										curProblem = pt.genProblem();
										VBox newProblem = new VBox();
										TextArea prob = new TextArea(curProblem.getQuestion());
										TextField answer1 = new TextField("Answer: ");
										newProblem.getChildren().add(prob);
										newProblem.getChildren().add(answer1);
										Scene newtrick = new Scene(newProblem);
										primary.setScene(newtrick);
									}
								});
							}
						};
						new Thread(run).start();
						

					} else
						System.out.println("Incorrect :( Correct answer was " + curProblem.getAns() + ".");
				}
			});
			Scene tryTrick = new Scene(displayProblem);
			primary.setScene(tryTrick);
			primary.setFullScreen(true);
		});
		vbox.getChildren().add(image);
		vbox.getChildren().add(multiplyingBy11s);
		Scene scene = new Scene(vbox);
		primary.setScene(scene);
		primary.setFullScreen(true);
		primary.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
