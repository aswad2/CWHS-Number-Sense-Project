import java.io.File;
import javax.imageio.ImageIO;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXApp extends Application {
	int timesPressedButton = 0;

	public void start(Stage primary) throws Exception {
		primary.setTitle("NS App");

		File photofile = new File("ronakBackView.png");
		Image image = SwingFXUtils.toFXImage(ImageIO.read(photofile), null);
		ImageView imageview = new ImageView(image);
		imageview.setFitHeight(300);
		imageview.setFitWidth(450);
		Image image2 = SwingFXUtils.toFXImage(ImageIO.read(photofile), null);
		ImageView imageview2 = new ImageView(image2);
		imageview2.setFitHeight(300);
		imageview2.setFitWidth(450);

		// newlabel.setFont(new Font("Arial", 16));
		Hyperlink hl = new Hyperlink("Take a quick test!");
		hl.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #0000ff;");
		hl.setOnAction(e -> {
			System.out.println("Vibe Check Passed. Good job king");
		});

		Button button = new Button("", imageview);
		Button backbutton = new Button("Back to Home Page", imageview2);
		button.setPrefHeight(300);

		Scene s = new Scene(generateVBox(backbutton));
		Label l = new Label("Not yet clicked");
		l.setStyle("-fx-background-color: #00ff00; -fx-font-size: 2em;");
		// button.setStyle("-fx-background-color: #ff0000;");
		button.setOnMousePressed(e -> {
			timesPressedButton++;
			System.out.println("Button Pressed " + timesPressedButton + " time(s)!");
			l.setText("Clicked");
			primary.setScene(s);
		});

		TextField texting = new TextField("Type Answer Here:");
		texting.setAlignment(Pos.CENTER);
		texting.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				Scene w = new Scene(generateVBox(button));
				primary.setScene(w);
			}
		});

		String[] items = { "FOIL Technique", "Approximations", "Squares" };
		MenuButton mb = new MenuButton("Select what you want to work on");
		for (String item : items) {
			MenuItem mi = new MenuItem(item);
			mi.setOnAction(e -> {
				System.out.println("Pressed on " + item);
			});
			mb.getItems().add(mi);
		}
		Scene scene2 = new Scene(generateVBox(mb, button, l, hl, texting));
		primary.setScene(scene2);
		backbutton.setOnMousePressed(e -> {
			primary.setScene(scene2);
		});
		primary.setFullScreen(false);
		primary.setWidth(1000);
		primary.setHeight(500);
		primary.show();
	}

	public static VBox generateVBox(Node... children) {
		VBox vbox = new VBox();
		for (Node child : children)
			vbox.getChildren().add(child);
		return vbox;
	}

	public static void main(String[] args) {
		Application.launch();
	}

}
