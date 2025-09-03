package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Dummy {

    @Test
    public void test(){
        int age = 19 ;
        System.out.println( age < 18);

        //Assertions.assertFalse(age < 18);
        //Assertions.assertFalse(false);


        String name1 = null ;
        String name2 = "Lama";
        String name3 = "Lama";
        String name4 = new String( "Lama");

        //Assertions.assertNull(name1);
        //Assertions.assertNull(name2); //False
        //Assertions.assertNull(name3); //False
        //Assertions.assertNotNull(name2); //null so true
        //Assertions.assertNotNull(name3); //null so true


        //Assertions.assertEquals(name2,name3);
        Assertions.assertSame(name2,name3);

        //Assertions.assertEquals(name2,name4);
        //Assertions.assertSame(name2,name4);







    }
}
