//This will randomly assign cards in the deck to ransom pistions 
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Random;

public class Player{
  //max 4 playes 
  final static int MAXIMUM_PLAYERS = 4;
  final static int MINIMUM_PLAYERS = 2;
  final static String ASK_FOR_LESS = "That is to many players please enter a number less then 5: ";
  final static String ASK_FOR_MORE = "That is to few players please enter a number greater then 1";
  final static String ASK_FOR_NAME = "Please enter the name of Player ";

  public static String[] getListOfPlayers(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter in the amount of players playing? ");
    int numOfPlayers = sc.nextInt();
    
    while(numOfPlayers > MAXIMUM_PLAYERS || numOfPlayers < MINIMUM_PLAYERS){
      if(numOfPlayers > MAXIMUM_PLAYERS){
        System.out.println(ASK_FOR_LESS);
        numOfPlayers = sc.nextInt();
      }
      else{
        System.out.println(ASK_FOR_MORE);
        numOfPlayers = sc.nextInt();
      }
      
    }
    String[] playerList = new String[numOfPlayers];
    String playerName = "";
    for(int i = 0; i < numOfPlayers; i++){
      System.out.println("Please enter Player " + (i+1) + "'s name: ");
      playerName = sc.next();
      while(playerName.length() < 2){
        System.out.println("Please enter a longer name: ");
        playerName = sc.next();
      }
      playerList[i] += playerName;
    }

    assignsDealer(playerList);
    return playerList;
  }

  //assigns the dealer randomly
  public static String assignsDealer(String [] playerList){
    System.out.println();
    int num = playerList.length;

    int d = (int) (Math.random() * num);
    String dealerName = playerList[d];
    dealerName = dealerName.replace("null", "");
    System.out.println("The dealer is: " + dealerName);
    return dealerName;
  }
  
}