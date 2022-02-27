package com.mycompany.stargame;

import java.io.IOException;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class PrimaryController {
    
//<editor-fold defaultstate="collapsed" desc="FXML Declarations">
    //Buttons
    @FXML
            ToggleButton btnNew = new ToggleButton();
    @FXML
            ToggleButton btnLoad = new ToggleButton();
    @FXML
            ToggleButton btnSave = new ToggleButton();
    @FXML
            ToggleButton btnHi = new ToggleButton();
    @FXML
            ToggleButton btnExit = new ToggleButton();
    
    //Texts
    @FXML
            Label txBigSG = new Label();
    @FXML
            Label txBigBy = new Label();
    @FXML
            Label txSmallSG = new Label();
    @FXML
            Label txSmallBy = new Label();
    
    //Circles
    @FXML
            Circle btnRed1 = new Circle();
    @FXML
            Circle btnRed2 = new Circle();
    @FXML
            Circle btnRed3 = new Circle();
    @FXML
            Circle btnRed4 = new Circle();
    @FXML
            Circle btnRed5 = new Circle();
    @FXML
            Circle btnRed6 = new Circle();
    @FXML
            Circle btnRed7 = new Circle();
    @FXML
            Circle btnRed8 = new Circle();
    @FXML
            Circle btnRed9 = new Circle();
    @FXML
            Circle btnBlue1 = new Circle();
    @FXML
            Circle btnBlue2 = new Circle();
    @FXML
            Circle btnBlue3 = new Circle();
    @FXML
            Circle btnBlue4 = new Circle();
    @FXML
            Circle btnBlue5 = new Circle();
    @FXML
            Circle btnBlue6 = new Circle();
    @FXML
            Circle btnBlue7 = new Circle();
    @FXML
            Circle btnBlue8 = new Circle();
    @FXML
            Circle btnBlue9 = new Circle();
    
    //Panes
    @FXML
            AnchorPane paneMenu = new AnchorPane();
    @FXML
            AnchorPane paneGame = new AnchorPane();
    @FXML
            AnchorPane paneInfo = new AnchorPane();
    @FXML
            AnchorPane paneLoad = new AnchorPane();
    @FXML
            AnchorPane paneSave = new AnchorPane();
    @FXML
            AnchorPane paneHi = new AnchorPane();
    
    
    //Info
    @FXML
            Label labelInfo = new Label();
    @FXML
            TextField txtfieldInfo = new TextField();
    @FXML
            Button buttonInfo = new Button();
    
    //Load
    @FXML
            ListView tableLoad = new ListView();

//</editor-fold>
 

    
    @FXML
    private void _newGame() throws IOException {
        _elsoAnim();
        _gombKidob(btnNew);
        _infoWindow("Új játék" , "Add meg a neved");
        
        
        
    }
    @FXML
    private void _loadGame() throws IOException {
        _gombKidob(btnLoad);
        _loadTable();
    }
    @FXML
    private void _saveGame() throws IOException {
        _gombKidob(btnSave);
        _proba();
    }
    @FXML
    private void _hiScore() throws IOException {
        _gombKidob(btnHi);
    }
    @FXML
    private void _exit() throws IOException {
        System.exit(0);
    }
    
    private void _gombKidob(ToggleButton actual){
        if(!actual.equals(btnNew))
            btnNew.setSelected(false);
        if(!actual.equals(btnLoad))
            btnLoad.setSelected(false);
        if(!actual.equals(btnSave))
            btnSave.setSelected(false);
        if(!actual.equals(btnHi))
            btnHi.setSelected(false);
    }    

    private void _elsoAnim() {
        RotateTransition rt = new RotateTransition(Duration.millis(500), txBigSG);
        rt.setByAngle(360);
        rt.play();
        
        RotateTransition rt1 = new RotateTransition(Duration.millis(500), txSmallSG);
        rt1.setByAngle(360);
        rt1.play();
        
        btnRed1.setVisible(false);
        btnRed2.setVisible(false);
        btnRed3.setVisible(false);
        btnRed4.setVisible(false);
        btnRed5.setVisible(false);
        btnRed6.setVisible(false);
        btnRed7.setVisible(false);
        btnRed8.setVisible(false);
        btnRed9.setVisible(false);

        btnBlue1.setVisible(false);
        btnBlue2.setVisible(false);
        btnBlue3.setVisible(false);
        btnBlue4.setVisible(false);
        btnBlue5.setVisible(false);
        btnBlue6.setVisible(false);
        btnBlue7.setVisible(false);
        btnBlue8.setVisible(false);
        btnBlue9.setVisible(false);
        
    }

    private void _infoWindow(String title, String text) {
        paneGame.setOpacity(0.1);
        paneGame.setDisable(true);
        paneLoad.setVisible(false);
        paneSave.setVisible(false);
        paneHi.setVisible(false);
        
        labelInfo.setText(title);
        txtfieldInfo.setPromptText(text);
        paneInfo.setVisible(true);
    }
    
    @FXML
    private void buttonInfoPushed(){
        //Űj játék labelInfo:"Új játék"
        if ( txtfieldInfo.getText() != null && txtfieldInfo.getText().replaceAll("\\s", "") !="" ){
            GameState game = new GameState(txtfieldInfo.getText());
            
            
            
            
            paneInfo.setVisible(false);
            paneGame.setOpacity(1);
            paneGame.setDisable(false);
            txBigSG.setText(game.player);
            txBigSG.setVisible(true);
        }else{
            txBigSG.setText("Please...");
            txBigSG.setVisible(true);
        }
        
        
        
    }

    private void _loadTable() {
        paneInfo.setVisible(false);
        paneSave.setVisible(false);
        paneHi.setVisible(false);
                
        paneGame.setOpacity(0.1);
        tableLoad.setOpacity(0.5);
        paneLoad.setVisible(true);
    }

    private void _proba() {
        
                

        
        
        
        
        
        
        
    }
    
    
    
}
