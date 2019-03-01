
public class SearchNSort extends ObjArray {
	
	public SearchNSort() {
		super();
	}
	public SearchNSort(int a) {
		super(a);
	}
	
	//We left the recursive code in the class just in case we needed it
	/*
	public static int recSeq(Object obj, Object [] objarr, int i, int ) {
		int ret = -1;
		if (i < objarr.length) {
			++;
			if (obj.equals(objarr[i])) {
				ret = i;
			}
			else {
				i++;
				return recSeq(obj, objarr, i, );
			}
		}
		System.out.println("Amount of  for recursive sequentialSearch(): " + );
		return ret;
	}
	
	public static int recBin (Object obj, Object [] objarr, int , int min, int max) {
		int mid = (max+min)/2;
		int def = -1;
		if ((max-min) < 1.5) {
			return -1;
		}
		if ( < objarr.length ) {
			++;
		if (obj.equals(objarr[mid])) {
			def = mid;
		} 
		else if (((JJNB_Player) obj).compareTo((JJNB_Player) objarr[mid]) < 0) {
			min = mid;
			mid = (min + max)/2;
			return recBin(obj, objarr, , min, max);
		} 
		else if (((JJNB_Player) obj).compareTo((JJNB_Player) objarr[mid]) > 0) {
			max = mid;
			mid = (min + max)/2;
			return recBin(obj, objarr, , min, max);
		}
		}
		System.out.println("Amount of  for recursive binarySearch(): " + );
		return def;
	} */
	
	
	public int sequentialSearch(JJNB_Player player) {
		int val = 0;
		int i;
		for (i = 0; i < getIndex(); i++) { //goes through entire array until a player is found and returns the location
			if (array[i].equals(player)){
				val = i;
				return val;
			}
		}
		return -1; //if not found
	}
	//splits the array in halves based on whether the searchkey/middle is greater than or less than what's being compared
	public int binarySearch(JJNB_Player player) { 
		boolean check = false;
		int val = -1;
		int min = 0;
		int mid = (getIndex()/2);
		int max = getIndex();
		selectSort();
		while (!check) {
			if(((JJNB_Player)getObject(mid)).equals(player)) {
				val = mid;
				check = true;
			}
			else if (((JJNB_Player)getObject(mid)).compareTo(player) < 0) { //search key is less than what is in the array
				max = mid; //max number becomes what was previously the middle and min stays the same
				mid = (min + max)/ 2; 
			}
			else if (((JJNB_Player)getObject(mid)).compareTo(player) > 0) { //search key is greater than what is in the array
				min = mid; //min becomes what was previously the middle and max stays the same
				mid = (min + max)/2;
			}
			if (max - min < 1) { //not found
				return -1;
			}
		}
		return val;
	}
	/*Sorting:
	 * if the object @ j is less than the object @ minPos, then the new minimum is j and then i is then swapped with new minPos
	 */
	
	//sorts the array out from least to greatest or alphabetically
	public void selectSort() { //sorts by name
		int minPos;
		int i;
		int j;
		for (i = 0; i < getIndex(); i++) {
			minPos = i;
			for(j = i+1; j < getIndex(); j++) {
				//sorting alphabetically & ignoring capitalization
				if (((JJNB_Player)getObject(j)).getpName().toLowerCase().compareTo(((JJNB_Player) getObject(minPos)).getpName().toLowerCase()) < 0) {
					minPos = j;
				}
			}
			swap(i, minPos);
		}
	}
	
	//sorts by kd
	public void kdSort() {
		int minPos;
		int i;
		int j;
		for (i = 0; i < getIndex(); i++) {
			minPos = i;
			for (j = i+1; j < getIndex(); j++) {
				if (((JJNB_Player)getObject(j)).getpKD() > (((JJNB_Player)getObject(minPos)).getpKD())) { 
					minPos = j;
				}
			}
			swap (i, minPos);
		}
	}
	
	//sorts by rating
	public void ratingSort() {
		int minPos;
		int i;
		int j;
		for (i = 0; i < getIndex(); i++) {
			minPos = i;
			for (j = i+1; j < getIndex(); j++) {
				if (((JJNB_Player)getObject(j)).getpRating() > (((JJNB_Player)getObject(minPos)).getpRating())) { 
					minPos = j;
				}
			}
			swap (i, minPos);
		}
	}
	
	//sorts by role statistics
	public void roleStatSort() {
		int minPos;
		int i;
		int j;
		for (i = 0; i < getIndex(); i++) {
			minPos = i;
			for (j = i+1; j < getIndex(); j++) {
				if (((JJNB_Player)getObject(j)).getRoleStat() > (((JJNB_Player)getObject(minPos)).getRoleStat())) { 
					minPos = j;
				}
			}
			swap (i, minPos);
		}
	}
	public void rifleSort() {
		int minPos;
		int i;
		int j;
		for (i = 0; i < getIndex(); i++) {
			minPos = i;
			for (j = i+1; j < getIndex(); j++) {
				if (((JJNB_Player)getObject(i)).getClass().getSimpleName().equals("JJNB_Rifler")) {
					if (((JJNB_Player)getObject(j)).getRoleStat() > (((JJNB_Player)getObject(minPos)).getRoleStat())) { 
					minPos = j;
					}
				}
			}
			swap (i, minPos);
		}
	}
	public void awpSort() {
		int minPos;
		int i;
		int j;
		for (i = 0; i < getIndex(); i++) {
			minPos = i;
			for (j = i+1; j < getIndex(); j++) {
				if (((JJNB_Player)getObject(i)).getClass().getSimpleName().equals("JJNB_Awper")) {
					if (((JJNB_Player)getObject(j)).getRoleStat() > (((JJNB_Player)getObject(minPos)).getRoleStat())) { 
					minPos = j;
					}
				}
			}
			swap (i, minPos);
		}
	}
	public void iglSort() {
		int minPos;
		int i;
		int j;
		for (i = 0; i < getIndex(); i++) {
			minPos = i;
			for (j = i+1; j < getIndex(); j++) {
				if (((JJNB_Player)getObject(i)).getClass().getSimpleName().equals("JJNB_InGameLeader")) {
					if (((JJNB_Player)getObject(j)).getRoleStat() > (((JJNB_Player)getObject(minPos)).getRoleStat())) { 
					minPos = j;
					}
				}
			}
			swap (i, minPos);
		}
	}
	
	//takes the player's name and searches it through the array
	public int nameSearch(String name) {
		int ret = -1;
		int i;
		for (i = 0; i < getIndex(); i++) {
			if (((JJNB_Player) array[i]).getpName().toLowerCase().equals(name.toLowerCase())){
				ret = i;
			}
		}
		if (ret == -1) {
		System.out.println("No player found with that name");
		}
		return ret;
	}
	public void teamSearch(String name) {
		boolean found = false;
		int fNum = 0;
		String str = "";
		int i;
		for (i = 0; i < getIndex(); i = i+5) {
			if (((JJNB_Player) array[i]).getpTeam().getName().toLowerCase().equals(name.toLowerCase())){
				found = true;
				fNum = i;
				str = ((JJNB_Player) array[i]).getpTeam().toString() + "  Players: " + ((JJNB_Player) array[i]).getpName() + ";" +
						((JJNB_Player) array[i+1]).getpName() + ";" + ";" + ((JJNB_Player) array[i+2]).getpName() + ";" + 
						((JJNB_Player) array[i+3]).getpName() + ";" + ((JJNB_Player) array[i+4]).getpName();
				System.out.println(str);
			}
		}
		if (found == false) {
		System.out.println("No team found with that name");
		}
	}
	public void roleSearch (String role) {
		String nRole = "jjnb_" + role.toLowerCase();
		boolean found = false;
		int i;
		for (i = 0; i < getIndex(); i++) {
			if (array[i].getClass().getSimpleName().toLowerCase().equals(nRole)) {
				found = true;
				System.out.println(array[i].toString());
			}
		}
		if (found == false) {
			System.out.println("No player found with that role");
		}
	}
	
}
