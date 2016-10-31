import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SecretSanta {

	int howMany = 0;
	String[] s;

	public SecretSanta(int x) {
		howMany = x;
	}

	public void addNames() {
		StdOut.println("What are the names ? ");
		s[0] = StdIn.readLine();
		for (int i = 0; i < howMany; i++) {
			String str = StdIn.readLine();
			s[i] = str;
		}
	}

	public void setName() {
		s = new String[howMany];
	}

	public void getNames() {
		StdOut.println(Arrays.toString(s));
	}

	public void whosPicking() {

		ArrayList<String> alreadyPicked = new ArrayList<String>();
		StdOut.println(alreadyPicked.size());

		Scanner sc = new Scanner(System.in);

		while (alreadyPicked.size() != howMany) {
			String picking;
			String notThis;
			// String[] temp = new String[s.length];
			String[] wut = new String[5];

			if (alreadyPicked.size() > 0) {
				StdOut.println("Who is picking now ");
				picking = sc.nextLine();
				StdOut.println("Who cannot this person get as SS? ");
				notThis = sc.nextLine();
			} else {
				StdOut.println("Who is picking? ");
				picking = StdIn.readLine();
				StdOut.println("Who cannot this person get as SS? ");
				notThis = StdIn.readLine();
			}
			StdOut.println("Is the picker's name alread been picked " + doesExist(picking, alreadyPicked)
					+ " What about the person they cant't get " + doesExist(notThis, alreadyPicked));
			if (notThis.equals("none")) {
				String[] temp = new String[s.length];
				wut = temp;
				StdOut.println("Special");
			} else {
				if (doesExist(picking, alreadyPicked) == false && doesExist(notThis, alreadyPicked) == false) {
					String[] temp = new String[s.length - 2];
					wut = temp;
					StdOut.println("One");
				} else if (doesExist(picking, alreadyPicked) == true && doesExist(notThis, alreadyPicked) == true) {
					String[] temp = new String[s.length];
					wut = temp;
					StdOut.println("Two");
				} else {
					String[] temp = new String[s.length - 1];
					wut = temp;
					StdOut.println("Four");
				}
			}

			int j = 0;
			int m = 0;
			String[] former = s;

			for (int i = 0; i < s.length; i++) {
				if (s[i].equals(picking) == false && s[i].equals(notThis) == false) {
					wut[j] = s[i];
					j++;
				}

			}
			s = wut;
			StdOut.println("The list is now only" + Arrays.toString(s));
			String ss = getRandom(s);
			StdOut.println("Your SS is " + ss + "!");
			StdOut.println("Are you ready to clear the console?! Enter 1 if you are");
			if (StdIn.readInt() == 1) {
				for (int clear = 0; clear < 1000; clear++) {
					System.out.println("\b");
				}
			}
			alreadyPicked.add(ss);
			String[] newList = new String[former.length - 1];
			s = newList;
			for (int i = 0; i < former.length; i++) {
				if (former[i].equals(ss) == false) {
					s[m] = former[i];
					m++;
				}

			}
			StdOut.println(Arrays.toString(s));
		}
	}

	public static String getRandom(String[] array) {
		int rnd = new Random().nextInt(array.length);
		return array[rnd];
	}

	public boolean doesExist(String s, ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(s)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int x = 0;
		StdOut.println("How many people are playing secret santa? ");
		x = StdIn.readInt();

		SecretSanta ss = new SecretSanta(x);
		ss.setName();
		ss.addNames();
		ss.getNames();
		ss.whosPicking();

	}

}
