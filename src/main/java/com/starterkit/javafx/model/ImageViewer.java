package com.starterkit.javafx.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;

public class ImageViewer {

	private final ObjectProperty<File> imageFile = new SimpleObjectProperty<>();
	private final ListProperty<File> result = new SimpleListProperty<>(FXCollections.observableList(new ArrayList<>()));

	public final File getImageFile() {
		return imageFile.get();
	}

	public final void setImageFile(File value) {
		imageFile.set(value);
	}

	public ObjectProperty<File> imageFileProperty() {
		return imageFile;
	}

	public final List<File> getResult() {
		return result.get();
	}

	public final void setResult(List<File> value) {
		result.setAll(value);
	}

	public ListProperty<File> resultProperty() {
		return result;
	}

	@Override
	public String toString() {
		return "PersonSearch [name=" + imageFile + ", result=" + result + "]";
	}

}
