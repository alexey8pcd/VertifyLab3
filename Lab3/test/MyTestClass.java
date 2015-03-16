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
        char[] result = key.getBaseAlphabet();
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
            'a', 'b', 'c'
        };
        boolean expected = false;
        boolean result = Comparer.compareCharArrays(alpahbet1, alphabet2);
        assertEquals(expected, result);
    }

    @Test
    public void testCharArrayEquals3() {
        char[] alpahbet1 = {
            'a', 'b', 'c', 'd'
        };
        char[] alphabet2 = {
            'a', 'b', 'c', 'd'
        };
        boolean expected = true;
        boolean result = Comparer.compareCharArrays(alpahbet1, alphabet2);
        assertEquals(expected, result);
    }

    @Test
    public void testEqualsKeys() {
        Key key1 = new Key();
        char[] alphabet = {
            'a', 'b', 'c', 'd'
        };
        key1.setBaseAlphabet(alphabet);
        char[] alphabet2 = {
            's', 'f', 'g', 'n'
        };
        key1.setReplacingAlphabet(alphabet2);
        Key key2 = new Key();
        char[] alphabet3 = new char[alphabet.length];
        char[] alphabet4 = new char[alphabet2.length];
        System.arraycopy(alphabet, 0, alphabet3, 0, alphabet.length);
        System.arraycopy(alphabet2, 0, alphabet4, 0, alphabet2.length);
        key2.setBaseAlphabet(alphabet3);
        key2.setReplacingAlphabet(alphabet4);
        boolean expected = true;
        boolean result = key1.equals(key2);
        assertEquals(expected, result);
    }

    @Test
    public void testEqualsKeys2() {
        Key key1 = new Key();
        key1.setBaseAlphabet(null);
        key1.setReplacingAlphabet(null);
        Key key2 = null;
        boolean expected = false;
        boolean result = key1.equals(key2);
        assertEquals(expected, result);
    }

    @Test
    public void testEqualsKeys3() {
        Key key1 = new Key();
        char[] alphabet = {'a', 'b'};
        char[] alphabet2 = {'b', 'a'};
        key1.setBaseAlphabet(alphabet);
        Key key2 = new Key();
        key2.setBaseAlphabet(alphabet2);
        boolean expected = false;
        boolean result = key1.equals(key2);
        assertEquals(expected, result);
    }

    @Test
    public void testEqualsKeys4() {
        Key key1 = new Key();
        char[] alphabet = {'a', 'b'};
        char[] alphabet2 = null;
        key1.setBaseAlphabet(alphabet);
        Key key2 = new Key();
        key2.setBaseAlphabet(alphabet2);
        boolean expected = false;
        boolean result = key1.equals(key2);
        assertEquals(expected, result);
    }

    @Test
    public void testKeyHashCode() {
        Key key1 = new Key();
        Key key2 = new Key();
        int expected = key1.hashCode();
        int result = key2.hashCode();
        assertEquals(expected, result);
    }

    @Test
    public void testKeyHashCode2() {
        Key key1 = new Key();
        Key key2 = new Key();
        char[] alpahbet = {'a', 'b'};
        key2.setBaseAlphabet(alpahbet);
        boolean expected = false;
        boolean result = Integer.compare(key1.hashCode(), key2.hashCode()) == 0;
        assertEquals(expected, result);
    }

    @Test
    public void testSetAndGetKeyInEncryptor() {
        Encryptor encryptor = new Encryptor();
        Key expected = new Key();
        char[] alphabet = {
            'a', 'b', 'c'
        };
        char[] alphabet2 = {
            'z', 'v', 'g'
        };
        expected.setBaseAlphabet(alphabet);
        expected.setReplacingAlphabet(alphabet2);
        encryptor.setKey(expected);
        Key result = encryptor.getKey();
        assertEquals(expected, result);
    }

    @Test
    public void testCreateKeyAlphabetToKey() {
        char[] alphabet = {'a'};
        char[] alphabet2 = {'z'};
        Key key = new Key(alphabet, alphabet2);
        assertArrayEquals(alphabet, key.getBaseAlphabet());
        assertArrayEquals(alphabet2, key.getReplacingAlphabet());
    }

    @Test
    public void testEncryptOneChar() {
        Encryptor encryptor = new Encryptor();
        char[] alphabet = {'a'};
        char[] replacingAlphabet = {'z'};
        encryptor.setKey(new Key(alphabet, replacingAlphabet));
        char toEncrypt = 'a';
        char expected = 'z';
        char result = encryptor.encryptChar(toEncrypt);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptOneChar2() {
        Encryptor encryptor = new Encryptor();
        char[] alphabet = {'a', 'b', 'c'};
        char[] replacingAlphabet = {'h', 'g', 'f'};
        encryptor.setKey(new Key(alphabet, replacingAlphabet));
        char toEncrypt = 'c';
        char expected = 'f';
        char result = encryptor.encryptChar(toEncrypt);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptOneChar3() {
        Encryptor encryptor = new Encryptor();
        char[] alphabet = {'a', 'b', 'c'};
        char[] replacingAlphabet = {'h', 'g'};
        encryptor.setKey(new Key(alphabet, replacingAlphabet));
        char toEncrypt = 'c';
        char expected = Key.NULL_SYMBOL;
        char result = encryptor.encryptChar(toEncrypt);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptOneChar4() {
        Encryptor encryptor = new Encryptor();
        encryptor.setKey(new Key());
        char toEncrypt = 'a';
        char expected = Key.NULL_SYMBOL;
        char result = encryptor.encryptChar(toEncrypt);
        assertEquals(expected, result);
    }

    @Test
    public void testEncrypt2() {
        String string="abacan";
        Encryptor encryptor=new Encryptor();
        char[] alphabet={
            'a','b','c','n'
        };
        char[] alphabet2={
            '0','1','2','3'
        };
        Key key=new Key(alphabet,alphabet2);
        encryptor.setKey(key);        
        String expected = "010203";
        String result=encryptor.encrypt(string);
        assertEquals(expected, result);        
    }

    @Test
    public void testEncryptAndDecryptStringDefaultKey(){
        String expected="Pure virtual function";
        Encryptor encryptor=new Encryptor();
        encryptor.setKey(new Key(100));
        String encryptedString=encryptor.encrypt(expected);
        String result=encryptor.decrypt(encryptedString);
        assertEquals(expected, result);
        
    }
}
