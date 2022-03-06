package com.mycompany.stargame;

public class GameState {
    
    String player;
    int[] gameSpace = new int[13];
    
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
    
    
    
    public boolean canStep( int actual ){
        if ( actual < 9 ){
            int bigger;
            int smaller;
            
            if ( actual == 8 )
                bigger = 1;
            else
                bigger = actual + 1;
            
            if ( actual == 1 )
                smaller = 8;
            else
                smaller = actual -1;
            
            if ( this.gameSpace[actual] == this.gameSpace[bigger] && this.gameSpace[actual] == this.gameSpace[smaller] )
                return false;
            else
                return true;
        }
        return true;
    }
    
    public boolean isNeighbour(){
        if ( this.gameSpace[12] < 9 ){
            int bigger;
            int smaller;
            
            if ( this.gameSpace[12] == 8 )
                bigger = 1;
            else
                bigger = this.gameSpace[12] + 1;
            
            if ( this.gameSpace[12] == 1 )
                smaller = 8;
            else
                smaller = this.gameSpace[12] -1;
            
            if ( this.gameSpace[11] == bigger || this.gameSpace[11] == smaller || this.gameSpace[11] == 9 )
                return true;
            else
                return false;
        }
        //If this.gameSpace[12] == 9
        return true;
    }
    
    
    
    
}
