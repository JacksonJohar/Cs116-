
public class JJNB_Team {
	private String teamName;
	private double teamWinLoss;
	private String teamFaveMap;
	
	//constructors
	public JJNB_Team() {
		teamName = "";
		teamWinLoss = 0.0;
		teamFaveMap = "";
	}
	public JJNB_Team(String name, double wl, String map) {
		teamName = name;
		teamWinLoss = wl;
		teamFaveMap = map;
	}
	//accessors and mutators
	public String getName() {
		return teamName;
	}
	public void setName(String name) {
		teamName = name;
	}
	public double getWinLoss() {
		return teamWinLoss;
	}
	public void setWinLoss(double wl) {
		teamWinLoss = wl;
	}
	public String getFaveMap() {
		return teamFaveMap;
	}
	public void setFaveMap(String map) {
		teamFaveMap = map;
	}
	
	//toString
	public String toString() {
		String str = "";
		str = "Team Name: " + teamName + "  Win Rate: " + teamWinLoss + "  Favorite Map: " + teamFaveMap;
		return str;
	}
	
	public boolean equals(JJNB_Team team) {
		boolean check = false;
		if (teamName.equals(team.getName()) && teamWinLoss == team.getWinLoss() && teamFaveMap.equals(team.getFaveMap())){ //makes sure it's the correct team
			check = true;
		}
		else {
			check = false;
		}
		return check;
	}
	public int compareTo(JJNB_Team team) {
		int check = -1;
		if (teamName.compareTo(team.getName()) == 0) {
			check = 0;
		}
		else if (teamName.compareTo(team.getName()) > 0) {
			check = 1;
		}
		else {
			check = -1;
		}
		return check;
		
	}
	public int compareWins (JJNB_Team team) {
		int check = -1;
		if (teamWinLoss -  team.getWinLoss() == 0) {
			check = 0;
		}
		else if (teamWinLoss - team.getWinLoss() > 0) {
			check = 1;
		}
		else {
			check = -1;
		}
		return check;
	}
	
}
