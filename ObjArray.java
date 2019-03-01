import java.util.Scanner;

/* Jackson & Norina
 */

	public class ObjArray{
		protected final int MAX;
		protected static Object [] array;
		protected int index;   // (next empty slot)
		protected int pointer;
		protected int length;

			//default constructor, instantiates array to MAX size and assigns 0 to index
			public ObjArray() {
				MAX = 75;
				length = 0;
				index = 0;
				array = new Object[MAX];
				pointer = 0;
			}
			
			//nondefault constructor to instantiate an array to size, assigns 0 to index
			public ObjArray(int size) {
				MAX = 75;
				length = size;
				index = 0;
				pointer = 0;
				array = new Object[size];
			}
			
			//nondefault constructor that will assign a new array and new value to index
			public ObjArray(Object [] anArr, int newIndex) {
				MAX = 75;
				array = anArr;
				index = newIndex;
			}

			public int getLength() {
				return array.length;
			}
			
			//return a copy of the array, accessor
			public Object[] getobjArr () {
				return array;
				
			}

			//assign a new array, mutator
			public void setobjArr(Object[] anObjArr) {
				array = anObjArr;
			}

			//return # of actual data in array, accessor
			public int getIndex() {
				return index;
			}
			
			//return current position
			public int getPointer() {
				return pointer;
			}
			
			//returns deep copy of the object array 
			public Object[] getArray() {
				Object [] deepArr = new Object[index];
				int i;
				for (i = 0; i < index; i++) {
					deepArr[i] = array[i];
				}
				return deepArr;
			}
			
			//assign a new index, mutator
			public void setIndex(int anIndex) {
				index = anIndex;
			}
			
			public void setPointer (int sPoint) {
				pointer = sPoint;
			}

			//return an object at given pos
			public Object getObject(int pos) {
				return array[pos];
				
			}
			
			//return the string with contents of array
			public String toString() {
				String toStrng = " ";
				int i;
				for (i = 0; i <= index-1; i++) {
					toStrng = toStrng + array[i].toString();
				}
				return toStrng;
			}
			
			//insert a new string into the next empty slot of the array if there is room, inc index
			public void add(Object anObj) {
				if (index < 50) {
					array[index] = anObj;
					index++;
				}
			}

			//searches the list for an object and returns the index where that object 
			//has been found or -1 if not found
			public int isThere(Object anObj) {
				int exist = -1;
				int i;
				for (i = 0; i < index; i++) {
					if (array[i].equals(anObj) == true) {
						exist = i;
					}
				}
				return exist;
			}

			//insert an object at particular index moving everything down
			public void insertObject(Object anObj, int pos) {
				int i;
				for (i = index; i >= pos; i--) {
					if (i > 0) {
					array[i] = array[i-1];
					}
				}
				array[pos] = anObj;
				
			}

		//replace an object with another object
			public void setObject(Object anObj, int pos) {
				array[pos] = anObj;
			}
		//delete object from the specified position, check if list is empty
			public void delete (int delIndex) {
				if (index > 1) {
					int i;
					for (i = delIndex; i <= index-1; i++) {
						array[i] = array[i+1];
					}
					index--;
				} 
				else if (index == 0) {
					System.out.println("List is empty");
				}
			}
			
			//is it full
			public boolean isFull() {
				boolean check = false;
				if (index+1 == MAX) {
					check = true;
				}
				else {
					check = false;
				}
				return check;
			}
			
			//is it empty
			public boolean isEmpty() {
				boolean check = false;
				if (index == 0) {
					check = true;
				}
				else {
					check = false;
				}
				return check;
			}
			
			//clears the entire array
			public void clear() {
				int i;
				for (i = 0; i < index; i++) {
					array[i] = null;
				}
				index = 0;
			}
			
			//decreases the array size by one
			public void trim() {
				Object [] trimmedArr = new Object[index--];
				int i;
				for (i = 0; i < index; i++) {
					trimmedArr[i] = array[i];
				}
				array = trimmedArr;
			}
			
			//doubles the size of the array
			public void moreCapacity () {
				if (index == MAX) {
				int newsize = index * 2;
				int i;
				Object [] moar = new Object [newsize];
				for (i = 0; i < index; i++) {
					moar[i] = array[i];
				}
				array = moar;
				}
				else {
					System.out.println("Cannot expand array because current array has not reached maximum size");
				}
			}
			// resets the pointer
			public void reset () {
				pointer = 0;
			}
			
			public boolean hasNext() {
				boolean check = true;
				if (pointer < index-1) {
					check = true;
				}
				else {
					check = false;
				}
				return check;
			}
			
			public Object getNext() {
				pointer++;
				return array[pointer-1];
			}
			
			//swaps objects in the desired indexes
			public void swap(int in1, int in2) {
				Object temp = new Object();
				temp = array[in1];
				array[in1] = array[in2];
				array[in2] = temp;
			}
			
			//adds a player (used to be in application class but it looked ugly)
			public void addPlayer(SearchNSort player) {
				Scanner mScan = new Scanner(System.in);
				String nRole;
				String nName;
				double nKd;
				String garb;
				int nWinnings;
				double nRating;
				double nAdr;
				JJNB_Team nTeam = new JJNB_Team();
				JJNB_Rifler nRifler;
				JJNB_Awper nAwper;
				JJNB_InGameLeader nIGL;
				System.out.print("Enter the new player's role: ");
				nRole = mScan.next().toLowerCase();
				index++;
				//makes sure to check every variable of a rifler
					if (nRole.equals("rifler")) {
						System.out.print("What is the new player's name: ");
						if (mScan.hasNext()) {
						nName = mScan.next();
						garb = mScan.nextLine();
						System.out.print("What is the new player's k/d: ");
							if (mScan.hasNextDouble()) {
								nKd = mScan.nextDouble();
								garb = mScan.nextLine();
								System.out.print("What is the new player's winnings: ");
									if (mScan.hasNextInt()) {
										nWinnings = mScan.nextInt();
										garb = mScan.nextLine();
										System.out.print("What is the new player's rating: ");
										if (mScan.hasNextDouble()) {
											nRating = mScan.nextDouble();
											garb = mScan.nextLine();
											System.out.print("What is the new player's ADR: ");
											if (mScan.hasNextDouble()) {
												nAdr = mScan.nextDouble();
												nRifler = new JJNB_Rifler(nName, nKd, nWinnings, nRating, nAdr, nTeam);
												player.add(nRifler);
												System.out.println("Player added: " + nRifler.toString());
									}
								}
							}
						}
					}
					}
					
					//makes sure to check every variable of an awper
					if (nRole.equals("awper")) {
						System.out.print("What is the new player's name: ");
						if (mScan.hasNext()) {
						nName = mScan.next();
						garb = mScan.nextLine();
						System.out.print("What is the new player's k/d: ");
							if (mScan.hasNextDouble()) {
								nKd = mScan.nextDouble();
								garb = mScan.nextLine();
								System.out.print("What is the new player's winnings: ");
									if (mScan.hasNextInt()) {
										nWinnings = mScan.nextInt();
										garb = mScan.nextLine();
										System.out.print("What is the new player's rating: ");
										if (mScan.hasNextDouble()) {
											nRating = mScan.nextDouble();
											garb = mScan.nextLine();
											System.out.print("What is the new player's Opening pick percentage: ");
											if (mScan.hasNextDouble()) {
												nAdr = mScan.nextDouble();
												garb = mScan.nextLine();
												nAwper = new JJNB_Awper(nName, nKd, nWinnings, nRating, nAdr, nTeam);
												player.add(nAwper);
												System.out.println("Player added: " + nAwper.toString());
									}
								}
							}
						}
					}
					}
					//makes sure to check every variable of an in game leader
					if (nRole.equals("ingameleader")) {
						System.out.print("What is the new player's name: ");
						if (mScan.hasNext()) {
						nName = mScan.next();
						garb = mScan.nextLine();
						System.out.print("What is the new player's k/d: ");
							if (mScan.hasNextDouble()) {
								nKd = mScan.nextDouble();
								garb = mScan.nextLine();
								System.out.print("What is the new player's winnings: ");
									if (mScan.hasNextInt()) {
										nWinnings = mScan.nextInt();
										garb = mScan.nextLine();
										System.out.print("What is the new player's rating: ");
										if (mScan.hasNextDouble()) {
											nRating = mScan.nextDouble();
											garb = mScan.nextLine();
											System.out.print("What is the new player's clutch percentage: ");
											if (mScan.hasNextDouble()) {
												nAdr = mScan.nextDouble();
												garb = mScan.nextLine();
												nIGL = new JJNB_InGameLeader(nName, nKd, nWinnings, nRating, nAdr, nTeam);
												player.add(nIGL);
												System.out.println("Player added: " + nIGL.toString());
									}
								}
							}
						}
					}
					}
				}
	}
