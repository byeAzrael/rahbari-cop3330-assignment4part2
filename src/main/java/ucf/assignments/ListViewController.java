package ucf.assignments;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class ListViewController implements Initializable {
    @FXML
    private TextField listTitle;
    @FXML
    private TableView<Item> table;
    @FXML
    private TableColumn<Item, String> colItem;
    @FXML
    private TableColumn<Item, DatePicker> colDate;
    @FXML
    private TableColumn<Item, CheckBox> colStatus;
    public static List list = new List();
    //Methods start for modified table
    public void initialize(URL location, ResourceBundle resources) {
        //Get initTable
        initTable();
    }
    private void initTable() {
        //Get initCols
        initCols();
    }
    private void initCols() {
        //Description="description"
        //Due date="dueDate"
        //Status="status"
        //Get editTableCols
        colItem.setCellValueFactory(new PropertyValueFactory<Item, String>("description"));
        colDate.setCellValueFactory(new PropertyValueFactory<Item, DatePicker>("dueDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<Item, CheckBox>("status"));
        editableCols();
    }
    private void editableCols() {
         //For description 
         //Cell=text field
         //Value=user input
         //For due date
         //Cell=text field
         //Value=user input
         //For status
         //Cell=text field
         //Value=user input
         //Table info=editable
        colItem.setCellFactory(TextFieldTableCell.forTableColumn());
        colItem.setOnEditCommit(e-> {
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setDescription(e.getNewValue());
        });
        colDate.setOnEditCommit(e-> {
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setDueDate(e.getNewValue());
        });
        colStatus.setOnEditCommit(e-> {
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setStatus(e.getRowValue().getStatus());
        });
        table.setEditable(true);
    }
    private void loadData() {
        //Item added to itemList
        //Table items=itemList
        //list.itemList.add(new Item("description", new DatePicker(), new CheckBox()));
        //table.setItems(list.itemList);
    }
    @FXML
    private void itemAdded(ActionEvent event) {
        //Get loadData
        loadData();
    }
    @FXML
    void deleteItemButtonClicked(ActionEvent event) {
        //Delete row from tableview
        //Get List.deleteItem
        Item it=table.getSelectionModel().getSelectedItem();
        table.getItems().removeAll(it);
        list.deleteItem(it);
    }
    @FXML
    void listTitleEdited(ActionEvent event) {
        //change the list object's title field to the user's input
        //list.setTitle(listTitle.getText());
    }
   //@FXML
   //void markedComplete(ActionEvent event) {
   //Item.status=C
   //}
   //@FXML
   //void markedIncomplete(ActionEvent event) {
   //Item.status=I
   //}
    private void clearTable() {
    ObservableList<Item> clr = FXCollections.observableArrayList();
    table.setItems(clr);
    }
    private void loadComplete() {
        //Initialize temp list
        //Phase through selectedList's items
        //Status=selected=add to list
        //Status=unselected, skip
        //Temp list to table
        ObservableList<Item> comp = FXCollections.observableArrayList();
        for(Item it : list.itemList) {
            System.out.print(it.bool);
            if(it.bool) {
            comp.add(it);
            }
        }
        clearTable();
        table.setItems(comp);
    }
    private void loadIncomplete() {
        //create temp list
        //loop through selectedList's items
        //S tatus=unselected, add to list
        //Status=selected, skip
        //Link temp list to table
        clearTable();
        ObservableList<Item> inc = FXCollections.observableArrayList();
        for(Item it : list.itemList) {
        if(!it.getStatus().isSelected()) {
        inc.add(it);
          }
        }
        table.setItems(inc);
    }
    @FXML
    void showCompleteButtonClicked(ActionEvent event) {
        //Get loadComplete
        loadComplete();
    }
    @FXML
    void showIncompleteButtonClicked(ActionEvent event) {
        //Get loadIncomplete
        loadIncomplete();
    }
    @FXML
    void showAllSelected(ActionEvent event) {
        //Set table items to itemList
        table.setItems(list.itemList);
    }
    @FXML
    void saveListButtonClicked(ActionEvent event) throws IOException {
            //Text input dialog
            //Title text=input dialog
            //Content input dialog="please input directory"
            //Field=string
            //Editable text field
            //Get user input
            //call List.setDirectory
            //call List.createDirectory
            //call List.saveListExternally
        TextInputDialog textInput = new TextInputDialog();
        textInput.setTitle("Save list");
        textInput.getDialogPane().setContentText("Please input directory:");
        Optional<String> result = textInput.showAndWait();
        TextField input = textInput.getEditor();
        list.setDirectory(input.getText());
        list.createFile();
    }
    @FXML
    void helpButtonClicked() throws IOException {
        //Set stage, parent ,scene
        //Set scene as parent  
        Stage stage = new Stage();
        stage.setTitle("Help");
        Parent help = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HelpScene.fxml")));
        Scene scene = new Scene(help);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void deleteListButtonClicked() {
        //Delete itemList,list title, table
        //Clear title box text
        list.itemList.removeAll();
        list.title = "New list";
        clearTable();
        listTitle.setText("New list");
    }
    @FXML
    void loadButtonClicked() throws FileNotFoundException {
        TextInputDialog textInput = new TextInputDialog();
        textInput.setTitle("Load list");
        textInput.getDialogPane().setContentText("Please input directory, including file name:");
        Optional<String> result = textInput.showAndWait();
        TextField input = textInput.getEditor();
        list.loadList(input.getText());
        table.setItems(list.itemList);
        listTitle.setText(list.getTitle());
    }
}
