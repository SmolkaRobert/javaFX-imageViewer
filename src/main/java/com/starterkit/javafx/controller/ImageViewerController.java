package com.starterkit.javafx.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.starterkit.javafx.model.ImageViewer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ImageViewerController {

	private static final Logger LOG = Logger.getLogger(ImageViewerController.class);

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	/*
	 * REV: nie ma takiej kontrolki w FXMLu
	 */
	@FXML
	private TextField nameField;

	@FXML
	private Button selectDirectoryButton;

	@FXML
	private TableView<File> resultTable;

	@FXML
	private TableColumn<File, String> fileNameColumn;

	private final FileChooser fileChooser = new FileChooser();

	private final ImageViewer model = new ImageViewer();

	private File selectedDirectory;

	public ImageViewerController() {
		LOG.debug("Constructor: nameField = " + nameField);
	}

	@FXML
	private void initialize() {
		LOG.debug("initialize(): nameField = " + nameField);

		// initializeResultTable();

		/*
		 * Bind controls properties to model properties.
		 */
		// nameField.textProperty().bindBidirectional(model.ImageFileProperty());
		// resultTable.itemsProperty().bind(model.resultProperty());

		// selectDirectoryButton.disableProperty().bind(nameField.textProperty().isEmpty());
	}

	private void initializeResultTable() {
		/*
		 * Define what properties of PersonVO will be displayed in different
		 * columns.
		 */
		// nameColumn.setCellValueFactory(cellData -> new
		// ReadOnlyStringWrapper(cellData.getValue().getName()));

		/*
		 * Show specific text for an empty table. This can also be done in FXML.
		 */
		resultTable.setPlaceholder(new Label(resources.getString("table.emptyDirectory")));

		/*
		 * When table's row gets selected display image instead of saying name.
		 */
		// resultTable.getSelectionModel().selectedItemProperty().addListener(new
		// ChangeListener<File>() {
		//
		// @Override
		// public void changed(ObservableValue<? extends File> observable, File
		// oldValue, File newValue) {
		// LOG.debug(newValue + " selected");
		//
		// if (newValue != null) {
		// Task<Void> backgroundTask = new Task<Void>() {
		//
		// @Override
		// protected Void call() throws Exception {
		// // speaker.say(newValue.getName());
		// return null;
		// }
		//
		// @Override
		// protected void failed() {
		// // LOG.error("Could not say name: " +
		// // newValue.getName(), getException());
		// }
		// };
		// new Thread(backgroundTask).start();
		// }
		// }
		// });
	}

	@FXML
	private void selectDirectoryButtonAction(ActionEvent event) {
		LOG.debug("'Search' button clicked");

		DirectoryChooser directoryChooser = new DirectoryChooser();
		Node eventSource = (Node) event.getSource();
		Stage currentStage = (Stage) eventSource.getScene().getWindow();
		selectedDirectory = directoryChooser.showDialog(currentStage);

		if (selectedDirectory == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("No directory selected.");
			alert.setContentText("You selected no directory");

			alert.showAndWait();
		} else {
			LOG.debug("Selected directory: " + selectedDirectory.getAbsolutePath());
			;
		}
		FileChooser fileChooser = new FileChooser();
		ExtensionFilter filtersCollection = new ExtensionFilter("Image file filters", ".jpg", ".png", ".bmp");
		fileChooser.getExtensionFilters().addAll(filtersCollection);

		fileChooser.setInitialDirectory(selectedDirectory);
	}

}
