
public class Main {
    private static final String beginning= "######----Encrypt/Decrip Cheaser Chiper's----######\n" +
                                    "               Welcome to uor programm                       \n";


    public static void main(String[] args) {

        System.out.println(beginning);

        Start start = new Start();
        int selectMode = start.selectMode();
        if(selectMode == 1) {
            Decode decode = new Decode();
        } else {
            Encrypted encrypted = new Encrypted();
        }


    }
}
