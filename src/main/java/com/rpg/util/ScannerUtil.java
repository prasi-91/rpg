package com.rpg.util;

import java.util.Scanner;

public class ScannerUtil {
	public static Scanner inputHandler = new Scanner(System.in);

	public static void closeInputConnection() {
		inputHandler.close();
	}
}
