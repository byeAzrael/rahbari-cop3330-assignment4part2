package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class List {
    //String "title"+"directory"
    //List of items "itemList"
    public static String title, directory;
    public static ObservableList<Item> itemList = FXCollections.observableArrayList();
    public List() {
      //Use "this" to set title/create empty item list
        title="New List";
        itemList=FXCollections.observableArrayList();;
    }
    public String getTitle() {
    return title;
    }
    //Set/takes parameter title
    public void setTitle(String newTitle) {
    title=newTitle;
    }
    public void setDirectory(String dir) {
    //Directory=input
    directory = dir;
    }
    public static void deleteItem(Item it) {
    //Delete item
    itemList.remove(it);
    }
    public void createFile() throws IOException {
    //Create text file, set filewriter
    //Get set title
    //Loops through items
    File file=new File(directory+title+".txt");
    FileWriter writer=new FileWriter(file);
    writer.write(title+"\n");
    System.out.println(title);
    for(Item it:itemList) {
    System.out.println(it.description+it.dueDate.getValue()+it.getStatus().isSelected());
    writer.write(it.description+","+it.dueDate.getValue()+","+it.getStatus().isSelected()+"\n");
    }
    writer.close();
    }
    public void loadList(String dir) throws FileNotFoundException {
       //Delete list/open files
       //File scanner created
       //Title=first line
       //Phase through item lines
       //New item created, added to itemList
       //Description=string one 
       //Date as string, set duedate
       //Boolean last in list, set status
       //File file=new File(dir+".txt");
       //Scanner input=new Scanner(file);
       //title=input.nextLine();
        input.useDelimiter(",");
        while(input.hasNextLine()){
            Item it=new Item("",new DatePicker(),new CheckBox());
            itemList.add(it);
            it.description=input.next();
            String date=input.next();
            LocalDate local=LocalDate.parse(date);
            it.dueDate.setValue(local);
            Boolean bool=input.nextBoolean();
            it.status.setSelected(bool);
        }
    }
}
