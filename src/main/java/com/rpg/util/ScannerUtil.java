package com.rpg.util;

import java.util.Scanner;

public class ScannerUtil {
	public static final Scanner inputHandler = new Scanner(System.in);

	public static void closeInputConnection() {
		inputHandler.close();
	}
}
