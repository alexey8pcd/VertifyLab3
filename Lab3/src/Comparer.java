


/**
 * @author Alexey
 */
public class Comparer {

    public static boolean compareCharArrays(char[] array1, char[] array2) {
        boolean arrayEquals = true;
        if (array1 == null) {
            arrayEquals = array2 == null;
        } else {
            if (array2 == null) {
                arrayEquals= false;
            } else {
                if (array1.length != array2.length) {
                    arrayEquals= false;
                } else {
                    for (int i = 0; i < array1.length; i++) {
                        if (array1[i] != array2[i]) {
                            arrayEquals= false;
                        }
                    }
                }
            }
        }
        return arrayEquals;
    }
}
