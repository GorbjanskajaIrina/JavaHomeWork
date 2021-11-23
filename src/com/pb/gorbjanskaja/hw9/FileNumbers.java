package com.pb.gorbjanskaja.hw9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class FileNumbers {
    public static void main(String[] args) {
        createNumbersFile();
        createOddNumbersFile();
    }

    private static void createNumbersFile() {
        Path path = Paths.get("files/numbers.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            Random random = new Random();
            int[] array = new int[100];
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(100);
            }
            for (int i = 0; i < array.length; i++) {
                if ((i > 0) && (i % 10 == 0)) {
                    writer.write("\n");
                }
                writer.write(array[i] + " ");
            }

        } catch (Exception ex) {
            System.out.println("Данные не записаны: " + ex);
        }
        System.out.println("Запись в файл \"" + path.toAbsolutePath() + "\" завершена");

    }
    public static void createOddNumbersFile() {
        try (Scanner scan = new Scanner(new File("files/numbers.txt"))) {
            PrintWriter pw = new PrintWriter(new File("files/odd-numbers.txt"));
            while (scan.hasNextLine()) {
                Scanner line = new Scanner(scan.nextLine());
                while (line.hasNextInt()) {
                    int ch = line.nextInt();
                    if (ch % 2 == 0) {
                        System.out.println("0");
                        ch = 0;
                    } else
                        System.out.println(ch + " ");
                    pw.println(ch + " ");
                }
                line.close();
                pw.println();
            }
            System.out.println();
            pw.close();
        } catch (IOException ioException) {
            System.out.println("Данные не записаны" + ioException);
        }
    }


}

