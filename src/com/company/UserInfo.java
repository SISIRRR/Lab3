package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInfo {

    public void userInput() throws IOException {
        String[] userInfo = new String[6];
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите имя");
        userInfo[0] = scanner.next();
        System.out.println("введите фамилию");
        userInfo[1] = scanner.next();
        System.out.println("введите отчество");
        userInfo[2] = scanner.next();
        System.out.println("введите мобильный телефон");
        userInfo[3] = scanner.next();
        System.out.println("введите никнейм");
        userInfo[4] = scanner.next();
        System.out.println("введите дату рождения");
        userInfo[5] = scanner.next();
        verification(userInfo);
        outputUserInfoInFile(userInfo);
    }

    private void verification(String[] userInfo) {
        for (int i = 0; i < userInfo.length;) {
            if (!Pattern.matches("[A-za-zА-яа-я0-9\\.]+", userInfo[i])) {
                System.out.println("Присутствуют посторонние символы в " + userInfo[i] + " введите её сейчас корректно:");
                Scanner scanner = new Scanner(System.in);
                userInfo[i] = scanner.next();
                i=0;
            }
            else {
                i++;
            }
        }
    }

    private void outputUserInfoInFile(String[] userInfo) throws IOException {
        try {
            FileWriter writer = new FileWriter("src/file/text.txt");
            Pattern pattern = Pattern.compile("[A-za-zА-яа-я0-9\\.]+");

            for (int i = 0; i < userInfo.length; i++) {
                Matcher matcher = pattern.matcher(userInfo[i]);
                if (matcher.matches()) {
                    writer.write(matcher.group() + "\n");
                    System.out.println(matcher.group() + "\n");
                }
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Файл не найден или не открываается" + e);
        }

    }
}
