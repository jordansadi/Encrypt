package edu.wctc.jsadi.Test;
import org.junit.*;
import edu.wctc.jsadi.Main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MainTest extends junit.framework.TestCase {
    @Before
    public void setUp() throws Exception {
        Main.encrypt("unencrypted.txt");
        Main.decrypt();
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testDecrypt() {
        BufferedReader testReader = null;
        String testString = "";

        try {
            testReader = new BufferedReader(new FileReader("decrypted.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File Open Error: decrypted.txt " + e);
        }

        try {
            testString = testReader.readLine();
        } catch (Exception e) {
            System.out.println("File Write Error: decrypted.txt " + e);
        }

        assertEquals(testString, "Please encrypt this file.");
    }

    @Test
    public void testEncrypt() {
        BufferedReader testReader = null;
        String testString = "";

        try {
            testReader = new BufferedReader(new FileReader("encrypted.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File Open Error: encrypted.txt " + e);
        }

        try {
            testString = testReader.readLine();
        } catch (Exception e) {
            System.out.println("File Write Error: encrypted.txt " + e);
        }

        assertEquals(testString, " ØÊÂæÊ@ÊÜÆäòàè@èÐÒæ@ÌÒØÊ\\");
    }
}
