# TAREA-5-RETS
Mostrar la tabla de resultados de conductores en un TablaView (Individual)


  **CAPTURA DE EJECUCIÓN**
![image](https://github.com/ToalaSanRi/TAREA-5-RETS/assets/169106800/769851e5-cc7e-4b54-974d-3ccbc7b83c34)


  **CÓDIGO**

package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static class Driver {
        private final String name;
        private final String team;
        private final int wins;
        private final int totalPoints;
        private final int rank;

        public Driver(String name, String team, int wins, int totalPoints, int rank) {
            this.name = name;
            this.team = team;
            this.wins = wins;
            this.totalPoints = totalPoints;
            this.rank = rank;
        }

        public String getName() {
            return name;
        }

        public String getTeam() {
            return team;
        }

        public int getWins() {
            return wins;
        }

        public int getTotalPoints() {
            return totalPoints;
        }

        public int getRank() {
            return rank;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage primaryStage) {
        ComboBox<Integer> yearComboBox = new ComboBox<>();
        yearComboBox.getItems().addAll(2016, 2017, 2018, 2019, 2020);

        TableView<Driver> tableView = new TableView<>();
        TableColumn<Driver, String> nameColumn = new TableColumn<>("Driver Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Driver, String> teamColumn = new TableColumn<>("Team");
        teamColumn.setCellValueFactory(new PropertyValueFactory<>("team"));

        TableColumn<Driver, Integer> winsColumn = new TableColumn<>("Wins");
        winsColumn.setCellValueFactory(new PropertyValueFactory<>("wins"));

        TableColumn<Driver, Integer> totalPointsColumn = new TableColumn<>("Total Points");
        totalPointsColumn.setCellValueFactory(new PropertyValueFactory<>("totalPoints"));

        TableColumn<Driver, Integer> rankColumn = new TableColumn<>("Rank");
        rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));

        tableView.getColumns().addAll(nameColumn, teamColumn, winsColumn, totalPointsColumn, rankColumn);

        // Datos para cada año
        ObservableList<Driver> drivers2016 = FXCollections.observableArrayList(
                new Driver("Lewis Hamilton", "Mercedes", 10, 250, 1),
                new Driver("Valtteri Bottas", "Mercedes", 5, 180, 2),
                new Driver("Max Verstappen", "Red Bull", 3, 150, 3),
                new Driver("Charles Leclerc", "Ferrari", 2, 120, 4),
                new Driver("Sebastian Vettel", "Ferrari", 1, 100, 5)
        );

        ObservableList<Driver> drivers2017 = FXCollections.observableArrayList(
                new Driver("Sebastian Vettel", "Ferrari", 9, 240, 1),
                new Driver("Lewis Hamilton", "Mercedes", 8, 230, 2),
                new Driver("Daniel Ricciardo", "Red Bull", 4, 170, 3),
                new Driver("Kimi Raikkonen", "Ferrari", 3, 130, 4),
                new Driver("Max Verstappen", "Red Bull", 2, 110, 5)
        );

        ObservableList<Driver> drivers2018 = FXCollections.observableArrayList(
                new Driver("Lewis Hamilton", "Mercedes", 11, 260, 1),
                new Driver("Sebastian Vettel", "Ferrari", 6, 200, 2),
                new Driver("Valtteri Bottas", "Mercedes", 4, 160, 3),
                new Driver("Max Verstappen", "Red Bull", 3, 140, 4),
                new Driver("Daniel Ricciardo", "Red Bull", 2, 120, 5)
        );

        ObservableList<Driver> drivers2019 = FXCollections.observableArrayList(
                new Driver("Lewis Hamilton", "Mercedes", 12, 270, 1),
                new Driver("Valtteri Bottas", "Mercedes", 7, 220, 2),
                new Driver("Charles Leclerc", "Ferrari", 5, 180, 3),
                new Driver("Max Verstappen", "Red Bull", 4, 150, 4),
                new Driver("Sebastian Vettel", "Ferrari", 3, 130, 5)
        );

        ObservableList<Driver> drivers2020 = FXCollections.observableArrayList(
                new Driver("Lewis Hamilton", "Mercedes", 13, 280, 1),
                new Driver("Valtteri Bottas", "Mercedes", 8, 230, 2),
                new Driver("Max Verstappen", "Red Bull", 6, 190, 3),
                new Driver("Sergio Perez", "Racing Point", 2, 140, 4),
                new Driver("Charles Leclerc", "Ferrari", 1, 120, 5)
        );

        yearComboBox.setOnAction(e -> {
            int selectedYear = yearComboBox.getValue();
            switch (selectedYear) {
                case 2016:
                    tableView.setItems(drivers2016);
                    break;
                case 2017:
                    tableView.setItems(drivers2017);
                    break;
                case 2018:
                    tableView.setItems(drivers2018);
                    break;
                case 2019:
                    tableView.setItems(drivers2019);
                    break;
                case 2020:
                    tableView.setItems(drivers2020);
                    break;
            }
        });

        // Agregamos un listener para manejar la selección en la tabla
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                System.out.println("Driver selected: " + newSelection.getName());
                System.out.println("Team: " + newSelection.getTeam());
                System.out.println("Wins: " + newSelection.getWins());
                System.out.println("Total Points: " + newSelection.getTotalPoints());
                System.out.println("Rank: " + newSelection.getRank());
            }
        });

        VBox vbox = new VBox(yearComboBox, tableView);
        vbox.getStyleClass().add("vbox"); // Aplicamos el estilo VBox definido en CSS
        Scene scene = new Scene(vbox, 800, 600); // Tamaño de la escena

        // Establecemos un estilo CSS para la escena
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Driver Results TableView");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


![image](https://github.com/ToalaSanRi/TAREA-5-RETS/assets/169106800/1e6b4af5-fd36-4514-8cd9-8227a3f6a69b)
![image](https://github.com/ToalaSanRi/TAREA-5-RETS/assets/169106800/0ecbd05c-01d5-470d-a1a2-21818b228d4f)
![image](https://github.com/ToalaSanRi/TAREA-5-RETS/assets/169106800/f52e8b63-c0bf-4993-b709-8a4b0791b604)
![image](https://github.com/ToalaSanRi/TAREA-5-RETS/assets/169106800/c54b4412-0ff8-43a7-8da3-ab173fdcc406)



