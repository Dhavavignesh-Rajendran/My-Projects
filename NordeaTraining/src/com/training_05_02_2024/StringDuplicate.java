package com.training_05_02_2024;

import java.util.Scanner;

public class StringDuplicate {
	static void duplicate(String a) {
		String name = a;
		System.out.print("The Duplicated characters are------>  ");
		char[] str = name.toCharArray();
		for (int i = 0; i < name.length(); i++) {
			for (int j = i + 1; j < name.length(); j++) {
				if (str[i] == str[j]) {
					System.out.print(str[j] + " ");
					break;
				}
			}
		}

	}

	class StringReverse {
		static void reverse(String a) {
			int length = a.length();
			System.out.print("\n" + "After reversed----->");
			while (length > 0) {
				System.out.print(a.charAt(length - 1));
				length--;
			}
		}
	}

	public static void main(String[] args) {
		Scanner getname = new Scanner(System.in);

		System.out.println("enter a name:------>");
		String name = getname.nextLine();
		StringDuplicate.duplicate(name);
		StringReverse.reverse(name);

	}

}
