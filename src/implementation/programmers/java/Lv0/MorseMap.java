package Programmers.JAVA.Lv0;

import java.util.HashMap;

public class MorseMap {
    public StringBuilder solution(String letter) {
        HashMap<String, Character> morseMap = new HashMap<String, Character>();
        morseMap.put(".-", 'a');
        morseMap.put("-...", 'b');
        morseMap.put("-.-.", 'c');
        morseMap.put("-..", 'd');
        morseMap.put(".", 'e');
        morseMap.put("..-.", 'f');
        morseMap.put("--.", 'g');
        morseMap.put("....", 'h');
        morseMap.put("..", 'i');
        morseMap.put(".---", 'j');
        morseMap.put("-.-", 'k');
        morseMap.put(".-..", 'l');
        morseMap.put("--", 'm');
        morseMap.put("-.", 'n');
        morseMap.put("---", 'o');
        morseMap.put(".--.", 'p');
        morseMap.put("--.-", 'q');
        morseMap.put(".-.", 'r');
        morseMap.put("...", 's');
        morseMap.put("-", 't');
        morseMap.put("..-", 'u');
        morseMap.put("...-", 'v');
        morseMap.put(".--", 'w');
        morseMap.put("-..-", 'x');
        morseMap.put("-.--", 'y');
        morseMap.put("--..", 'z');

        StringBuilder result = new StringBuilder();

        for (String code : letter.split(" ")){
            Character ch = morseMap.get(code);
            if(ch != null) {
                result.append(ch);
            }
        }
        return result;
    }
}

