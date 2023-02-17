import java.util.*;

public class Encrypted extends Start {

    public Encrypted(boolean mode) {
        super.inputText();
        inputKey();
        if(mode)
            encryptedText();
        else
            decodeByKey(key);
    }

    public Encrypted(boolean mode ,String inputText) {
        super.inputText = inputText;
        inputKey();
        if(mode)
            encryptedText();
        else
            decodeByKey(key);
    }
    private void inputKey() {
        super.scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите пожалуйста ключ от 1 до 40: ");
            if(scanner.hasNextInt()) {
                super.key = scanner.nextInt();
                if(super.key >= 1 && super.key <= 40) {
                    break;
                } else System.out.println("Вы ввели ключ не в заданном интервале...");
            }
        }
    }
    private void encryptedText() {
        List<Character> alphabet= super.shifr.get(0);
        List<Character> alphabetShifr = super.shifr.get(super.key);
        for (int i = 0; i < super.inputText.length(); i++) {
            char ch = super.inputText.toLowerCase().charAt(i);
            int index = alphabet.indexOf(ch);
            if(index == -1) {
                super.outputText += ch;
            } else
                super.outputText += alphabetShifr.get(index).toString();
        }
        System.out.println("Ваш закодированный текст: " + super.outputText);
    }

    private void decodeByKey(int key) {
        List<Character> alphabet= super.shifr.get(key);
        List<Character> alphabetShifr = super.shifr.get(0);
        for (int i = 0; i < super.inputText.length(); i++) {
            char ch = super.inputText.toLowerCase().charAt(i);
            int index = alphabet.indexOf(ch);
            if(index == -1) {
                super.outputText += ch;
            } else
                super.outputText += alphabetShifr.get(index).toString();
        }
        System.out.println("Ваш раскодированный текст: " + super.outputText);
    }
}
