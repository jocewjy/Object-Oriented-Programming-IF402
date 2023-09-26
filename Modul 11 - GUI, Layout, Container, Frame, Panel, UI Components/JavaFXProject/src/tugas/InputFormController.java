package tugas;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class InputFormController {
    @FXML
    TextField txtId, txtProductName, txtPrice, txtStock;
    @FXML
    ComboBox<String> cboCategory;

    ObservableList<Item> items;

    @FXML

    public void handleBtnAdd() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String productName = txtProductName.getText();
            int price = Integer.parseInt(txtPrice.getText());
            String category = cboCategory.getValue().toString();
            int stock = Integer.parseInt(txtStock.getText());
            Item i = new Item(id, productName, price, category, stock);
            items.add(i);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void setListItem(ObservableList<Item> items) {
        this.items = items;
    }
}