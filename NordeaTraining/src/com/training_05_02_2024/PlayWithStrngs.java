package com.training_05_02_2024;

public class PlayWithStrngs {

	static String spaceRemover(String str) {
		str = str.replace(" ", "");
		return str;
	}

	static String iteratingStr(String str) {
		String removeSp = spaceRemover(str);
		StringBuffer ch = new StringBuffer();
		// System.out.println(removeSp.length());
		// System.out.println("After removing space->");
		for (int i = 0; i < removeSp.length(); i++) {
			ch.append(removeSp.charAt(i) + " ");
			// System.out.print(removeSp.charAt(i) + " ");
		}
		System.out.println("After Adding space------->" + ch.toString());
		return removeSp;
	}

	static String reverseStr(String str) {
		// System.out.println("Before reversing---->" + str);
		StringBuilder bul1 = new StringBuilder();
		bul1.append(str);
		bul1.reverse();
		String bul1tostr = bul1.toString();
		System.out.println("After reversing------->" + bul1tostr);
		return bul1tostr;
	}

	static String reverseStrWord(String str) {

		String[] word = str.split(" ");
		String revString = "";
		for (int i = 0; i < word.length; i++) {  ///to iterate between each word
			String word1 = word[i];
			String revWord = "";

//			for (int j = word1.length() - 1; j >= 0; j--) {
//				revWord = revWord + word1.charAt(j);
//			}
			revString=reverseStr(word1);

			//revString = revString + revWord + " ";
		}
		System.out.println("Ater reversing only words------------>" + revString);
		return str;

	}

	public static void main(String[] args) {
		String name = "DHAVA VIGNESH RAJENDRAN";

		System.out.println("After removing spaces-------------> " + spaceRemover(name)); // function to remove space in
																							// // name
		iteratingStr(name);// methos to add space
		reverseStr(name);// method to reverse a string
		reverseStrWord(name);// method to reverse a word in a string

	}
}
