package model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

public class ValidatorInput {

    private String inputData;
    private String[] outData;
    boolean validInput;

    public ValidatorInput(String inputData) {

        this.inputData = inputData;
        validInput = false;
        validateInput();
    }


    private void  validateInput() {
        String[] strArray;
        if (inputData != null) {

            strArray = inputData.trim().split(" +");
            ArrayList<String> stringList = new ArrayList<>();
            Collections.addAll(stringList, strArray);

            String  data = null;
            Telephone  tel = null;
            Gender gender = null;
            LocalDate lDate = null;

            if (strArray.length != 6)
                throw new IllegalArgumentException("Число полей ввода не соответствует требуемому");

            int count = 0;
            Iterator<String> iteratorList = stringList.iterator();
            while (iteratorList.hasNext() && count < 3) {
                String item = iteratorList.next();
                if (item.length() > 1 && item.matches("^[A-ZА-Я].+")) { //ФИО
                    strArray[count++] = item;
                    iteratorList.remove();
                }
            }
            if (count != 3)
                throw new IllegalArgumentException("Первые буквы в ФИО должны быть заглавными " +
                        "и ФИО могут не состоять только из одной буквы");

            String s1 = ".+[\\d%:;&*.,<>}{\\[\\]~`'\"].+";
            if (strArray[0].matches(s1) || strArray[1].matches(s1) || strArray[2].matches(s1))
                throw new IllegalArgumentException("ФИО должны состоять только из букв");

            if (!strArray[0].matches("^[A-ZА-я][a-zа-я-]+(-[A-ZА-я])*[a-zа-я]*") ||
                    !strArray[1].matches("^[A-ZА-я][a-zа-я]+") ||
                    !strArray[2].matches("^[A-ZА-я][a-zа-я]+"))
                throw new IllegalArgumentException("Заглавные буквы в середине ФИО могут быть только у составных фамилий");

            iteratorList = stringList.iterator();
            while (iteratorList.hasNext()) {
                String item = iteratorList.next();
                if (item.length() == 1) { // пол
                    gender = Gender.parseGender(item);
                    iteratorList.remove();
                }
            }
            if (gender == null) {
                throw new IllegalArgumentException("В заданной строке не найдены идентификаторы пола");
            }

            iteratorList = stringList.iterator();
            while (iteratorList.hasNext()) {
                String item = iteratorList.next();
                if (item.matches(".*\\d{2}\\.\\d{2}\\.\\d{2,}.*")) { //дата
                    data = item;
                    iteratorList.remove();
                }
            }
            if (data != null) {
                String[] localDateAr = data.split("\\.");
                if (localDateAr.length != 3)
                    throw new IllegalArgumentException("Неверный формат даты рождения");
                try {
                    lDate = LocalDate.of(Integer.parseInt(localDateAr[2]),
                            Integer.parseInt(localDateAr[1]), Integer.parseInt(localDateAr[0]));
                } catch (DateTimeException e) {
                    throw new IllegalArgumentException(e.getMessage());
                } catch (RuntimeException r) {
                    throw new IllegalArgumentException("что то не так с введенной датой рождения");
                }
               if (lDate.isAfter(LocalDate.now()))
                    throw new IllegalArgumentException("Дата рождения не мож ет быть позднее сегодняшней");
               if (lDate.isBefore(LocalDate.of(1900,1,1)))
                   throw new IllegalArgumentException("Дата рождения не может быть ранее 1900г.");
            } else {
                throw new IllegalArgumentException("что то не так с введенной датой рождения");
            }

            iteratorList = stringList.iterator();
            while (iteratorList.hasNext()) {
                String item = iteratorList.next();
                if (item.replace("+7", "8").
                        replaceAll("[-)( ]", "").matches("^[0-9]+$")) {
                        tel =  Telephone.parseTelephone(item);
                }
            }

            if (tel == null) {
                throw new IllegalArgumentException("неверный формат номера телефона");
            }

            strArray[3] = lDate.toString();
            strArray[4] = tel.getNumber();
            strArray[5] = gender.toString();

            validInput = true;
            outData = strArray;
        } else {
            throw new NullPointerException("Передано значение null");
        }

    }

    public String getInputData() {
        return inputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }

    public String[] getOutData() {
        return outData;
    }

    public void setOutData(String[] outData) {
        this.outData = outData;
    }

    public boolean isValidInput() {
        return validInput;
    }

}
