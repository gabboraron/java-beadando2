package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import snake.Game;

public class Main {

	public static void main(String[] args) {
		if (args.length != 3) {
			System.err.println("Three arguments required.");
			return;
		}

		String applesFile = args[0];
		String movesFile = args[1];
		String outputFile = args[2];

		List<String> apples = read(applesFile);
		List<String> moves = read(movesFile);

		Game game = new Game(apples);
		String output = game.play(moves);

		write(outputFile, output);
	}

	private static List<String> read(String file) {
		try (Scanner sc = new Scanner(new FileReader(new File(file)))) {
			ArrayList<String> lines = new ArrayList<>();
			while (sc.hasNextLine()) {
				lines.add(sc.nextLine());
			}
			return lines;
		} catch (FileNotFoundException e) {
			System.err.println("File " + file + " cannot be opened. (Running with empty list.)");
			return new ArrayList<>();
		}
	}

	private static void write(String file, String text) {
		try (PrintWriter pw = new PrintWriter(new File(file))) {
			pw.println(text);
		} catch (FileNotFoundException e) {
			System.err.println("Cannot write to file " + file + ".");
		}

	}

}
