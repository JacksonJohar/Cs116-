/*
 * Jackson Johar and Norina Balderas
 * Winans
 * CS116
 * 
 * This application's purpose is to search and sort for specific statistics based on what the user wants. So, if they want to look for a certain player 
 * in a certain role, it will spit out the statistics of that player, and the same thing goes for teams.
 */


import java.io.*;
import java.util.Scanner;
public class JoharBalderas_Final {
	public static void main(String[] args){
		//reading in the text file
		try {
		FileInputStream csgo = new FileInputStream("top15csgo.txt");
		SearchNSort playerArr = new SearchNSort();
		SearchNSort teamArr = new SearchNSort();
		JJNB_Team teamObj;
		//instant of Player class is not needed, bc of polymorphism xD
		JJNB_Awper awp;
		JJNB_Rifler rifler;
		JJNB_InGameLeader igl = new JJNB_InGameLeader();
		Scanner scan = new Scanner(csgo);
		String scnln;
		String [] tokens;
		int i = 0;
		
		//scanning in the text file into the object array list
		while (scan.hasNext()) {
			scnln = scan.nextLine();
			tokens = scnln.split(",");
			if (tokens.length == 3) { //scans the teams into the team array
				teamObj = new JJNB_Team(tokens[0], Double.parseDouble(tokens[1]), tokens[2]);
				scnln = "";
				for (i = 0; i < 5; i++) { //scanning in the players from each team; each team has five players
					if (scan.hasNextLine()) {
					scnln = scan.nextLine();
					tokens = scnln.split(",");
					}
					//the fourth token contain the player roles
					if (tokens[4].equals("Rifler")) {
						rifler = new JJNB_Rifler(tokens[0], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]), Double.parseDouble(tokens[5]), teamObj);
						playerArr.add(rifler);
						
					} 
					else if(tokens[4].equals("Awper")) {
						awp = new JJNB_Awper(tokens[0], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]), Double.parseDouble(tokens[5]), teamObj);
						playerArr.add(awp);
					}
					else if (tokens[4].equals("IGL")) {
						igl = new JJNB_InGameLeader(tokens[0], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]), Double.parseDouble(tokens[5]), teamObj);
						playerArr.add(igl);
					}
				}
			}
		}
		scan.close();
		//menu call 
		String quit = "quit";
		String menu = "menu";
		boolean run = true;
		Scanner scnr = new Scanner (System.in);
		String usrEnter;
		while (run) {
			System.out.print("Enter menu for menu OR quit for quit: ");
			usrEnter = scnr.next();
			if (menu.equals(usrEnter.toLowerCase())) {
				menu(playerArr);
				run = false; //stops loop
			}
			else if (usrEnter.toLowerCase().equals(quit)) {
				System.out.println("Thank you, and goodbye.");
				run = false;
			}
			else {
				System.out.println("Error! Your input was not menu or quit. Please try again."); //continues to prompt for menu or quit until the correct input is received
			}
		}
		}
		catch (FileNotFoundException fnfe) {
			System.err.println("File not found, sorry.");
		}
	}//main
	
	
	public static void menu (SearchNSort player) {
		try {
		File ofile = new File("csgo_output.txt");
		FileOutputStream out = new FileOutputStream (ofile);
		PrintWriter pw = new PrintWriter (out, true);
		Scanner mScan = new Scanner (System.in);
		boolean run = true;
		String userWant;
		String name;
		String search = "search";
		String sort = "sort";
		String alter = "alter";
		String quit = "quit";
		String kd = "kd";
		String role = "rolestat";
		String rating = "rating";
		String garb = ""; //to hold scans that could turn into run time errors
		int i;
		
		while (run) {
			System.out.print("Search, sort, delete, add, or quit?: ");
			userWant = mScan.next();
			//searching
			if (search.equals(userWant.toLowerCase())) {
				System.out.println("Who are you looking for? A team, a player, or all players of a role(awper, rifler, ingameleader)? ");
				System.out.print("Enter team, player, or any of the roles(awper, rifler, ingameleader): ");
				userWant = mScan.next().toLowerCase();
				int pLoc;
				if (userWant.equals("player")) {
					System.out.print("Enter the player's name you're looking for: ");
					name = mScan.next();
					pLoc = player.nameSearch(name); //calls nameSearch() method from SearchNSort
					pw.println("Searched for: " + name);
					if(pLoc != -1)
					System.out.println("Player found: " + player.getObject(pLoc).toString());
					garb = mScan.nextLine();
				} else if (userWant.equals("team")) { 
					System.out.print("Enter the Team's name you're looking for: ");
					name = mScan.next();
					pw.println("Team searched for: " + name);
					player.teamSearch(name); //calls teamSearch() method from SearchNSort
					garb = mScan.nextLine();
				} else if (userWant.equals("awper") || userWant.equals("rifler") || userWant.equals("ingameleader")) {
					pw.println("Role searched for: " + userWant);
					player.roleSearch(userWant); //calls roleSearch() method from SearchNSort
					garb = mScan.nextLine();
				}
			//adding and deleting
			} 
			else if (userWant.equals("add")) {
					player.addPlayer(player); //calls the addPlayer() from ObjArray
					pw.println("Player added: " + player.getObject(player.getIndex()-1));
				}
			else if (userWant.equals("delete")) {
					int pLoc;
					System.out.print("Enter the player's name that you would like to delete: ");
					userWant = mScan.next().toLowerCase();
					garb = mScan.nextLine();
					pLoc = player.nameSearch(userWant);
					if (pLoc != -1 && player.getIndex() > 0) { //makes sure that the player exists before deleting
						//prints out who the user intended to delete, and then prints what was deleted
						System.out.println("Delete: " + userWant);
						System.out.println("Player deleted: " + player.getObject(pLoc).toString()); 
						pw.println("Player deleted: " + player.getObject(pLoc).toString());
						player.delete(pLoc);
					}
					else {
						System.out.println("Player not found.");
					}
				}
			else if (sort.equals(userWant.toLowerCase())) {
				String nameSrch = "name";
				System.out.println("Would you like to sort by k/d, rating, name, or role statistics?");
				System.out.print("Enter kd, rating, name, or rolestat: ");
				userWant = mScan.next().toLowerCase();
				garb = mScan.nextLine();
				if (userWant.equals(nameSrch)) {
					player.selectSort();
					//print to output
					pw.println("Sorting by name: ");
					for (i = 0; i < player.getIndex(); i++) {
						System.out.println(player.getObject(i).toString());
						pw.println(player.getObject(i).toString());
					}
				}
				else if (userWant.equals(kd.toLowerCase())) {
					player.kdSort();
					//print to output
					pw.println("Sorting by kd: ");
					for (i = 0; i < player.getIndex(); i++) {
						System.out.println(player.getObject(i).toString());
						pw.println(player.getObject(i).toString());
					}
				}
				else if (userWant.equals(rating.toLowerCase())) {
					player.ratingSort();
					//print to output
					pw.println("Sorting by rating: ");
					for (i = 0; i < player.getIndex(); i++) {
						System.out.println(player.getObject(i).toString());
						pw.println(player.getObject(i).toString());
					}
				}
				else if (userWant.equals(role.toLowerCase())) {
					System.out.print("Would you like to sort the Awpers, Riflers, InGameLeaders, or All?: ");
					if (mScan.hasNext()) {
						userWant = mScan.next().toLowerCase();
						garb = mScan.nextLine();
						pw.println("Sorting by role: ");
						if (userWant.equals("all")) {
							player.roleStatSort();
							pw.println("All roles: ");
							for (i = 0; i < player.getIndex(); i++) {
								System.out.println(player.getObject(i).toString());
								pw.println(player.getObject(i).toString());
							}
						} 
						else if (userWant.equals("riflers")) {
							player.rifleSort();
							pw.println("Riflers: ");
							for (i = 0; i < player.getIndex(); i++) {
								if ((player.getObject(i).getClass().getSimpleName().equals("JJNB_Rifler"))) {
									System.out.println(player.getObject(i).toString());
									pw.println(player.getObject(i).toString());
								}
							}
						}
						else if (userWant.equals("awpers")) {
							player.rifleSort();
							pw.println("Awpers: ");
							for (i = 0; i < player.getIndex(); i++) {
								if ((player.getObject(i).getClass().getSimpleName().equals("JJNB_Awper"))) {
									System.out.println(player.getObject(i).toString());
									pw.println(player.getObject(i).toString());
								}
							}
						}
						else if (userWant.equals("ingameleaders")) {
							player.rifleSort();
							pw.println("In Game Leaders: ");
							for (i = 0; i < player.getIndex(); i++) {
								if ((player.getObject(i).getClass().getSimpleName().equals("JJNB_InGameLeader"))) {
									System.out.println(player.getObject(i).toString());
									pw.println(player.getObject(i).toString());
								}
							}
						}
					}
				}
			}
			else if (quit.equals(userWant.toLowerCase())) {
				System.out.println("Thank you, and goodbye.");
				run = false; //exits out of menu prompt loop
			}
		}
	mScan.close();
		}
		catch (FileNotFoundException fnfe) {
			System.err.println("Not found, sorry.");
		}
	}//menu
	
}
