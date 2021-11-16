package ucf.assignments;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;

public class Item {
    //"description" string
    //"dueDate" string
    //"Status" string
    //"Date" localDate
    //"Bool" boolean
    String description;
    DatePicker dueDate;
    CheckBox status;
    LocalDate date;
    Boolean bool=false;
    //Constructor takes description/dueDate parameters
    public Item(String desc, DatePicker dueD, CheckBox stat) {
        //Make due date/description
        //D Status=I
        this.description = desc;
        this.dueDate = dueD;
        this.status = stat;
        dueDate.setOnAction(e -> {
        date=dueDate.getValue();
        });
        status.setOnAction(e -> {
        if(status.isSelected()) {
        bool=true;
        }
        else {
        bool=false;
          }
        });
    }
    //Setters+Getters
    //Takes/Sets Description 
    public String getDescription() {
    return description;
    }
    public void setDescription(String desc) {
    this.description = desc;
    }
    public DatePicker getDueDate() {
    return dueDate;
    }
    //Return/take dueDate
    public void setDueDate(DatePicker d) {
        // set due date
        this.dueDate=d;
    }
    public CheckBox getStatus() {
    //Return/set status
        return status;
    }
    public void setStatus(CheckBox stat) {
    this.status = stat;
    }
}
