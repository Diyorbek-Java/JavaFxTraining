package org.example.perexam.controller;

import jakarta.persistence.PostRemove;
import jakarta.persistence.criteria.CriteriaBuilder;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.perexam.models.Product;




public class InventoryController {
    private ObservableList<Product> inventory;

    @FXML
    private TextField productName;



    @FXML
    private TextField stockField;

    @FXML
    private TextField productId;

    @FXML
    private  TextField searchField;

    @FXML
    private  TableView<Product> productTable;

    @FXML
    private TableColumn<Product,String> nameColumn;

    @FXML
    private TableColumn<Product, Integer> idColumn;

    @FXML
    private TableColumn<Product,Integer> stockColumn;

    @FXML
    public void initialize(){
        inventory = FXCollections.observableArrayList();
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productTable.setItems(inventory);
        populateTable();      
    }

    @FXML
    private void handleSearch(){
        if (searchField.getText().isBlank() || searchField.getText().isEmpty()){
            showAlert("Warning","Search field should not be blank", Alert.AlertType.WARNING);
            return;
        }
        String querySearch = searchField.getText().trim().toLowerCase();

        Product product1 = findProductByName(querySearch) ;

        if (product1==null){
            showAlert("Info","Product Not Found", Alert.AlertType.INFORMATION);
            return;
        }
        productTable.getSelectionModel().select(product1);
        productTable.scrollTo(product1);

    }
    @FXML
    private void handleAddOrUpdate(){
        if (productName.getText().isEmpty() || productName.getText().isBlank()
                || stockField.getText().isEmpty() || stockField.getText().isBlank())
            showAlert("Warning","All name and stock should be set", Alert.AlertType.NONE);
        else {
            String name = productName.getText();
            int stock = Integer.parseInt(stockField.getText());
            if (productId.getText().isEmpty()){
                inventory.add(new Product(name,stock));
                productTable.refresh();
                clearEverything();
            }else{
                int id = Integer.parseInt(productId.getText());
                Product product = inventory.stream().filter(product1 -> product1.getId()==id).findFirst().orElse(null);
                if (product==null)
                    showAlert("Warning","No product with given Id", Alert.AlertType.NONE);
                else {
                    product.setName(name);
                    product.setStock(stock);
                    clearEverything();
                    productTable.refresh();
                }
            }
            productTable.refresh();
        }
    }

    private void showAlert(String title, String content, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private Product findProductByName(String name){
        return inventory.stream().filter(product -> product.getName()
                .toLowerCase().contains(name)).findFirst().orElse(null);
    }

    private void clearEverything(){
        stockField.clear();
        productName.clear();
        productId.clear();
    }
    private void populateTable(){
        inventory.add(new Product("apple",200));
        inventory.add(new Product("Banana",250));
        inventory.add(new Product("Orange",150));
    }
}
