package co.grandcircus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// TODO Replace all the `Object` types with the type you're reading & writing.
public class CountryTextFile {

	// The path to the file to use
	public static final String FILE_NAME = "countries.txt";

	// Modify this method as necessary to convert a line of text from the file to a
	// new item instance
	private static Country convertLineToItem(String line) {
		String[] parts = line.split(",");
		String type = parts[0];
		// double price = Double.parseDouble(parts[1]);
		// boolean isRed = Boolean.parseBoolean(parts[2]);
		Country country1 = new Country(type);
		return country1;
	}

	// Modify this method as necessary to convert an item instance to a line of text
	// in the file
	private static String convertItemToLine(Country item) {
		String line = item.toString();
		return line;
	}

	public static List<Country> readFile() {
		List<Country> countryList = new ArrayList<>();

		try (
				// Open/prepare the resources in the try resources block
				FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
				Scanner fileScanner = new Scanner(fileInputStream);) {
			// loop until the end of the file
			while (fileScanner.hasNextLine()) {
				// read each line as a string
				String line = fileScanner.nextLine();
				// then convert it to an object
				countryList.add(convertLineToItem(line));
			}

		} catch (FileNotFoundException ex) {
			// If the file doesn't exist, there just aren't any items.
			return countryList;
		} catch (IOException e) {
			// If something else crazy goes wrong, print out the error.
			System.err.println("Something unexpected happended.");
			e.printStackTrace();
		}

		// Finally return the array of items.
		return countryList;
	}

	public static void appendLine(Country item) {
		// convert object to a string line of text to be written to the file
		String line = convertItemToLine(item);

		try (
				// The `true` here tells the FileOutputStream to append to the file rather than
				// overwriting it
				FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME, true);
				PrintWriter fileWriter = new PrintWriter(fileOutputStream);) {
			// write to the file
			fileWriter.println(line);

		} catch (IOException e) {
			// If something else crazy goes wrong, print out the error.
			System.err.println("Something unexpected happended.");
			e.printStackTrace();
		}
	}

	public static void writeFile(List<Country> items) {
		try (
				// The `false` here tells the FileOutputStream to overwrite the file, rather
				// than append to it
				FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME, false);
				PrintWriter fileWriter = new PrintWriter(fileOutputStream);) {
			// write to the file
			for (Country item : items) {
				// each item must be converted to a string of text to write to the file
				String line = convertItemToLine(item);
				fileWriter.println(line);
			}

		} catch (IOException e) {
			// If something else crazy goes wrong, print out the error.
			System.err.println("Something unexpected happended.");
			e.printStackTrace();
		}
	}

	public static void createDirectory(String pathName) {
		Path path = Paths.get(pathName);
		if (Files.notExists(path)) {
			try {
				Files.createDirectories(path);
				System.out.println("Directory created at " + path.toAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void createBlankFile(String pathName) {
		Path path = Paths.get(pathName);
		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
				System.out.println("File created at " + path.toAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}