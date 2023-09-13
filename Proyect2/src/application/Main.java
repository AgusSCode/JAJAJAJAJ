package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Tooltip;

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
            pie.setTitle(":D");
            pie.setLegendVisible(false); // Oculta la leyenda
            pie.setLabelsVisible(true);
            pie.setLabelLineLength(60);
            pie.setLabelsVisible(true);
            pie.getData().forEach(this::installTooltip);
            
            StackPane root = new StackPane(pie);
            Scene scene = new Scene(root, 800, 600);
            
            pie.getData().forEach(this::installTooltip);
            
            primaryStage.setTitle("Prueba (:");
            primaryStage.setScene(scene);
            primaryStage.show();
          
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    public void installTooltip(PieChart.Data d) {

        String msg = String.format("%s : %s", d.getName(), d.getPieValue());

        Tooltip tt = new Tooltip(msg);
        tt.setStyle("-fx-background-color: gray; -fx-text-fill: whitesmoke;");
        
        Tooltip.install(d.getNode(), tt);
        
    }
    
}