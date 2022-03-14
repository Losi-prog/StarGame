package com.mycompany.stargame;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;



public class PrimaryModel {

    
    
    Connection conn = null;
    
        public void saveGame(GameState game) throws IOException {                                            
        //String saveID =  jTextFieldName.getText().trim();
        //if (saveID == null || saveID.length() == 0) {System.out.println("Nulla név");} else
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/stargamedb", "root", "");
            
            PreparedStatement st = conn.prepareStatement("SELECT `ID` FROM `stargametable` WHERE `Name`=?");
            st.setString(1 , game.player);
            st.execute();
            if(st.getResultSet().next())
            {
                PreparedStatement preparedStmt = conn.prepareStatement("UPDATE `stargametable` set "
                        + "`1` = ? , `2` = ? , `3` = ? , `4` = ? , `5` = ? , `6` = ? , `7` = ? , `8` = ? , `9` = ? ,"
                        + " `10` = ? , `11` = ? , `12` = ? `13` = ? , `14` = ? , `15` = ? , `Date` = ? , `Time` = ? WHERE `Name` = ?");
                
                preparedStmt.setInt(1, game.gameSpace[1]);
                preparedStmt.setInt(2, game.gameSpace[2]);
                preparedStmt.setInt(3, game.gameSpace[3]);
                preparedStmt.setInt(4, game.gameSpace[4]);
                preparedStmt.setInt(5, game.gameSpace[5]);
                preparedStmt.setInt(6, game.gameSpace[6]);
                preparedStmt.setInt(7, game.gameSpace[7]);
                preparedStmt.setInt(8, game.gameSpace[8]);
                preparedStmt.setInt(9, game.gameSpace[9]);
                preparedStmt.setInt(10, game.gameSpace[10]);
                preparedStmt.setInt(11, game.gameSpace[11]);
                preparedStmt.setInt(12, game.gameSpace[12]);
                preparedStmt.setInt(13, 0);
                preparedStmt.setInt(14, 0);
                preparedStmt.setInt(15, game.gameSpace[0]);
                preparedStmt.setString(16, game.getDate());
                preparedStmt.setString(17, game.getTime());
                preparedStmt.setString(18, game.player);

                preparedStmt.executeUpdate();
                System.out.println("Felülírva létező mentés");
            }
            
            else
            {   
                //String cucc = "uj mentes";
                PreparedStatement preparedStmt = conn.prepareStatement("INSERT INTO `stargametable` "
                        + "(`Name`,`1`,`2`,`3`,`4`,`5`,`6`,`7`,`8`,`9`,`10`,`11`,`12`,`13`,`14`,`15`,`Date`,`Time`) "
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                
                preparedStmt.setString(1, game.player);
                preparedStmt.setInt(2, game.gameSpace[1]);
                preparedStmt.setInt(3, game.gameSpace[2]);
                preparedStmt.setInt(4, game.gameSpace[3]);
                preparedStmt.setInt(5, game.gameSpace[4]);
                preparedStmt.setInt(6, game.gameSpace[5]);
                preparedStmt.setInt(7, game.gameSpace[6]);
                preparedStmt.setInt(8, game.gameSpace[7]);
                preparedStmt.setInt(9, game.gameSpace[8]);
                preparedStmt.setInt(10, game.gameSpace[9]);
                preparedStmt.setInt(11, game.gameSpace[10]);
                preparedStmt.setInt(12, game.gameSpace[11]);
                preparedStmt.setInt(13, game.gameSpace[12]);
                preparedStmt.setInt(14, 0);
                preparedStmt.setInt(15, 0);
                preparedStmt.setInt(16, game.gameSpace[0]);
                preparedStmt.setString(17, game.getDate());
                preparedStmt.setString(18, game.getTime());
                
                
                preparedStmt.executeUpdate();
                System.out.println("Új mentés rögzítve");
            }
        } 
        catch (SQLException SQLEx)
        {
             System.out.println(SQLEx.getSQLState());
        } catch (ClassNotFoundException ex) {
            System.err.println("Adatbázisba mentési probléma");
        }
        finally {
                    if (conn != null) try {
                        conn.close();
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }

      }
        
    } 
    
    public void addDataToLoadTable(TableView tableLoad) throws ClassNotFoundException{
        final ObservableList<GameState> data =
        FXCollections.observableArrayList(
                new GameState("Jacob", new int[13]),
            new GameState("Isabella", new int[13]),
            new GameState("Ethan", new int[13]),
            new GameState("Emma", new int[13]),
            new GameState("Michael", new int[13])
        );
        
        
        TableColumn firstNameCol = new TableColumn("Name");
        firstNameCol.setMinWidth(200);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<GameState, String>("ssplayer"));
        
        TableColumn secondDateCol = new TableColumn("Date");
        secondDateCol.setMinWidth(100);
        secondDateCol.setCellValueFactory(
                new PropertyValueFactory<GameState, String>("date"));
        
        TableColumn thirdTimeCol = new TableColumn("Time");
        thirdTimeCol.setMinWidth(100);
        thirdTimeCol.setCellValueFactory(
                new PropertyValueFactory<GameState, String>("time"));
        
        
        Statement st = null;
        ResultSet rs = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/save", "root", "");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM stargametable WHERE 1");
//            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) TablePane.getModel();
            while(rs.next())
            {
                
                
                
                
                
                
                
                //data.add(new GameState(rs.getString("Name")));
            }
//            TablePane.setPreferredSize(null);
//            TablePane.setModel(model);
        } 
        catch (SQLException hiba)
        {
            System.out.println("Nem sikerült csatlakozni az adatbázishoz\n" +hiba);
        }
        finally {     if (conn!=null)   try {
              conn.close();
             } catch (SQLException ex) {
              System.out.println("Nem sikerült lezárni az adb-t");
            } 
        }
        
        
        
        
        
        
        
        tableLoad.setItems(data);
        tableLoad.getColumns().addAll(firstNameCol , secondDateCol, thirdTimeCol);
        
        
    }
}
