
	//Import to generate random value
	import java.util.Random;
	//Import to create ArrayList
	import java.util.ArrayList;
	import edu.cmu.ri.createlab.terk.robot.finch.Finch;
	import javax.swing.JOptionPane;
	import java.awt.Color;
	 
	public class FinchGame {
	    public static void main(String args[]) {
	        //Creating 5 instances of robots
	        Finch red_bot = new Finch();
	        Finch blue_bot = new Finch();
	        Finch yellow_bot = new Finch();
	        Finch green_bot = new Finch();
	        Finch switch_bot = new Finch();
	               
	        String colors[] = {"red", "yellow" , "blue", "green"};//Colours to be picked
	       
	        ArrayList<String> game_s = new ArrayList<String>();//Declaring the game sequence as a list
	        ArrayList<String> player_s = new ArrayList<String>();//Declaring user player sequence as a list
	        int score = 0;
	       
	        game_s.add((colors[new Random().nextInt(colors.length)]));//starts with one random colour on the game sequence
	       
	        //Execute code as long as the fifth finch does not have its beak up
	        while(!switch_bot.isBeakUp())
	        {
	            System.out.println(score);//Just displaying the score value
	           
	            for(int i = 0; i < game_s.size(); i++)
	            {
	                //Displays current sequence of the game_s list
	                System.out.println("Sequence " + (i + 1) + ":");
	                for (int j = 0; j < game_s.size(); j++)
	                {
	                    int duration = 2000;
	                    //If the current value of game_s is red, flash the red bot
	                    if (game_s.get(j).equals("red")) {
	                        red_bot.setLED(Color.red, duration);
	                        System.out.println(game_s.get(j));
	                    }
	                    //If the current value of game_s is blue, flash the blue bot
	                    else if (game_s.get(j).equals("blue")) {
	                        blue_bot.setLED(Color.blue, duration);
	                        System.out.println(game_s.get(j));
	                    }
	                    //If the current value of game_s is yellow, flash the yellow bot
	                    else if (game_s.get(j).equals("yellow")) {
	                        yellow_bot.setLED(Color.yellow, duration);
	                        System.out.println(game_s.get(j));
	                    }
	                    //If the current value of game_s is green, flash the green bot
	                    else if (game_s.get(j).equals("green")) {
	                        green_bot.setLED(Color.green, duration);
	                        System.out.println(game_s.get(j));
	                    }
	                    else {
	                        System.out.println("My Dude, this program sucks");
	                    }
	                }
	               
	                //Loop to enter values on the player_sequence list
	                for(int k = 0; k < game_s.size(); k++)
	                {
	                    System.out.println("Point one of the finch upwards");
	                    JOptionPane.showMessageDialog(null,"Tap One of the bots and click ok...");//User needs to point finch and then click ok on screen
	                    //Thinking of adding this instead of the dialog box:
	                    //this should pause program for as long as the bots did not get tapped. leaving it out as a comment as needs to be tested first
	                    /*while(!red_bot.isTapped() || !blue_bot.isTapped() ||
	                     *      !yellow_bot.isTapped || !green_bot.isTapped){
	                            Thread.sleep();
	                           
	                        }  
	                    */
	                    //Thinking of changing from beak up back to tap if the commented code above works
	                    //If the red bot beak is up, add the string "red" on the player sequence
	                    if(red_bot.isBeakUp()) {
	                        red_bot.setLED(Color.red, 200);
	                        player_s.add("red");
	                    }
	                   
	                    //If the blue bot beak is up, add the string "blue" on the player sequence
	                    else if(blue_bot.isBeakUp()) {
	                        blue_bot.setLED(Color.blue, 200);
	                        player_s.add("blue");
	                    }
	                   
	                    //If the yellow bot beak is up, add the string "yellow" on the player sequence
	                    else if(yellow_bot.isBeakUp()) {
	                        yellow_bot.setLED(Color.yellow, 200);
	                        player_s.add("yellow");
	                    }
	                   
	                    //If the green bot beak is up, add the string "green" on the player sequence
	                    else if(green_bot.isBeakUp()) {
	                        green_bot.setLED(Color.green, 200);
	                        player_s.add("green");
	                    }
	                   
	                    else {
	                        System.out.println("My Dude, this program sucks");
	                    }
	                    //checking if string stored in player_s match with game_s, this will be checked every time the player chooses a bot to lift
	                    if(game_s.get(k).equals(player_s.get(k)))
	                    {                      
	                        continue;
	                    }
	                    //if it doesn't match...
	                    else
	                    {
	                        player_s.clear();//...clear all values from player sequence and game sequence and then stop the loop
	                        game_s.clear();
	                        break;
	                    }
	                }
	               
	                //Once every value is added to the player list without breaks, it will be equal to the game sequence...
	                if(game_s.equals(player_s))
	                {  
	                    player_s.clear();//clear player sequence as the player needs to type the sequence again
	                    game_s.add((colors[new Random().nextInt(colors.length)]));//...Therefore add another random color to the game sequence
	                   
	                }
	                else {
	                    break;
	                }
	            }
	            System.out.println("Game Over");//if player sequence is not equal to game sequence, break out of the loop and display game over
	            System.out.println("Would You Like To Continue?");
	           
	        }
	        System.out.println("Thank you for playing!");//Closing message
	    }      
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
