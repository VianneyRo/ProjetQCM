package fr.eni.projet.qcm.common.util;

import fr.eni.projet.qcm.common.AppConstants;

/**
 * String utilities.
 * 
 * @author externe
 *
 */
public class StringUtil {

    private StringUtil() {}
    
    /**
     * Convert Null value to blank value.
     * 
     * @param data
     * @return
     */
    public static final String nullToBlank(String data) {
        String result = AppConstants.EMPTY;
        if(data != null) {
        	result = data;
    	}
        return result;
    }
}
