package lab8;

import java.util.Scanner;

public class MemoryManagement {
	public static int memory[] = { 900, 300, 800, 500, 100, 700, 400, 200, 600,
			1000 };
	public static int consumed[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public static int size[] = new int[10];
	Scanner s = new Scanner(System.in);
	public static int seg, choice;
	public static int a = -1;
	public static int b = -1;

	public MemoryManagement() {
		starting();
	} // Consructor ends

	public void starting() {
		System.out.println("\n\t***** Assuming memory is contagious *****");
		System.out
				.println("\nEnter the number of segments : (not more than 10)");
		seg = s.nextInt();
		for (int i = 1; i <= seg; i++) {
			System.out.println("\nSize of segment " + i + " : ");
			size[i - 1] = s.nextInt();
		}
		System.out
				.println("\n\t***** Choose Memory allocation method *****\n=> First Fit [1]\n=> Best Fit [2]\n=> Exit  [3]\n");
		choice = s.nextInt();
		switch (choice) {
		case 1:
			firstfit();
			break;
		case 2:
			bestfit();
			break;
		case 3:
			System.exit(0);
		}
	} // starting method ends

	public void firstfit() {
		showmemory();
		int stat;
		for (int i = 1; i <= seg; i++) {
			stat=largestfirst(size[i - 1]);
			System.out.println("\nSegment " + size[i - 1]
					+ " is taking memory block of " + stat
					+ " and empty space in block is "
					+ (stat - size[i - 1]));
		}
	} // firstfit method ends

	public void bestfit() {

		showmemory();
		int stat;
		for (int i = 1; i <= seg; i++) {
			stat=smallestreturn(size[i - 1]);
			System.out.println("\nSegment " + size[i - 1]
					+ " is taking memory block of " + stat
					+ " and empty space in block is "
					+ (stat - size[i - 1]));
		}
	} // bestfit method ends

	public int largestfirst(int x) {
		int value = 00;
		for (int i = 0; i < 10; i++) {
			if (x <= memory[i] && isconsumed(memory[i]) == false) {
				value = memory[i];
				a++;
				consumed[a] = memory[i];
				break;
			}
		}
		return value;
	} // largestfirst method ends
	
	
	public int smallestreturn(int x){
		int smallremainder=memory[0]-x;
		int suitableslot=memory[0];
		for(int i=1;i<10;i++){
			int a=memory[i]-x;
			if((a<smallremainder)&&(a>0)&& (isconsumed(memory[i])==false)){smallremainder=a;suitableslot=memory[i];}
		}
		b++;
		consumed[b]=suitableslot;
		return suitableslot;
	}

	public boolean isconsumed(int x) {
		boolean value = false;
		for (int i = 0; i < 10; i++) {
			if (consumed[i] == x) {
				value = true;
				break;
			}
		}
		return value;
	} // isconsumed method ends

	public void showmemory() {
		System.out.println("\n*** Memory has following blocks in order ***");
		for (int i = 0; i < 10; i++) {
			if (i == 9) {
				System.out.print(memory[i] + "\n");
			} else {
				System.out.print(memory[i] + " , ");
			}
		}
	} // showmemory method ends

	public static void main(String[] args) {
		MemoryManagement object = new MemoryManagement();
	}

} // MemoryManagement Class ends
