package com.mycompany.stargame;

public class GameState {
    
    String player;
    int[] gameSpace = new int[10];
    
    
    
    
    
    

    public GameState() {
        gameSpace[0] = 1;
    }
    
    public String kiJon(){
        if (gameSpace[0]%2 == 1)
            return "Red";
        if (gameSpace[0]%2 == 0)
            return "Blue";
        return "";
    }
    
    
    
    /*    public boolean haveStep( String player ){
    if ( possibleMoves.length > 0 )
    return true;
    else
    return false;*/
        
    
    //}
    
    
    
}
