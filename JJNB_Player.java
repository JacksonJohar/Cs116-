
public class JJNB_Player implements Comparable <JJNB_Player>{
	protected String pName;
	protected double pKD;
	protected int pWinnings;
	protected double pRating;
	protected JJNB_Team team;
	
	public JJNB_Player() { //default constructor
		pName = "Name";
		pKD = 0;
		pWinnings = 0;
		pRating = 0;
		team = new JJNB_Team();
	}
	
	public JJNB_Player(String name, double kd, int winnings, double rating, JJNB_Team nTeam) { //non-default constructor
		pName = name;
		pKD = kd;
		pWinnings = winnings;
		pRating = rating;
		team = nTeam;
	}
	
	//mutators and accessors
	public void setpName(String name) {
		pName = name;
	}
	public String getpName() {
		return pName;
	}
	public void setpKD(double kd) {
		pKD = kd;
	}
	public double getpKD() {
		return pKD;
	}
	public void setpWinnings(int winnings) {
		pWinnings = winnings;
	}
	public int getpWinnings() {
		return pWinnings;
	}
	public void setpRating(double rating) {
		pRating = rating;
	}
	public double getpRating() {
		return pRating;
	}
	public JJNB_Team getpTeam() {
		return team;
	}
	public void setpTeam(JJNB_Team nTeam) {
		team = nTeam;
	}
	
	//set/getRoleStat are our two overridden methods unique to our application
	public void setRoleStat(double nStat) { 
		
	}
	public double getRoleStat() {
		return -1;
	}
	//toString, equals and compareTos
	public String toString() {
		String str;
		str = "Name: " + pName + "  K/D: " + pKD + "  Winnings: " + pWinnings + "  Rating: " + pRating;
		return str;
	}
	public boolean equals(JJNB_Player plr) {
		boolean ret = false;
		if (pName.equals(plr.getpName())) { //name has to be the same b/c no CS:GO player has the same username
			if (pKD - plr.getpKD() < .01 && pKD - plr.getpKD() > -.01) {
				if (pWinnings == plr.getpWinnings()) {
					if (pRating - plr.getpRating() < .01 && pRating - plr.getpRating() > .01) {
						ret = true;
					}
				}
			}
		}
		return ret;
	}
	//compares name, winnings and ratings
	public int compareTo(JJNB_Player plr) {
		int ret = 0;
		if (pName.compareTo(plr.getpName()) > 0) {
			ret = 1;
		} else if (pName.compareTo(plr.getpName()) < 0) {
			ret = -1;
		}
		return ret;
	}
	public int compareWinnings(JJNB_Player plr) {
		int ret = 0;
		if (pWinnings > plr.getpWinnings()) {
			ret = 1;
		} else if (pWinnings < plr.getpWinnings()) {
			ret = -1;
		}
		return ret;
	}
	public int compareRatings(JJNB_Player plr) {
		int ret = 0;
		if (pRating > plr.getpRating()) {
			ret = 1;
		} else if (pRating < plr.getpRating()) {
			ret = -1;
		}
		
		return ret;
	}
	
}
