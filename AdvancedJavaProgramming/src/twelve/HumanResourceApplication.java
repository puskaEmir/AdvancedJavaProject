package twelve;

import java.time.LocalDate;
import java.util.List;

import eight.Gender;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import seven.Person;
import seven.PersonDao;

/**
 * 
 * 
 * Preduvjet za poziv ove metode start -> postojanje objekta tipa Application
 * <p>
 * Startamo JavaFx aplikaciju i dalje kroz main funkciju tako što pozivamo launch(args)
 * <p>
 * 
 *     TableView personTable
 *     
 *     TableColumn idColumn, nameColumn, surnameColumn, birthdayColumn, genderColumn
 *     
 *     ObservableList ->   List<Person> listOfPersons -> DB -> PersonDao     DAO Data Access Object
 *     
 *     
 *     
 *     
 * @author emir
 *
 */
public class HumanResourceApplication extends Application{
	//UI controls
	private TableView<Person> personTable;
	//Sastavni dio moje forme za unos jedne osobe
	private TextField nameTextField;
	private TextField surnameTextField;
	private DatePicker birthdayDatePicker;
	private RadioButton maleRadioButton;
	private RadioButton femaleRadioButton;
	
	
	//RY  -> DRY Don't Repeat Yourself
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Human resource");
		personTable = new TableView<Person>();
		//KOLONE 
		TableColumn<Person, Integer> idColumn = new TableColumn<Person, Integer>("ID");
		idColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));
		//Name 
		TableColumn<Person, String> nameColumn = new TableColumn<Person, String>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
		nameColumn.setMinWidth(300);
		//Surname 
		TableColumn<Person, String> surnameColumn = new TableColumn<Person, String>("Surname");
		surnameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("surname"));
		surnameColumn.setMinWidth(300);
		//Birthday 
		TableColumn<Person, LocalDate> birthdayColumn = new TableColumn<Person, LocalDate>("Birthday");
		birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("birthday"));
		birthdayColumn.setMinWidth(200);
		//Gender 
		TableColumn<Person, Gender> genderColumn = new TableColumn<Person, Gender>("Gender");
		genderColumn.setCellValueFactory(new PropertyValueFactory<Person, Gender>("gender"));
		//PRAVITI vezu između TableView -> ObservableList -> TableColumn
		personTable.setItems(loadPersons());
		personTable.getColumns().addAll(idColumn,nameColumn, surnameColumn, birthdayColumn, genderColumn);
		//Kontejnersku komponentu
		VBox vBox = new VBox();
		//Druga kontejnerska komponenta -> glavnu kontejnersku komponentu
		HBox hBox = new HBox(); 
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.setSpacing(10);
		nameTextField = new TextField();
		nameTextField.setPromptText("Unesi ime..");
		surnameTextField = new TextField();
		surnameTextField.setPromptText("Unesi prezime...");
		birthdayDatePicker = new DatePicker(LocalDate.now());
		ToggleGroup genderGroup = new ToggleGroup();
		maleRadioButton = new RadioButton("Muško");
		maleRadioButton.setToggleGroup(genderGroup);
		femaleRadioButton = new RadioButton("Žensko");
		femaleRadioButton.setSelected(true);
		femaleRadioButton.setToggleGroup(genderGroup);
		Button addButton = new Button("Add person");
		addButton.setOnAction(e -> onAddButtonClick());//EventHandler
		Button deleteButton = new Button("Delete person");
		deleteButton.setOnAction(e->onDeleteButtonClick());// e -> void  
		hBox.getChildren().addAll(nameTextField, surnameTextField, birthdayDatePicker, maleRadioButton, femaleRadioButton, addButton, deleteButton);
		vBox.getChildren().addAll(personTable, hBox);  // vBox -> prima vertikalno .. table ..ispod hBox(horizo)
		//STAGE je glavni -> Scene
		Scene scene = new Scene(vBox);
		stage.setScene(scene);
		stage.show();
	}
	
	
	//OBSERVER 
	//Subject(Observable) -->   Observer o1, o2, o3 , o4 
	private ObservableList<Person> loadPersons(){
		PersonDao personDao = new PersonDao();
		List<Person> personList = personDao.retrieveAll();
		//observabilne kolekcije
		ObservableList<Person> observableList = FXCollections.observableArrayList(personList);
		return observableList;
	}
	
	private void onAddButtonClick() {
		Person person = new Person(); // id MySQL server
		person.setId(8);
		person.setName(nameTextField.getText());
		person.setSurname(surnameTextField.getText());
		person.setBirthday(birthdayDatePicker.getValue());
		person.setGender(maleRadioButton.isSelected()?Gender.MALE:Gender.FEMALE);
		//PersonDao personDao = new PersonDao();
		//personDao.insert(person);
		personTable.getItems().add(person);
		nameTextField.setText("");
		surnameTextField.setText("");
		birthdayDatePicker.setValue(LocalDate.now());
		maleRadioButton.setSelected(true);
	}
	
	
	private void onDeleteButtonClick() {
		ObservableList<Person> allPersons = personTable.getItems();
		ObservableList<Person> selectedPersons = personTable.getSelectionModel().getSelectedItems();
		PersonDao personDao = new PersonDao();
		for(Person selectedPerson: selectedPersons) {
			allPersons.remove(selectedPerson);
			personDao.delete(selectedPerson);
		}
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
