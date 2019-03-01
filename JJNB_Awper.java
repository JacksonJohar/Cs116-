
public class JJNB_Awper extends JJNB_Player{
	private double openPicks;
	
	public JJNB_Awper() {// default
		super();
		openPicks = 0;
	}
	
	public JJNB_Awper(double op) { //non-default
		super();
		openPicks = op;
	}
	
	public JJNB_Awper(String name, double kd, int winnings, double rating, double op, JJNB_Team nTeam) { //second non-default
		super(name, kd, winnings, rating, nTeam); //puts nondefault instances of the parent variables
		openPicks = op;
	}
	
	//gets and sets methods
	public double getRoleStat () {
		return openPicks;
	}
	
	public void setRoleStat (double setPick) {
		openPicks = setPick;
	}
	
	public String toString () {
		String line = super.toString() + " Opening pick rate: " + openPicks; //overrides the parent's toString
		return line;
	}
	
	public boolean equals (JJNB_Awper awp) {
		boolean check = false;
		if (Math.abs(openPicks - awp.getRoleStat()) < .001 && super.equals((JJNB_Player) awp)) { //makes sure it's the same awper
			check = true;
		}
		else {
			check = false;
		}
		return check;
	}
	
	public int comparePicks (JJNB_Awper awp) {
		int check = -1;
		if (openPicks - awp.getRoleStat() > 0) {
			check = 1;
		}
		else if (openPicks == awp.getRoleStat()) {
			check = 0;
		}
		else {
			check = -1;
		}
		return check;
	}
}
