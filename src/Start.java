import java.util.*;

public class Start {

    protected final String alphabet ="абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";
    protected Map<Integer, List<Character>> shifr = new HashMap<>();
    protected String inputText ="";
    protected String outputText = "";
    protected int key;
    protected Scanner scanner;

    public Start(){
        initShifr();
    }

    private void  initShifr(){
        List<Character> alphabetShifr = new ArrayList<>(alphabet.length());
        for(int i = 0; i < alphabet.length(); i++) {
            for(int j = 0; j < alphabet.length(); j++) {
                alphabetShifr.add(alphabet.charAt((j+i) % alphabet.length()));
            }
            shifr.put(i, new ArrayList<>(alphabetShifr));
            alphabetShifr.clear();
        }
    }
    public void startProgram() {
        int selectMode = selectMode(); //Выбор режима работы программы
        int i = selectPath();  //Выбор метода получение текста
        if (selectMode == 1) {
            if(selectDecodeMod())
                decodeMod(i);
            else
                decodeByKeyMod(i);
        } else {
            Encrypted encrypted;
            if( i == 1) {
                WorkingWithFiles files = new WorkingWithFiles();
                files.readFile();
                encrypted = new Encrypted(true, files.getInputText());
            } else {
                encrypted = new Encrypted(true);

            }
            this.outputText = encrypted.outputText;
            int j = outputPath();
            if( j == 1) {
                WorkingWithFiles files = new WorkingWithFiles();
                files.setOutputText(this.outputText);
                files.writeFile();
            }
        }

    }
    private int selectMode() {
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

    private int selectPath() {
        System.out.println("Выберите способ вставки текста: \n1. Файл\n2. Ввод");
        System.out.print("Способ №: ");
        scanner = new Scanner(System.in);
        while (true) {
            while (scanner.hasNextInt()) {
                int i = scanner.nextInt();
                if (i == 1) {
                    return 1;
                } else if (i == 2) {
                    return 2;
                } else {
                    System.out.println("Вы выбрали не существующий способ");
                    System.out.print("Способ №: ");
                }
            }
        }
    }

    private boolean selectDecodeMod(){
        System.out.println("\nВыберите способ расшифровки: \n1. Брут-форс\n2. Ввести собственный ключ");
        while (true){
            System.out.print("Выбранный способ: ");
            scanner = new Scanner(System.in);
            while (scanner.hasNextInt()){
                int i = scanner.nextInt();
                if(i == 1) {
                    return true;
                } else if (i == 2) {
                    return false;
                } else {
                    System.out.println("Вы выбрали не существующий способ");
                    System.out.print("Выбранный способ: ");
                }
            }
        }
    }

    private void decodeMod(int i) {
        Decode decode;
        if(i == 1 ) {
            WorkingWithFiles files = new WorkingWithFiles();
            files.readFile();
            decode = new Decode(files.getInputText());
        } else {
            decode = new Decode();
        }
        this.outputText = decode.outputText;
        int j = outputPath();
        if( j == 1) {
            WorkingWithFiles files = new WorkingWithFiles();
            files.setOutputText(this.outputText);
            files.writeFile();
        }
    }

    private void decodeByKeyMod(int i) {
        Encrypted encrypted;
        if( i == 1) {
            WorkingWithFiles files = new WorkingWithFiles();
            files.readFile();
            encrypted = new Encrypted(false, files.getInputText());
        } else {
            encrypted = new Encrypted(false);

        }
        this.outputText = encrypted.outputText;
        int j = outputPath();
        if( j == 1) {
            WorkingWithFiles files = new WorkingWithFiles();
            files.setOutputText(this.outputText);
            files.writeFile();
        }
    }

    private int outputPath(){
        System.out.println("\nНужно ли записать результат в файл?\n1. Да\n2. Нет");
        System.out.print("Ваш выбор: ");
        scanner = new Scanner(System.in);
        while (true) {
            while (scanner.hasNextInt()) {
                int i = scanner.nextInt();
                if (i == 1) {
                    return 1;
                } else if (i == 2) {
                    return 2;
                } else {
                    System.out.println("Вы выбрали не существующий способ");
                    System.out.print("Ваш выбор: ");
                }
            }
        }
    }

    protected void inputText(){
        System.out.println("Введите пожалуйста текст для зашифровки\n\n!!!!!При завершение набора текста, нажмите два раза Enter!!!!!");
        Scanner scanner = new Scanner((System.in));
        List<String> text = new ArrayList<>();
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            if(str.isEmpty()) break;
            else {
                text.add(str);
            }
        }
        for(String str : text){
            inputText += str + " ";
        }
        //Убираем последний пробел в тексте
        inputText = inputText.substring(0, inputText.length()-1);
    }

    public String getOutputText() {
        return outputText;
    }
}
