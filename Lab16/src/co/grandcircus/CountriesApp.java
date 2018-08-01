package co.grandcircus;

import java.util.List;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		System.out.println(
				"Welcome to the Country Console App!\n\nI heard that you would like to view and make changes to the current list of Countries...\n");
		String humanName = Validator.getString(scnr,
				"Please enter your first name so I know with whom I'm working with:\n");
		System.out.println("\nThanks, " + humanName
				+ "!\nWe have just ran you through out 2 factor verification by using just your first name, and now you're all set to edit away!-)\n");

		System.out.println("Here are the currently Countries:\n");
		printList();

		String cont = "y";

		do {
			System.out.println("\nWhat would you like to do today?\n");

			String choice = Validator.getStringMatchingRegex(scnr,
					"1 - See the current list of countries\n2 - Add a country\n3 - Exit\n", "1|2|3", false);

			if (choice.equals("1")) {
				printList();

			} else if (choice.equals("2")) {
				System.out.println("Please enter the name of the country that you'd like to add:\n");
				String userInput = scnr.nextLine();
				Country country = new Country(userInput);
				CountryTextFile.appendLine(country);
				printList();

			} else {
				break;
			}

			cont = Validator.getString(scnr, "\nWould you like to view the list of your options again? y/n?");
		} while (cont.matches("[yY].*"));

		System.out.println("\nI hope that you were able to accomplish everything you needed to do! Have a good one.");

		scnr.close();
	}

	private static void printList() {
		List<Country> countries = CountryTextFile.readFile();

		for (Country country : countries) {
			System.out.println(country);
		}
	}
}