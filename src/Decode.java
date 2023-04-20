import java.util.*;

public class Decode extends Start{
    private String outChar = "";
    private int caountMax = -1;
    private int caountPrepositions = 0;
    private String resultCheckPrepositions = "";

    private final String[] prepositions = {"В", "Над", "О", "Об", "От", "По", "При", "Про", "С", "Со", "У"};

    public Decode () {
        super.inputText();
        decoding();
        printResulText();
    }

    public Decode (String inputText) {
        super.inputText = inputText.trim();
        decoding();
        printResulText();
    }

    private void decoding() {
        for(int key : super.shifr.keySet()) {
            List<Character> alphabetaShifr = shifr.get(key);
            for(int i = 0; i < super.inputText.length(); i++) {
                char ch = super.inputText.charAt(i);
                int index = alphabetaShifr.indexOf(ch);
                if(index == -1) {
                    outChar += ch;
                } else {
                    outChar += super.alphabet.charAt(index);
                }
            }
            if(checkResult(outChar)) {
                this.key = key;
                this.outputText = outChar;
            }
            outChar = "";
        }
    }
    private boolean checkResult(String outChar){
        String[] splitMax = outChar.split(" ");
        // Проверка на пунктуацию
        int count = 0;
        for (String text : splitMax){
            if(!punctuationСheck(text)) return false;
            if(isPreposition(text)) count++;

        }
        if(splitMax.length > this.caountMax ) {
            this.caountMax = splitMax.length;
            if(count > this.caountPrepositions) {
                this.resultCheckPrepositions = outChar;
                this.caountPrepositions = count;
            }
            return true;
        }
        return false;
    }
    private boolean punctuationСheck (String text) {
        if(text.indexOf(',') != text.length() - 1) {
            if (text.indexOf(',') != -1) {
                return false;
            }
        }
        if (text.indexOf('.') != text.length() - 1) {
            if (text.indexOf('.') != -1) {
                return false;
            }
        }
        if (text.indexOf('!') != text.length() - 1) {
            if (text.indexOf('!') != -1) {
                return false;
            }
        }
        if(text.indexOf('?') != text.length() - 1) {
            if (text.indexOf('?') != -1) {
                return false;
            }
        }
        return true;
    }
    private boolean isPreposition(String word) {
        for (String preposition : prepositions) {
            if (word.equalsIgnoreCase(preposition)) {
                return true;
            }
        }
        return false;
    }
    private void printResulText(){
        if (this.outputText.equals(this.resultCheckPrepositions)) System.out.println("Расшифрованный текст: " + outputText + "\nКлюч: " + this.key);
        else {
            System.out.println("При расшифровке возникли некоторые трудности....\nОдин из текстов ваша расшифровка");
            System.out.println("Расшифрованный текст вариант 1: " + this.outputText + "\nКлюч: " + this.key);
            if (!resultCheckPrepositions.equals(""))
                System.out.println("Расшифрованный текст вариант 2: " + this.resultCheckPrepositions + "\nКлюч: " + this.key);
        }
    }
}