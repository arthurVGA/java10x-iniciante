package org.artius.application.utils;

import java.util.Scanner;

public class ScannerUtils {

    private Scanner scanner;

    public ScannerUtils() {
        this.scanner = new Scanner(System.in);
    }

    public String getUserInputs() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
