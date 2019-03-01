
public class JJNB_Rifler extends JJNB_Player {
	private double adr;
	
	public JJNB_Rifler() { //default constructor
		super();
		adr = 0;
	}
	
	public JJNB_Rifler(double nadr) { //non-default constructor
		super();
		adr = nadr;
	}
	
	public JJNB_Rifler(String name, double kd, int winnings, double rating, double nadr, JJNB_Team nTeam) { //second non-default constructor
		super(name, kd, winnings, rating, nTeam); //puts nondefault instances of the parent variables
		adr = nadr;
	}
	//get and set methods
	public double getRoleStat () {
		return adr;
	}
	
	public void setRoleStat (double setnadr) {
		adr = setnadr;
	}
	
	//toString that overrides the parent's toString method
	public String toString () {
		String line = super.toString() + "  Player's average damage per round: " + adr;
		return line;
	}
	
	public boolean equals (JJNB_Rifler rifler) {
		boolean check = false;
		if (Math.abs(adr - rifler.getRoleStat()) < .001 && super.equals((JJNB_Player) rifler)) { //makes sure it's the correct rifler
			check = true;
		}
		else {
			check = false;
		}
		return check;
	}
	
	public int compareAdr (JJNB_Rifler rifler) {
		int check = -1;
		if (adr - rifler.getRoleStat() > 0) {
			check = 1;
		}
		else if (adr == rifler.getRoleStat()) {
			check = 0;
		}
		else {
			check = -1;
		}
		return check;
	}
}
