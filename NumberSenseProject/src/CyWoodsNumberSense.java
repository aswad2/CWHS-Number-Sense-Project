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
		primary.setTitle("Number Sense Practice");

		FileInputStream titlePhoto = new FileInputStream("NumberSenseTitleScreen.png");
		ImageView image = new ImageView(new Image(titlePhoto));
		VBox vbox = new VBox();
		vbox.getChildren().add(image);

		Button multiplyingBy11s = new Button("Multiplying by 11");
		ProblemManager pm = new ProblemManager(primary);
		pm.loadNewProblemTemplates(new MultiplyingBy11());
		multiplyingBy11s.setOnMousePressed(event -> {
			System.out.println("Pressed");
			pm.loadNewProblem();
		});

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
