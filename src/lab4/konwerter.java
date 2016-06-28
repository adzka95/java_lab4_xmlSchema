/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.math.BigDecimal;
import java.util.regex.Pattern;
import javafx.util.StringConverter;

/**
 *
 * @author Ada
 */
public class konwerter extends StringConverter<BigDecimal> {
    
    /** {@inheritDoc} */
    @Override public BigDecimal fromString(String value) {
        // If the specified value is null or zero-length, return null
        if (value == null) {
            return null;
        }

        value = value.trim();

        if (value.length() < 1) {
            return null;
        }
        Pattern pat=Pattern.compile("[a-z]");
        for(int i=1; i<value.length();){
           char znak=value.charAt(i);
           if((znak=='0'||znak=='1'||znak=='2'||znak=='3'||znak=='4'||znak=='5'||znak=='6'||znak=='7'||znak=='8'||znak=='9'||znak=='.'))
                i+=1;
           else
               return null;
            
        }
        return new BigDecimal(value);
    }

    
     @Override public String toString(BigDecimal value) {
        // If the specified value is null, return a zero-length String
        if (value == null) {
            return "";
        }

        return ((BigDecimal)value).toString();
    }
}