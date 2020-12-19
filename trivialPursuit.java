/**
 * The purpose of this code is to showcase our take on Trivial Pursuit. In this version, up to four people can
 * play at a time and they must answer a series of questions of their choice from select categories, 
 * ranging from easy, medium, and hard. The objective of the game is to these answer questions correctly until a player
 * reaches the game's winning score. There are six categories which can be chosen from: Arts & Literature, 
 * Entertainment, Geography, History, Sports & Leisure, and Science & Nature. To start, Player 1 will go 
 * first followed by Player 2, and so on. During the turn of a player, the player can choose which difficulty 
 * of a question they want and based on the difficulty, the points received varies. 
 * The game continues this way until a player reaches 25 points.
 *
 * Date Last Modified: June 16th, 2018
 * Authors: Niruthieka Velalakan & Meghna Ravikumar
 * Class: ICS3U1-21
 * School: Lester B. Pearson Collegiate Institute
 */

import java.util.Random; 
import java.util.Scanner;

public class trivialPursuit {

	//global variables
	public static Scanner input = new Scanner (System.in); //gets input from user
	public static Random rand = new Random(); //outputs random numbers
	public static int quesNum; //chooses question numbers
	public static String players;  //used to enter number of players as a string
	public static int numPlayers = 0; //string answer is converted to int answer 
	public static int points1 = 0, points2 = 0, points3 = 0, points4 = 0; //points counter for each player
	public static String player1, player2, player3, player4; //stores player names
	public static String cat, level; //used to get which category the player wants & which level the player wants
	public static String answer; //gets answers to trivia questions from user
	public static String start; //used to see if the player wants instructions or not
	public static int turns = 1; //counts the turns
	public static boolean correct = false; //keeps track of if the answers are true or false
	public static boolean easy, medium, hard; //keeps track of which level the user has chosen
	public static boolean player1turn = true, player2turn = false, player3turn = false, player4turn = false; //keeps track of which player's turn it is
	public static int player1Count = 1, player2Count = 2, player3Count = 3, player4Count = 4; //keeps track of each turn so we know whose it is

	//outputs the number of points each player has & adds points if they have answered correctly
	public static void points() {

		//tells us which level was chosen by the players
		levels();

		if(player1turn) { //accumulates points for player 1, only if CORRECT
			if(correct) {	
				if(easy) {	//easy level
					points1++; //adds 1 point
					System.out.println("\nYou are correct! " + player1 + ", you currently have " + points1 + " points."); //prints the # of points player 1 has
				}else if(medium) {	//medium level
					points1 += 3; //adds 3 points
					System.out.println("\nYou are correct! " + player1 + ", you currently have " + points1 + " points."); //prints the # of points player 1 has
				}else if(hard) {	//hard level
					points1 += 5; //adds 5 points
					System.out.println("\nYou are correct! " +player1 + ", you currently have " + points1 + " points."); //prints the # of points player 1 has
				}
			}

		}else if(player2turn) {	//accumulates points for player 2, only if CORRECT
			if(correct) {
				if(easy) {	//easy level
					points2++; //adds 1 point
					System.out.println("\nYou are correct! " + player2 + ", you currently have " + points2 + " points."); //prints the # of points player 2 has
				}else if(medium) {	//medium level
					points2 += 3; //adds 3 points
					System.out.println("\nYou are correct! " + player2 + ", you currently have " + points2 + " points."); //prints the # of points player 2 has
				}else if(hard) { //hard level
					points2 += 5; //adds 5 points
					System.out.println("\nYou are correct! " + player2 + ", you currently have " + points2 + " points."); //prints the # of points player 2 has
				}
			}
		}else if(player3turn) { //accumulates points for player 3, only if CORRECT
			if(correct) {
				if(easy) {	//easy level
					points3++; //adds 1 point
					System.out.println("\nYou are correct! " + player3 + ", you currently have " + points3 + " points."); //prints the # of points player 3 has
				}else if(hard) {	//medium level
					points3 += 3; //adds 3 points
					System.out.println("\nYou are correct! " + player3 + ", you currently have " + points3 + " points."); //prints the # of points player 3 has
				}else if(hard) { //hard level 
					points3 += 5; //adds 5 point
					System.out.println("\nYou are correct! " + player3 + ", you currently have " + points3 + " points."); //prints the # of points player 3 has
				}
			}
		}else if(player4turn) { //accumulates points for player 4, only if CORRECT
			if(correct) {
				if(easy) {	//easy level
					points4++; //adds 1 point
					System.out.println("\nYou are correct! " + player4 + ", you currently have " + points4 + " points."); //prints the # of points player 4 has
				}else if(medium) { //medium level
					points4 += 3; //adds 3 points
					System.out.println("\nYou are correct! " + player4 + ", you currently have " + points4 + " points."); //prints the # of points player 4 has
				}else if(hard) { //hard level
					points4 += 5; //adds 5 points
					System.out.println("\nYou are correct! " + player4 + ", you currently have " + points4 + " points."); //prints the # of points player 4 has
				}
			}
		}

		//if the answer was not correct, it only outputs the number of points each player has
		if(!correct) {
			if(player1turn) { //if player 1 gets their answer wrong
				System.out.println("\n"+player1 + ", you currently have " + points1 + " points."); //prints the # of points player 1 has
			}else if (player2turn){ //if player 2 gets their answer wrong
				System.out.println("\n"+player2 + ", you currently have " + points2 + " points."); //prints the # of points player 2 has
			}else if(player3turn) { //if player 3 gets their answer wrong
				System.out.println("\n"+player3 + ", you currently have " + points3 + " points."); //prints the # of points player 3 has
			}else if(player4turn) { //if player 4 gets their answer wrong
				System.out.println("\n"+player4 + ", you currently have " + points4 + " points."); //prints the # of points player 4 has
			}
		}

		turns++; //adds to the turn counter so it is the next player's turn
	}

	//keeps track of which level was chosen by the players
	public static void levels() {

		if(level.equalsIgnoreCase("easy")) { //if easy was chosen, then it becomes true and the rest become false
			easy = true;
			medium = false;
			hard = false;
		}else if(level.equalsIgnoreCase("medium")) { //if medium was chosen, then it becomes true and the rest become false
			easy = false;
			medium = true;
			hard = false;
		}else if(level.equalsIgnoreCase("hard")) {//if hard was chosen, then it becomes true and the rest become false
			easy = false;
			medium = false;
			hard = true;
		}
	}

	//keeps track of & outputs whose turn it is (used for 2 + players)
	public static void turns (){

		//if two players are playing
		if(numPlayers == 2){
			if(turns%2 == 1){ //makes all odd numbers player 1's turn
				player1turn = true; //makes it true that it is player 1's turn
				player2turn = false; //makes it false to show that it is not player 2's turn
				System.out.println("\nIt is " + player1+ "'s turn. "); //outputs that it is player 1's turn
				cats(); //outputs the categories
			}else if(turns%2 == 0){ //makes all even numbers player 2's turn
				player1turn = false; //makes it false to show that it is not player 1's turn
				player2turn = true; //makes it true that it is player 2's turn
				System.out.println("\nIt is " + player2 + "'s turn. "); //outputs that it is player 1's turn
				cats(); //outputs the categories
			}
		}	

		//if 3 players are playing
		if(numPlayers == 3) {
			if(turns == player1Count){ //player 1's turn comes every 3 turns
				player1turn = true;	//makes it true that it is player 1's turn		
				player2turn = false; //it is not player 2's turn
				player3turn = false; //it is not player 3's turn
				System.out.println("\nIt is " + player1 + "'s turn. "); //outputs that it is player 1's turn
				cats(); //outputs the categories
				player1Count +=3; //adds to the player's specific turn count
			}else if(turns == player2Count){ //player 3's turn comes every 3 turns
				player1turn = false; //it is not player 1's turn
				player2turn = true; //makes it true that it is player 2's turn
				player3turn = false; //it is not player 3's turn
				System.out.println("\nIt is " + player2 + "'s turn. "); //outputs that it is player 2's turn
				cats(); //outputs the categories
				player2Count += 3; //adds to the player's specific turn count
			}else if(turns == player3Count){ //player 3's turn comes every 3 turns
				player1turn = false; //it is not player 1's turn
				player2turn = false; //it is not player 2's turn
				player3turn = true; //makes it true that it is player 3's turn
				System.out.println("\nIt is " + player3+ "'s turn. "); //outputs that it is player 3's turn
				cats(); //outputs the categories
				player3Count += 3; //adds to the player's specific turn count
			}
		}

		//if 4 players are playing
		if(numPlayers == 4) { 
			if(turns == player1Count){ //player 1's turn comes every 4 turns
				player1turn = true;	//it is player 1's turn		
				player2turn = false; //not player 2's turn
				player3turn = false; //not player 3's turn
				player4turn = false; //not player 4's turn
				System.out.println("\nIt is " + player1 + "'s turn. "); //outputs that it is player 1's turn
				cats(); //outputs the categories
				player1Count += 4; //adds to the player's specific turn count 
			}else if(turns == player2Count){ //player 2's turn comes every 4 turns
				player1turn = false; //not player 1's turn			
				player2turn = true; //it is player 2's turn
				player3turn = false; //not player 3's turn
				player4turn = false; //not player 4's turn
				System.out.println("\nIt is " + player2 + "'s turn. "); //outputs that it is player 2's turn
				cats(); //outputs the categories
				player2Count += 4; //adds to the player's specific turn count 
			}else if(turns == player3Count){ //player 3's turn comes every 4 turns
				player1turn = false; //not player 1's turn
				player2turn = false; //not player 2's turn
				player3turn = true; //it is player 3's turn
				player4turn = false; //not player 4's turn
				System.out.println("\nIt is " + player3+ "'s turn. "); //outputs that it is player 3's turn
				cats(); //outputs the categories
				player3Count += 4; //adds to the player's specific turn count 
			}else if(turns == player4Count){ //player 4's turn comes every 4 turns
				player1turn = false; //not player 1's turn
				player2turn = false; //not player 2's turn
				player3turn = false; //not player 3's turn
				player4turn = true; //it is player 4's turn
				System.out.println("\nIt is " + player4 + "'s turn. "); //outputs that it is player 4's turn
				cats(); //outputs the categories
				player4Count += 4; //adds to the player's specific turn count 
			}

		}

	}

	//outputs the introduction at the very beginning
	public static void intro() {
		System.out.println("TRIVIAL PURSUIT\nBy Meghna & Niru"); //title
		System.out.print("\nWould you like to see the instuctions? (yes/no) "); //prompts whether instructions is desired
		start = input.nextLine(); //user answers if they want instructions or not
	}

	//displays the instructions if the user wants it & gets the number of players 
	public static void menu() {
		do { 
			if(start.equalsIgnoreCase("yes")){ // outputs menu and instructions if "yes"
				System.out.println("\nThe objective of the game is to answer questions correctly until a player "
						+ "\nreaches the game's winning score of 25 points. In this version of the game, up to four players can "
						+ "\nplay at a time. There are six categories which can be chosen from: Arts & Literature, "
						+ "\nEntertainment, Geography, History, Sports & Leisure, and Science & Nature. To start, "
						+ "\nPlayer 1 will go first followed by Player 2, and so on. During the turn of a player, the player "
						+ "\ncan choose which difficulty of a question they want and based on the difficulty, the "
						+ "\npoints received varies. The game continues this way until a player reaches 25 points. ");

				System.out.print("\nHow many players? (1, 2, 3, or 4) ");  //asks for number of players
				players = input.nextLine(); //gets # of players
				if(players.equals("1")) { //string input is 1
					numPlayers = 1; //makes integer input 1
				}else if(players.equals("2")) { //string input is 2
					numPlayers = 2; //makes integer input 2
				}else if(players.equals("3")){ //string input is 3
					numPlayers = 3; //makes integer input 3
				}else if(players.equals("4")) { //string input is 4
					numPlayers = 4; //makes integer input 4
				}else{ //will output if user input is invalid
					while(!players.equals("1") && !players.equals("2") && !players.equals("3") && !players.equals("4")) { //loops until valid input is entered
						System.out.println("\nSorry. You have entered an invalid number of players."); //outputs that they have entered invalid input
						System.out.print("Enter the number of players (1, 2, 3, or 4): "); //asks for # of players again
						players = input.nextLine(); //gets # of players
						if(players.equals("1")) { //string input is 1
							numPlayers = 1; //makes integer input 1
						}else if(players.equals("2")) { //string input is 2
							numPlayers = 2; //makes integer input 2
						}else if(players.equals("3")){ //string input is 3
							numPlayers = 3; //makes integer input 3
						}else if(players.equals("4")) { //string input is 4
							numPlayers = 4; //makes integer input 4
						} //loop ends
					} //if statement for player input ends

				} //if statements for instructions shown ends

			} else if(start.equalsIgnoreCase("no")){ //does not output instructions
				System.out.print("\nHow many players? (1, 2, 3, or 4) ");  //asks for number of players
				players = input.nextLine(); //gets # of players
				if(players.equals("1")) { //string input is 1
					numPlayers = 1; //makes integer input 1
				}else if(players.equals("2")) { //string input is 2
					numPlayers = 2; //makes integer input 2
				}else if(players.equals("3")){ //string input is 3
					numPlayers = 3; //makes integer input 3
				}else if(players.equals("4")) { //string input is 4
					numPlayers = 4; //makes integer input 4
				}else{ //will output if user input is invalid
					while(!players.equals("1") && !players.equals("2") && !players.equals("3") && !players.equals("4")) { //loops until valid input is entered
						System.out.println("\nSorry. You have entered an invalid number of players."); //outputs that they have entered invalid input
						System.out.print("Enter the number of players (1, 2, 3, or 4): "); //asks for # of players again
						players = input.nextLine(); //gets # of players
						if(players.equals("1")) { //string input is 1
							numPlayers = 1; //makes integer input 1
						}else if(players.equals("2")) { //string input is 2
							numPlayers = 2; //makes integer input 2
						}else if(players.equals("3")){ //string input is 3
							numPlayers = 3; //makes integer input 3
						}else if(players.equals("4")) { //string input is 4
							numPlayers = 4; //makes integer input 4
						} //loop ends
					} //if statement for player input ends
				} //if statement for if instructions are not shown ends

			} else if(!start.equalsIgnoreCase("yes") || !start.equalsIgnoreCase("no")){ //if invalid input is entered when prompted for instructions
				System.out.println("\nSorry, your answer is invalid. Please try again."); //outputs that it the answer is invalid
				System.out.print("\nWould you like to see the instuctions? (yes/no) "); //prompts whether instructions is desired again
				start = input.nextLine(); //gets answer again
			}

		} while (numPlayers == 0); //loops if the number of players is still 0

	}

	//players menu

	//gets the name for each player
	public static void playersMenu() {

		do{ // loop for player names
			if(numPlayers == 1){ // asks for player's name if only one player 
				System.out.print("\nWhat is your name? "); //asks for their name
				player1 = input.nextLine(); //stores their name
				numPlayers = 1; //keeps number of players at 1
			}else if(numPlayers == 2){ //asks for players' names if two players
				System.out.print("\nWhat is player 1's name? ");  //asks for player 1's name
				player1 = input.nextLine(); //stores player 1's name
				System.out.print("What is player 2's name? "); //asks for player 2's name
				player2 = input.nextLine(); //stores player 2's name
				numPlayers = 2; //keeps number of players at 2
			}else if(numPlayers == 3) { //asks for players' names if 3 players
				System.out.print("\nWhat is player 1's name? "); //asks for player 1's name
				player1 = input.nextLine(); //stores player 1's name
				System.out.print("What is player 2's name? "); //asks for player 2's name
				player2 = input.nextLine(); //stores player 2's name
				System.out.print("What is player 3's name? "); //asks for player 3's name
				player3 = input.nextLine(); //stores player 3's name
				numPlayers = 3; //keeps number of players at 3
			}else if(numPlayers == 4) { //asks for players' names if 4 players
				System.out.print("\nWhat is player 1's name? "); //asks for player 1's name
				player1 = input.nextLine(); //stores player 1's name
				System.out.print("What is player 2's name? "); //asks for player 2's name
				player2 = input.nextLine(); //stores player 2's name
				System.out.print("What is player 3's name? "); //asks for player 3's name
				player3 = input.nextLine(); //stores player 3's name
				System.out.print("What is player 4's name? "); //asks for player 4's name
				player4 = input.nextLine(); //stores player 4's name
				numPlayers = 4; //keeps number of players at 4
			}
		}while(numPlayers < 0 || numPlayers > 4); // loops if number of players if less than 0 or greater than 4

	}

	//outputs categories of questions

	//displays the categories, lets player choose which one they want & which level they want
	public static void cats(){  
		System.out.println("\nThese are the categories."); //array that holds list of categories
		String categories [] = {"a) Arts & Literature", "b) Entertainment", "c) Geography", 
				"d) History", "e) Sports & Leisure", "f) Science & Nature"};

		for(int i = 0; i < categories.length; i++){ //outputs the categories
			System.out.println(categories[i]);
		}

		System.out.print("\nPlease choose a category. "); //asks player to choose a category
		correct = false; //sets correct as false
		cat = input.nextLine(); // gets the desired category

		//loops if the input is invalid for the desired category
		while(!cat.equalsIgnoreCase("a") && !cat.equalsIgnoreCase("b") && !cat.equalsIgnoreCase("c") &&
				!cat.equalsIgnoreCase("d") && !cat.equalsIgnoreCase("e") && !cat.equalsIgnoreCase("f")) {
			System.out.println("Sorry, your input is invalid. "); //says that input is invalid
			System.out.print("\nPlease choose a category. "); //asks to choose a category again
			cat = input.nextLine(); // gets the desired category
		}

		System.out.print("Would you like easy, medium, or hard questions? "); // asks user for difficulty
		level = input.nextLine(); // gets the desired difficulty

		//loops if the input is invalid for the desired difficulty
		while(!level.equalsIgnoreCase("easy") && !level.equalsIgnoreCase("medium") && !level.equalsIgnoreCase("hard")) {
			System.out.println("\nSorry, your input is invalid. "); //says that input is invalid
			System.out.print("Would you like easy, medium, or hard questions? "); // asks user for difficulty
			level = input.nextLine(); // gets the desired difficulty
		}
	}

	//outputs the questions depending on what category is chosen
	public static void askQuestion(){
		if(cat.equalsIgnoreCase("a")){
			artsQs();
		}else if(cat.equalsIgnoreCase("b")){
			entertainQs();
		}else if(cat.equalsIgnoreCase("c")){
			geographyQs();
		}else if(cat.equalsIgnoreCase("d")){
			historyQs();
		}else if(cat.equalsIgnoreCase("e")){
			sportsQs();
		}else if(cat.equalsIgnoreCase("f")){
			scienceQs();
		}
	}

	//holds questions and answers for arts & literature category

	//arts & literature category
	public static void artsQs(){

		//array that holds easy arts & literature questions
		String [] artsEasyQs = {"What nationality was Chopin?", "Who lived at 221B, Baker Street, London? ", 
				"Who cut Van Gogh's ear?", "Who painted the Mona Lisa?", 
				"Who wrote Julius Caesar, Macbeth and Hamlet?", 
				"What did the crocodile swallow in Peter Pan?", 
				"What did the 7 dwarves do for a job?", "Who wrote the James Bond books?", 
				"What's the most important book in the Muslim religion?",
		"What are the first three words of the bible?"};

		//array that holds easy arts & literature answers 
		String [] artsEasyAs = {"Polish","Sherlock Holmes","He did","Da Vinci",
				"Shakespeare","Alarm clock","Mining",
				"Ian Fleming","Quran","In the beginning"};

		if(cat.equalsIgnoreCase("a") && level.equalsIgnoreCase("easy")){ //if easy category is picked
			quesNum = rand.nextInt(10); //chooses random question
			System.out.print("\nYour question, worth 1 point, is: " + artsEasyQs[quesNum] + " "); // outputs easy question
			answer = input.nextLine(); // gets answer
			if(artsEasyAs[quesNum].equalsIgnoreCase(answer)){ // outputs statement if correct
				correct = true; //sets correct as true  so points are added
			}else if(!artsEasyAs[quesNum].equalsIgnoreCase(answer)) { // outputs statement if incorrect
				System.out.println("\nYou are incorrect. The correct answer is: " + artsEasyAs[quesNum]); //outputs the correct answer 
				correct = false; //sets correct as false so points are not added
			}
		}

		//array that holds medium arts & literature questions 
		String [] artsMediumQs = {"What's the Hungarian word for pepper?", "Who wrote the Ugly Duckling?",
				"What was the first theatre play in Spain?", 
				"What Spanish artist said he would eat his wife when she died?", 
				"How many people went onto Noah's Ark?", 
				"Name a famous detective who smoked a pipe and played the violin.", 
				"Who painted the Sistine Chapel?", "Where did Salvador Dali live?", 
				"Who said, \"I think, therefore I am\"?", "Selling at Sotheby's in New York in 1995 for almost $3 million,"
						+ " \"Autoretrato con Chango y Loro\" was the most expensive painting by what woman?"};

		//array that holds medium arts & literature answers 
		String [] artsMediumAs = {"Paprika","Hans Christian Andersen","La Celestina","Dali","8",
				"Sherlock Holmes","Michelangelo","Figueras","Descartes","Frida Kahlo"};

		if(cat.equalsIgnoreCase("a") && level.equalsIgnoreCase("medium")){ //if medium category is picked
			quesNum = rand.nextInt(10); //chooses random question
			System.out.print("\nYour question, worth 3 points, is: " + artsMediumQs[quesNum]+ " "); // outputs medium question
			answer = input.nextLine(); // gets answer
			if(artsMediumAs[quesNum].equalsIgnoreCase(answer)){ // outputs statement if correct
				correct = true; //sets correct as true so points are added
			}else if(!artsMediumAs[quesNum].equalsIgnoreCase(answer)) { // outputs statement if incorrect
				System.out.println("\nYou are incorrect. The correct answer is: " + artsMediumAs[quesNum]); //outputs the correct answer
				correct = false; //sets correct as false so points are not added
			} 
		}

		//array that holds hard arts & literature questions
		String [] artsHardQs = {"What's the best known artificial international language?", "Who wrote Lazarillo de Tormes?", 
				"Where was Lope de Vega born?", "Who wrote La Colmena?", "What was the name of Don Quixote's horse?",
				"Who wrote Dr. Jekyll and Mr. Hyde?", "Where was El Greco born?", 
				"Which painter did the group Mecano write a song about?", "Who wrote the Satanic Verses?",
		"Who was Robin Hood's girlfriend?"};

		//array that holds hard arts & literature answers
		String [] artsHardAs = {"Esperanto","Anonymous","Madrid","Cela","Rocinante",
				"Robert Louis Stevenson","Greece","Dali","Salman Rushdie","Maid Marian"};

		if(cat.equalsIgnoreCase("a") && level.equalsIgnoreCase("hard")){ //if hard category is picked
			quesNum = rand.nextInt(10); //chooses random question
			System.out.print("\nYour question, worth 5 points, is: " + artsHardQs[quesNum] + " "); // outputs hard question
			answer = input.nextLine(); // gets answer
			if(artsHardAs[quesNum].equalsIgnoreCase(answer)){ // outputs statement if correct
				correct = true; //sets correct as true so points are added
			}else if(!artsHardAs[quesNum].equalsIgnoreCase(answer)) { // outputs statement if incorrect
				System.out.println("\nYou are incorrect. The correct answer is: " + artsHardAs[quesNum]); //outputs the correct answer
				correct = false; //sets correct as false so points are not added
			}
		}
	}

	//entertainment category

	//holds questions and answers for entertainment category
	public static void entertainQs(){

		//array that holds easy entertainment questions
		String [] entertainEasyQs = {"Who sang \"My Way\"?", "In which city is Hollywood?", "Who was the director of the film \"Psycho\"?", 
				"Who played the Nutty Professor in the 1996 remake of Jerry Lewis's film?", 
				"Who was cast as Princess Leia in Star Wars after her film debut in Shampoo with Warren Beatty?", 
				"What genre did Ice Cube define as \"the network newscast black people never had\"?", 
				"What TV cartoon character wrote on his school chalkboard. \"I will not aim at the head\" and \"My name is not Dr. Death\"?", 
				"How many brothers were in the original Jackson family line up?", "In 'Finding Nemo', what is Nemo's dad called?", 
		"Who is Shrek’s wife?"};

		//array that holds easy entertainment answers
		String [] entertainEasyAs = {"Frank Sinatra","Los Angeles","Alfred Hitchcock","Eddie Murphy","Carrie Fisher","Rap",
				"Bart Simpson","5","Marlin","Fiona"};

		if(cat.equalsIgnoreCase("b") && level.equalsIgnoreCase("easy")){	//if easy category is picked
			quesNum = rand.nextInt(10); //chooses random question
			System.out.print("\nYour question, worth 1 point, is: " + entertainEasyQs[quesNum] + " "); //outputs question
			answer = input.nextLine(); //gets answer
			if(entertainEasyAs[quesNum].equalsIgnoreCase(answer)){ // outputs statement if correct
				correct = true; //sets correct as true so points are added
			}else if(!entertainEasyAs[quesNum].equalsIgnoreCase(answer)) { // outputs statement if incorrect
				System.out.println("\nYou are incorrect. The correct answer is: " + entertainEasyAs[quesNum]); //outputs correct answer
				correct = false; //sets correct as false so points are not added
			}
		}

		// medium entertainment questions
		String [] entertainMediumQs = {"Who did John Lennon marry?", "What year did Elvis Presley die?", 
				"Which band produced the album Dark Side Of The Moon?", "Tusk was a best-selling album for which band?", 
				"Who played Neo in The Matrix?", "Who was the director of the Lord of the Rings trilogy?", 
				"What book did E.B. White base on personal experiences at his farm in Maine?", 
				"Which was the last feature film of screen legend Paul Newman, which was also the highest grossing movie of his career?", 
				"In the Harry Potter film franchise, what does the Hogwarts motto \"Draco dormiens nunquam titillandus\" mean?", 
		"What movie is this quote from? I'll get you, my pretty, and your little dog too!"};

		// medium entertainment answers
		String [] entertainMediumAs = {"Yoko Ono","1977","Pink Floyd","Fleetwood Mac","Keanu Reeves",
				"Peter Jackson","Charlotte’s Web","Cars","Never tickle a sleeping dragon","The Wizard of Oz"};

		if(cat.equalsIgnoreCase("b") && level.equalsIgnoreCase("medium")){ 		//if medium category is picked
			quesNum = rand.nextInt(10); //chooses random question
			System.out.print("\nYour question, worth 3 points, is: " + entertainMediumQs[quesNum] + " "); //outputs question
			answer = input.nextLine(); //gets answer
			if(entertainMediumAs[quesNum].equalsIgnoreCase(answer)){ // outputs statement if correct
				correct = true; //sets correct as true so points are added
			}else if(!entertainMediumAs[quesNum].equalsIgnoreCase(answer)) { // outputs statement if incorrect
				System.out.println("\nYou are incorrect. The correct answer is: " + entertainMediumAs[quesNum]); //outputs correct answer
				correct = false; //sets correct as false so points are not added
			}
		}

		//array that holds hard entertainment questions
		String [] entertainHardQs = {"Who was the main actor in Superman 2?", "What was the first film with sound?", 
				"Who was the narrator for English language version of the movie March of the Penguins?", 
				"When was Elvis' first ever concert?", "Janet Leigh played one of the most horrific scenes where in a motel?", 
				"Which writer of children's books also wrote Tales of the Unexpected for television and the screenplay for the "
						+ "film You Only Live Twice?", "What was the screen name of Lee Yuen Kam?", 
						"Which Viennese composer left his eighth symphony unfinished?", "How many oscars did Alfred Hitchcock win?", 
		"Which instrument does Nigel Kennedy play?"};

		// hard entertainment answers
		String [] entertainHardAs = {"Christopher Reeve","The Jazz Singer","Morgan Freeman","1954",
				"The shower","Roald Dahl","Bruce Lee","Schubert","None","Violin"};

		if(cat.equalsIgnoreCase("b") && level.equalsIgnoreCase("hard")){ 	//if hard category is picked
			quesNum = rand.nextInt(10); //chooses random question
			System.out.print("\nYour question, worth 5 points, is: " + entertainHardQs[quesNum] + " ");  //outputs question
			answer = input.nextLine(); //gets answer
			if(entertainHardAs[quesNum].equalsIgnoreCase(answer)){ // outputs statement if correct
				correct = true; //sets correct as true so points are added
			}else if(!entertainHardAs[quesNum].equalsIgnoreCase(answer)) { // outputs statement if incorrect
				System.out.println("\nYou are incorrect. The correct answer is: " + entertainHardAs[quesNum]); //outputs correct answer
				correct = false; //sets correct as false so points are not added
			}
		}

	}

	//holds questions and answers for geography category

	//geography category
	public static void geographyQs(){

		//array that holds easy geography questions
		String [] geoEasyQs = {"Which is the largest ocean?", "What's the smallest country in the world?",
				"What's the capital of Denmark?", 
				"How many states are there in the United States of America?",
				"Which German city is famous for the perfume it produces?",
				"What's the highest mountain in the world?", "Which is bigger, a lake or an ocean?", 
				"What is the capital city of Norway?", "What is the biggest state in the USA?", 
		"Which country has the biggest land area?"};

		//array that holds easy geography answers
		String [] geoEasyAs = {"Pacific","Vatican City","Copenhagen","50",
				"Cologne","Everest","Ocean","Oslo","Alaska","Russia"};

		if(cat.equalsIgnoreCase("c") && level.equalsIgnoreCase("easy")){  //if easy category is picked
			quesNum = rand.nextInt(10); //chooses random question
			System.out.print("\nYour question, worth 1 point, is: " + geoEasyQs[quesNum] + " "); //outputs question
			answer = input.nextLine(); //gets answer
			if(geoEasyAs[quesNum].equalsIgnoreCase(answer)){ // outputs statement if correct
				correct = true; //sets correct as true so points are added
			}else if(!geoEasyAs[quesNum].equalsIgnoreCase(answer)) { // outputs statement if incorrect
				System.out.println("\nYou are incorrect. The correct answer is: " + geoEasyAs[quesNum]);
				correct = false; //sets correct as false so points are not added
			}
		}

		//array that holds medium geography questions
		String [] geoMediumQs = {"What's the capital of Finland?", "What's the capital of Brazil?", 
				"What is the name of the tallest mountain in Japan?", 
				"Which country has the longest shoreline?", 
				"What is the only continent without a desert?", 
				"Which country produces the most bananas?", 
				"Which is Britain's second largest city?", "Which is the smallest ocean?", 
				"What's the capital of Monaco?", "What's the largest city in India?"};

		//array that holds medium geography answers
		String [] geoMediumAs = {"Helsinki","Brasilia","Mount Fuji","Canada","Europe",
				"India","Birmingham","Arctic Ocean","Monaco","Bombay"};

		if(cat.equalsIgnoreCase("c") && level.equalsIgnoreCase("medium")){ //if medium category is picked
			quesNum = rand.nextInt(10); //chooses random question
			System.out.print("\nYour question, worth 3 points, is: " + geoMediumQs[quesNum] + " "); //outputs question
			answer = input.nextLine(); //gets answer 
			if(geoMediumAs[quesNum].equalsIgnoreCase(answer)){ // outputs statement if correct
				correct = true; //sets correct as true so points are added
			}else if(!geoMediumAs[quesNum].equalsIgnoreCase(answer)) { // outputs statement if incorrect
				System.out.println("\nYou are incorrect. The correct answer is: " + geoMediumAs[quesNum]);
				correct = false; //sets correct as false so points are not added
			}
		}

		//array that holds hard geography questions
		String [] geoHardQs = {"What's the highest mountain in Africa?",
				"What's the capital of Honduras?", "What is the capital of Australia?", 
				"What's the capital of Ecuador?", "Which river goes through London?", 
				"Where are the Luxembourg Gardens?", 
				"Which mountains are between Spain and France?", 
				"Which river passes through Madrid?", 
				"How many avenues radiate from the Arc de Triomphe in Paris?", 
		"Where are the Dolomites?"};

		//array that holds hard geography answers
		String [] geoHardAs = {"Kilimanjaro","Tegucigalpa","Canberra","Quito","Thames",
				"Paris","Pyrenees","Manzanares","12","Italy"};

		if(cat.equalsIgnoreCase("c") && level.equalsIgnoreCase("hard")){ //if hard category is picked
			quesNum = rand.nextInt(10); //chooses random question
			System.out.print("\nYour question, worth 5 points, is: " + geoHardQs[quesNum] + " "); //outputs question
			answer = input.nextLine(); //gets answer
			if(geoHardAs[quesNum].equalsIgnoreCase(answer)){ // outputs statement if correct
				correct = true; //sets correct as true so points are added
			}else if(!geoHardAs[quesNum].equalsIgnoreCase(answer)) { // outputs statement if incorrect
				System.out.println("You are incorrect. The correct answer is: " + geoHardAs[quesNum]);
				correct = false; //sets correct as false so points are not added
			}
		}
	}

	//history category

	//holds questions and answers for history category
	public static void historyQs(){

		//array that holds easy history questions
		String [] historyEasyQs = {"What year did Christopher Columbus go to America?",
				"What year did the Spanish Civil War end?", "When did the First World War start?",
				"When did the Second World War end?", "Who was the first president of America?", 
				"What's the real name of Siddhartha Gautama?", "Who was the first man on the moon?", 
				"Who did Lady Diana Spencer marry?", 
				"Where did the first atomic bomb explode for the first time in Japan?",
		"What's the name of the famous big clock in London?"};

		//array that holds easy history answers
		String [] historyEasyAs = {"1492","1939","1914","1945","Washington","Buddha",
				"Neil Armstrong","Prince Charles","Hiroshima","Big Ben"};

		if(cat.equalsIgnoreCase("d") && level.equalsIgnoreCase("easy")){ //if easy category is picked
			quesNum = rand.nextInt(10); //chooses random question
			System.out.print("\nYour question, worth 1 point, is: " + historyEasyQs[quesNum] + " "); //outputs question
			answer = input.nextLine(); //gets answer
			if(historyEasyAs[quesNum].equalsIgnoreCase(answer)){ // outputs statement if correct
				correct = true; //sets correct as true so the points are added
			}else if(!historyEasyAs[quesNum].equalsIgnoreCase(answer)) { // outputs statement if incorrect
				System.out.println("\nYou are incorrect. The correct answer is: " + historyEasyAs[quesNum]); //outputs correct answer
				correct = false; //sets correct as true so the points are added
			} 
		}

		//array that holds medium history questions
		String [] historyMediumQs = {"Can Queen Elizabeth the Second vote?", 
				"When did the Americans leave Vietnam?", 
				"How many children has Queen Elizabeth the Second got?",
				"How many wives did Henry the Eighth have?", 
				"Where was Marco Polo's home town?", "When did the American Civil War end?", 
				"Who gave his name to the month of July?", 
				"What country gave Florida to the USA in 1891?", 
				"When was President Kennedy killed?", "What nationality was Marco Polo?"};

		//array that holds medium history answers
		String [] historyMediumAs = {"No","1973","4","6","Venice","1865","Julius Caesar",
				"Spain","1963","Italian"};

		if(cat.equalsIgnoreCase("d") && level.equalsIgnoreCase("medium")){ 	//if medium category is picked
			quesNum = rand.nextInt(10); //chooses random question
			System.out.print("\nYour question, worth 3 points, is: " + historyMediumQs[quesNum] + " "); //outputs question
			answer = input.nextLine(); //gets answer
			if(historyMediumAs[quesNum].equalsIgnoreCase(answer)){ // outputs statement if correct
				correct = true; //sets correct as true so the points are added
			}else if(!historyMediumAs[quesNum].equalsIgnoreCase(answer)) { // outputs statement if incorrect
				System.out.println("\nYou are incorrect. The correct answer is: " + historyMediumAs[quesNum]);
				correct = false; //sets correct as false so the points are not added
			} 
		}

		//array that holds hard history questions
		String [] historyHardQs = {"When did the first man go into space?", 
				"Which Italian leader was terribly afraid of the evil eye?",
				"What stopped in London at 3.45 on August 5th, 1975?",
				"How many fingers did Anne Boleyn have?", 
				"Where was Christopher Columbus born?",
				"Who said, \"Veni, vidi, vici\"?", "What did the Montgolfier brothers invent?", 
				"What year did King Juan Carlos get married?", 
				"Who did Prince Rainier of Monaco marry?", 
		"In what decade was the last execution at the Tower of London?"};

		//array that holds hard history answers
		String [] historyHardAs = {"1961","Mussolini","Big Ben","11","Genoa","Julius Caesar", 
				"the balloon","1962","Grace Kelly","1940"};

		if(cat.equalsIgnoreCase("d") && level.equalsIgnoreCase("hard")){ //if hard category is picked
			quesNum = rand.nextInt(10); //chooses random question
			System.out.print("\nYour question, worth 5 points, is: " + historyHardQs[quesNum] + " "); //outputs question
			answer = input.nextLine(); //gets answer 
			if(historyHardAs[quesNum].equalsIgnoreCase(answer)){ // outputs statement if correct
				correct = true; //sets correct as true so the points are added
			}else if(!historyHardAs[quesNum].equalsIgnoreCase(answer)) { // outputs statement if incorrect
				System.out.println("\nYou are incorrect.  The correct answer is: " + historyHardAs[quesNum]);
				correct = false; //sets correct as false so the points are not added
			} 
		}

	}

	//sports category

	//holds questions and answers for sports & leisure category
	public static void sportsQs(){

		//array that holds easy sports & leisure questions
		String [] sportsEasyQs = {"Which sportsman, usually described as the greatest basketballer of all time, "
				+ "liked to wear special shorts under his uniform every time he played?", "Despite being one of the best "
						+ "football players in the world, I've never played for a European club. I've won three World Cups. "
						+ "My real name is Edson Arantes do Nascimento. Who am I?", "How long does a rugby union match last for (in minutes)?",
						"Soccer: Which nation hosted and won the first ever World Cup?", "What does NHL stand for?", 
						"In what sport would you resort to 'sooping'?", "How long is a round in boxing (in minutes)?", 
						"How many coloured balls are there in billiards?", "How many lanes does an olympic swimming pool have?", 
		"Who starts first in chess?"};

		//array that holds easy sports & leisure answers
		String [] sportsEasyAs = {"Michael Jordan","Pele","80","Uruguay","National Hockey League","Curling",
				"3","15","8","white"};

		if(cat.equalsIgnoreCase("e") && level.equalsIgnoreCase("easy")){ //if easy category is picked
			quesNum = rand.nextInt(10); //chooses random question
			System.out.print("\nYour question, worth 1 point, is: " + sportsEasyQs[quesNum] + " "); //outputs question
			answer = input.nextLine(); //gets answer
			if(sportsEasyAs[quesNum].equalsIgnoreCase(answer)){ // outputs statement if correct
				correct = true; //sets correct to true so points are added
			}else if(!sportsEasyAs[quesNum].equalsIgnoreCase(answer)) { // outputs statement if incorrect
				System.out.println("\nYou are incorrect. The correct answer is: " + sportsEasyAs[quesNum]);
				correct = false; //sets correct to false so points are not added
			} 
		}

		// medium sports & leisure questions
		String [] sportsMediumQs = {"Pakistan's Jahangir Khan is widely considered the greatest player in the history of which sport?",
				"In amateur wrestling, how many points is an escape worth?", 
				"In football (soccer), which player is allowed to touch the ball with his hand anywhere on the field of play?", 
				"My middle name is Fred and I eat roughly 12000 calories a day, I need them, my training regime is brutal but it "
						+ "is worth it due to the fact that, in 2008, I became the 'Golden' boy of the pool?", 
						"Who was the first team to win the English League Cup and the F.A. Cup in the same season?", 
						"Which team won the NBA championship title in 2006?", "Which NFL team was the first to win five Super Bowls?", 
						"Who is the tallest basketball player in the world?", "How many eyes are there on a pack of 52 cards?", 
		"What is professional wrestler, John Cena, catch phrase?"};

		// medium sports & leisure answers
		String [] sportsMediumAs = {"Squash","1","None","Michael Phelps","Arsenal","Miami Heat","San Francisco 49ers",
				"Manute Bol","42","You can't see me"};

		if(cat.equalsIgnoreCase("e") && level.equalsIgnoreCase("medium")){ 	//if medium category is picked
			quesNum = rand.nextInt(10); //chooses random question
			System.out.print("\nYour question, worth 3 points, is: " + sportsMediumQs[quesNum] + " "); //outputs question
			answer = input.nextLine(); //gets answer
			if(sportsMediumAs[quesNum].equalsIgnoreCase(answer)){ // outputs statement if correct
				correct = true; //sets correct to true so points are added
			}else if(!sportsMediumAs[quesNum].equalsIgnoreCase(answer)) { // outputs statement if incorrect
				System.out.println("\nYou are incorrect. The correct answer is: " + sportsMediumAs[quesNum]); //outputs correct answer
				correct = false; //sets correct to false so points are not added
			} 
		}

		//array that holds hard sports & leisure questions
		String [] sportsHardQs = {"In which city is the annual F1 Spanish Grand Prix held?", 
				"Which NBA legend won a record six league MVP awards?", "Who was the first left handed golfer to win the Masters?", 
				"How many Formula 1 Championships did Jackie Stewart win?", "Since the turn of the new millenium, "
						+ "five of the six Le Mans 24 hour endurance races were won by the same make of car. Name the manufacturer.",
						"Who won a gold medal for Spain in cycling in the 1992 Olympics?", "How many dots are there on two dice?",
						"How many squares are there on a chess board?", "What activity other than jumping are kangaroos good at?", 
		"How many events are there in the decathlon?"};

		//array that holds hard sports & leisure answers
		String [] sportsHardAs = {"Barcelona","Kareem Abdul-Jabbar","Mike Weir","3","Audi R8","Jose Manuel Moreno","42"
				,"64","Boxing","10"};

		if(cat.equalsIgnoreCase("e") && level.equalsIgnoreCase("hard")){ //if hard category is picked
			quesNum = rand.nextInt(10); // chooses random question
			System.out.print("\nYour question, worth 5 points, is: " + sportsHardQs[quesNum] + " "); //outputs question
			answer = input.nextLine(); //gets answer 
			if(sportsHardAs[quesNum].equalsIgnoreCase(answer)){ // outputs statement if correct
				correct = true; //sets correct to true so points are added
			}else if(!sportsHardAs[quesNum].equalsIgnoreCase(answer)) { // outputs statement if incorrect
				System.out.println("\nYou are incorrect. The correct answer is: " + sportsHardAs[quesNum]); //outputs correct answer 
				correct = false; //sets correct to false so points are not added
			}
		}
	}

	//science category

	//holds questions and answers for science & nature category
	public static void scienceQs(){

		//array that holds easy science questions
		String [] scienceEasyQs = {"How many colours are there in a rainbow?",
				"What is the most commonly diagnosed cancer in men?", "How many legs has a spider got?", 
				"Who invented the telephone?", "What temperature does water boil at (in Celsius)?",
				"Who invented the electric light bulb?", "The average human body contains how many pints of blood?",
				"Who said E=mc2?", "Which animal has the longest tongue relative to its total size?", 
		"Diamonds are made up almost entirely of what element?"};

		//array that holds easy science answers
		String [] scienceEasyAs = {"7","Prostate","8","Alexander Graham Bell","100",
				"Thomas Edison","10","Albert Einstein","Chameleon ","Carbon"};

		if(cat.equalsIgnoreCase("f") && level.equalsIgnoreCase("easy")){ //if easy category is picked
			quesNum = rand.nextInt(10); // chooses random question
			System.out.print("\nYour question, worth 1 point, is: " + scienceEasyQs[quesNum]+ " "); //outputs question
			answer = input.nextLine(); //gets answer 
			if(scienceEasyAs[quesNum].equalsIgnoreCase(answer)){ // outputs statement if correct
				correct = true; //sets correct to true so points are added
			}else if(!scienceEasyAs[quesNum].equalsIgnoreCase(answer)) { // outputs statement if incorrect
				System.out.println("\nYou are incorrect. The correct answer is: " + scienceEasyAs[quesNum]);
				correct = false; //sets correct to false so points are not added
			}
		}

		//array that holds medium science questions
		String [] scienceMediumQs = {"What does the female praying mantis do after she's made love?", 
				"Which nail grows fastest?", "Who discovered penicillin?", 
				"What's the smallest type of tree in the world?", 
				"What does the roman numeral C represent?", 
				"What's the hardest rock?", "How many time zones are there in the world?",
				"What is a group of whales called?", "What is the chemical formula for ozone?", 
		"What planet in our solar system has the most gravity?"};

		//array that holds medium science answers
		String [] scienceMediumAs = {"Eats the male","Middle","Alexander Fleming","Bonsai","100","Diamond","24",
				"A pod","O3","Jupiter"};

		if(cat.equalsIgnoreCase("f") && level.equalsIgnoreCase("medium")){ //if medium category is picked
			quesNum = rand.nextInt(10); // chooses random question
			System.out.print("\nYour question, worth 3 points, is: " + scienceMediumQs[quesNum] + " "); //outputs question
			answer = input.nextLine(); //gets answer
			if(scienceMediumAs[quesNum].equalsIgnoreCase(answer)){ // outputs statement if correct
				correct = true; //sets correct to true so points are added
			}else if(!scienceMediumAs[quesNum].equalsIgnoreCase(answer)) { // outputs statement if incorrect
				System.out.println("\nYou are incorrect. The correct answer is: " + scienceMediumAs[quesNum]);
				correct = false; //sets correct to false so points are not added
			}
		}

		//array that holds hard science questions
		String [] scienceHardQs = {"What type of elephant has got the biggest ears?", 
				"What did Joseph Priesley discover in 1774?", 
				"Where is the smallest bone in the body?", "Which is the only mammal that can't jump?",
				"Who invented television?", "Which planet is nearest the sun?", 
				"Which planet has the most moons?", 
				"How long does it take for light from the Sun to reach Earth? (in minutes and in seconds)", 
				"What was the first planet to be discovered using the telescope?", 
		"What is a meteor called when it reaches Earth's surface?"};

		//array that holds hard science answers
		String [] scienceHardAs = {"African","Oxygen","Ear","Elephant","John Logie Baird",
				"Mercury","Jupiter","8 minutes and 20 seconds","Uranus","Meteorite"};

		if(cat.equalsIgnoreCase("f") && level.equalsIgnoreCase("hard")){ //if hard category is picked
			quesNum = rand.nextInt(10); // chooses random question
			System.out.print("Your question, worth 5 points, is: " + scienceHardQs[quesNum] + " "); //outputs question
			answer = input.nextLine(); //gets answers
			if(scienceHardAs[quesNum].equalsIgnoreCase(answer)){ // outputs statement if correct
				correct = true; //sets correct to true so points are added
			}else if(!scienceHardAs[quesNum].equalsIgnoreCase(answer)) { // outputs statement if incorrect
				System.out.println("\nYou are incorrect. The correct answer is: " + scienceHardAs[quesNum]);
				correct = false; //sets correct to false so points are not added
			}
		}
	}

	//one-player game

	//holds the game for if only 1 player is playing
	public static void onePlayer() {
		player1turn = true; //makes it so that only player 1's turn will work
		player2turn = false; //makes it so that 2 players will not play
		player3turn = false; //makes it so that 3 players will not play
		player4turn = false; //makes it so that 4 players will not play
		System.out.println("\nWelcome to Trivial Pursuit " + player1 + "!"); //welcome message to the game
		do {
			cats(); //outputs the categories
			askQuestion(); //outputs questions depending on the categories
			points(); //keeps track of points
		}while(points1 < 25); //loops until the the player gets 25 points

		System.out.println("\n" + player1 + ", you have won Trivial Pursuit! Congratulations on being the smartest person in the world."); //ending message
	}

	//holds the game for if 2 players are playing

	//two-player game
	public static void twoPlayer(){
		player1turn = true; //makes it true that player 1 is a part of the game
		player2turn = true; //makes it true that player 2 is a part of the game
		player3turn = false; //player 2 is not a part of this game
		player4turn = false; //player 3 is not a part of this game

		if(numPlayers == 2){ //if the number of players is 2
			System.out.println("\nWelcome to Trivial Pursuit " + player1 + " & " + player2 + "!"); //welcome message
			do {
				turns(); //outputs the turns method which tells us whose turn it is & outputs the categories
				askQuestion(); //outputs the questions depending on the category
				points(); //keeps track of & adds points
			}while(points1 < 25 || points2 < 25); //loops until a player has hit 25 points

			if(points1 > 25) { //if player 1 has over 25 points before player 2
				System.out.println("\n" + player1 + ", you have won Trivial Pursuit! Congratulations on being the smartest person in the world."); //winner's message
			}else if(points2 > 25){ //if player 2 has over 25 points before player 1
				System.out.println("\n" + player2 + ", you have won Trivial Pursuit! Congratulations on being the smartest person in the world."); //winner's message
			}
		}
	}

	//three-player game

	//holds the game for if 3 players are playing
	public static void threePlayer() {

		player1turn = true; //player 1 is a part of this game
		player2turn = true; //player 2 is a part of this game
		player3turn = true; //player 3 is a part of this game
		player4turn = false; //player 4 is not a part of this game

		if(numPlayers == 3){
			System.out.println("\nWelcome to Trivial Pursuit " + player1 + ", " + player2 + " & " + player3 + "!"); //welcome message
			do {
				turns(); //outputs the turns method which tells us whose turn it is & outputs the categories
				askQuestion(); //outputs the questions depending on the category
				points(); //keeps track of & adds points
			}while(points1 < 25 || points2 < 25 || points3 < 25); //loops until a player has hit 25 points

			if(points1 > 25) { //if player 1 has over 25 points first
				System.out.println("\n" + player1 + ", you have won Trivial Pursuit! Congratulations on being the smartest person in the world."); //winner's message
			}else if(points2 > 25){ //if player 1 has over 25 points first
				System.out.println("\n" + player2 + ", you have won Trivial Pursuit! Congratulations on being the smartest person in the world."); //winner's message
			}else if(points3 >25) { //if player 3 has over 25 points first
				System.out.println("\n" + player3 + ", you have won Trivial Pursuit! Congratulations on being the smartest person in the world."); //winner's message
			}
		}
	}

	//four-player game

	//holds the game for if 4 players are playing
	public static void fourPlayer() {

		player1turn = true; //player 1 is a part of this game
		player2turn = true; //player 2 is a part of this game
		player3turn = true; //player 3 is a part of this game
		player4turn = true; //player 4 is a part of this game

		if(numPlayers == 4){
			System.out.println("\nWelcome to Trivial Pursuit " + player1 + ", " + player2 + " & " + player3 + "!"); //welcome message
			do {
				turns(); //outputs the turns method which tells us whose turn it is & outputs the categories
				askQuestion(); //outputs the questions depending on the category
				points(); //keeps track of & adds points
			}while(points1 < 25 || points2 < 25 || points3 < 25 || points4 < 25); //loops until a player has hit 25 points

			if(points1 > 25) { //if player 1 has over 25 points first
				System.out.println("\n" + player1 + ", you have won Trivial Pursuit! Congratulations on being the smartest person in the world."); //winner's message
			}else if(points2 > 25){ //if player 2 has over 25 points first
				System.out.println("\n" + player2 + ", you have won Trivial Pursuit! Congratulations on being the smartest person in the world."); //winner's message
			}else if(points3 > 25) { //if player 3 has over 25 points first
				System.out.println("\n" + player3 + ", you have won Trivial Pursuit! Congratulations on being the smartest person in the world."); //winner's message
			}else if(points4 > 25) {//if player 4 has over 25 points first
				System.out.println("\n" + player4 + ", you have won Trivial Pursuit! Congratulations on being the smartest person in the world."); //winner's message
			}
		}
	}

	//asks questions

	//method that holds the games depending on how many players are player
	public static void chooseGame() {
		if (numPlayers == 1){ //if only 1 player is playing
			onePlayer(); //outputs the 1 player game
		} else if(numPlayers == 2){ //if 2 players are playing
			twoPlayer(); //outputs the 2 player game
		}else if(numPlayers == 3) { //if 3 players are playing
			threePlayer(); //outputs the 3 player game
		}else if(numPlayers == 4) { //if 4 players are playing
			fourPlayer(); //outputs the 4 player game
		}
	}

	//M A I N  M E T H O D

	//main method
	public static void main(String[] args) {
		intro(); //outputs introduction
		menu(); //outputs the menu that holds instructions & # of players
		playersMenu(); //asks for players' names
		chooseGame(); //outputs the games depending on how many players are player
	}
}




