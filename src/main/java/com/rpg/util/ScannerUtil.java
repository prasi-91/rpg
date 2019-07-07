package com.rpg.util;

import java.util.Scanner;

public class ScannerUtil {
	private final Scanner scanner;

	public ScannerUtil() {
		this(new Scanner(System.in));
	}

	public ScannerUtil(Scanner scanner) {
		this.scanner = scanner;
	}

	public String getInput() {
		return scanner.nextLine();
	}
}
