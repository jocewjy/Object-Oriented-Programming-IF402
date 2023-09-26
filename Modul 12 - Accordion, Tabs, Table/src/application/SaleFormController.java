package application;

import java.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SaleFormController {
	@FXML
	protected ComboBox<String> cboItem;
	
	@FXML
	protected TextField txtAmount, txtSellingPrice;
	
	protected User user;
	protected List<Item> lstOfItem;
	
	public void setSaleFormData(User user, List<Item> lstOfItem) {
		this.user = user;
		this.lstOfItem = lstOfItem;
		lstOfItem.stream().forEach(item->cboItem.getItems().add(item.getName()));
	}
	
	public void addSale() {
		String title = "Warning Dialog";
		try {
			String selectedItemName = cboItem.getSelectionModel().getSelectedItem();
			Item item = lstOfItem.stream()
					.filter(i-> i.getName().equals(selectedItemName))
					.findFirst()
					.get();
			int amount = Integer.parseInt(txtAmount.getText());
			int price = Integer.parseInt(txtSellingPrice.getText());
			Sale sale = new Sale(item, amount, price);
			user.addTransaction(sale);
			Stage stage = (Stage)cboItem.getScene().getWindow();
			stage.close();
		} catch(NoSuchElementException e) {
			String header = "No Selected Item";
			String content = "Please select item from the item options";
			presentAlert(title, header, content);
		} catch (NumberFormatException e) {
			String header = "Amount must be a number!";
			String content = "Please input number for amount field";
			presentAlert(title, header, content);
		}
	}
	
	private void presentAlert(String title, String header, String content) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
	}
}
