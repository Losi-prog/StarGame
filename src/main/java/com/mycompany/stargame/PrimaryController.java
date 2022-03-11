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
    
    GameState game = new GameState();
    Circle[] redTomb = new Circle[10];
    Circle[] blueTomb = new Circle[10];
    
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
        game = new GameState();
        _elsoAnim();
        _gombKidob(btnNew);
        _infoWindow("Új játék" , "Add meg a neved");
        fillUp();
        _game();
    }
    
    @FXML
    private void _loadGame() throws IOException {
        _gombKidob(btnLoad);
        _loadTable();
    }
    
    @FXML
    private void _saveGame() throws IOException {
        _gombKidob(btnSave);
        
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
        paneGame.setOpacity(0.3);
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
            game.player =  txtfieldInfo.getText();
            
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

    private void _game() {
        game.gameSpace[0] = 1;
        txBigBy.setText("Következik: " + game.kiJon());
            
        //lépések ellenőrzése
        //.....
        
    }
    
    
    
    //jaték körök elhelyezése valamint játék
    
//<editor-fold defaultstate="collapsed" desc="Grey controllers">
    //Grey controllers
    @FXML
    private void _btnGrey1(){
        if (game.gameSpace[0] < 9){
            if ( game.kiJon() == "Red" )
                game.gameSpace[1] = 1;
            else
                game.gameSpace[1] = 2;
            nextRound();
        }
        
        game.gameSpace[12] = 1;
        if ( game.isNeighbour() ){
            makeStep();
            nextRound();
        }
        
        
    }
    
    @FXML
    private void _btnGrey2(){
        if (game.gameSpace[0] < 9){
            if ( game.kiJon() == "Red" )
                game.gameSpace[2] = 1;
            else
                game.gameSpace[2] = 2;
            nextRound();
        }
        
        game.gameSpace[12] = 2;
        if ( game.isNeighbour() ){
            makeStep();
            nextRound();
        }
    }
    
    @FXML
    private void _btnGrey3(){
        if (game.gameSpace[0] < 9){
            if ( game.kiJon() == "Red" )
                game.gameSpace[3] = 1;
            else
                game.gameSpace[3] = 2;
            nextRound();
        }
        
        game.gameSpace[12] = 3;
        if ( game.isNeighbour() ){
            makeStep();
            nextRound();
        }
    }
    
    @FXML
    private void _btnGrey4(){
        if (game.gameSpace[0] < 9){
            if ( game.kiJon() == "Red" )
                game.gameSpace[4] = 1;
            else
                game.gameSpace[4] = 2;
            nextRound();
        }
        
        game.gameSpace[12] = 4;
        if ( game.isNeighbour() ){
            makeStep();
            nextRound();
        }
    }
    
    @FXML
    private void _btnGrey5(){
        if (game.gameSpace[0] < 9){
            if ( game.kiJon() == "Red" )
                game.gameSpace[5] = 1;
            else
                game.gameSpace[5] = 2;
            nextRound();
        }
        
        game.gameSpace[12] = 5;
        if ( game.isNeighbour() ){
            makeStep();
            nextRound();
        }
    }
    
    @FXML
    private void _btnGrey6(){
        if (game.gameSpace[0] < 9){
            if ( game.kiJon() == "Red" )
                game.gameSpace[6] = 1;
            else
                game.gameSpace[6] = 2;
            nextRound();
        }
        
        game.gameSpace[12] = 6;
        if ( game.isNeighbour() ){
            makeStep();
            nextRound();
        }
    }
    
    @FXML
    private void _btnGrey7(){
        if (game.gameSpace[0] < 9){
            if ( game.kiJon() == "Red" )
                game.gameSpace[7] = 1;
            else
                game.gameSpace[7] = 2;
            nextRound();
        }
        
        game.gameSpace[12] = 7;
        if ( game.isNeighbour() ){
            makeStep();
            nextRound();
        }
    }
    
    @FXML
    private void _btnGrey8(){
        if (game.gameSpace[0] < 9){
            if ( game.kiJon() == "Red" )
                game.gameSpace[8] = 1;
            else
                game.gameSpace[8] = 2;
            nextRound();
        }
        
        game.gameSpace[12] = 8;
        if ( game.isNeighbour() ){
            makeStep();
            nextRound();
        }
    }
    
    @FXML
    private void _btnGrey9(){
        if (game.gameSpace[0] < 9){
            //nem lehet ide tenni
        }
        
        game.gameSpace[12] = 9;
        if ( game.isNeighbour() ){
            makeStep();
            nextRound();
        }
    }
//</editor-fold>
    
    
//<editor-fold defaultstate="collapsed" desc="Red controllers">
    //Red controllers
    @FXML
    private void _btnRed1(){
        if (game.gameSpace[0] < 9){
            //semmi
        }else{
            if ( game.kiJon() == "Red" && game.canStep(1) ){
                game.gameSpace[10] = 1;
                game.gameSpace[11] = 1;
            }
        }
    }
    
    @FXML
    private void _btnRed2(){
        if (game.gameSpace[0] < 9){
            //semmi
        }else{
            if ( game.kiJon() == "Red" && game.canStep(2) ){
                game.gameSpace[10] = 1;
                game.gameSpace[11] = 2;
            }
        }
    }
    
    @FXML
    private void _btnRed3(){
        if (game.gameSpace[0] < 9){
            //semmi
        }else{
            if ( game.kiJon() == "Red" && game.canStep(3) ){
                game.gameSpace[10] = 1;
                game.gameSpace[11] = 3;
            }
        }
    }
    
    @FXML
    private void _btnRed4(){
        if (game.gameSpace[0] < 9){
            //semmi
        }else{
            if ( game.kiJon() == "Red" && game.canStep(4) ){
                game.gameSpace[10] = 1;
                game.gameSpace[11] = 4;
            }
        }
    }
    
    @FXML
    private void _btnRed5(){
        if (game.gameSpace[0] < 9){
            //semmi
        }else{
            if ( game.kiJon() == "Red" && game.canStep(5) ){
                game.gameSpace[10] = 1;
                game.gameSpace[11] = 5;
            }
        }
    }
    
    @FXML
    private void _btnRed6(){
        if (game.gameSpace[0] < 9){
            //semmi
        }else{
            if ( game.kiJon() == "Red" && game.canStep(6) ){
                game.gameSpace[10] = 1;
                game.gameSpace[11] = 6;
            }
        }
    }
    
    @FXML
    private void _btnRed7(){
        if (game.gameSpace[0] < 9){
            //semmi
        }else{
            if ( game.kiJon() == "Red" && game.canStep(7) ){
                game.gameSpace[10] = 1;
                game.gameSpace[11] = 7;
            }
        }
    }
    
    @FXML
    private void _btnRed8(){
        if (game.gameSpace[0] < 9){
            //semmi
        }else{
            if ( game.kiJon() == "Red" && game.canStep(8) ){
                game.gameSpace[10] = 1;
                game.gameSpace[11] = 8;
            }
        }
    }
    
    @FXML
    private void _btnRed9(){
        if (game.gameSpace[0] < 9){
            //semmi
        }else{
            if ( game.kiJon() == "Red" && game.canStep(9) ){
                game.gameSpace[10] = 1;
                game.gameSpace[11] = 9;
            }
        }
    }
//</editor-fold>
    
    
//<editor-fold defaultstate="collapsed" desc="Blue controllers">
    //Blue controllers
    @FXML
    private void _btnBlue1(){
        if (game.gameSpace[0] < 9){
            //semmi
        }else{
            if ( game.kiJon() == "Blue" && game.canStep(1) ){
                game.gameSpace[10] = 2;
                game.gameSpace[11] = 1;
            }
        }
    }
    
    @FXML
    private void _btnBlue2(){
        if (game.gameSpace[0] < 9){
            //semmi
        }else{
            if ( game.kiJon() == "Blue" && game.canStep(2) ){
                game.gameSpace[10] = 2;
                game.gameSpace[11] = 2;
            }
        }
    }
    
    @FXML
    private void _btnBlue3(){
        if (game.gameSpace[0] < 9){
            //semmi
        }else{
            if ( game.kiJon() == "Blue" && game.canStep(3) ){
                game.gameSpace[10] = 2;
                game.gameSpace[11] = 3;
            }
        }
    }
    
    @FXML
    private void _btnBlue4(){
        if (game.gameSpace[0] < 9){
            //semmi
        }else{
            if ( game.kiJon() == "Blue" && game.canStep(4) ){
                game.gameSpace[10] = 2;
                game.gameSpace[11] = 4;
            }
        }
    }
    
    @FXML
    private void _btnBlue5(){
        if (game.gameSpace[0] < 9){
            //semmi
        }else{
            if ( game.kiJon() == "Blue" && game.canStep(5) ){
                game.gameSpace[10] = 2;
                game.gameSpace[11] = 5;
            }
        }
    }
    
    @FXML
    private void _btnBlue6(){
        if (game.gameSpace[0] < 9){
            //semmi
        }else{
            if ( game.kiJon() == "Blue" && game.canStep(6) ){
                game.gameSpace[10] = 2;
                game.gameSpace[11] = 6;
            }
        }
    }
    
    @FXML
    private void _btnBlue7(){
        if (game.gameSpace[0] < 9){
            //semmi
        }else{
            if ( game.kiJon() == "Blue" && game.canStep(7) ){
                game.gameSpace[10] = 2;
                game.gameSpace[11] = 7;
            }
        }
    }
    
    @FXML
    private void _btnBlue8(){
        if (game.gameSpace[0] < 9){
            //semmi
        }else{
            if ( game.kiJon() == "Blue" && game.canStep(8) ){
                game.gameSpace[10] = 2;
                game.gameSpace[11] = 8;
            }
        }
    }
    
    @FXML
    private void _btnBlue9(){
        if (game.gameSpace[0] < 9){
            //semmi
        }else{
            if ( game.kiJon() == "Blue" && game.canStep(9) ){
                game.gameSpace[10] = 2;
                game.gameSpace[11] = 9;
            }
        }
    }
//</editor-fold>
    
    private void fillUp(){
        redTomb[1] = btnRed1;
        redTomb[2] = btnRed2;
        redTomb[3] = btnRed3;
        redTomb[4] = btnRed4;
        redTomb[5] = btnRed5;
        redTomb[6] = btnRed6;
        redTomb[7] = btnRed7;
        redTomb[8] = btnRed8;
        redTomb[9] = btnRed9;
        
        blueTomb[1] = btnBlue1;
        blueTomb[2] = btnBlue2;
        blueTomb[3] = btnBlue3;
        blueTomb[4] = btnBlue4;
        blueTomb[5] = btnBlue5;
        blueTomb[6] = btnBlue6;
        blueTomb[7] = btnBlue7;
        blueTomb[8] = btnBlue8;
        blueTomb[9] = btnBlue9;
    }
    
    
    private void drawing(){
        //0-szürke
        //1-Red
        //2-Blue
        
        for (int i = 1 ; i <= 9 ; i++){
            if ( game.gameSpace[i] == 0 ){
                redTomb[i].setVisible(false);
                blueTomb[i].setVisible(false);
            }
            if ( game.gameSpace[i] == 1 ){
                redTomb[i].setVisible(true);
                blueTomb[i].setVisible(false);
            }
            if ( game.gameSpace[i] == 2 ){
                redTomb[i].setVisible(false);
                blueTomb[i].setVisible(true);
            }
        }
    }

    private void makeStep() {
        game.gameSpace[game.gameSpace[11]] = 0;
        game.gameSpace[game.gameSpace[12]] = game.gameSpace[10];
    }

    private void nextRound() {
        game.gameSpace[10] = 0;
        game.gameSpace[0]++;
        drawing();
        txBigBy.setText("Következik: " + game.kiJon());
        if ( game.isWin() != 0 ){
            game.gameSpace[0]--;
            txBigSG.setText("!!" + game.kiJon() + "!!");
            txBigBy.setText("Lépések: " + (game.gameSpace[0]-8)   );
            winAnim();
        }
        
    }

    private void winAnim() {
        int looser;
        if ( game.isWin() == 1 )
            looser = 2;
        else
            looser = 1;
        for ( int i = 1 ; i < 9 ; i++ ){
            if ( game.gameSpace[i] == looser && looser == 1)
                redTomb[i].setOpacity(0.5);
            if ( game.gameSpace[i] == looser && looser == 2)
                blueTomb[i].setOpacity(0.3);
        }
        if ( looser == 2 )
            System.out.println("HI-SCORE mentése");
    }
}