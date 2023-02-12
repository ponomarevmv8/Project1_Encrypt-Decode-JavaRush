import java.util.*;

public class Start {

    protected final String alphabet ="абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";
    protected final Map<Integer, List<Character>> shifr = new HashMap<>();

    protected String inputText ="";
    protected String outputText = "";
    protected int key;
    protected Scanner scanner;

    public Start(){
        List<Character> alphabetShifr = new ArrayList<>(alphabet.length());
        for(int i = 0; i < alphabet.length(); i++) {
            for(int j = 0; j < alphabet.length(); j++) {
                alphabetShifr.add(alphabet.charAt((j+i) % alphabet.length()));
            }
            shifr.put(i, new ArrayList<>(alphabetShifr));
            alphabetShifr.clear();
        }
    }


    public int selectMode() {
        System.out.println("          Выберите режим работы программы\n               1. Расшифровка\n               2. Зашифровка\n");
        while (true){
            System.out.print("Выбранный режим: ");
            scanner = new Scanner(System.in);
            while (scanner.hasNextInt()){
                int i = scanner.nextInt();
                if(i == 1) {
                    return 1;
                } else if (i == 2) {
                    return 2;
                } else {
                    System.out.println("Вы выбрали не существующий режим");
                    System.out.print("Выбранный режим: ");
                }
            }
        }
    }

    protected void inputText(){
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
}
