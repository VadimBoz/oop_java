package model;


public enum Gender {
    m("male"),
    f("female");


    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public static Gender parseGender(String str) {
        if (str.length() != 1)
            throw new IllegalArgumentException("При указании пола используется один символ");
        str = str.toLowerCase();
        return switch (str) {
            case "m", "м" -> Gender.m;
            case "f", "ж" -> Gender.f;
            default -> throw new IllegalArgumentException("Недопустимый символ в обозначении пола");
        };
    }

    @Override
    public String toString() {
        if (this == Gender.m)
            return "m";
        else
             return "f";
    }
}
