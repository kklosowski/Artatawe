/**
 * CanvasController.java
 * @version 1.0
 * @author Tereza
 */

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

public class CanvasController {
	/**
	 * The colour a user has picked.
	 */
	@FXML
	private ColorPicker colour;
	/**
	 * A button for erasing.
	 */
	@FXML
	private Button eraser;
	/**
	 * A button for drawing a line or lines.
	 */
	@FXML
	private Button drawLine;
	/**
	 * A button for drawing a circle or circles.
	 */
	@FXML
	private Button drawCircle;
	/**
	 * Canvas used for the drawing.
	 */
	@FXML
	private Canvas canvas;
	/**
	 * A button for saving the image.
	 */
	@FXML
	private Button saveImage;
	/**
	 * A label for a selected option.
	 */
	@FXML
	private Label selectedLabel;
	/**
	 * A button for drawing a rectangle or rectangles.
	 */
	@FXML
	private Button drawRect;
	/**
	 * A slider for the size of the shapes.
	 */
	@FXML
	private Slider size;

	/**
	 * A label for the title of the page.
	 */
	@FXML
	private Label drawAvatarLabel;
	/**
	 * A variable for keeping track of selected options.
	 */
	private int selectedTool = -1;

	/**
	 * Creating the GUI and
	 * initializing the right action depending on the user's choices.
	 */
	@FXML
	public void initialize() {
		selectedLabel.setText("Nothing Selected.");//Initial state of selectedLabel.
		eraser.setOnAction((e) -> {//Selected is the "Eraser" button.
			selectedLabel.setText("Selected: Eraser");
			selectedTool = 0;
		});

		drawLine.setOnAction((e) -> {//Selected is the "Draw a line" button.
			selectedLabel.setText("Selected: Line");
			selectedTool = 1;
		});
		drawCircle.setOnAction((e) -> {//Selected is the "Draw a circle" button.
			selectedLabel.setText("Selected: Circle");
			selectedTool = 2;
		});

		drawRect.setOnAction((e) -> {//Selected is the "Draw a rectangle" button.
			selectedLabel.setText("Selected: Rectangle");
			selectedTool = 3;
		});
		saveImage.setOnAction((e) -> {//Selected is the "Save image" button.
			//Write a image with the properties of the canvas used.
			WritableImage writableImage = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
			//Take a snapshot of the canvas and write in writableImage.
			canvas.snapshot(null, writableImage);
			String format = "png";
			//Create an empty file.
			File file = new File("drawnAvatar.png");
			//Try to write image to file.
			try {
				ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), format, file);
			} catch (IOException e1) {
				e1.printStackTrace();

			}
			//Close the window,after the image is saved.
			((Stage) (((Button) e.getSource()).getScene().getWindow())).close();
		});

		// Access the graphic context of the canvas
		GraphicsContext g = canvas.getGraphicsContext2D();
		
		//Handle mouse events - clicking and dragging the mouse.
		EventHandler<MouseEvent> event = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				if (selectedTool == 0) {//Selected is eraser.
					//Create a clear rectangle, using the mouse's coordinates on the canvas as the rectangle's coordinates
					//and get the width and height by the value of the slider.
					g.clearRect((int) e.getX(), (int) e.getY(), (int) size.getValue(), (int) size.getValue());

				} else if (selectedTool == 1) {//Selected is drawLine. 
					//Set the colour of the line.
					g.setStroke(colour.getValue());
					//Set the width of the line,
					g.setLineWidth(5);
					//Create a line, using the mouse's coordinates on the canvas as the lines's coordinates.
					g.strokeLine((int) e.getX(), (int) e.getY(), (int) e.getX() + (int) size.getValue(),
							(int) e.getY());

				} else if (selectedTool == 2) {// Selected is drawCircle.
					//Set the colour of the circle.
					g.setFill(colour.getValue());
					//Create a filled circle, using the mouse's coordinates on the canvas as the circle's coordinates
					//and get the width and height by the value of the slider.
					g.fillOval((int) e.getX(), (int) e.getY(), (int) size.getValue(), (int) size.getValue());

				} else if (selectedTool == 3) {// Selected is rectangle.
					//Set the colour of the rectangle.
					g.setFill(colour.getValue());
					//Create a filled rectangle, using the mouse's coordinates on the canvas as the rectangle's coordinates
					//and get the width and height by the value of the slider.
					g.fillRect((int) e.getX(), e.getY(), (int) size.getValue(), (int) size.getValue());

				}
			}
		};

		//Set the minimum value of the slider.
		size.setMin((int) 1);
		//Set the maximum value of the slider.
		size.setMax((int) 100);

		//Call the mouse handler "event", when the mouse is clicked.
		canvas.setOnMouseClicked(event);
		//Call the mouse handler "event", when the mouse is clicked.
		canvas.setOnMouseDragged(event);

	}

}