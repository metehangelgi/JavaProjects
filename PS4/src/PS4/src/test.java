

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.lang.SecurityException;
import java.io.FileNotFoundException;

public class test {
	
	public static void main(String[] args) {
		try (Scanner input = new Scanner(Paths.get("./src/huntington.txt"))) {
			try (Formatter output = new Formatter("./src/HD_report.txt")) {
				
				output.format("#Name\tSurname\tNumber of Repeats\tDisease Status%n");
				input.nextLine(); // skip first line
				while (input.hasNext()) {
					String firstName = input.next();
					String lastName = input.next();
					String chrom4sequence = input.next();
					output.format("%s\t%s\t%d\t%s%n", firstName, lastName, numberOfRepeates(chrom4sequence, "CAG"),
							getDiseaseStatus(numberOfRepeates(chrom4sequence, "CAG")));
				}
			} catch (SecurityException | FileNotFoundException | FormatterClosedException e) {
				e.printStackTrace();
			}
		} catch (IOException | NoSuchElementException | IllegalStateException e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		try (Scanner input = new Scanner(Paths.get("./src/PS4/huntington.txt"))) // To read from console it is System.in
//		{
//			try (Formatter output = new Formatter("./src/PS4/HD_report.txt")) {
//
//				input.nextLine();
//				while(input.hasNext()) {
//					String firstName=input.next();
//					String lastName= input.next();
//					String chorm4seq=input.next();
//					int repeated=0;
//					output.format("%s\t%s\t%d\t%s%n",
//							firstName,lastName,numberOfRepeates(chorm4seq,"CAG"),getDiseaseStatus(repeated));
//				}
//				input.next();
//
//				output.format("...");
//
//			} catch (SecurityException | FileNotFoundException | FormatterClosedException e) {
//				e.printStackTrace();
//			}
//		} catch (IOException | NoSuchElementException | IllegalStateException e) {
//			e.printStackTrace();
//		}
//	}

	public static int numberOfRepeates(String sequence, String dnaRepeat) {
		Pattern pattern=Pattern.compile(dnaRepeat);
		Matcher matcher=pattern.matcher(sequence);
		int count=0;
		while(matcher.find()) count++;
		return count;
	}

	private static DiseaseStatusHD getDiseaseStatus(int repeatCount) {
		DiseaseStatusHD diseaseStatus = DiseaseStatusHD.WILL_NOT_DEVELOP_HD;
		if (repeatCount >= 27 && repeatCount <= 37) {
			diseaseStatus = DiseaseStatusHD.OFFSPRING_AT_RISK;
		} else if (repeatCount == 38 || repeatCount == 39) {
			diseaseStatus = DiseaseStatusHD.AT_HD_RISK;
		} else if (repeatCount >= 40) {
			diseaseStatus = DiseaseStatusHD.WILL_DEVELOP_HD;
		}
		return diseaseStatus;

	}
}