package com.company;

public class Main {
    public static void main(String[] args )throws Exception {
        Diary app = new Diary();
        app.setVisible(true);
        Diary.setDefaultLookAndFeelDecorated(true);
        new Diary();
    }
}
