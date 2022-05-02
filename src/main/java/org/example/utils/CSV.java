package org.example.utils;

import java.util.ArrayList;
import java.util.List;

public class CSV {
    private CSV() { }

    /**
     * Encloses a given text between quote marks and escapes quote marks inside the text.
     * @param text The text to encode.
     * @return The text enclosed between quote marks and with escaped quotes.
     */
    public static String encode(String text) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '"') {
                sb.append("\"\"");
            }
            else {
                sb.append(text.charAt(i));
            }
        }

        sb.insert(0, '"');
        sb.append('"');

        return sb.toString();
    }

    /**
     * Deletes the enclosing quote marks from an encoded text and converts its escaped quotes to single quotes.
     * @param encodedText The text to decode.
     * @return The text without enclosing quotes and without escaped quotes.
     */
    public static String decode(String encodedText) {
        StringBuilder sb = new StringBuilder();

        int i = 1;
        while (i < encodedText.length() - 1) {
            if (encodedText.charAt(i) == '"') {
                i++;
            }
            sb.append(encodedText.charAt(i));
            i++;
        }

        return sb.toString();
    }

    /**
     * Returns the next comma separator index starting from the first quote mark of an encoded text
     * or the index where it's supposed to be if there's no more encoded text.
     * @param encodedRegister A CSV register containing encoded text separated by commas.
     * @param firstQuoteMarkIndex The index of the first quote mark of an encoded text.
     * @return The index of the comma separator situated between the first quote mark of the encoded text
     * and the next encoded text or the index where it's supposed to be if there's no more encoded text.
     */
    private static int getNextSeparatorIndex(String encodedRegister, int firstQuoteMarkIndex) {
        int result = encodedRegister.length();

        int i = firstQuoteMarkIndex;
        int commaCount = 0;
        do {
            i++;
            if (encodedRegister.charAt(i) == '"') {
                commaCount++;
            }
        } while (i + 1 < encodedRegister.length() && !(commaCount % 2 != 0 && encodedRegister.charAt(i + 1) == ','));

        if (i + 1 < encodedRegister.length()) {
            result = i + 1;
        }

        return result;
    }

    /**
     * Converts a list of text values to a CSV register containing the encoded text values separated by commas.
     * @param decodedRegister A list of plain text values.
     * @return A CSV register containing the encoded text values separated by commas.
     */
    public static String encodeRegister(List<String> decodedRegister) {
        StringBuilder encodedRegister = new StringBuilder();

        for (String text : decodedRegister) {
            encodedRegister.append(encode(text)).append(",");
        }

        encodedRegister.setLength(encodedRegister.length() - 1);
        encodedRegister.append("\n");

        return encodedRegister.toString();
    }

    /**
     * Converts an encoded CSV register to separated and decoded text.
     * @param encodedRegister A text line containing encoded text separated by commas.
     * @return A list with the decoded text.
     */
    public static List<String> decodeRegister(String encodedRegister) {
        List<String> decodedData = new ArrayList<>();

        int index = 0;
        int commaSeparatorIndex;

        while (index <= encodedRegister.length()) {
            commaSeparatorIndex = getNextSeparatorIndex(encodedRegister, index);
            decodedData.add(decode(encodedRegister.substring(index, commaSeparatorIndex)));
            index = commaSeparatorIndex + 1;
        }

        return decodedData;
    }
}
