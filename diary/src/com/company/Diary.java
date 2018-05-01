package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Diary extends JFrame {
    private JEditorPane textArea = new JEditorPane();
    JTextPane jTextPanel = new JTextPane();
    JTextArea theText = new JTextArea();
    JPanel contentPanel;
    BorderLayout borderLayout = new BorderLayout();
    JMenu jMenuFile = new JMenu();
    JMenuBar jMenuBar = new JMenuBar();
    JLabel statusBar = new JLabel();
    JMenu File = new JMenu();
    JMenuItem open = new JMenuItem();
    JMenuItem save = new JMenuItem();
    JMenuItem exit = new JMenuItem();

    JMenu Copytext = new JMenu();
    JMenuItem copy = new JMenuItem();
    JMenuItem past = new JMenuItem();
    JMenuItem cut = new JMenuItem();

    JMenu Textoption = new JMenu();
    JMenuItem textb = new JMenuItem();
    JMenuItem texti = new JMenuItem();
    JMenuItem texts = new JMenuItem();

    JMenu font = new JMenu();
    JMenuItem arial = new JMenuItem();
    JMenuItem times = new JMenuItem();

    JMenu size = new JMenu();
    JMenuItem small = new JMenuItem();
    JMenuItem normal = new JMenuItem();
    JMenuItem big = new JMenuItem();

    JMenu Help = new JMenu();
    JMenuItem site = new JMenuItem();


    private JMenu createSubmenus() {
        JMenu text = new JMenu("Текст");
        // и несколько вложенных меню
        JMenu style = new JMenu("Стиль");
        JMenuItem bold = new JMenuItem("Жирный");
        JMenuItem italic = new JMenuItem("Курсив");
        JMenu font = new JMenu("Шрифт");
        JMenuItem arial = new JMenuItem("Arial");
        JMenuItem times = new JMenuItem("Times");
        font.add(arial);
        font.add(times);
        // размещаем все в нужном порядке
        style.add(bold);
        style.add(italic);
        style.addSeparator();
        style.add(font);
        text.add(style);
        return text;
    }

    public Diary() throws Exception {
        this.setSize(500, 500);
        this.setTitle("Diary");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.textArea.setFont(new Font("", Font.PLAIN, 14));
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(textArea);

        jMenuBar.add(File);
        jMenuBar.add(Copytext);
        jMenuBar.add(Textoption);
        jMenuBar.add(font);
        jMenuBar.add(size);
        jMenuBar.add(Help);
        setJMenuBar(jMenuBar);


        File.setText("File");
        open.setText("Open");
        File.add(open);
        save.setText("Save");
        File.add(save);
        exit.setText("Exit");
        File.add(exit);

        exit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(exit, "Good Bye!");
                System.exit(0);
            }
        });
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser save = new JFileChooser();
                int option = save.showSaveDialog(save);
                if (option == JFileChooser.APPROVE_OPTION) {
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
                        out.write(textArea.getText());
                        out.close();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        });


        open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser open = new JFileChooser();
                int option = open.showOpenDialog(open);
                if (option == JFileChooser.APPROVE_OPTION) {
                    theText.setText("");
                    try {
                        Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
                        while (scan.hasNext())
                            textArea.setText(scan.nextLine() + "\n");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        });


        Copytext.setText("Edit");
        copy.setText("Copy");
        Copytext.add(copy);
        past.setText("Paste");
        Copytext.add(past);
        cut.setText("Cut");
        Copytext.add(cut);
        copy.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textArea.copy();
            }
        });
        past.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textArea.paste();
            }
        });
        cut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textArea.cut();
            }
        });

        Textoption.setText("Style");
        texts.setText("Standart");
        Textoption.add(texts);
        textb.setText("Bold");
        Textoption.add(textb);
        texti.setText("Italic");
        Textoption.add(texti);
        texts.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                textArea.setFont(new Font("", Font.PLAIN, 14));
            }
        });
        textb.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                textArea.setFont(new Font("", Font.BOLD, 14));
            }
        });
        texti.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                textArea.setFont(new Font("", Font.ITALIC, 14));
            }
        });

        font.setText("Font");
        arial.setText("Arial");
        font.add(arial);
        times.setText("Times");
        font.add(times);
        arial.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                textArea.setFont(new Font("ARIAL", Font.PLAIN,14));
            }
        });
        times.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                textArea.setFont(new Font("SEGOE PRINT", Font.PLAIN, 14));
            }
        });

        size.setText("Size");
        small.setText("Small");
        size.add(small);
        normal.setText("Normal");
        size.add(normal);
        big.setText("Big");
        size.add(big);
        small.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                textArea.setFont(new Font("", Font.PLAIN, 14));
            }
        });
        normal.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                textArea.setFont(new Font("", Font.PLAIN, 18));
            }
        });
        big.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                textArea.setFont(new Font("", Font.PLAIN, 24));
            }
        });

        Help.setText("Help");
        site.setText("Web-side");
        Help.add(site);
        site.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(exit, "Site:");
                }
        }
        );
    }
}