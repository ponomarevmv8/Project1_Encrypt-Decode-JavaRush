import java.net.Inet4Address;
import java.util.*;

public class Encrypted {

    private Map<Integer, List<Character>> shifr;
    private int key;

    private String encryptedText = "";

    private String inputText = "";



    public Encrypted(Map<Integer, List<Character>> shifr) {
        this.shifr = shifr;
        inputText();
        inputKey();
        encryptedText();
    }

    private void inputText(){
        System.out.println("Введите пожалуйста текст для зашифровки\nПри завершение набора текста, введите exit");
        Scanner scanner = new Scanner((System.in));
        List<String> text = new ArrayList<>();
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            if(str.equals("exit")) break;
            else {
                text.add(str);
            }
        }
        for(String str : text){
            inputText += str + " ";
        }



    }
    private void inputKey() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите пожалуйста ключ для зашифровки от 1 до 40: ");
            if(scanner.hasNextInt()) {
                key = scanner.nextInt();
                if(key >= 1 && key <= 40) {
                    break;
                } else System.out.println("Вы ввели ключ не в заданном интервале...");
            }
        }
    }

    private void encryptedText() {
        List<Character> alphabet= shifr.get(0);
        List<Character> alphabetShifr = shifr.get(key);

        for (int i = 0; i < inputText.length(); i++) {
            char ch = inputText.toLowerCase().charAt(i);
            int index = alphabet.indexOf(ch);
            if(index == -1) {
                encryptedText += ch;
            } else
                encryptedText += alphabetShifr.get(index).toString();
        }

        System.out.println("Ваш закодированный текст: " + encryptedText);
    }

}
