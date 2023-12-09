package model;

public class Telephone {
    Long telephone;
    String telIn;

    public Telephone(String telIn) {
        this.telIn = telIn;
        validateTel();
    }


    private void validateTel() {
        String tel = telIn.replace("+7", "8").replaceAll("[-)( ]", "");
        if (!tel.matches("^8.+") && !tel.matches("^\\+7.+"))
            throw new IllegalArgumentException("Номер телефона должен начинаться с 8 или +7");
        if (tel.length() != 11)
            throw new IllegalArgumentException("В номере телефона  [" + tel + "] неверное количество цифр");

        if (!tel.matches("^[0-9]+$"))
            throw new IllegalArgumentException("В номере телефона должны быть только цифры () '-+' ");


        telephone = Long.parseLong(tel);
    }


    public static Telephone parseTelephone(String telIn) {
        return new Telephone(telIn);
    }

    @Override
    public String toString() {
        String t;
        if (telephone != null) {
            t = telephone.toString();
            return "+7(" + t.substring(1, 4) + ")" + t.substring(4, 7) + "-" +
                    t.substring(7, 9) + "-" + t.substring(9, 11);
        } else
            return "номер не задан";
    }

    public String getNumber() {
        if (telephone != null)
            return telephone.toString();
        else return "номер не задан";
    }
}
