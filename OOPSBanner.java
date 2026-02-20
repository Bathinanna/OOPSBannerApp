/**
 * OPSBannerApp – Using Map for Character Patterns and Rendering via Function
 *
 * This class demonstrates creation of ASCII art patterns using HashMap.
 * It stores patterns for characters in a reusable map and prints the banner
 * for the given message (e.g., "OOPS") line-by-line.
 *
 * Author: Developer
 * Version: 8.0
 */

import java.util.HashMap;

public class OOPSBanner {
    public static HashMap<Character, String[]> createCharacterMap() {

        HashMap<Character, String[]> charMap = new HashMap<>();

      
        charMap.put('O', new String[]{
            " *** ",
            "*   *",
            "*   *",
            "*   *",
            " *** "
        });

        // ASCII art pattern for 'P'
        charMap.put('P', new String[]{
            "**** ",
            "*   *",
            "**** ",
            "*    ",
            "*    "
        });

        // ASCII art pattern for 'S'
        charMap.put('S', new String[]{
            " *** ",
            "*    ",
            " *** ",
            "    *",
            " *** "
        });

        return charMap;
    }

    /**
     * Displays the ASCII banner for the provided message.
     * It loops through each of the 5 rows and constructs the full row
     * by combining the matching rows of each character.
     *
     * @param message The word to print as banner (e.g., "OOPS")
     * @param charMap Map containing ASCII patterns for characters
     */
    public static void displayBanner(String message, HashMap<Character, String[]> charMap) {

      
        message = message.toUpperCase();

    
        for (int line = 0; line < 5; line++) {

            StringBuilder bannerLine = new StringBuilder();

          
            for (char ch : message.toCharArray()) {


                String[] pattern = charMap.get(ch);

                if (pattern != null) {
                    bannerLine.append(pattern[line]).append("  "); // space between characters
                }
         }
           
            System.out.println(bannerLine.toString());
 }
    }    
     public static void main(String[] args) {

              HashMap<Character, String[]> charMap = createCharacterMap();
        String message = "OOPS";
        displayBanner(message, charMap);
}
}

