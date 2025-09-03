package Tests.Junit;

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
        //Assertions.assertNull(name2);
        //Assertions.assertNull(name3);
        //Assertions.assertNotNull(name2);
        //Assertions.assertNotNull(name3);


        //Assertions.assertEquals(name2,name3);
        Assertions.assertSame(name2,name3);

        //Assertions.assertEquals(name2,name4);
        //Assertions.assertSame(name2,name4);
    }
}
