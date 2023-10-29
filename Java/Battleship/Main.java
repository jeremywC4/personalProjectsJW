import java.util.Scanner;

class Main {
  
  public static void main(String[] args) {
    Commons com = new Commons();
    Scanner sc = new Scanner(System.in);
    String mode;
    String start;
    
    //prompt new game
    setup: while(true){
      System.out.println("\n\n\u001B[34mWould you like to play BATTLESHIP against HAL-9K? (Y/N)\u001B[37m");
      start = sc.nextLine().toUpperCase();
    
      //game loop
      if(start.equals("Y")){
        //prompts user to select game mode
        while(true){
          System.out.println("\n\u001B[34mWhich mode would you like to play? [Classic][Salvo] (C/S)\u001B[37m");
          mode = sc.nextLine().toUpperCase();
          if(mode.equals("C")){
            break setup;
          }else if(mode.equals("S")){
            break setup;
          }else{
            System.out.println("\nENTER VALID GAMEMODE\n");
          }
        }
      //exit program
      }else if(start.equals("N")){
        System.out.println("\n>.<");
        System.out.println("Goodbye...");
        System.exit(0);
      }
    }
        
    //game setup
    Board game = new Board();
    com.printBoard(game.getEmptyBoard());
    Player one = new Player();
    game.createBotShips();
    //com.printBoard(game.getBotBoard()); //cheat sheet
    com.printPOV(game.getP1POV());

      //salvo mode
      if(mode.equals("S")){
        System.out.println("\n\nSelect a coordinate to fire on.");
        while(game.getBotShips()>0 && one.getUserShips()>0){
          for(int i = 0; i<one.getUserShips(); i++){
            game.guessBotShips();
            //win conditions
            if(game.getBotShips()==0){
              System.out.println("\n\u001B[34m<<PLAYER WINS>>\n<<GOOD GAME>>\n\u001B[35mHappy Birthday Jeremy :D\n\n");
              System.exit(0);
            }
          }
          for(int i = 0; i<game.getBotShips(); i++){
            one.guessUserShips();
            //win conditions
            if(one.getUserShips()==0){
              System.out.println("\n\u001B[34m<<HAL-9K WINS>>\n<<GOOD GAME>>\n");
              com.printBoard(game.getBotBoard());
              System.exit(0);
            }
          }
        com.printPOV(game.getP1POV());
        }
      //classic mode
      }else if(mode.equals("C")){
        System.out.println("Select a coordinate to fire on.");
        while(game.getBotShips()>0 && one.getUserShips()>0){
          game.guessBotShips();
          //win conditions
          if(game.getBotShips()==0){
            System.out.println("\n\u001B[34m<<PLAYER WINS>>\n<<GOOD GAME>>\n");
            System.exit(0);
          }
          one.guessUserShips();
          //win conditions
          if(one.getUserShips()==5){
            System.out.println("\n\u001B[34m<<HAL-9K WINS>>\n<<GOOD GAME>>\n");
            com.printBoard(game.getBotBoard());
            System.exit(0);
          }
        }
      }   
  }
}