import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

class GamePanel extends JPanel implements MouseListener, ActionListener, KeyListener {
  ImageIcon image = new ImageIcon("target.png");
  ImageIcon dragon = new ImageIcon("dragon.jpg");
  private Timer timer;
  private int delay = 50;
  private int targetSize = 50; 
  int numTargets = 30;
  final int length = 50;
  int currentLength = 50;
  final int boardWidth = 600;
  final int boardHeight = 700;
  JFrame frame = new JFrame();
  Target target = new Target();
  boolean shrinking = false;
  boolean moving = false;
  int angle;
  Scores score = new Scores();
  JPanel startScreen = new JPanel();
  JPanel gameOverScreen = new JPanel();
  JPanel pausePanel = new JPanel();
  boolean inGame = true;
  boolean paused = false;
  JLabel scoreLabel = new JLabel(" Score: 0");
  JLabel mode1 = new JLabel("Custom Mode!");//custom mode (choose # of targets)
  JLabel mode2 = new JLabel("Endless Mode!");//endless
  JLabel mode3 = new JLabel("Hydra Mode!");//hydra
  boolean start = true;
  boolean limitedMode = false; //custom mode
  JTextArea highscoreLabel = new JTextArea("High Scores:");
  JLabel GameOverLabel = new JLabel("GAME OVER");
  JLabel replayButton = new JLabel("Play Again?");
  JPanel textPanel = new JPanel();
  JTextField textField = new JTextField("");
  JButton textButton = new JButton("Click to Confirm");
  boolean hydra = false;
  int hydraSize = 1;
  Timer hydraTimer = new Timer(10000,this);
  int count=0;//for hydra
  ArrayList<Target> heads = new ArrayList<Target>();
  public GamePanel(){
    target.setIcon(image);
    heads.add(target);
    frame.setSize(600,700);//this should be boardWidth,height
    frame.setTitle("AimTrainer.io");
    frame.setResizable(false);
    frame.setVisible(true);
    frame.setLayout(null);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    target.setBackground(Color.RED);
    target.setOpaque(true);
    target.setVisible(false);
    target.addMouseListener(this);
    frame.add(target);
    timer = new Timer(delay,this);
    timer.start();
    //could be used as a label for detecting missed shots - not implemented
    //why is it 600 by 600 not 600 by 700
    /*
    JLabel background = new JLabel();
    background.setBounds(0,0,600,600);
    background.setBackground(Color.WHITE);
    background.setOpaque(true);
    background.setVisible(true);
    background.addMouseListener(this);
    frame.add(background);
    */
    
    //textPanel
    textPanel.setSize(600,700);
    textPanel.setBackground(Color.BLACK);
    textPanel.setVisible(false);
    frame.add(textPanel);
    
    //textfield
    textField.setBounds(100,100,200,100);
    textField.setToolTipText("How many targets would you like?");
    textField.addActionListener(this);
    textField.setVisible(false);
    textField.setOpaque(true);
    frame.add(textField);

    //textButton
    textButton.setBounds(100,200,200,30);
    textButton.addMouseListener(this);
    textButton.setVisible(false);
    textButton.setOpaque(true);
    frame.add(textButton);
    
    //start Screen 
    startScreen.setSize(600,700);
    startScreen.setBackground(Color.BLACK);
    startScreen.setVisible(true);
    frame.add(startScreen);
    mode1.setBounds(100,400,100,300);
    mode1.setPreferredSize(new Dimension(150, 300));
    mode1.setHorizontalAlignment(JLabel.CENTER);
    mode1.setVerticalAlignment(JLabel.CENTER);
    mode1.setOpaque(true);
    mode1.setBackground(Color.GREEN);
    mode1.setForeground(Color.BLACK);
    mode1.setVisible(true);
    mode1.addMouseListener(this);
    startScreen.add(mode1);
    mode2.setBounds(400,400,100,300);
    mode2.setPreferredSize(new Dimension(150, 300));
    mode2.setHorizontalAlignment(JLabel.CENTER);
    mode2.setVerticalAlignment(JLabel.CENTER);
    mode2.setOpaque(true);
    mode2.setBackground(Color.GREEN);
    mode2.setForeground(Color.BLACK);
    mode2.setVisible(true);
    mode2.addMouseListener(this);
    startScreen.add(mode2);
    mode3.setBounds(100,400,100,300);
    mode3.setPreferredSize(new Dimension(150, 300));
    mode3.setHorizontalAlignment(JLabel.CENTER);
    mode3.setVerticalAlignment(JLabel.CENTER);
    mode3.setOpaque(true);
    mode3.setBackground(Color.GREEN);
    mode3.setForeground(Color.BLACK);
    mode3.setVisible(true);
    mode3.addMouseListener(this);
    startScreen.add(mode3);
    
    //game over panel
    gameOverScreen.setSize(600,700);
    gameOverScreen.setBackground(Color.BLACK);
    gameOverScreen.setVisible(false);
  
    //pause panel
    frame.add(gameOverScreen);
    pausePanel.setSize(600,700);
    pausePanel.setBackground(Color.BLACK);
    pausePanel.setVisible(false);
    frame.add(pausePanel);
    JLabel paused = new JLabel("The game is paused.");
    paused.setPreferredSize(new Dimension(200, 200));
    paused.setHorizontalAlignment(JLabel.CENTER);
    paused.setVerticalAlignment(JLabel.CENTER);
    paused.setOpaque(true);
    paused.setBackground(Color.BLACK);
    paused.setForeground(Color.WHITE);
    paused.setVisible(true);
    pausePanel.add(paused);

    //display score
    scoreLabel.setBounds(250,25,100,50);
    scoreLabel.setOpaque(true);
    scoreLabel.setVisible(true);
    scoreLabel.setBackground(Color.WHITE);
    scoreLabel.setForeground(Color.BLACK);
    frame.add(scoreLabel);
  }

    public void mouseClicked(MouseEvent e){
      System.out.println(" Targets left: " + numTargets);

      //text button click
      if(e.getSource().equals(textButton)){
        int inputTar = Integer.parseInt(textField.getText());
        numTargets = inputTar;
        System.out.println("new target number " + numTargets);
        textPanel.setVisible(false);
        textField.setVisible(false);
        textButton.setVisible(false);
        target.setVisible(true);

        //set max score
        highscoreLabel.setText("\n\n  Max Score Possible: " + score.maxPossible(numTargets));
      }
      
      //target click decreases numTargets
      if(e.getSource().equals(target)){
      numTargets--;
      score.addToScore();
      score.increaseStreak();
      scoreLabel.setText(" Score: " + score.returnScore());
      }
      //replay
      if(e.getSource().equals(replayButton)){
        startScreen.setVisible(true);
        gameOverScreen.setVisible(false);
        scoreLabel.setText(" Score: 0");
      }
      //limited mode
      if(e.getSource().equals(mode1)){
        target.setIcon(image);
        textField.setVisible(true);
        textButton.setVisible(true);
        //textPanel.setVisible(true);
        numTargets = 5; //changes target num
        target.setVisible(false);
        limitedMode = true;
        startScreen.setVisible(false);
      }
      
      //endless mode
      if(e.getSource().equals(mode2)){
        target.setIcon(image);
        target.setVisible(true);
        startScreen.setVisible(false);
      }

      //hydra mode
      if(e.getSource().equals(mode3)){
        target.setIcon(dragon);
        target.setVisible(true);
        startScreen.setVisible(false);
        hydra = true;
        hydraTimer.start();
        shrinking = true;//always have shirnking true - lose when they miss one target
      }

      if(hydra){
      score.addToScore();
        //clear hydra targets
        for(Target i:heads){
          if(e.getSource()==i){
            i.setVisible(false);
            count++;
            }
          }
        if(count==heads.size()){
          hydraSize*=2;
          heads.clear();
          count = 0;
          for(int j = 0; j<hydraSize; j++){
            heads.add(new Target());
                heads.get(j).setBounds((int)heads.get(j).getXPOS(),(int)heads.get(j).getYPOS(),50,50);
                heads.get(j).setIcon(dragon);
                heads.get(j).setBackground(Color.RED);
                heads.get(j).setOpaque(true);
                heads.get(j).setVisible(true);
                heads.get(j).addMouseListener(this);
                frame.add(heads.get(j));
              }
          }
      }
      if(!hydra)//implement hydra (always shrinks?)
      shrinking = false;
      targetSize = length;
      moving = false;
      int[] coords = {(int)(Math.random()*550),(int)(Math.random()*550)};
      System.out.println("X: " + coords[0] + " Y: " + coords[1]);
      target.setXY(coords[0], coords[1]);
      target.setLength(length);
      
      //someitmes moves/shrinks
      if(Math.random()<.33){
        System.out.println("Shrinking");
        shrinking = true;
      }else if(Math.random()<.66){
        System.out.println("Moving");
        angle = (int)(Math.random()*361);
        moving = true;
      }
      
      //updates
      frame.repaint();

      if(!inGame){
        startScreen.setVisible(true);
        gameOverScreen.setVisible(false);
        inGame = true;
      }
    }
    
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void actionListener(ActionEvent e){}
    public void actionPerformed(ActionEvent e){

      //hydra timer - stops after 30 seconds
      if(e.getSource()==hydraTimer){
        hydraTimer.stop();
        gameOver();
      }
      
      //end game condition for custom mode
      if(limitedMode){
        if(numTargets<=0){
          gameOver();
        }
      }
      
      //redraw target
      target.setBounds((int)target.getXPOS(),(int)target.getYPOS(),targetSize,targetSize);
      
      //shrinking target - replace "target" with "heads.get(i)"
      if(shrinking){
        targetSize-=1;
        target.setLength(targetSize);
        if(targetSize<=0){
          targetSize=length;
          int[] coords = {(int)(Math.random()*550),(int)(Math.random()*550)};
          target.setXY(coords[0], coords[1]);
          score.resetStreak();
          numTargets--;
          shrinking = false;
        }
      }
      
      //move target
      if(moving){
        double distance = 4.5;
        double XComponent = Math.cos(Math.toRadians(angle))*distance;
        double YComponent = Math.sin(Math.toRadians(angle))*distance;
target.setXY(target.getXPOS()+XComponent,target.getYPOS()+YComponent);
        
        //if hit wall make new target
        if(target.getXPOS()<-50||target.getXPOS()>boardWidth||target.getYPOS()<-50||target.getYPOS()>boardHeight){
          int[] coords = {(int)(Math.random()*550),(int)(Math.random()*550)};
      target.setXY(coords[0], coords[1]);
          score.resetStreak();
          numTargets--;
          moving = false;
        }
      }
    }

  public void keyTyped(KeyEvent e){
    int key = e.getKeyCode();
    //pause game - doesnt work
    if(key == 80){ //80 = P
      if(!paused){
      System.out.println("paused");
      timer.stop();
      pausePanel.setVisible(true);
      paused = true;
      }else{
      timer.start();
      pausePanel.setVisible(false);
      paused = false;
      }
    }
  }
  public void keyReleased(KeyEvent e){}
  public void keyPressed(KeyEvent e){}
  
   public void gameOver(){
    
    target.setVisible(false);
     
    if(hydra){
      //clear hydra list and targets for replayability
      for(Target tar:heads){
        tar.setVisible(false);
      }
      heads.clear();//may have to add target to the list
      heads.add(target);
      hydraSize = 1;
      count = 0;
      hydra = false;
      
      //rewrite high score text
      String allScore = "";
      for(int i = 0; i < score.getHighScores().size(); i++){
        allScore += "\n  " + (i+1) + ". " + score.getHighScores().get(i);
      }
      highscoreLabel.setText("\n  HIGH SCORES: " + allScore);
      System.out.println(allScore);
    }
      //doesnt work bc numTargets is zero at end
     else if(limitedMode){
      highscoreLabel.setText("\n  SCORE: " + score.returnScore() + highscoreLabel.getText());
       score = new Scores(); //resets maxScore
     }
    else{
      //addScore for endless mode
    }
     //moved here from top of gameOver()
    limitedMode = false;
    score.gameOver();
    score.printList();
    inGame = false;
    gameOverScreen.setVisible(true);

     
    highscoreLabel.setBounds(50,10,100,500);
    highscoreLabel.setPreferredSize(new Dimension(150, 500));
    highscoreLabel.setOpaque(true);
    highscoreLabel.setBackground(Color.GREEN);
    highscoreLabel.setVisible(true);
    highscoreLabel.setEditable(false);
    highscoreLabel.setLineWrap(true);
    highscoreLabel.setFont(UIManager.getFont("Label.font"));
    gameOverScreen.add(highscoreLabel);
     
    GameOverLabel.setFont(new Font("Verdana", Font.ITALIC, 25));
    GameOverLabel.setLayout(null);
    GameOverLabel.setBounds(250,250,100,500);
    GameOverLabel.setPreferredSize(new Dimension(200, 150));
    GameOverLabel.setHorizontalAlignment(JLabel.CENTER);
    GameOverLabel.setVerticalAlignment(JLabel.CENTER);
    GameOverLabel.setOpaque(true);
    GameOverLabel.setBackground(Color.BLACK);
    GameOverLabel.setForeground(Color.RED);
    GameOverLabel.setVisible(true);
    gameOverScreen.add(GameOverLabel);
     
    replayButton.setFont(new Font("Verdana", Font.PLAIN, 20));
    replayButton.setLayout(null);
    replayButton.setBounds(250,400,100,500);
    replayButton.setPreferredSize(new Dimension(150, 150));
    replayButton.setHorizontalAlignment(JLabel.CENTER);
    replayButton.setVerticalAlignment(JLabel.CENTER);
    replayButton.setOpaque(true);
    replayButton.setBackground(Color.GREEN);
    replayButton.setForeground(Color.BLACK);
    replayButton.setVisible(true);
    replayButton.addMouseListener(this);
    gameOverScreen.add(replayButton);
  }
  
}
