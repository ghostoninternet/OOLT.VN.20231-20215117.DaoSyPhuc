package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	
	private Cart cart;
	private Store store;
	
	@FXML
	private TextField tfFilter;
	
	@FXML
	private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;
	
	@FXML
	private ToggleGroup filterCategory;

	@FXML
	private TableView<Media> tblMedia;

	@FXML
	private TableColumn<Media, Integer> colMediaId;

	@FXML
	private TableColumn<Media, String> colMediaTitle;

	@FXML
	private TableColumn<Media, String> colMediaCategory;

	@FXML
	private TableColumn<Media, Float> colMediaCost;

	@FXML
	private Button btnPlay;

	@FXML
	private Button btnRemove;

	@FXML
	private Label costLabel;

	public CartController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}
	    
	@FXML
	void btnPlayPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		Playable playableMedia = (Playable) media;
		playableMedia.play();
	}

	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		totalCost(cart.getItemsOrdered());
	}

	@FXML
	void btnViewStorePressed(ActionEvent event) {
		try {
			final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
			ViewStoreController viewStoreController = new ViewStoreController(store, cart);
			fxmlLoader.setController(viewStoreController);
			Parent root = fxmlLoader.load();
			
        	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        	stage.setScene(new Scene(root));
        	stage.setTitle("Cart");
        	stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
	}
	
	@FXML
	void btnPlaceOrderPressed(ActionEvent event) {
		cart.emptyCart();
		tblMedia.setItems(cart.getItemsOrdered());
		costLabel.setText("0$");
	}
	
	@FXML
	public void initialize() {
		colMediaId.setCellValueFactory(
				new PropertyValueFactory<Media, Integer>("id"));
		colMediaTitle.setCellValueFactory(
				new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(
				new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(
				new PropertyValueFactory<Media, Float>("cost"));
		if(cart.getItemsOrdered() != null) {
			tblMedia.setItems(cart.getItemsOrdered());
			totalCost(cart.getItemsOrdered());
			btnPlay.setVisible(false);
			btnRemove.setVisible(false);
			
			tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>(){
				@Override
				public void changed(ObservableValue< ? extends Media> observable, Media oldValue, Media newValue) {
					updateButtonBar(newValue);
				}
			});
		}
		
		tfFilter.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (radioBtnFilterId.isSelected()) {
					try {
						showFilteredMedia(Integer.parseInt(newValue));						
					} catch (NumberFormatException e) {
					    System.out.println("Error: Cannot parse the string as an integer.");
					}
				} else {
					showFilteredMedia(newValue);					
				}
			}
		});
		
	}
	
	void updateButtonBar(Media media) {
		if (media == null) {
			btnPlay.setVisible(false);
			btnRemove.setVisible(false);
		} else {
			btnRemove.setVisible(true);
			if (media instanceof Playable) {
				btnPlay.setVisible(true);
			} else {
				btnPlay.setVisible(false);
			}
		}
	}
	
	void showFilteredMedia(String newValue) {
		FilteredList<Media> filteredData = new FilteredList<>(cart.getItemsOrdered());
		filteredData.setPredicate(media -> {
			if (newValue == null || newValue.isEmpty()) {
				return true;
			}
			
			String lowerCaseFilter = newValue.toLowerCase();
			
			if (media.getTitle().toLowerCase().indexOf(lowerCaseFilter) != -1) {
				return true;
			}
			return false;
		});
		tblMedia.setItems(filteredData);
	}
	
	void showFilteredMedia(int newValue) {
		FilteredList<Media> filteredData = new FilteredList<>(cart.getItemsOrdered());
		filteredData.setPredicate(media -> {
			return media.isMatch(newValue);
		});
		tblMedia.setItems(filteredData);
	}
	
	void totalCost(ObservableList<Media> currentCart) {
		float cost = 0;
		for(int i = 0; i < currentCart.size(); i++) {
			cost += currentCart.get(i).getCost();
		}
		costLabel.setText(cost + "$");
	}
}
