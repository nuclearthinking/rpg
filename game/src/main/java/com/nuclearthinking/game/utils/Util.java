package com.nuclearthinking.game.utils;

/**
 * Created
 * Date: 23.12.2015
 * Time: 14:41
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class Util {

    public String setFirstCharUpperCase(String string){
        String firstChar = String.valueOf(string.charAt(0));
        String otherPart = string.substring(1,string.length());
        return firstChar.toUpperCase()+otherPart;
    }
}
