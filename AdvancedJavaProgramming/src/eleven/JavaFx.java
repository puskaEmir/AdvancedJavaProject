package eleven;

import java.time.LocalDate;
import java.util.List;

import eight.Gender;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class JavaFx extends Application{
	
	Stage stage;
	TableView<Person> personTable;
	TextField nameTextField;
	TextField surnameTextField;
	DatePicker birthdayDatePicker;
	RadioButton maleGenderRadioButton;
	RadioButton femaleGenderRadioButton;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = new Stage();
		stage.setTitle("Human resource");
		//COLUMNS
		TableColumn<Person, Integer> idColumn = new TableColumn<Person, Integer>("ID");
		idColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));
		TableColumn<Person, String> nameColumn = new TableColumn<Person, String>("Name");
		nameColumn.setMinWidth(300);
		nameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
		TableColumn<Person, String> surnameColumn = new TableColumn<Person, String>("Surname");
		surnameColumn.setMinWidth(300);
		surnameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("surname"));
		TableColumn<Person, LocalDate> birthdayColumn = new TableColumn<Person, LocalDate>("Birthday");
		birthdayColumn.setMinWidth(200);
		birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("birthday"));
		TableColumn<Person, Gender> genderColumn = new TableColumn<Person, Gender>("Gender");
		genderColumn.setMinWidth(200);
		genderColumn.setCellValueFactory(new PropertyValueFactory<Person, Gender>("gender"));
		//TABLE CREATION
		personTable = new TableView<Person>();
		personTable.setItems(loadPersons());
		personTable.getColumns().addAll(idColumn, nameColumn, surnameColumn, birthdayColumn, genderColumn);

		//HBox
		nameTextField = new TextField();
		nameTextField.setPromptText("Ime");
		nameTextField.setMinWidth(50);
		surnameTextField = new TextField();
		birthdayDatePicker = new DatePicker(LocalDate.now());
		ToggleGroup groupRadio = new ToggleGroup();
		maleGenderRadioButton = new RadioButton("MALE");
		femaleGenderRadioButton = new RadioButton("FEMALE");
		femaleGenderRadioButton.setSelected(true);
		maleGenderRadioButton.setToggleGroup(groupRadio);
		femaleGenderRadioButton.setToggleGroup(groupRadio);
		Button addButton = new Button("Add");
		addButton.setOnAction(e->onAddButtonClick());
		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(e->onDeleteButtonClick());
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10));
		hBox.setSpacing(10);
		hBox.getChildren().addAll(nameTextField, surnameTextField, birthdayDatePicker, maleGenderRadioButton, femaleGenderRadioButton,addButton, deleteButton);
		//VBox layout
		VBox vBox = new VBox();
		vBox.getChildren().addAll(personTable, hBox);
		Scene scene = new Scene(vBox);
		stage.setScene(scene);
		stage.show();
	}
	
	private void onAddButtonClick() {
		Person person = new Person();
		person.setName(nameTextField.getText());
		person.setSurname(surnameTextField.getText());
		person.setBirthday(birthdayDatePicker.getValue());
		person.setGender(maleGenderRadioButton.isSelected()?Gender.MALE:Gender.FEMALE);
		PersonDao personDao = new PersonDao();
		personDao.insert(person);
		personTable.getItems().add(person);
	}
	
	private void onDeleteButtonClick() {
		ObservableList<Person> allPersons = personTable.getItems();
		ObservableList<Person> selectedPersons = personTable.getSelectionModel().getSelectedItems();
		selectedPersons.forEach(allPersons::remove);
		PersonDao personDao = new PersonDao();
		for(Person person: selectedPersons) {
			personDao.delete(person);
		}
	}
	
	public ObservableList<Person> loadPersons(){
		PersonDao personDao = new PersonDao();
		List<Person> personList = personDao.retrieveAll();
		return FXCollections.observableArrayList(personList);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
