import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Round {
  private final static int FIRST_BLIND = 1;

  private final static int CARDS_IN_FIRST_PHASE = 0;
  private final static int CARDS_IN_SECOND_PHASE = 3;
  private final static int CARDS_IN_THIRD_PHASE = 4;
  private final static int CARDS_IN_FOURTH_PHASE = 5;
  private String questionForAction = "Do you plan to raise 1, raise 2, call, or fold?";

  private final static int TIMES_TO_SHUFFLE = 10;
  private final static int RAISE_ONE_CHIP = 1;
  private final static int RAISE_TWO_CHIPS = 2;
  private final static int CALL = 0;
  private final static int FOLD = 3;
  private final static int INVALID_INPUT = -1;
  
  private int pot;
  private int calledPlayers;
  private int foldedPlayers;
  private Card[] cardsOnTable;

  private static HashMap<String, Integer> acceptableRaisingInput = new HashMap<>() {
    {
      put("raise 1",RAISE_ONE_CHIP);
      put("raise one",RAISE_ONE_CHIP);
      put("1", RAISE_ONE_CHIP);
      put("r1", RAISE_ONE_CHIP);
      put("r_1", RAISE_ONE_CHIP);
      put("one", RAISE_ONE_CHIP);
      put("r 1",RAISE_ONE_CHIP);

      put("raise 2",RAISE_TWO_CHIPS);
      put("raise two",RAISE_TWO_CHIPS);
      put("2", RAISE_TWO_CHIPS);
      put("r2", RAISE_TWO_CHIPS);
      put("r_2", RAISE_TWO_CHIPS);
      put("two", RAISE_TWO_CHIPS);
      put("r 2",RAISE_TWO_CHIPS);

      put("call", CALL);
      put("zero", CALL);
      put("0", CALL);
      put("c", CALL);
      put("r0", CALL);
      put("r_0", CALL);
      put("raise 0", CALL);

      put("fold", FOLD);
      put("f", FOLD);
    }
  };

  /*
   * This constructor will cause a round to start and end. It also sets up a * randomized deck along with some other important values:
   *  - calledPlayers, marking how many players have called 
   *  - foldedPlayers, marking how many players have folded  
   * 
   * @param   players   An array containing all of the players 
   * 
   * @param   inputReader     A scanner for reading input
  */
  public Round(Player[] players, Scanner inputReader) {
    calledPlayers = 0;
    foldedPlayers = 0;
    Deck d = new Deck();
    // d.randomizeDeck(TIMES_TO_SHUFFLE);
    cardsOnTable = new Card[5];
    for (Player p : players) {
      p.setCards(d.drawCard(), d.drawCard());
      if (p.getChips() == 0){
        p.setFolded(true);
      }
      if (p.hasFolded()){
        foldedPlayers++;
      }
    }
    for (int i = 0; i < cardsOnTable.length; i++){
      cardsOnTable[i] = d.drawCard();
    }
    startRound(inputReader, players, CARDS_IN_FIRST_PHASE);
    startRound(inputReader, players, CARDS_IN_SECOND_PHASE);
    startRound(inputReader, players, CARDS_IN_THIRD_PHASE);
    startRound(inputReader, players, CARDS_IN_FOURTH_PHASE);
    endRound(players);
  }

  private void resetPlayers(Player[] players){
    calledPlayers = 0;
    for (Player p : players) {
      if (p.hasCalled()){
        p.setCalled(false);
      }
      if (p.getChips() == 0 && !p.has){
        p.setFolded(true);
      }
      p.startNewRound();
    }
  }
  /*
   * This method will cause the round to start. How each round starts:
   * There is a 'first blind,' forcing the first player to bet at least one chip.
   * 
   * For each player, it first confirms that it is this player's turn, to 
   * prevent them from seeing another player's card. It also displays 
   * general details about this round, which is handled by another method.
   * 
   * Also, a player can only move if:
   *   - They haven't folded
   *   - The player still has tokens
   *   - The player hasn't called. However, this rule is overrided if 
   *      there is a previous bet.
   *
   * There are also a few actions, but what they are and how they work are 
   * detailed in 'executeAction.' The only exception is when there is invalid
   * input, in which case, the valid inputs are displayed.
   *
   * Overall, this method is designed to keep the round going until all but 
   * one player has folded or all players have either called or folded.
   * This is why 'calledPlayers' and 'foldedPlayers' are important.
   *
   * @param   inputReader     A scanner for reading input 
   *
   * @param   players   All players in the game
  */
  private void startRound(Scanner inputReader, Player[] players, int cardsInPhase) {
    int previousBet = FIRST_BLIND;
    resetPlayers(players);
    for (int i = 0; calledPlayers + foldedPlayers < players.length && foldedPlayers < players.length - 1; i = (i + 1) % players.length) {
      Player p = players[i];
      System.out.println(Util.EMPTY_SPACE);
      // System.out.println();
      boolean playerCanMakeMove = !p.hasFolded() && (!p.hasCalled() ||previousBet != 0) && p.getChips() != 0;
      while (playerCanMakeMove) {
        if (p.hasCalled()) {
          p.setCalled(false);
          calledPlayers--;
        }
        System.out.println("Confirm that this is " + p.getName() + "\'s turn.");
        
        inputReader.next();
        showInfo(players, p, previousBet, pot, cardsInPhase, cardsOnTable);
        System.out.println(questionForAction);
        
        String input = inputReader.next();
        int action = getAction(input);
        if (action != INVALID_INPUT) {
          playerCanMakeMove = false;
          previousBet = executeAction(p, action, previousBet, inputReader);
        } else {
          System.out.println(getAcceptableRaisingInput());
        }
      }
    }
  }

  /*
   * This will execute an action, depending on what the player chose. The 
   * available actions are:
   *  - Call, which means you bet enough chips to 'match' the bet. Also,
   *      the next bet would be 0 for the next player. The player is 
   *      considered to have called.
   *  - Raise 1, which means you bet one more chip than the previous bet.
   *      The next bet is 1 for the next player.
   *  - Raise 2, which means you bet two more chips than the previous bet.
   *      The bet becomes 2 for the next player.
   *  - Fold, which means you give up everything you have placed in the pot.
   *      You can no longer do anything until the round ends, and therefore,
   *      you cannot win anything.
   *
   *  If chips are bet, then they are added to the pot, later used to reward
   *  the winner.
   *
   *  If you can't bet chips (mainly because you bet more than you have),
   *  then an exception is handled. It will be assumed that the player called
   *  and all of the player's chips will be placed in the pot. The next
   *  bet then becomes the difference between the previous bet and the 
   *  the player's chips.
   *  
   * @param   p             the current player
   * @param   action        The player's action
   * @param   previousBet   The previous bet 
   * @param   inputReader   A scanner for input. This is used to confirm
   *                          that the user saw the error.
   *
   * @return  the next bet, designed to be the previous bet of the next 
   *          player.
  */
  private int executeAction(Player p, int action, int previousBet, Scanner inputReader) {
    try {
      switch (action) {
        case CALL:
          p.setCalled(true);
          calledPlayers++;
        case RAISE_ONE_CHIP:
        case RAISE_TWO_CHIPS:
          int chipsBet = action + previousBet;
          p.betChips(chipsBet);
          pot += chipsBet;
          return action;
        case FOLD:
          p.setFolded(true);
          foldedPlayers++;
          return previousBet;
      }
    } catch (TooManyChipsBet e) {
      System.out.println("Too many chips were bet. You have now been called. Type anything to confirm you have seen this.");
      inputReader.next();
      p.setCalled(true);
      int chips = e.getAvailableChips();
      pot += chips;
      calledPlayers++;
      return Math.abs(previousBet - chips);
    }
    return -1;
  }

  /* 
   * This is the code for the end of the round. It first finds who the
   * winners are, then displays them.
   *
   * @param   players   All players playing
  */
  private void endRound(Player[] players) {
    ArrayList<Player> winners = new ArrayList<>();
    int i = 0;
    while (i < players.length && players[i].hasFolded()) {
      i++;
    }
    Player bestPlayer = players[i];
    winners.add(bestPlayer);
    for (i = i + 1; i < players.length; i++) {
      Player current = players[i];
      if (!current.hasFolded()) {
        int difference = bestPlayer.compareTwoCards(current);
        if (difference == 0) {
          winners.add(current);
        } else if (difference < 0) {
          winners.clear();
          bestPlayer = current;
          winners.add(bestPlayer);
        }
      }
    }
    // System.out.println(winners);
    displayWinners(winners);
  }

  /*
   * This displayes all of the winners, along with giving them their chips.
   *  Also, and remaining chips are lost permanently.
   *
   * @param   winners    All winners of this round.
  */
  private void displayWinners(ArrayList<Player> winners) {
    System.out.println("Congratulations! The winner(s) are: ");
    int tokensWon = pot / winners.size();
    for (int i = 0; i < winners.size(); i++) {
      Player p = winners.get(i);
      System.out.println(p.getName() + " (had the " + p.getCard(0) + ".)");
      p.gainChips(tokensWon);
    }
  }

  /*
   * This will return a string containing all inputs accepted by this program.
   * This is used to help the user if they need help.
   *
   * @return  all acceptable forms of inputs, along with what action they 
   *            respond to.
  */
  private static String getAcceptableRaisingInput() {
    StringBuilder allActions = new StringBuilder(
        "\nAssuming you need help.\n All available actions: (everything is case-desensitive)\n ");
    Iterator<String> eachAction = acceptableRaisingInput.keySet().iterator();
    while (eachAction.hasNext()) {
      String action = eachAction.next();
      allActions.append("* \'").append(action).append("\' - ");
      switch (getAction(action)) {
        case RAISE_ONE_CHIP:
          allActions.append("Raise 1 chip.");
          break;
        case RAISE_TWO_CHIPS:
          allActions.append("Raise 2 chips.");
          break;
        case CALL:
          allActions.append("Call.");
          break;
        case FOLD:
          allActions.append("Fold.");
          break;

      }
      allActions.append("\n");
    }
    return allActions.toString();
  }

  /*
   * This method gets the appropiate action for the given input, if there is 
   * one.
   *
   * @param   input   The user's input
   *
   * @return  the action the player took
  */
  private static int getAction(String input) {
    if (acceptableRaisingInput.containsKey(input)) {
      return acceptableRaisingInput.get(input);
    }
    return INVALID_INPUT;
  }

  /*
   * This method will show all of the info important to this round, which 
   *   includes:
   *    - Who's turn it is 
   *    - How many chips this player has and has bet.
   *    - The size of the pot and the previous bet 
   *    - The amount of chips the other players have and how much they
   *        have bet.
   *        -- However, a player is not included if they folded. 
   *
   * @param   allPlayers      all players playing 
   * @param   current         the current player 
   * @param   previousBet     The previous bet 
   * @param   pot             The current pot
  */
  private static void showInfo(Player[] allPlayers, Player current, int previousBet, int pot, int cardsInPhase, Card[] cardsOnTable) {
    System.out.println("\n" + current.getName() + "'s turn.");
    System.out.println("You currently have " + current.getChips() + " chips.");
    System.out.println("You currently have: \n* " +  current.getCard(0) + "\n* " + current.getCard(1) + "\n");

    System.out.println("The pot currently has " + pot + ((pot == 1) ? " chip" : " chips")
            + "\nand the previous bet is currently " + previousBet + ". ");

    if (cardsInPhase != CARDS_IN_FIRST_PHASE){
      System.out.println("The cards on the table are: ");
      for (int i = 0; i < cardsInPhase; i++){
        System.out.println("* " + cardsOnTable[i]);
      }
    }
    
    System.out.println("As for the other players:");
    for (Player p: allPlayers){
      if (p != current && !p.hasFolded()){
        System.out.println("* " + p.getName() + " has " + p.getChips() + " chips. (bet " + p.getBetChips() + " chips)");
      }
    }

    System.out.println("\nYou have currently bet " + current.getBetChips() + " chips.");
  }
  
}