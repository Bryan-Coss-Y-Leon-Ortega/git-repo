import java.util.ArrayList;

public class arrayManipulation {

	/*
	 * This method prints all the names of the students in the roll call
	 * */
	public static void printArray(ArrayList<Student> rollCall ) {
		for(int i = 0; i<rollCall.size(); i++) {
			System.out.println(rollCall.get(i).getName() + ", ID num: " + rollCall.get(i).getNum()
					+ ", address: " + rollCall.get(i).getAddy());
		}
	}
	
	//Selection sort will sort the roll numbers of the students from lowest to highest.
	
	public static void sortNum(ArrayList<Student> rollCall) {
		int min;
		for(int i = 0; i < rollCall.size()-1; i++) {
			min = i;
			for(int j = i+1; j < rollCall.size(); j++) {
				if(rollCall.get(j).getNum() < rollCall.get(min).getNum()) {
					Student temp = rollCall.get(i);
					rollCall.set(i, rollCall.get(j));
					rollCall.set(j, temp);
				}
				
			}
						
		}
	}
	
	//This is the sort number but in the reverse number order
	public static void reverseSortNum(ArrayList<Student> rollCall) {
		int min;
		for(int i = 0; i < rollCall.size()-1; i++) {
			min = i;
			for(int j = i+1; j < rollCall.size(); j++) {
				if(rollCall.get(j).getNum() > rollCall.get(min).getNum()) {
					Student temp = rollCall.get(i);
					rollCall.set(i, rollCall.get(j));
					rollCall.set(j, temp);
				}
				
			}
						
		}
	}
	
	//This sort method will sort the names of every student alphabetically. 
	public static void sortName(ArrayList<Student> rollCall) {
		for(int i = 0; i<rollCall.size()-1; i++) {
			for(int j = i+1; j<rollCall.size(); j++) {
				//This will compare names then sort them
				if(rollCall.get(i).getName().compareTo(rollCall.get(j).getName()) > 0) {
					Student temp = rollCall.get(i);
					rollCall.set(i, rollCall.get(j));
					rollCall.set(j, temp);
				}
			}
		}
	}
	
	//This sorts the name in reverse alphabetical order
	public static void reverseSortName(ArrayList<Student> rollCall) {
		for(int i = 0; i<rollCall.size()-1; i++) {
			for(int j = i+1; j<rollCall.size(); j++) {
				//This will compare names then sort them
				if(rollCall.get(i).getName().compareTo(rollCall.get(j).getName()) < 0) {
					Student temp = rollCall.get(i);
					rollCall.set(i, rollCall.get(j));
					rollCall.set(j, temp);
				}
			}
		}
	}
	
	
	
	
}
