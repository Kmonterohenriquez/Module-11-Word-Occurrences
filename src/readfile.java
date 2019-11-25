import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class readfile {
//----- Declare Array to hold every word from the testStates.txt
		String [] testStates;
		private Scanner stateFile;
		
//------------->   Open File  <-------------------//
		public void openFile() {
			try {
				stateFile= new Scanner(new File("testStates.txt"));		
			}
			catch(Exception e) {
				System.out.println("Could not find file");
			}		
		}
		
//------------->   Read File  <-------------------//
		public void readFile() {
			while(stateFile.hasNext()) {
				String statesFromDoc= stateFile.next();
				int size= statesFromDoc.length();
				for (int i=0; i < size; i++) {
					testStates[i]= statesFromDoc;
				}
				System.out.printf("s%\n", statesFromDoc );
			}
		}
		
//------------->  Close file <---------------------//
		public void closeFile() {
			stateFile.close();
		}
	}