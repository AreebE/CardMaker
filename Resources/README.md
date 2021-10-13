This is intended to act as a sort of chapter index, describing what is in each folder.
====
Game Logic
--- 
Anything that would fall under making some logical decision, such as making a turn or deciding whose's hand is the best.

- Card: A class for a single card


- Deck: A file that contains a deck. It is used to draw cards for the game to use.


- Game: Whenever its constructor is called, it starts a game (different from a round). It displays the rank of each player at the end of a round and asks if players want to play another round or another game.


- Round: Similar to game, Whenever its constructor is called, it starts a _betting round._ It also displays the winner of a round.


- Player: This contains some information relevant to a specific player and also allows players to be compared to one another. This information currently includes: 
  - The amount of chips bet 
  - The current amount of chips the player has
  - Their name
  - Whether they have folded 
  - Whether thay have called.
  - The cards they currently have


- TooManyChipsBet: This specific exception is designed to be thrown if too many chips are bet.
---

HandLogic (Inside GameLogic)
--
This contains logic for deciding not only which hand was best, but what type of hand a set of cards were.

- Hand: An abstract class meant to be overrided by other classes. Overall, this class serves the function of storing cards of a given hand and comparing two hands, whether they are alike or not.


- HandDecider: This class only contains static methods, as all it is meant for is to decide what type of hand something is. IT also contains a method for determining the best hand out of a set of 7 cards.


- HandTester: This class is not used by the game - It is just used to test if HandDecider and all of the handtypes work.
---
HandTypes (in HandLogic)
-
This folder contains all of the different hand types. Here are the conditions of each handtype in order:
- Royal Flush: All cards are of the same suit and contains a Ace, Ten, King, Queen, and Jack 
- Straight Flush: All cards are of the same suit and in consecutive order 
- Four of a Kind: Four cards of the same number are present
- Full House: There is a pair and a three of a kind.
- Flush: All cards are in the same suit.
- Straight: All cards are consecutive.
- Three of a kind: Three of the cards are the same number 
- Two Pair: There are two pairs of cards, where each card in a pair have the same number. 
- One Pair: There is only one pair of cards.
- Highest Card: It uses the card with the highest value.
---
Graphics
-
This includes any type of classes that have anything to do with drawing.
- CardDrawer: This will draw a card at a starting position. It also is able to scale the card's size


- DrawingPanel: This class is imported and is used for contain the canvas.


- Blueprint: This class is used to determine where the symbols go, based on a card's rank.
---
FaceDrawers (Inside Graphics)
-

This class is used to draw the symbols representing a specific suit, along with being able to draw cards with a rank of King, Queen, or Jack.

- CardFaceDrawer: This class is abstract and meant to be extended. It is used for drawing the symbols of a card or the face cards (King, Queen, and Jack)


- Club: This is responsible for drawing club symbols.


- Diamond: This is responsible for drawing diamond symbols.


- Heart: This is responsible for drawing heart symbols.


- Spade: This is responsible for drawing spade symbols.
---
Resources
-
This folder contains some general resources used by a lot of classes.
- README: The name of this file, not much to it.
- Util: A file containing some constants and helper methods (ex. sorting an array)
---
To do:
==