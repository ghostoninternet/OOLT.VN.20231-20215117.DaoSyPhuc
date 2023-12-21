package hust.soict.hedspi.test.screen.customer.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewCartScreen extends Application {
	private static Cart cart;
	private static Store store;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		CartController cartController = new CartController(store, cart);
		fxmlLoader.setController(cartController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Cart");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		cart = new Cart();
		store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(145, "Oppenheimer", "Documentation", 50.5f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(245, "Indiana Jones and the Dial of Destiny", "Action", 70.5f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(345, "Die Hard 5 - Movie Collection", "Action", 100f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc(445, "Top Gun: Maverick", "Action", 40.5f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc(545, "Avengers: Infinity War", "Sci-fi", 50.5f);
		Book book1 = new Book(123, "Silence of the lambs", "Psychology", 10.25f);
		cart.addMedia(book1);
		cart.addMedia(dvd1);
		cart.addMedia(dvd2);
		cart.addMedia(dvd3);
		cart.addMedia(dvd4);
		cart.addMedia(dvd5);
		
		launch(args);
	}
}
