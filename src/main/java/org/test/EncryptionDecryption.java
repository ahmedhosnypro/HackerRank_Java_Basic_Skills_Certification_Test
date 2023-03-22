package org.test;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EncryptionDecryption {

}

class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//        String encryptedMessage = bufferedReader.readLine();
        Scanner scanner = new Scanner(System.in);
        String encryptedMessage = scanner.nextLine();
        String result = Result.decryptMessage(encryptedMessage);
        System.out.println(result);
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

class Result {

    public static String decryptMessage(String encryptedMessage) {
        String[] words = encryptedMessage.split(" ");
        List<String> decryptedWords = new ArrayList<>();
        for (String word : words) {
            decryptedWords.add(decryptWord(word));
        }
        StringBuilder decryptedMessage = new StringBuilder();
        for (int i = decryptedWords.size() - 1; i >= 0; i--) {
            decryptedMessage.append(decryptedWords.get(i));
            if (i != 0) {
                decryptedMessage.append(" ");
            }
        }
        return decryptedMessage.toString();
    }


    private static String decryptWord(String word) {
        StringBuilder decryptedWord = new StringBuilder();
        char[] letters = word.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            char letter = letters[i];
            if (Character.isDigit(letter)) {
                for (int j =0; j < letter - '0'; j++) {
                    decryptedWord.append(decryptedWord.charAt(decryptedWord.length() - 1));
                }
            } else {
                decryptedWord.append(letter);
            }
        }
        return decryptedWord.toString();
    }
}