
import java.util.Random;
import java.util.Scanner;

public class Controller {
    Random random = new Random();
    Ship dublicateship = new Ship(3);
    int size = dublicateship.getShipSize();   //this size won't change
    boolean blocked;
    Scanner sc = new Scanner(System.in);
    int hit = 0;
    int trys = 0;

    int verticalOrHorizontalDecider(){
        // If the number is 0 then its vertical and if the number is 1 then its horizontal
        return random.nextInt(2);
    }
    
    void seaIntializer(int sea[][]){        //Initializer of the array
    for(int i = 0; i < sea.length; i++){
        for(int j = 0; j < sea.length; j++){
            sea[i][j] = 0;
        }
    }
    }

    boolean existenceCheckerVertical(int rowDecider, int columnDecider, int sea[][]){
        for(int i = 0; i < size; i++){
            if(sea[rowDecider + i][columnDecider] == 1){
                    return false;
                }
        }
        return true;
    }

    boolean existenceCheckerHorizontal(int rowDecider, int columnDecider, int sea[][]){
        for(int i = 0; i < size; i++){
            if(sea[rowDecider][columnDecider + i] == 1){
                    return false;
                }
        }
        return true;
    }

    void placer(int numberOfShips, Ship ship, int sea[][]){   //sets the ship into the sea
        for(int i = 0; i < numberOfShips;){
        int decider = verticalOrHorizontalDecider();
        blocked = false;
        if(decider == 1){
            int rowDecider = random.nextInt(size);
            int columnDecider = random.nextInt(sea.length - size);
            int shipsize = ship.getShipSize();

            blocked = existenceCheckerVertical(rowDecider, columnDecider, sea);
            if(!blocked){
                continue;
            }
            for(int j = 0; j < shipsize; j++){
                sea[rowDecider + j][columnDecider] = 1;  //Vertical
            }
            i++;
        } else {
            int rowDecider = random.nextInt(size);
            int columnDecider = random.nextInt(sea.length - size);
            blocked = existenceCheckerHorizontal(rowDecider, columnDecider, sea);
            if(!blocked){
                continue;
            }
            for(int j = 0; j < ship.getShipSize(); j++){    //Horizontal
                sea[rowDecider][columnDecider + j] = 1;
            }
            i++;
        }
    }

    }
    void printLocation(int sea[][]){
            for(int i = 0; i < sea.length; i++){
                for(int j = 0; j < sea.length; j++){
                System.out.print(" " + sea[i][j]);
                }
            System.out.println();
            }
        }

    void checker(int sea[][], int firstNumber, int secondNumber){
         if(sea[firstNumber][secondNumber] == 1){
                    System.out.println("It was a HIT!!!");
                    hit++;
                    trys++;
                    sea[firstNumber][secondNumber] = 0;
                } else {
                    System.out.println("IT was a MISS!!");
                    trys++;
                }
    }
        
    
    void playStarts(int sea[][]){
            while(true){
                int userInput = sc.nextInt();
                int firstNumber = (int)userInput / 10;
                int secondNumber = (int) userInput % 10;
                
                if(firstNumber <= 7 || secondNumber <= 7 || firstNumber > 0 || secondNumber > 0){
                   checker(sea, firstNumber, secondNumber);
                } else {    
                    System.out.println("The CO-ORDINATES are invalid, The range should be between 0-0 to 6-6");
                }

                if(hit == 9 ){
                System.out.println("CONGRADULATIONS ON WINNING THE GAME!!!");
                Stats();
                return;
                }
            }
        }
    void Stats(){
        System.out.println("You took total " + trys + " number of Trys");
    }
    }








