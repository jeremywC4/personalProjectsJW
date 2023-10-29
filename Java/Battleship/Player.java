import java.util.ArrayList;
import java.util.Scanner;

public class Player {

 //initialize variables, battleships
  Scanner sc = new Scanner(System.in);
  Commons fire = new Commons();
  Board ape = new Board();
  
  private Battleships carrier = new Battleships("CARRIER", 5, true, 0, 0, 0, new ArrayList<String>());
  private Battleships battleship = new Battleships("BATTLESHIP", 4, true, 0, 0, 0, new ArrayList<String>());
  private Battleships cruiser = new Battleships("CRUISER", 3, true, 0, 0, 0, new ArrayList<String>());
  private Battleships submarine = new Battleships("SUBMARINE", 3, true, 0, 0, 0, new ArrayList<String>());
  private Battleships destroyer = new Battleships("DESTROYER", 2, true, 0, 0, 0, new ArrayList<String>());
  private ArrayList<Battleships> userShips = new ArrayList<Battleships>();
  private ArrayList<ArrayList<String>> userShipCoords = new ArrayList<ArrayList<String>>();

  //constructor, adds ships to appropriate lists
  public Player(){
    userShips.add(carrier);
    userShips.add(battleship);
    userShips.add(cruiser);
    userShips.add(submarine);
    userShips.add(destroyer);
    createUserShips();
  }

  //prompt for user to set ship locations
  public void createUserShips(){
    String scan = "";
    //place the user's carrier
    Carrier: while(true){
      System.out.println("\nWhich row would you like to place your carrier?");
      carrier.setRow(fire.rowPrompt());
      System.out.println("\nWhich column would you like to place your carrier?");
      carrier.setCol(fire.colPrompt());
      System.out.println("\nWould you like to place it horizontal or vertical? (H/V)");
      scan = (sc.nextLine()).toLowerCase();
      
      if(scan.equals("h")){
        carrier.setHorizontal(true);
        //check if overlaps or goes out of bounds
        A: while(true){
          for(int i=0; i<carrier.getSize(); i++){
            if(carrier.getCol()+i>10||ape.getP1Board()[carrier.getRow()][carrier.getCol()+i].equals("*")){
              System.out.println("\nYOU CANNOT PLACE THIS SHIP HERE!!\n");
              break A;
            }
          }
          for(int i = 0; i<carrier.getSize(); i++){
            ape.drawShip(carrier.getRow(), carrier.getCol()+i);
          }
          break Carrier;
        }
      //checks valid input for orientation
      }else if(!scan.equals("h") && !scan.equals("v")){
        System.out.println("\nSELECT VALID ORIENTATION!!");
      }
        
      if(scan.equals("v")){
        carrier.setHorizontal(false);
        //check if overlaps or goes out of bounds
        A: while(true){
          for(int i=0; i<carrier.getSize(); i++){
            if(carrier.getRow()+i>10||ape.getP1Board()[carrier.getRow()+i][carrier.getCol()].equals("*")){
              System.out.println("\nYOU CANNOT PLACE THIS SHIP HERE!!\n");
              break A;
            }
          }
          for(int i = 0; i<carrier.getSize(); i++){
            ape.drawShip(carrier.getRow()+i, carrier.getCol());
          }
          break Carrier;
        }
      //checks valid input for orientation
      }else if(!scan.equals("h") && !scan.equals("v")){
        System.out.println("(Horizontal(H)/Vertical(V))\n");
      }
    }
    fire.printBoard(ape.getP1Board());

    //place the user's battleship
    Battleship: while(true){
      System.out.println("\nWhich row would you like to place your battleship?");
      battleship.setRow(fire.rowPrompt());
      System.out.println("\nWhich column would you like to place your battleship?");
      battleship.setCol(fire.colPrompt());
      System.out.println("\nWould you like to place it horizontal or vertical? (H/V)");
      scan = (sc.nextLine()).toLowerCase();
      
      if(scan.equals("h")){
        battleship.setHorizontal(true);
        //check if overlaps or goes out of bounds
        A: while(true){
          for(int i=0; i<battleship.getSize(); i++){
            if(battleship.getCol()+i>10||ape.getP1Board()[battleship.getRow()][battleship.getCol()+i].equals("*")){
              System.out.println("\nYOU CANNOT PLACE THIS SHIP HERE!!\n");
              break A;
            }
          }
          for(int i = 0; i<battleship.getSize(); i++){
            ape.drawShip(battleship.getRow(), battleship.getCol()+i);
          }
          break Battleship;
        }
      //checks valid input for orientation
      }else if(!scan.equals("h") && !scan.equals("v")){
        System.out.println("\nSELECT VALID ORIENTATION!!");
      }
        
      if(scan.equals("v")){
        battleship.setHorizontal(false);
        //check if overlaps or goes out of bounds
        A: while(true){
          for(int i=0; i<battleship.getSize(); i++){
            if(battleship.getRow()+i>10||ape.getP1Board()[battleship.getRow()+i][battleship.getCol()].equals("*")){
              System.out.println("\nYOU CANNOT PLACE THIS SHIP HERE!!\n");
              break A;
            }
          }
          for(int i = 0; i<battleship.getSize(); i++){
            ape.drawShip(battleship.getRow()+i, battleship.getCol());
          }
          
          break Battleship;
        }
      //checks valid input for orientation
      }else if(!scan.equals("h") && !scan.equals("v")){
        System.out.println("(Horizontal(H)/Vertical(V))\n");
      }
    }
    fire.printBoard(ape.getP1Board());

    //place user's cruiser
    Cruiser: while(true){
      System.out.println("\nWhich row would you like to place your cruiser?");
      cruiser.setRow(fire.rowPrompt());
      System.out.println("\nWhich column would you like to place your cruiser?");
      cruiser.setCol(fire.colPrompt());
      System.out.println("\nWould you like to place it horizontal or vertical? (H/V)");
      scan = (sc.nextLine()).toLowerCase();
      
      if(scan.equals("h")){
        cruiser.setHorizontal(true);
        //check if overlaps or goes out of bounds
        A: while(true){
          for(int i=0; i<cruiser.getSize(); i++){
            if(cruiser.getCol()+i>10||ape.getP1Board()[cruiser.getRow()][cruiser.getCol()+i].equals("*")){
              System.out.println("\nYOU CANNOT PLACE THIS SHIP HERE!!\n");
              break A;
            }
          }
          for(int i = 0; i<cruiser.getSize(); i++){
            ape.drawShip(cruiser.getRow(), cruiser.getCol()+i);
          }
          break Cruiser;
        }
      //checks valid input for orientation
      }else if(!scan.equals("h") && !scan.equals("v")){
        System.out.println("\nSELECT VALID ORIENTATION!!");
      }
        
      if(scan.equals("v")){
        cruiser.setHorizontal(false);
        //check if overlaps or goes out of bounds
        A: while(true){
          for(int i=0; i<cruiser.getSize(); i++){
            if(cruiser.getRow()+i>10||ape.getP1Board()[cruiser.getRow()+i][cruiser.getCol()].equals("*")){
              System.out.println("\nYOU CANNOT PLACE THIS SHIP HERE!!\n");
              break A;
            }
          }
          for(int i = 0; i<cruiser.getSize(); i++){
            ape.drawShip(cruiser.getRow()+i, cruiser.getCol());
          }
          break Cruiser;
        }
      //checks valid input for orientation
      }else if(!scan.equals("h") && !scan.equals("v")){
        System.out.println("(Horizontal(H)/Vertical(V))\n");
      }
    }
    fire.printBoard(ape.getP1Board());

    //place user's submarine
    Submarine: while(true){
      System.out.println("\nWhich row would you like to place your submarine?");
      submarine.setRow(fire.rowPrompt());
      System.out.println("\nWhich column would you like to place your submarine?");
      submarine.setCol(fire.colPrompt());
      System.out.println("\nWould you like to place it horizontal or vertical? (H/V)");
      scan = (sc.nextLine()).toLowerCase();
      
      if(scan.equals("h")){
        submarine.setHorizontal(true);
        //check if overlaps or goes out of bounds
        A: while(true){
          for(int i=0; i<submarine.getSize(); i++){
            if(submarine.getCol()+i>10||ape.getP1Board()[submarine.getRow()][submarine.getCol()+i].equals("*")){
              System.out.println("\nYOU CANNOT PLACE THIS SHIP HERE!!\n");
              break A;
            }
          }
          for(int i = 0; i<submarine.getSize(); i++){
            ape.drawShip(submarine.getRow(), submarine.getCol()+i);
          }
          break Submarine;
        }
      //checks valid input for orientation
      }else if(!scan.equals("h") && !scan.equals("v")){
        System.out.println("\nSELECT VALID ORIENTATION!!");
      }
        
      if(scan.equals("v")){
        cruiser.setHorizontal(false);
        //check if overlaps or goes out of bounds
        A: while(true){
          for(int i=0; i<cruiser.getSize(); i++){
            if(submarine.getRow()+i>10||ape.getP1Board()[submarine.getRow()+i][submarine.getCol()].equals("*")){
              System.out.println("\nYOU CANNOT PLACE THIS SHIP HERE!!\n");
              break A;
            }
          }
          for(int i = 0; i<submarine.getSize(); i++){
            ape.drawShip(submarine.getRow()+i, submarine.getCol());
          }
          break Submarine;
        }
      //checks valid input for orientation
      }else if(!scan.equals("h") && !scan.equals("v")){
        System.out.println("(Horizontal(H)/Vertical(V))\n");
      }
    }
    fire.printBoard(ape.getP1Board());

    //place user's destroyer
    Destroyer: while(true){
      System.out.println("\nWhich row would you like to place your destroyer?");
      destroyer.setRow(fire.rowPrompt());
      System.out.println("\nWhich column would you like to place your destroyer?");
      destroyer.setCol(fire.colPrompt());
      System.out.println("\nWould you like to place it horizontal or vertical? (H/V)");
      scan = (sc.nextLine()).toLowerCase();
      
      if(scan.equals("h")){
        destroyer.setHorizontal(true);
        //check if overlaps or goes out of bounds
        A: while(true){
          for(int i=0; i<destroyer.getSize(); i++){
            if(destroyer.getCol()+i>10||ape.getP1Board()[destroyer.getRow()][destroyer.getCol()+i].equals("*")){
              System.out.println("\nYOU CANNOT PLACE THIS SHIP HERE!!\n");
              break A;
            }
          }
          for(int i = 0; i<destroyer.getSize(); i++){
            ape.drawShip(destroyer.getRow(), destroyer.getCol()+i);
          }
          break Destroyer;
        }
      //checks valid input for orientation
      }else if(!scan.equals("h") && !scan.equals("v")){
        System.out.println("\nSELECT VALID ORIENTATION!!");
      }
        
      if(scan.equals("v")){
        destroyer.setHorizontal(false);
        //check if overlaps or goes out of bounds
        A: while(true){
          for(int i=0; i<cruiser.getSize(); i++){
            if(destroyer.getRow()+i>10||ape.getP1Board()[destroyer.getRow()+i][destroyer.getCol()].equals("*")){
              System.out.println("\nYOU CANNOT PLACE THIS SHIP HERE!!\n");
              break A;
            }
          }
          for(int i = 0; i<destroyer.getSize(); i++){
            ape.drawShip(destroyer.getRow()+i, destroyer.getCol());
          }
          break Destroyer;
        }
      //checks valid input for orientation
      }else if(!scan.equals("h") && !scan.equals("v")){
        System.out.println("(Horizontal(H)/Vertical(V))\n");
      }
    }
    fire.printBoard(ape.getP1Board());
    setUserCoords();
  }

  //adds user ship coordinates to each ship's list
  public void setUserCoords(){
    //carrier
    if(carrier.isHorizontal()){
      for(int i = 0; i<carrier.getSize(); i++){
        carrier.addCoords("" + carrier.getRow() + (carrier.getCol()+i));
      }
    }
    if(!carrier.isHorizontal()){
      for(int i = 0; i<carrier.getSize(); i++){
        carrier.addCoords("" + (carrier.getRow()+i) + carrier.getCol());
      }
    }
    //battleship
    if(battleship.isHorizontal()){
      for(int i = 0; i<battleship.getSize(); i++){
        battleship.addCoords("" + battleship.getRow() + (battleship.getCol()+i));
      }
    }
    if(!battleship.isHorizontal()){
      for(int i = 0; i<battleship.getSize(); i++){
        battleship.addCoords("" + (battleship.getRow()+i) + battleship.getCol());
      }
    }
    //cruiser
    if(cruiser.isHorizontal()){
      for(int i = 0; i<cruiser.getSize(); i++){
        cruiser.addCoords("" + cruiser.getRow() + (cruiser.getCol()+i));
      }
    }
    if(!cruiser.isHorizontal()){
      for(int i = 0; i<cruiser.getSize(); i++){
        cruiser.addCoords("" + (cruiser.getRow()+i) + cruiser.getCol());
      }
    }
    //submarine
    if(submarine.isHorizontal()){
      for(int i = 0; i<submarine.getSize(); i++){
        submarine.addCoords("" + submarine.getRow() + (submarine.getCol()+i));
      }
    }
    if(!submarine.isHorizontal()){
      for(int i = 0; i<submarine.getSize(); i++){
        submarine.addCoords("" + (submarine.getRow()+i) + submarine.getCol());
      }
    }
    //destroyer
    if(destroyer.isHorizontal()){
      for(int i = 0; i<destroyer.getSize(); i++){
        destroyer.addCoords("" + destroyer.getRow() + (destroyer.getCol()+i));
      }
    }
    if(!destroyer.isHorizontal()){
      for(int i = 0; i<destroyer.getSize(); i++){
        destroyer.addCoords("" + (destroyer.getRow()+i) + destroyer.getCol());
      }
    }
    userShipCoords.add(carrier.getCoords());
    userShipCoords.add(battleship.getCoords());
    userShipCoords.add(cruiser.getCoords());
    userShipCoords.add(submarine.getCoords());
    userShipCoords.add(destroyer.getCoords());
  }

  //bot's turn, guess user ship locations
  public void guessUserShips(){
    int rowShot; 
    int colShot; 
    String target;
    
    rowShot = (int)((Math.random() * 10) + 1);
    colShot = (int)((Math.random() * 10) + 1);
    target = "" + rowShot + colShot;

    //if shot hits
    if(ape.getP1Spot(rowShot, colShot).equals("*")){
      ape.setP1Spot(rowShot, colShot, "\u001B[31mX\u001B[37m");
      
      Found: for(Battleships ship : userShips){
        for(String located : ship.getCoords()){
          if(target.equals(located)){
            System.out.println("\n\u001B[31mHAL-9K has hit your ship!\n\u001B[37m");
            ship.removeCoords(target);

            //when a ship is destroyed
            if(ship.getCoords().size()==0){
              System.out.println("\n\u001B[31mHAL-9K has destroyed your " + ship.getName() + "\n\u001B[37m");
              userShips.remove(ship);
            }
            break Found;
          }
        }
      }
      fire.printBotBoard(ape.getP1Board());
    //if shot misses
    }else if(ape.getP1Spot(rowShot, colShot).equals("-")){
      System.out.println("\nHAL-9K missed.\n");
      ape.setP1Spot(rowShot, colShot, "O");
      fire.printBotBoard(ape.getP1Board());
    //if already fired upon
    }else{
      guessUserShips();
    }
  }

  //return number of remaining user ships
  public int getUserShips(){
    return userShips.size();
  }
  
}