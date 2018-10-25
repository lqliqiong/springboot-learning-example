package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: lq
 * @CreateTime:2018-10-18 17:17
 * @Description:todo
 */
public class CollectionsDemo {
    public static void main(String args[]) {
        disjoint();
    }

    private static void  disjoint(){
        // create two lists
        List<String> srclst = new ArrayList<String>(5);
        List<String> destlst = new ArrayList<String>(10);

        // populate two lists
        srclst.add("Java");
        srclst.add("is");
        srclst.add("best");

        destlst.add("C++");
        destlst.add("is not");
        destlst.add("older");

        // check elements in both collections
        boolean iscommon = Collections.disjoint(srclst, destlst);

        System.out.println("No commom elements: "+iscommon);
    }
}
