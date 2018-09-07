package org.ontology.processor.utils;

/**
 * Created by thisura on 7/21/18.
 */
public class Utils {
    public static boolean isFloat( String input )
    {
        try
        {
            Float.parseFloat( input );
            return true;
        }
        catch( Exception e)
        {
            return false;
        }
    }
}
