package ucf.assignments;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
public class TodoListController {
    @FXML
    public void loadListButtonClicked(ActionEvent event) {
       //Ask for user directory
       //Make/Set text dialog, content "please input directory/list title"
       //New editable text string, gather user input
       //Get TodoList.setDirectory
       //Get TodoList.createDirectory
       //Get TodoList.loadList
       //Menu item "open list" implemented 
       //Set button=open list 4
       //Action event=openListButtonClicked
       //*List view=Open*
       //Set new loader, open/load ListViewOpen.fxml
       //New parent,scene
       //New ListViewOpenController 
       //Initialize/call controller, pass the list the user selected
    }
    @FXML
    public void newListButtonClicked(ActionEvent event) {
        //add list to TodoList.todoLists
        //New button in open menu list (txt=title)
        //Action event to openListButtonClicked
        //In list view window:
        //Declare new parent, scene stage
    }
    @FXML
    public void saveListsButtonClicked(ActionEvent event) {
            //Directory opens:
            //Text input dialog (set title)
            //Input dialog as "please input directory"
            //Field=string, show and wait
            //Editable text field
            //Get user input
            //Get TodoList.setDirectory
            //Get TodoList.createDirectory
            //Get TodoList.saveAllExternally
            }
    @FXML
    public void openListButtonClicked(ActionEvent event) {
        //Make/load ListViewOpen.fxml
        //Make new parent,scene, listviewopencontroller and its' loader
        //call the controller.initialize and pass the list the user selected
        //Make new stage/retrieve n stage info
        //Display Window
    }
}
