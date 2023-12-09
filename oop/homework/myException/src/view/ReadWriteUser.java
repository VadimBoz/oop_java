package view;

import model.User;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;


public class ReadWriteUser {

    public void writeUserToFile(User user) throws IOException {
        String separator = System.getProperty("file.separator");
        boolean appendRecord = false;
        File fileUser = new File(getPathDataDirectory() + separator + user.getSecondName() + ".srv");
        if (fileUser.exists()) appendRecord = true;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileUser, appendRecord))){
            bw.write(user.toString());
            bw.close();
            System.out.println("Данные записаны в файл " + fileUser.getAbsolutePath());
        } catch (IOException e) {
            throw new IOException("данные не записаны, файл не создан");
        }
    }




    public ArrayList<User> readUserFromFile(String secondName) throws IOException {
        ArrayList<User> res;
        String filename = secondName.trim();
        if (secondName.matches(".+[\\d%:;&*.,<>}{\\[\\]~`'\"].+"))
            throw new IllegalArgumentException("Фамилия не может содержать цифры");
        if (!secondName.matches("^[A-ZА-Я].+"))
            throw new IllegalArgumentException("Фамилия должна начинаться с заглавной буквы");

        String separator = System.getProperty("file.separator");
        File fileUser = new File(getPathDataDirectory().toAbsolutePath() + separator + filename + ".srv");
        if (!fileUser.exists())
            throw new IOException("Файл с данными о пользователе не найден");
        else {
                BufferedReader br = new BufferedReader(new FileReader(fileUser));
                res = new ArrayList<>();
                while (br.ready()) {
                    String userLine = br.readLine();
                    res.add(new User(userLine.split(";")));
                }
                br.readLine();
            }
        return res;
        }


    private Path getPathDataDirectory() {
        Path homeDir = Path.of(System.getProperty("user.dir"));
//        System.out.println(homeDir);
        String separator = System.getProperty("file.separator");
        Path defaultDir = Path.of(homeDir.toAbsolutePath() + separator + "src" + separator + "data" + separator);
        Path newDir = Path.of(homeDir.toAbsolutePath() + separator + "dataException" + separator);
        if (Files.exists(defaultDir)) {
            System.out.println("папка по умолчанию c БД найдена " + defaultDir.toAbsolutePath());
            return defaultDir;
        } else if (Files.exists(newDir)) {
            System.out.println("найдена папка " + newDir.toAbsolutePath() + " работаем с ней");
            return newDir;
        } else {
            System.out.println("папка  с по умолчанию С БД не найдена,  создаем новую");
            try {
                 Files.createDirectory(newDir);
                System.out.println("папка  создана");
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
            return newDir;
        }

    }

    public File[] fundAllFiles() {
        Path dir  = getPathDataDirectory();

        File[] matches;
        if (Files.exists(dir)) {
            matches = dir.toFile().listFiles(((dir1, name) -> name.endsWith(".srv")));
        } else {
            throw new RuntimeException("папка не найдена " + dir.toAbsolutePath());
        }

        if (matches == null || matches.length == 0) {
            System.out.println("Файлы с данными отсутствуют в папе " + dir.toAbsolutePath());
            matches = new  File[]{ new File("")};
        }
        return matches;
    }

}
