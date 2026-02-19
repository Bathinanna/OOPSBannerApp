/* 

 * OOPSBannerApp UC7 - Store Character Pattern in a Class
 *
 * This use case extends UC6 by implementing a CharacterPatternMap class to encapsulate
 * character-to-pattern mappings. The application retrieves and displays the "OOPS"
 * banner using these mappings. This approach enhances code organization and modularity.
 *
 *
 * @author Developer
 * @version 7.0
 */

public class OOPSBanner {

    static class CharacterPatternMap {
        final char ch;
        final String[] pattern; 

        CharacterPatternMap(char ch, String[] pattern) {
            this.ch = Character.toUpperCase(ch);
            this.pattern = pattern;
        }
    }

    private static final char BLANK = ' ';
    private static final char PIXEL = '*';
    private static final String LETTER_GAP = "  "; // will be normalized to BLANK

    public static void main(String[] args) {
        CharacterPatternMap[] maps = createCharacterPatternMaps();
        String message = "OOPS";
        printMessage(message, maps);
    }

    public static CharacterPatternMap[] createCharacterPatternMaps() {
        String[] O = {
                "..XXX..",
                ".X...X.",
                "X.....X",
                "X.....X",
                "X.....X",
                ".X...X.",
                "..XXX.."
        };

        String[] P = {
                "XXXXXX.",
                "X.....X",
                "X.....X",
                "XXXXXX.",
                "X......",
                "X......",
                "X......"
        };

        String[] S = {
                ".XXXXX.",
                "X......",
                "X......",
                ".XXXXX.",
                "......X",
                "......X",
                ".XXXXX."
        };

        String[] SPACE = {
                ".......",
                ".......",
                ".......",
                ".......",
                ".......",
                ".......",
                "......."
        };

        String[] UNKNOWN = {
                ".XXXXX.",
                "....X..",
                "...X...",
                "..X....",
                "..X....",
                ".......",
                "..X...."
        };

        return new CharacterPatternMap[] {
                new CharacterPatternMap('O', O),
                new CharacterPatternMap('P', P),
                new CharacterPatternMap('S', S),
                new CharacterPatternMap(' ', SPACE),
                new CharacterPatternMap('?', UNKNOWN)
        };
    }

    /** Lookup pattern for a given character or return a fallback. */
    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] maps) {
        char upper = Character.toUpperCase(ch);
        for (CharacterPatternMap m : maps) {
            if (m.ch == upper) return m.pattern;
        }
        for (CharacterPatternMap m : maps) {
            if (m.ch == '?') return m.pattern;
        }
        return new String[]{".......",".......",".......",".......",".......",".......","......."};
    }

    /** Render message row-by-row across letters. */
    public static void printMessage(String message, CharacterPatternMap[] maps) {
        String gap = LETTER_GAP.replace(' ', BLANK);
        int height = getCharacterPattern('O', maps).length;
        for (int r = 0; r < height; r++) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                String[] pat = getCharacterPattern(message.charAt(i), maps);
                line.append(convertRow(pat[r]));
                if (i < message.length() - 1) line.append(gap);
            }
            System.out.println(line);
        }
    }

   /** Convert a pattern row: X -> '*', '.' -> BLANK */
    private static String convertRow(String row) {
        StringBuilder sb = new StringBuilder(row.length());
        for (int i = 0; i < row.length(); i++) {
            char c = row.charAt(i);
            sb.append(c == 'X' ? PIXEL : BLANK);
        }
        return sb.toString();
    }
}
