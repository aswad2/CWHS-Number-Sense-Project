
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXApp extends Application {
	int timesPressedButton = 0;

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primary) throws Exception {
		// TODO Auto-generated method stub
		primary.setTitle("First JavaFX App");
		Label label = new Label("Number Sense Ting!");
		File photofile = new File("ronakBackView.png");
		Image image = SwingFXUtils.toFXImage(ImageIO.read(photofile), null);
		ImageView imageview = new ImageView(image);
		imageview.setFitHeight(300);
		imageview.setFitWidth(450);
		Image image2 = SwingFXUtils.toFXImage(ImageIO.read(photofile), null);
		ImageView imageview2 = new ImageView(image2);
		imageview2.setFitHeight(300);
		imageview2.setFitWidth(450);
		Label newlabel = new Label("", imageview);
		Label blabel = new Label("", imageview);
		newlabel.setWrapText(true);
		// newlabel.setFont(new Font("Arial", 16));
		Hyperlink hl = new Hyperlink("Take a quick test!");
		hl.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #0000ff;");
		hl.setOnAction(e -> {
			System.out.println("Vibe Check Passed. Good job king");
		});
		TextField texting = new TextField("Type Answer Here:");
		texting.setAlignment(Pos.CENTER);
		Button button = new Button("", imageview);
		Button backbutton = new Button("Back to Home Page", imageview2);
		button.setPrefHeight(300);
		VBox b = new VBox();
		b.getChildren().add(backbutton);
		Scene s = new Scene(b);
		Label l = new Label("Not yet clicked");
		l.setStyle("-fx-background-color: #00ff00; -fx-font-size: 2em;");
		// button.setStyle("-fx-background-color: #ff0000;");
		button.setOnMousePressed(new EventHandler() {
			public void handle(Event event) {
				timesPressedButton++;
				System.out.println("Button Pressed " + timesPressedButton + " time(s)!");
				l.setText("Clicked");
				primary.setScene(s);
			}
		});
		texting.setOnKeyPressed(e -> {
		    if (e.getCode() == KeyCode.ENTER) {
		    	VBox x = new VBox();
		    	x.getChildren().add(button);
		    	Scene w = new Scene(x);
		    	primary.setScene(w);
		    }
		});
		MenuItem m1 = new MenuItem("FOIL Technique");
		MenuItem m2 = new MenuItem("Approximations"), m3 = new MenuItem("Squares");
		MenuButton mb = new MenuButton("Select what you want to work on", null);
		mb.getItems().add(m1);
		mb.getItems().add(m2);
		mb.getItems().add(m3);
		VBox vbox = new VBox();
		vbox.getChildren().add(mb);
		vbox.getChildren().add(button);
		vbox.getChildren().add(l);
		vbox.getChildren().add(hl);
		vbox.getChildren().add(texting);
		Scene scene2 = new Scene(vbox);
		primary.setScene(scene2);
		backbutton.setOnMousePressed(new EventHandler() {
			public void handle(Event arg0) {
				// Scene ss = new Scene(generateVBox(mb, button, l, hl, texting));
				primary.setScene(scene2);
			}
		});
		primary.setFullScreen(false);
		primary.setWidth(1000);
		primary.setHeight(500);
		primary.show();
	}

	public static VBox generateVBox(MenuButton mb, Button button, Label l, Hyperlink hl, TextField texting) {
		VBox vbox = new VBox();
		vbox.getChildren().add(mb);
		vbox.getChildren().add(button);
		vbox.getChildren().add(l);
		vbox.getChildren().add(hl);
		vbox.getChildren().add(texting);
		return vbox;
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
