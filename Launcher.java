import java.util.Random;

public class Launcher {
    public static void main(String[] args) {
    
        Controller controller = new Controller();
        Ship ship1 = new Ship(3);
        
        int sea[][] = new int[7][7];
        int numberOfShips = 3;
        
        controller.seaIntializer(sea);
        controller.placer(numberOfShips, ship1, sea);
        controller.printLocation(sea);
        controller.playStarts(sea);
    
}
}



//First a 2d matrices ..........sea
//Place the ship into the matrices, both vertical and horizontal, and make it random
//take the user input and result it in the "Hit" or "miss".
//Allow no dublicates "Hit" this time.
//The game ends when all the ships are hitted
//Print the user stats