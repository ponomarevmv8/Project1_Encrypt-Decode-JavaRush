import java.util.*;

public class Start {

    private final String alphabet ="абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";

    private final Map<Integer, List<Character>> shifr = new HashMap<>();

    private List<Character> alphabetShifr = new ArrayList<>(alphabet.length());

    private Scanner scanner;

    public Start(){
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

    public Map<Integer, List<Character>> getShifr() {
        return shifr;
    }
}
