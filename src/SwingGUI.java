import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

public class SwingGUI {

    private JFrame jFrame = new JFrame("Encrypted/Decrypted");

    private JPanel panelStartMenu, panelMenuSelectDecode, panelMenuDecode, panelMenuEncrypted, panelMenuResult;

    private String outputText;


    public void startGUI() {
        startMenu();
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void startMenu() {
        JButton jButton1 = new JButton("1. Encrypted");
        JButton jButton2 = new JButton("2. Decrypted");

        //Расположение в пр. кнопки Encrypted
        GridBagLayout gridBagLayout = new GridBagLayout();
        panelStartMenu = new JPanel();
        panelStartMenu.setLayout(gridBagLayout);

        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.weightx = 0;
        constraints1.weighty = 0;
        constraints1.gridx = 0;
        constraints1.gridy = 0;
        constraints1.gridheight = 1;
        constraints1.gridwidth = 2;
        constraints1.insets = new Insets(10, 0 , 10, 0);
        panelStartMenu.add(jButton1, constraints1);

        //Расположение в пр. кнопки Decrypted
        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.weightx = 0;
        constraints2.weighty = 0;
        constraints2.gridx = 0;
        constraints2.gridy = 2;
        constraints2.gridheight = 1;
        constraints2.gridwidth = 2;
        panelStartMenu.add(jButton2, constraints2);

        //Логика кнопки Encrypted
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelStartMenu.setVisible(false);
                menuEncrypted(true);
            }
        });

        //Логика кнопки Decrypted
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelStartMenu.setVisible(false);
                menuSelectDecode();
            }
        });

        panelStartMenu.revalidate();
        jFrame.add(panelStartMenu);



    }

    private void menuSelectDecode() {
        JButton jButton1 = new JButton("    1. Brut-force   ");
        JButton jButton2 = new JButton("2. Enter your key");

        //Расположение кнопки Brut-force
        GridBagLayout gridBagLayout = new GridBagLayout();
        panelMenuSelectDecode = new JPanel();
        panelMenuSelectDecode.setLayout(gridBagLayout);

        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.weightx = 0;
        constraints1.weighty = 0;
        constraints1.gridx = 0;
        constraints1.gridy = 0;
        constraints1.gridheight = 1;
        constraints1.gridwidth = 2;
        constraints1.insets = new Insets(10, 0 , 10, 0);
        panelMenuSelectDecode.add(jButton1, constraints1);

        //Расположение кнопки Enter you key
        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.weightx = 0;
        constraints2.weighty = 0;
        constraints2.gridx = 0;
        constraints2.gridy = 2;
        constraints2.gridheight = 1;
        constraints2.gridwidth = 2;
        panelMenuSelectDecode.add(jButton2, constraints2);

        //Логика кнопки Brut-force
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelMenuSelectDecode.setVisible(false);
                menuDecode();
            }
        });

        //Логика кнопки Enter you key
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelMenuSelectDecode.setVisible(false);
                menuEncrypted(false);
            }
        });

        panelMenuSelectDecode.revalidate();
        jFrame.add(panelMenuSelectDecode);
    }

    private void menuDecode() {

        JButton jButtonStart = new JButton("        Start        ");
        JButton jButtonEnterText = new JButton("Enter text");

        GridBagLayout gridBagLayout = new GridBagLayout();
        panelMenuDecode = new JPanel();
        panelMenuDecode.setLayout(gridBagLayout);

        //Расположение поля для вставки текста
        JTextArea jTextArea = new JTextArea("Напишите ваш текст", 5, 20);
        jTextArea.setLineWrap(true);
        JScrollPane jScrollPaneText = new JScrollPane(jTextArea);

        GridBagConstraints constraintsText = new GridBagConstraints();
        constraintsText.weightx = 0;
        constraintsText.weighty = 0;
        constraintsText.gridx = 0;
        constraintsText.gridy = 0;
        constraintsText.gridheight = 1;
        constraintsText.gridwidth = 20;
        constraintsText.insets = new Insets(10, 10 , 10, 10);
        panelMenuDecode.add(jScrollPaneText, constraintsText);

        //Расположение кнопки "Вставить текст"
        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.weightx = 0;
        constraints2.weighty = 0;
        constraints2.gridx = 20;
        constraints2.gridy = 0;
        constraints2.gridheight = 1;
        constraints2.gridwidth = 21;
        constraints2.insets = new Insets(10, 10 , 10, 10);
        panelMenuDecode.add(jButtonEnterText, constraints2);

        //Расположение кнопки Старт
        GridBagConstraints constraintsStart = new GridBagConstraints();
        constraintsStart.weightx = 0;
        constraintsStart.weighty = 0;
        constraintsStart.gridx = 10;
        constraintsStart.gridy = 2;
        constraintsStart.gridheight = 1;
        constraintsStart.gridwidth = 11;
        constraintsStart.insets = new Insets(10, 10 , 10, 10);
        jButtonStart.setSize(100, 1);
        panelMenuDecode.add(jButtonStart, constraintsStart);

        //Логика кнопка старт
        jButtonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Start start = new Start();
                Decode decode = new Decode(jTextArea.getText());
                outputText = decode.getOutputText();
                panelMenuDecode.setVisible(false);
                menuResult();
            }
        });

        //Логика кнопки "Вставка текста"
        jButtonEnterText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));
                String filePath = "";
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    filePath = file.getAbsolutePath();
                    WorkingWithFiles files = new WorkingWithFiles();
                    files.readFile(filePath);
                    jTextArea.setText(files.getInputText());
                }
            }
        });

        panelMenuDecode.revalidate();
        jFrame.add(panelMenuDecode);
    }

    private void menuEncrypted(boolean mode) {
        JButton jButtonStart = new JButton("        Start        ");
        JButton jButtonEnterText = new JButton("Enter text");

        GridBagLayout gridBagLayout = new GridBagLayout();
        panelMenuEncrypted = new JPanel();
        panelMenuEncrypted.setLayout(gridBagLayout);

        //Позиция в приложения для поля ввода текста
        JTextArea jTextArea = new JTextArea("Напишите ваш текст", 5, 20);
        jTextArea.setLineWrap(true);
        JScrollPane jScrollPaneText = new JScrollPane(jTextArea);

        GridBagConstraints constraintsText = new GridBagConstraints();
        constraintsText.weightx = 0;
        constraintsText.weighty = 0;
        constraintsText.gridx = 0;
        constraintsText.gridy = 0;
        constraintsText.gridheight = 1;
        constraintsText.gridwidth = 20;
        constraintsText.insets = new Insets(10, 10 , 10, 10);
        panelMenuEncrypted.add(jScrollPaneText, constraintsText);

        //Позиция для отображение кнопки вставки текста из файла
        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.weightx = 0;
        constraints2.weighty = 0;
        constraints2.gridx = 20;
        constraints2.gridy = 0;
        constraints2.gridheight = 1;
        constraints2.gridwidth = 21;
        constraints2.insets = new Insets(10, 10 , 10, 10);
        panelMenuEncrypted.add(jButtonEnterText, constraints2);

        //Позиция текстового поля для введения ключа для расшифровки
        JTextArea jTextAreaKey = new JTextArea("Напишите ключ от 1 до 40", 1, 15);
        jTextAreaKey.setLineWrap(true);
        JScrollPane jScrollPaneKey = new JScrollPane(jTextAreaKey);

        GridBagConstraints constraintsKey = new GridBagConstraints();
        constraintsKey.weightx = 0;
        constraintsKey.weighty = 0;
        constraintsKey.gridx = 5;
        constraintsKey.gridy = 1;
        constraintsKey.gridheight = 1;
        constraintsKey.gridwidth = 20;
        constraintsKey.insets = new Insets(10, 10 , 10, 10);
        panelMenuEncrypted.add(jScrollPaneKey, constraintsKey);

        //Позиция для кнопки старт
        GridBagConstraints constraintsStart = new GridBagConstraints();
        constraintsStart.weightx = 0;
        constraintsStart.weighty = 0;
        constraintsStart.gridx = 10;
        constraintsStart.gridy = 2;
        constraintsStart.gridheight = 1;
        constraintsStart.gridwidth = 11;
        constraintsStart.insets = new Insets(10, 10 , 10, 10);
        jButtonStart.setSize(100, 1);
        panelMenuEncrypted.add(jButtonStart, constraintsStart);

        //Логика кнопки Старта зашифровки
        jButtonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = jTextAreaKey.getText();
                int key = 0;
                try {
                    key = Integer.parseInt(str);
                    if (key < 1 || key > 40) {
                        JOptionPane.showMessageDialog(null, "Ошибка: число не входит в заданный диапазон, введите пожалуйста число от 1 до 40",
                                "Сообщение об ошибке", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Start start = new Start();
                        Encrypted encrypted;
                        if (mode == true) {
                            encrypted = new Encrypted(mode, jTextArea.getText(), key);
                        } else {
                            encrypted = new Encrypted(mode, jTextArea.getText(), key);
                        }
                        outputText = encrypted.getOutputText();
                        panelMenuEncrypted.setVisible(false);
                        menuResult();
                    }
                } catch (NumberFormatException m) {
                    JOptionPane.showMessageDialog(null, "Ошибка: Вы вели не число",
                            "Сообщение об ошибке", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Логика кнопки вставки Текста из файла
        jButtonEnterText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));
                String filePath = "";
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    filePath = file.getAbsolutePath();
                    WorkingWithFiles files = new WorkingWithFiles();
                    files.readFile(filePath);
                    jTextArea.setText(files.getInputText());
                }
            }
        });

        panelMenuEncrypted.revalidate();
        jFrame.add(panelMenuEncrypted);
    }

    private void menuResult(){

        GridBagLayout gridBagLayout = new GridBagLayout();
        panelMenuResult = new JPanel();
        panelMenuResult.setLayout(gridBagLayout);

        //Расположение поля вывода результата работы программы
        JTextArea jTextArea = new JTextArea("Напишите ваш текст", 5, 30);
        jTextArea.setLineWrap(true);
        JScrollPane jScrollPaneText = new JScrollPane(jTextArea);

        GridBagConstraints constraintsText = new GridBagConstraints();
        constraintsText.weightx = 0;
        constraintsText.weighty = 0;
        constraintsText.gridx = 0;
        constraintsText.gridy = 0;
        constraintsText.gridheight = 1;
        constraintsText.gridwidth = 30;
        constraintsText.insets = new Insets(5, 5 , 5, 5);
        panelMenuResult.add(jScrollPaneText, constraintsText);

        //Расположение поля для ввода пути к файлу для записи
        JTextArea jTextPath = new JTextArea("Введите путь куда записать результат", 2, 20);
        jTextPath.setLineWrap(true);
        JScrollPane jScrollPanePath = new JScrollPane(jTextPath);

        GridBagConstraints constraintsPath = new GridBagConstraints();
        constraintsPath.weightx = 0;
        constraintsPath.weighty = 0;
        constraintsPath.gridx = 0;
        constraintsPath.gridy = 1;
        constraintsPath.gridheight = 1;
        constraintsPath.gridwidth = 20;
        constraintsPath.insets = new Insets(5, 5, 5, 5);
        panelMenuResult.add(jScrollPanePath, constraintsPath);

        //Расположение кнопки "Вставки пути"
        JButton jButtonPath = new JButton("Enter path");
        GridBagConstraints constraintsButtonPath = new GridBagConstraints();
        constraintsButtonPath.weightx = 0;
        constraintsButtonPath.weighty = 0;
        constraintsButtonPath.gridx = 20;
        constraintsButtonPath.gridy = 1;
        constraintsButtonPath.gridheight = 1;
        constraintsButtonPath.gridwidth = 1;
        constraintsButtonPath.insets = new Insets(5, 5, 5, 5);
        panelMenuResult.add(jButtonPath, constraintsButtonPath);

        //Расположение кнопки "Запись в файл"
        JButton jButtonRecorded = new JButton("Записать в файл");
        GridBagConstraints constraintsButtonRecorded = new GridBagConstraints();
        constraintsButtonRecorded.weightx = 0;
        constraintsButtonRecorded.weighty = 0;
        constraintsButtonRecorded.gridx = 15;
        constraintsButtonRecorded.gridy = 2;
        constraintsButtonRecorded.gridheight = 1;
        constraintsButtonRecorded.gridwidth = 16;
        constraintsButtonRecorded.insets = new Insets(5, 5, 5, 5);
        panelMenuResult.add(jButtonRecorded, constraintsButtonRecorded);

        //Логика работы кнопки "Вставки пути"
        jButtonPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));
                String filePath = "";
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    filePath = file.getAbsolutePath();
                    jTextPath.setText(filePath);
                }
            }
        });

        //Логика работы кнопки "Запись в файл"
        jButtonRecorded.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WorkingWithFiles files = new WorkingWithFiles();
                files.setOutputText(outputText);
                if(files.writeFile(jTextPath.getText())) {
                    JOptionPane.showMessageDialog(null, "Результат успешно записан в вайл");
                } else{
                    JOptionPane.showMessageDialog(null, "Ошибка: Произошла ошибка при записи файла, пожалуйста проверьте правильность пути к файлу и доступ к нему",
                            "Сообщение об ошибке", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        jTextArea.setText(outputText);
        panelMenuResult.revalidate();
        jFrame.add(panelMenuResult);
    }
}

