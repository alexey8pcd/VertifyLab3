/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Алексей
 */
public class MyTestClass {

    public MyTestClass() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testEncrypt() {
        Encryptor encryptor = new Encryptor();
        assertNotNull(encryptor);
    }

    @Test
    public void testKey() {
        Key key = new Key();
        assertNotNull(key);
    }

    @Test
    public void testGetAndSetOneChar() {
        Key key = new Key();
        key.setCharToEncrypt('a');
        char expected = 'a';
        char result = key.getCharToEncrypt();
        assertEquals(expected, result);
    }

    @Test
    public void testGetAndSetAnotherChar() {
        Key key = new Key();
        key.setCharToEncrypt('g');
        char expected = 'g';
        char result = key.getCharToEncrypt();
        assertEquals(expected, result);
    }

    @Test
    public void testGetAndSetAnotherChar2() {
        Key key = new Key();
        key.setCharToEncrypt('m');
        char expected = 'm';
        char result = key.getCharToEncrypt();
        assertEquals(expected, result);
    }

    @Test
    public void testGetAndSetChars() {
        Key key = new Key();
        char[] alphabet = {
            'a', 'b', 'c'
        };
        key.setBaseAlphabet(alphabet);
        char[] expected = {'a', 'b', 'c'};
        char[] result = key.getAllChars();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testGetAndSetReplace() {
        Key key = new Key();
        char[] alphabet = {
            'z', 'y', 'x'
        };
        key.setReplacingAlphabet(alphabet);
        char[] expected = {'z', 'y', 'x'};
        char[] result = key.getReplacingAlphabet();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testReplacedChar() throws Exception {
        Key key = new Key();
        char[] aphabet = {
            'z', 'y', 'x'
        };
        char[] replacingAlphabet = {
            'b', 's', 'e'
        };
        key.setBaseAlphabet(aphabet);
        key.setReplacingAlphabet(replacingAlphabet);
        char expected = 'b';
        char result = key.getEncryptedChar('z');
        assertEquals(expected, result);
    }

    @Test
    public void testCharArrayEquals() {
        char[] alpahbet1 = {
            'a', 'b', 'c', 'd'
        };
        char[] alphabet2 = {
            'z', 'x', 'v', 'n'
        };
        boolean expected = false;
        boolean result = Comparer.compareCharArrays(alpahbet1, alphabet2);
        assertEquals(expected, result);        
    }
    
    @Test
    public void testCharArrayEquals2() {
        char[] alpahbet1 = {
            'a', 'b', 'c', 'd'
        };
        char[] alphabet2 = {
            'a','b','c'
        };
        boolean expected = true;
        boolean result = Comparer.compareCharArrays(alpahbet1, alphabet2);
        assertEquals(expected, result);        
    }
    
    @Test
    public void testCharArrayEquals3() {
        char[] alpahbet1 = {
            'a', 'b', 'c', 'd'
        };
        char[] alphabet2 = {
            'a','b','c','d'
        };
        boolean expected = true;
        boolean result = Comparer.compareCharArrays(alpahbet1, alphabet2);
        assertEquals(expected, result);        
    }
}
