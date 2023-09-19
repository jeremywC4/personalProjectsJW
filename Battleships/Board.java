import java.util.ArrayList;

public class Board {
  //initialize battleships
  private Battleships botCarrier = new Battleships("ENEMY CARRIER", 5, true, 0, 0, 0, new ArrayList<String>());
  private Battleships botBattleship = new Battleships("ENEMY BATTLESHIP", 4, true, 0, 0, 0, new ArrayList<String>());
  private Battleships botCruiser = new Battleships("ENEMY CRUISER", 3, true, 0, 0, 0, new ArrayList<String>());
  private Battleships botSubmarine = new Battleships("ENEMY SUBMARINE", 3, true, 0, 0, 0, new ArrayList<String>());
  private Battleships botDestroyer = new Battleships("ENEMY DESTROYER", 2, true, 0, 0, 0, new ArrayList<String>());
  private ArrayList<Battleships> botShips = new ArrayList<Battleships>();
  private ArrayList<ArrayList<String>> botShipCoords = new ArrayList<ArrayList<String>>();
  
  //creates matrices for different game boards
  private String[][] emptyBoard = {
    {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
    {"A", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"B", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"C", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"D", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"E", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"F", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"G", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"H", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"I", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"J", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
  };
  
  private String[][] p1Board = {
    {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
    {"A", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"B", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"C", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"D", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"E", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"F", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"G", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"H", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"I", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"J", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
  };
  
  private String[][] p1POV = {
    {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
    {"A", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"B", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"C", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"D", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"E", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"F", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"G", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"H", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"I", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"J", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
  };

  private String[][] botBoard = {
    {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
    {"A", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"B", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"C", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"D", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"E", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"F", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"G", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"H", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"I", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
    {"J", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
  };

  //constructor, adds ships to appropriate lists
  public Board(){
    botShips.add(botCarrier);
    botShips.add(botBattleship);
    botShips.add(botCruiser);
    botShips.add(botSubmarine);
    botShips.add(botDestroyer);
    botShipCoords.add(botCarrier.getCoords());
    botShipCoords.add(botBattleship.getCoords());
    botShipCoords.add(botCruiser.getCoords());
    botShipCoords.add(botSubmarine.getCoords());
    botShipCoords.add(botDestroyer.getCoords());
  }

  //need to randomly generate 3 variables:
  //1.row
  //2.col
  //3.h/v (coinflip)
  private int size;
  private int row;
  private int col;
  private int flip;
  
  public void createBotShips(){
    //placement of bot carrier
    size = 5;
    row = (int)((Math.random() * (11-size))+1);
    col = (int)((Math.random() * (11-size))+1);
    flip = (int)(Math.random()*2);
    botCarrier.setRow(row);
    botCarrier.setCol(col);
    //draws bot carrier
    for(int i=0; i<size; i++){
      if(flip==0){//horiz
        drawBotShip(row,col+i);
        botCarrier.addCoords("" + row + (col+i));
      }else{//vert
        drawBotShip(row+i,col);
        botCarrier.addCoords("" + (row+i) + col);
      }
    }
    
    //placement of bot battleship
    size = 4;
    Battleship: while(true){
      row = (int)((Math.random() * (11-size))+1);
      col = (int)((Math.random() * (11-size))+1);
      flip = (int)(Math.random()*2);
      botBattleship.setRow(row);
      botBattleship.setCol(col);
      //to check for overlap (flip 0 = horiz)
      A:  while(true){
            if(flip==0){
              for(int i=0; i<size; i++){
                if(botBoard[row][col+i].equals("*")){
                  break A;
                }
              }
            }else{
              for(int i=0; i<size; i++){
                if(botBoard[row+i][col].equals("*")){
                  break A;
                }
              }
            }
            break Battleship;
      }
    }
    //draws bot battleship
    for(int i=0; i<size; i++){
      if(flip==0){//horiz
        drawBotShip(row,col+i);
        botBattleship.addCoords("" + row + (col+i));
      }else{//vert
        drawBotShip(row+i,col);
        botBattleship.addCoords("" + (row+i) + col);
      }
    }

    //placement of bot cruiser
    Cruiser: while(true){
      size = 3;
      row = (int)((Math.random() * (11-size))+1);
      col = (int)((Math.random() * (11-size))+1);
      flip = (int)(Math.random()*2);
      botCruiser.setRow(row);
      botCruiser.setCol(col);
      //to check for overlap (flip 0 = horiz)
      A:  while(true){
            if(flip==0){
              for(int i=0; i<size; i++){
                if(botBoard[row][col+i].equals("*")){
                  break A;
                }
              }
            }else{
              for(int i=0; i<size; i++){
                if(botBoard[row+i][col].equals("*")){
                  break A;
                }
              }
            }
            break Cruiser;
      }
    } 
    //draws bot cruiser
    for(int i=0; i<size; i++){
      if(flip==0){//horiz
        drawBotShip(row,col+i);
        botCruiser.addCoords("" + row + (col+i));
      }else{//vert
        drawBotShip(row+i,col);
        botCruiser.addCoords("" + (row+i) + col);
      }
    }

    //placement of bot submarine
    Submarine: while(true){
      size = 3;
      row = (int)((Math.random() * (11-size))+1);
      col = (int)((Math.random() * (11-size))+1);
      flip = (int)(Math.random()*2);
      botSubmarine.setRow(row);
      botSubmarine.setCol(col);
      //to check for overlap (flip 0 = horiz)
        A: while(true){
            if(flip==0){
              for(int i=0; i<size; i++){
                if(botBoard[row][col+i].equals("*")){
                  break A;
                }
              }
            }else{
              for(int i=0; i<size; i++){
                if(botBoard[row+i][col].equals("*")){
                  break A;
                }
              }
            }
            break Submarine;
      }
    }
      //draws bot submarine
      for(int i=0; i<size; i++){
        if(flip==0){//horiz
          drawBotShip(row,col+i);
          botSubmarine.addCoords("" + row + (col+i));
        }else{//vert
          drawBotShip(row+i,col);
          botSubmarine.addCoords("" + (row+i) + col);
        }
      }

    
    //placement of bot destroyer
    Destroyer: while(true){
    size = 2;
    row = (int)((Math.random() * (11-size))+1);
    col = (int)((Math.random() * (11-size))+1);
    flip = (int)(Math.random()*2);
    botDestroyer.setRow(row);
    botDestroyer.setCol(col);
    //to check for overlap (flip 0 = horiz)
      A: while(true){
          if(flip==0){
            for(int i=0; i<size; i++){
              if(botBoard[row][col+i].equals("*")){
                break A;
              }
            }
          }else{
            for(int i=0; i<size; i++){
              if(botBoard[row+i][col].equals("*")){
                break A;
              }
            }
          }
          break Destroyer;
      }
    }
    //draws bot destroyer
    for(int i=0; i<size; i++){
      if(flip==0){//horiz
        drawBotShip(row,col+i);
        botDestroyer.addCoords("" + row + (col+i));
      }else{//vert
        drawBotShip(row+i,col);
        botDestroyer.addCoords("" + (row+i) + col);
      }
    }
  }
  
  //draw ships on boards
  public void drawShip(int row, int col){
    p1Board[row][col] = "*";
  }
  public void drawBotShip(int row, int col){
    botBoard[row][col] = "*";
  }

  //checks whether ship is at location
  public boolean isShip(int row, int col){
    if(p1Board[row][col].equals("*")){
      return true;
    }else{
      return false;
    }
  }


  Commons shooting = new Commons();
  //user's turn, guess bot ship locations
  public void guessBotShips(){
    int rowShot; 
    int colShot; 
    String target;

    while(true){
      rowShot = shooting.rowPrompt();
      colShot = shooting.colPrompt();
      //checks valid shot
      if(0<rowShot && rowShot<11 && 0<colShot && colShot<11){
        break;
      }
    }
    target = "" + rowShot + colShot;

    //if shot hits
    if(botBoard[rowShot][colShot].equals("*")){
      p1POV[rowShot][colShot] = "\u001B[31mX\u001B[37m";
      botBoard[rowShot][colShot] = "\u001B[31mX\u001B[37m";
      
      Found: for(Battleships ship : botShips){
        for(String located : ship.getCoords()){
          
          if(target.equals(located)){
            System.out.println("\n\n\u001B[32mYou've hit their ship!\u001B[37m");
            ship.removeCoords(target);

            //when a ship is destroyed
            if(ship.getCoords().size()==0){
              System.out.println("\u001B[32mYou have destroyed the " + ship.getName() + "\n\u001B[37m");
              botShips.remove(ship);
            }
            break Found;
          }
        }
      }
      shooting.printPOV(p1POV);
    //if shot misses
    }else if(botBoard[rowShot][colShot].equals("-")){
      System.out.println("\nYou missed.");
      p1POV[rowShot][colShot] = "O";
      botBoard[rowShot][colShot] = "O";
      shooting.printPOV(p1POV);
    //if location already fired on
    }else{
      System.out.println("You cannot target this location.\n");
      guessBotShips();
    }
    
  }

  //return number of remaining bot ships
  public int getBotShips(){
    return botShips.size();
  }

  //returns/sets index at location row/col
  public String getP1Spot(int row, int col){
    return p1Board[row][col];
  }
  
  public void setP1Spot(int row, int col, String sprite){
    p1Board[row][col] = sprite;
  }

  //accessor and mutator for boards
  public String[][] getEmptyBoard(){
    return emptyBoard;
  }
  
  public String[][] getP1Board(){
    return p1Board;
  }
  
  public String[][] getP1POV(){
    return p1POV;
  }
  
  public String[][] getBotBoard(){
    return botBoard;
  }
  
}