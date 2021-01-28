package com.morse.code;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MorseCodeTranslator {

    private static final String[] letters = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            ",", ".", "?" };

    private static final String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "--..--", ".-.-.-", "..--.." };

    public static String translate(String text){
        StringBuilder sb = new StringBuilder();
        Map<String, String> charMap = mapMorseCodes();
        String[] words = text.trim().toLowerCase(Locale.ROOT).split(" ");

        for(String word : words){
            for (int i = 0; i < word.length(); i++){
                Character c  = word.charAt(i);
                sb.append(charMap.get(c.toString()));
                sb.append(" ");
            }
            sb.append(" | ");
        }
        return sb.toString();
    }

    private static Map<String, String> mapMorseCodes(){
        Map<String, String> charMap = new HashMap<>();
        for (int i = 0; i < letters.length; i++){
            charMap.put(letters[i], morse[i]);
        }
        return charMap;
    }

//    public static void main(String[] args) {
//        System.out.println(translate("abcdefghijklmnopqrstuvwxyz0123456789"));
//    }

}
