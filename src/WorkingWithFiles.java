import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class WorkingWithFiles {

    private String inputText ="";
    private String outputText = "";

    private String path;


    public  WorkingWithFiles() {
    }

    private void enterPath() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пожалуйста путь к файлу: ");
        this.path = scanner.nextLine();
    }

    private void checkPath() {
        while (true) {
            if(Files.exists(Paths.get(this.path))) break;
            else {
                System.out.println("Файла по заданному пути не существует, введти пожалуйста занова: ");
                enterPath();
            }
        }
    }

    public void readFile() {
        enterPath();
        checkPath();
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            this.inputText = sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFile () {
        enterPath();
        checkPath();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(this.path))) {
            writer.write(this.outputText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getInputText() {
        return inputText;
    }

    public void setOutputText(String outputText) {
        this.outputText = outputText;
    }

}
