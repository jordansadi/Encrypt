package edu.wctc.jsadi;

import java.io.*;
import java.util.ArrayList;

/**
 * This class creates a framework for simple encryption of a file
 * Created by jsadi on 9/1/2018
 * @author Jordan Sadi
 * @version 2018 0822 .3
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        encrypt("unencrypted.txt");
        decrypt();
    }

    /**
     * This method encrypts a text file.
     * Each character in the file is converted to its ASCII value and added to an ArrayList.
     * The ASCII values are doubled and added to a char[].
     * The char[] is written to a new, encrypted file.
     * @param fileName the name of the file that is to be encrypted
     * @throws FileNotFoundException if the specified file does not exist
     * @throws IOException if a file cannot be closed
     * @throws Exception if a file cannot be read from or written to
     */
    public static void encrypt(String fileName) {
        BufferedReader in = null;
        Writer out = null;
        String line;
        ArrayList<Integer> asciiArray = new ArrayList<>();

        try {
            in = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File Open Error: " + fileName + " " + e);
        }

        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("encrypted.txt")));
        } catch(FileNotFoundException e) {
            System.out.println("File Open Error: encrypted.txt "  + e);
        }

        try {
            while ((line = in.readLine()) != null) {
                char[] lineArray = line.toCharArray();

                for (char c : lineArray) {
                     asciiArray.add(((int)c * 2));
                }
            }
        } catch (Exception e) {
            System.out.println("File Write Error: unencrypted.txt " + e);
        }

        char[] outputArray = new char[asciiArray.size()];
        for (int i = 0; i < outputArray.length; i++) {
            outputArray[i] = (char)asciiArray.get(i).intValue();
        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.write(outputArray);
        }
        catch(Exception e) {
            System.out.println("File Write Error: encrypted.txt "  + e);
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method decrypts a file encrypted with the encrypt() method.
     * The encrypted file is converted to a char[].
     * Each char in the char[] is halved, then added to an ArrayList.
     * The ArrayList is converted to a char[] and written to a decrypted file.
     * @throws FileNotFoundException if the specified file does not exist
     * @throws IOException if a file cannot be closed
     * @throws Exception if a file cannot be read from or written to
     */
    public static void decrypt() {
        BufferedReader in = null;
        Writer out = null;
        String line;
        ArrayList<Integer> asciiArray = new ArrayList<>();

        try {
            in = new BufferedReader(new FileReader("encrypted.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File Open Error: encrypted.txt " + e);
        }

        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("decrypted.txt")));
        }
        catch(FileNotFoundException e) {
            System.out.println("File Open Error: decrypted.txt "  + e);
        }

        try {
            while ((line = in.readLine()) != null) {
                char[] lineArray = line.toCharArray();

                for (char c : lineArray) {
                    asciiArray.add(((int)c / 2));
                }
            }
        } catch (Exception e) {
            System.out.println("File Write Error: encrypted.txt " + e);
        }

        char[] outputArray = new char[asciiArray.size()];
        for (int i = 0; i < outputArray.length; i++) {
            outputArray[i] = (char)asciiArray.get(i).intValue();
        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.write(outputArray);
        }
        catch(Exception e) {
            System.out.println("File Write Error: decrypted.txt "  + e);
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
