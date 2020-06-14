package com.paul.temperaturecontrollerapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Controller Tool");
		primaryStage.show();

	}

	public MenuBar createMenu(){

		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");
		newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked !"));

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

		MenuItem quitMenuItem = new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("aboutApp");
		aboutApp.setOnAction(event -> aboutApp());

		helpMenu.getItems().addAll(aboutApp);


		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);

		return menuBar;
	}

	private void aboutApp() {
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First Desktop App");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("I am just a beginner but soon I will become a pro in developing awesome Java games");

		ButtonType yesbtn = new ButtonType("Yes");
		ButtonType nobtn = new ButtonType("No");
		alertDialog.getButtonTypes().setAll(yesbtn,nobtn);

		Optional<ButtonType> clickedbtn = alertDialog.showAndWait();
		if(clickedbtn.isPresent() && clickedbtn.get()==yesbtn){
			System.out.println("Yes Button Clicked !");
		}else{
			System.out.println("No Button Clicked !");
		}

	}

}
