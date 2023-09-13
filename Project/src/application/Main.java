package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
            data.add(new PieChart.Data("OpenCV", 80));
            data.add(new PieChart.Data("JavaFX", 40));
            data.add(new PieChart.Data("Python", 10));
            data.add(new PieChart.Data("Spring", 15));
            data.add(new PieChart.Data("Qt", 10));
            data.add(new PieChart.Data("SQL", 17));

            PieChart pie = new PieChart(data);
            pie.setTitle("PieChart Tutorial 2017");
            pie.setLegendVisible(false); // Oculta la leyenda
            pie.setLabelsVisible(true);

            StackPane root = new StackPane(pie);
            Scene scene = new Scene(root, 800, 600);

            primaryStage.setTitle("JavaFX PieChart");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
