package application;

import java.util.*;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller {
	@FXML
	public Pagination pagination;
	
	@FXML
	protected TextField txtFullName, txtGender, txtAddress, txtIncome;
	
	@FXML
	protected ListView<String> lvPurchase, lvSale;
	
	protected int contentPerPage =7;
	
	protected String selectedName;
	protected User selectedUser;
	
	List<User> lstOfUser = new ArrayList<>();
	List<Item> lstOfItem = new ArrayList<>();
	
	public void seedUser() {
		lstOfUser.add(new User("John", "Doe", 'M', "Dove Street"));
		lstOfUser.add(new User("Mary", "Sue", 'F', "Eagle Street"));
		lstOfUser.add(new User("Van", "Couver", 'M', "Crow Street"));
		lstOfUser.add(new User("Chuan", "Cuan", 'M', "Parrot Street"));
		lstOfUser.add(new User("Pan", "Demonium", 'M', "Bird Street"));
		lstOfUser.add(new User("San", "Serif", 'M', "Dove Street"));
		lstOfUser.add(new User("Ran", "Mao", 'M', "Dove Street"));
		lstOfUser.add(new User("Sam", "Sung", 'M', "Dove Street"));
	}
	
	public void seedItem() {
		lstOfItem.add(new Item("Helm", 125000));
		lstOfItem.add(new Item("Obeng", 12000));
		lstOfItem.add(new Item("Spion", 18000));
		lstOfItem.add(new Item("Oli", 30000));
	}
	
	public void initialize() {
		selectedName = "";
		seedUser();
		seedItem();
		double pageCount = (double) lstOfUser.size() / contentPerPage;
		
		pageCount = Math.ceil(pageCount);
		pagination.setPageCount((int)pageCount);
		
		pagination.setPageFactory(param->createPage(param));
	}
	
	public ListView<String> createPage(int pageIndex){
		ListView<String> lvUser = new ListView<>();
		
		lvUser.setOnMouseClicked(event->
			selectedName = lvUser.getSelectionModel().getSelectedItem());
		
		int minIndex = pageIndex * contentPerPage;
		int maxIndex = pageIndex+1 * contentPerPage;
		
		maxIndex = Math.min(maxIndex, lstOfUser.size());
		LinkedList<String> lstOfNames =
				lstOfUser.subList(minIndex, maxIndex)
				.stream()
				.map(user->user.getFullName())
				.collect(Collectors.toCollection(LinkedList::new));
		ObservableList<String> items = FXCollections.observableArrayList(lstOfNames);
		lvUser.setItems(items);
		
		return lvUser;
	}
	
	public void handleLoadInfo() {
		try {
			Optional<User> userOptional =
					lstOfUser.stream()
					.filter(u -> u.getFullName().equals(selectedName))
					.findFirst();
			
			selectedUser = userOptional.get();
			
			txtFullName.setText(selectedUser.getFullName());
			txtGender.setText(selectedUser.getGender());
			txtAddress.setText(selectedUser.getAddress());
			
			refreshSaleListView();
			refreshPurchaseListView();
			refreshIncome();
					
		} catch(NoSuchElementException ex) {
			System.out.println("No Selected element");
		}
	}
	
	public void refreshSaleListView() {
		lvPurchase.getItems().clear();
		for(Transaction p : selectedUser.getPurchase()) {
			lvPurchase.getItems().add(p.getTransactionInfo());
		}
	}
	
	public void refreshPurchaseListView() {
		try {
			lvSale.getItems().clear();
			for(Transaction p : selectedUser.getPurchase()) {
				lvSale.getItems().add(p.getTransactionInfo());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void	refreshIncome() {
		txtIncome.setText(selectedUser.getIncome().toString());
	}
	
	public void handlePurchase() {
		if(selectedUser == null) {
			String title = "Warning";
			String header = "No Selected User";
			String content = "Please select user from the list";
			presentAlert(title,header,content);
			return;
		}
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("purchaseForm.fxml"));
			Parent root = loader.load();
			Stage purchaseStage = new Stage();
			purchaseStage.initModality(Modality.APPLICATION_MODAL);
			purchaseStage.setTitle("Purchase");
			purchaseStage.setScene(new Scene(root,333,222));
			
			PurchaseFormController controller = loader.getController();
			controller.setPurchaseFormData(selectedUser, lstOfItem);
			purchaseStage.showAndWait();
			refreshPurchaseListView();
			refreshIncome();
		} catch (Exception e) {
			System.out.println("Failed to open form!");
		}
	}
	
	public void handleSale() {
		if(selectedUser == null) {
			String title = "Warning";
			String header = "No Selected User";
			String content = "Please select user from the list";
			presentAlert(title,header,content);
			return;
		}
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("saleForm.fxml"));
			Parent root = loader.load();
			Stage purchaseStage = new Stage();
			purchaseStage.initModality(Modality.APPLICATION_MODAL);
			purchaseStage.setTitle("Purchase");
			purchaseStage.setScene(new Scene(root,333,222));
			
			SaleFormController controller = loader.getController();
			controller.setSaleFormData(selectedUser, lstOfItem);
			purchaseStage.showAndWait();
			refreshPurchaseListView();
			refreshIncome();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to open form!");
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
