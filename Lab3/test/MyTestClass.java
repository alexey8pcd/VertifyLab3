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
        key.setChars(alphabet);
        char[] expected = {'a', 'b', 'c'};
        char[] result = key.getAllChars();
        assertArrayEquals(expected, result);
    }  
}
