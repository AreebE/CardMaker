import java.util.HashMap;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Arrays;

public class Game {

  private final static int STARTING_CHIPS = 25;
  private final static int INVALID_INPUT = -1;

  private static HashSet<String> yesInput=new HashSet<>(){{
    add("yes");
    add("ye");
    add("y");
    add("yep");
  }};

  private static HashMap<String, Integer> acceptableNumberInput = new HashMap<>() {{
      put("two",2);
      put("2",2);
      put("three",3);
      put("3",3);
      put("four",4);
      put("4",4);
  }};
  
  private final static int MAX_PLAYERS = 8;

  /*
   * This constructor will cause the game to start. It also handles 
   * the logic for when a new game should be played. 
  */
  public Game() {
    Scanner inputReader = new Scanner(System.in);
    Player[] players = getPlayers(inputReader);

    boolean playGame = true;
    while (playGame) {
      startGame(players, inputReader);
      System.out.println("Good game! Do you wish to start over?");
      String input = inputReader.next().toLowerCase();
      playGame = yesInput.contains(input);
    }
    inputReader.close();
  }

  /*
   * This starts a single game. Each game consists of a lot of betting rounds.
   * After each betting round, the results are displayed and the current 
   * state of the players are stated.
   *
   * @param   players   All players that are currently in the game.
   *
   * @param   inputReader     A scanner for reading input.
  */
  private void startGame(Player[] players, Scanner inputReader) {
    boolean gameKeepsGoing = true;
    while (gameKeepsGoing) {
      for (Player p : players) {
        p.setFolded(p.getChips() == 0);
        p.setCalled(false);
      }
      new Round(players, inputReader);
      gameKeepsGoing = wantsAnotherRound(inputReader, players);
    }
  }

  /*
   * This initializes the array that will contain all of the players.
   * A user is asked for input, first how many players should play, 
   * then the names of each players. There are only certain inputs which 
   * work, which is best shown in the static hashmaps in this class.
   *
   * @param   inputReader   A scanner for reading input 
   *
   * @return  an array containing all players.
  */
  private static Player[] getPlayers(Scanner inputReader) {
    int numPlayers = INVALID_INPUT;
    while (numPlayers == INVALID_INPUT) {
      System.out.print("How many players are playing? (There are at most " + MAX_PLAYERS + " players) ");
      String input = inputReader.next();
      numPlayers = (acceptableNumberInput.containsKey(input))? acceptableNumberInput.get(input) : INVALID_INPUT;
      if (numPlayers == INVALID_INPUT) {
        System.out.println("The input was not valid. Please input a number. \n");
      }
    }

    Player[] players = new Player[numPlayers];
    for (int i = 1; i <= numPlayers; i++) {
      System.out.print("Player " + i + ", what is your name? ");
      String name = inputReader.next();
      players[i - 1] = new Player(STARTING_CHIPS, name);
    }
    System.out.println();

    return players;
  }

  /*
   * This asks the players if they want to play another round.
   *
   * @param   inputReader     A scanner for getting input 
   *
   * @param   players   All of the players in the game
  */
  private boolean wantsAnotherRound(Scanner inputReader, Player[] players) {
    boolean onlyOnePlayerLeft = displayState(players);
    if (onlyOnePlayerLeft) {
      return false;
    }
    System.out.println("Do you want to play another round?");
    String input = inputReader.next().toLowerCase();
    return yesInput.contains(input);
  }

  /*
   * This displays the current state of the game. It makes a copy of the 
   * array to ensure that the order of players is not lost.
   * This copy of players is sorted based on how many chips each player has.
   * If there is only one player who has chips though, then it will return 'true',
   * as if to say that the game is over.
   *
   * @param   players   All players in the game
  */
  private boolean displayState(Player[] players) {
    Player[] copyOfPlayers = new Player[players.length];
    for (int i = 0; i < players.length; i++) {
      copyOfPlayers[i] = players[i];
    }
    int numOfZeroes = 0;
    Arrays.sort(copyOfPlayers);
    Util.reverseArray(copyOfPlayers);
    System.out.println("Here are the rankings: ");
    for (int i = 1; i <= copyOfPlayers.length; i++) {
      Player current = copyOfPlayers[i - 1];
      System.out.println("- " + i + ". " + current.getName() + " with " + current.getChips() + " chip(s)");
      if (current.getChips() == 0) {
        numOfZeroes++;
      }
    }
    System.out.println();
    return numOfZeroes == copyOfPlayers.length - 1;
  }

  // Unfinished! 
  /* This will display all of the rules, if the players ask.
  */
  private static void displayPokerRules(){
    System.out.println("Here are the rules: \n" + 
    "Each player has " + STARTING_CHIPS + " at first. and one card. \n" + 
    "" + 
    "All players have four choices each turn: \n" + 
    "\t* "
    );
  }
}