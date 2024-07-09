module RETS_INDV {
	requires javafx.controls;
	 exports application;
	
	opens application to javafx.base, javafx.fxml;
}
