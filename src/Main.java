
public class Main {
    private static final String beginning= "######----Encrypt/Decrip Cheaser Chiper's----######\n" +
                                    "               Welcome to uor programm                       \n";

    public static void main(String[] args) {
        boolean isGUI = true;
        if (isGUI) {
            SwingGUI swingGUI = new SwingGUI();
            swingGUI.startGUI();
        } else {
        System.out.println(beginning);
        Start start = new Start();
        start.startProgram();
        }
    }
}
