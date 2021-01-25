package application;
	
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public static double MTBF;
	public static double lambda;
	public static double fiabilite;
	public static double temps;
	private static int nbMachine;
	
	@FXML
    private ScrollPane scrollPane;

    @FXML
    private static ScatterChart<?, ?> chart;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Interface.fxml"));
			Scene scene = new Scene(root,700,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("3 ordinateurs à bord");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		fiabilite=0.999;
		nbMachine=1;
		temps=7;
		moyenneVolIncident();
	}
	
	private static void moyenneVolIncident() {
    	double moyenne;
    	lambda= Math.log(fiabilite)/(-temps);
    	if(nbMachine==1) {
    		MTBF=1/lambda;
    	}else if(nbMachine==2) {
    		MTBF=2/(3*lambda);
    	}else {
    		MTBF=11/(6*lambda);
    	}
    	
    	moyenne=MTBF/temps;
    	System.out.println("MTBF"+MTBF+"Lambda :"+lambda+" moyenne :"+moyenne);
    }
	private static double loiSurvie(int lambda,double temps) {
    	return Math.exp(-lambda*temps);
    }
	
	// fiabilité
    private static double fonctionRepartitionLoiExponentielle(double x, int lambda) {
        return 1 - Math.pow(Math.exp(-lambda*x), nbMachine);
    }
}
