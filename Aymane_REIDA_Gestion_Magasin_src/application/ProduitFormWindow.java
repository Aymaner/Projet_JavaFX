package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProduitFormWindow {
	ProduitAddHandler handler = new ProduitAddHandler(this);
	VBox root = new VBox();
	HBox buttonsBox = new HBox();
	Scene scene = new Scene(root);
	Stage window = new Stage();
	Label titleLabel = new Label("Nouveau produit");

	Label produitDesignationLabel = new Label("Designation:");
	TextField produitDesignationTextField = new TextField();
	Label produitQteLabel = new Label("Quantit� en stock:");
	TextField produitQteTextField = new TextField();
	Label produitPrixAchatLabel = new Label("Prix achat:");
	TextField produitPrixAchatTextField = new TextField();
	Label produitPrixVenteLabel = new Label("Prix vente:");
	TextField produitPrixVenteTextField = new TextField();
	Label produitDateLabel = new Label("Date saisie:");
	DatePicker produitDateSaisieDatePicker = new DatePicker();
	Button produitAddButton = new Button("Ajouter");
	Button produitCancelButton = new Button("Annuler");

	private void initWindow() {
		window.setScene(scene);
		window.setWidth(700);
		window.setHeight(600);
		window.setTitle("Nouveau produit");
		window.getIcons().add(new Image("file:icon.png"));
		window.initModality(Modality.APPLICATION_MODAL);
	}

	private void addNodesToWindow() {
		root.getChildren().add(titleLabel);
		root.getChildren().addAll(produitDesignationLabel, produitDesignationTextField, produitQteLabel,
				produitQteTextField, produitPrixAchatLabel, produitPrixAchatTextField, produitPrixVenteLabel,
				produitPrixVenteTextField, produitDateLabel, produitDateSaisieDatePicker);
		buttonsBox.getChildren().addAll(produitAddButton, produitCancelButton);
		root.getChildren().addAll(buttonsBox);
	}

	private void addStylesToNodes() {
		scene.getStylesheets().add("css/styles.css");
		titleLabel.getStyleClass().add("labelTitle");
		titleLabel.setMinWidth(window.getWidth());
		produitDesignationLabel.getStyleClass().add("labelForm");
		produitQteLabel.getStyleClass().add("labelForm");
		produitPrixAchatLabel.getStyleClass().add("labelForm");
		produitPrixVenteLabel.getStyleClass().add("labelForm");
		produitDateLabel.getStyleClass().add("labelForm");
		root.setSpacing(15);
		buttonsBox.setSpacing(20);
	}

	private void addEvents() {
		produitCancelButton.setOnAction(event -> {
			window.close();
		});
		produitAddButton.setOnAction(event -> {
			// System.out.println("Traitement pour ajouter");
			handler.addClick();
		});
		window.setOnCloseRequest(event -> {
			event.consume();
		});
	}

	public ProduitFormWindow() {
		initWindow();
		addStylesToNodes();
		addNodesToWindow();
		addEvents();
		window.show();
	}
}
