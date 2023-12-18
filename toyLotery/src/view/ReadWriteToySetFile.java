package view;

import model.Toy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ReadWriteToySetFile {

    public void writeToySetToFile(List<Toy> toys) throws IOException {
        String separator = System.getProperty("file.separator");
        boolean appendRecord = false;
        File fileToyList = new File(getPathDataDirectory() + separator  + "sweepstakes.srv");
//        if (fileToyList.exists()) appendRecord = true;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileToyList, appendRecord))){
            for (Toy item: toys) {
                bw.write(item.toCrvString() + "\n");
                System.out.println(item.toCrvString());
            }
            bw.flush();
            System.out.println("Данные записаны в файл " + fileToyList.getAbsolutePath() + "\n");
        } catch (IOException e) {
            throw new IOException("данные не записаны, файл не создан");
        }
    }


    public void writeToySetToFile(PriorityQueue<Toy> toys) throws IOException {
        List<Toy> toyList = new ArrayList<>(toys);
        writeToySetToFile(toyList);

    }



    public ArrayList<Toy> readToysFromFile() throws IOException {
        ArrayList<Toy> res;

        String separator = System.getProperty("file.separator");
        File fileUser = new File(getPathDataDirectory().toAbsolutePath() + separator  + "sweepstakes.srv");
        if (!fileUser.exists())
            throw new IOException("Файл с данными не найден");
        else {
            BufferedReader br = new BufferedReader(new FileReader(fileUser));
            res = new ArrayList<>();
            while (br.ready()) {
                String toyLine = br.readLine();
                String[] ar = toyLine.split(";");
                if (ar.length != 3) throw  new IllegalArgumentException("Данне в файле некорректные");
                if (!ar[0].matches("\\d+")) throw  new IllegalArgumentException("Данне в файле некорректные (id)");
                int id = Integer.parseInt(ar[0]);
                if (!ar[1].matches("\\d*[.,]?\\d*")) throw new IllegalArgumentException("Вторым аргументом должно быть число");
                double statWeight = Double.parseDouble(ar[1]);
                res.add(new Toy(id, statWeight, ar[2]));

            }
        }
        return res;
    }


    private Path getPathDataDirectory() {
        Path homeDir = Path.of(System.getProperty("user.dir"));
//        System.out.println(homeDir);
        String separator = System.getProperty("file.separator");
        Path defaultDir = Path.of(homeDir.toAbsolutePath() + separator + "src" + separator + "data" + separator);
        Path newDir = Path.of(homeDir.toAbsolutePath() + separator + "dataToy" + separator);
        if (Files.exists(defaultDir)) {
            System.out.println("папка по умолчанию c БД найдена " + defaultDir.toAbsolutePath());
            return defaultDir;
        } else if (Files.exists(newDir)) {
            System.out.println("найдена папка " + newDir.toAbsolutePath() + " работаем с ней");
            return newDir;
        } else {
            System.out.println("папка по умолчанию c БД не найдена,  создаем новую");
            try {
                Files.createDirectory(newDir);
                System.out.println("папка создана");
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
            return newDir;
        }

    }


}
