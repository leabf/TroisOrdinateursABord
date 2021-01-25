package application;

import javafx.fxml.FXML;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
	@FXML
    private TextField mtbf;

    @FXML
    private TextField dureeVol;

    @FXML
    private TextArea resultat;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private ScatterChart<?, ?> chart;
    
    
}
