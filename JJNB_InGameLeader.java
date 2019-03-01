
public class JJNB_InGameLeader extends JJNB_Player{
	private double clutches;
	
	public JJNB_InGameLeader() { //default
		super();
		clutches = 0;
	}
	
	public JJNB_InGameLeader(double nclutch) { //non-default
		super();
		clutches = nclutch;
	}
	
	public JJNB_InGameLeader(String name, double kd, int winnings, double rating, double nclutch, JJNB_Team nteam) { //second non-default
		super(name, kd, winnings, rating, nteam); //puts nondefault instances of the parent variables
		clutches = nclutch;
	}
	
	//accesor and mutator methods
	public double getRoleStat () {
		return clutches;
	}
	
	public void setRoleStat (double setClu) {
		clutches = setClu;
	}
	
	public String toString () {
		String line = super.toString() + "  Number of clutches made: " + clutches; //overrides the parent's toString method
		return line;
	}
	
	public boolean equals (JJNB_InGameLeader igl) {
		boolean check = false;
		if (super.equals((JJNB_Player)igl) && Math.abs(clutches - igl.getRoleStat()) < .01) { //makes sure it's the correct igl
			check = true;
		}
		else {
			check = false;
		}
		return check;
	}
	
	public int compareClutches (JJNB_InGameLeader igl) {
		int check = -1;
		if (clutches - igl.getRoleStat() > 0) {
			check = 1;
		}
		else if (clutches == igl.getRoleStat()) {
			check = 0;
		}
		else {
			check = -1;
		}
		return check;
	}
}