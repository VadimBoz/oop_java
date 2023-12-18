package model.enums;


public enum AgeRange {      // в месяцах
    Smallest_0m_6m(0, 12),
    Smallest_6m_12m(6, 12),
    Smallest_0m_12m(0, 12),
    AgeRange_1y_3y(12, 36),
    AgeRange_3y_6y(36, 72),
    AgeRange_6y_12y(72, 144),
    AgeRange_12y_16y(144, 192),
    AgeRange_15y(180, 2400),
    AgeFrom_6y(72, 2400),
    Adult_18 (216,  2400),
    AnyEge_0 (0, 2400);



    final int ageStart;
    final int ageEnd;

    private AgeRange(int ageStart, int ageEnd) {
        this.ageStart = ageStart;
        this.ageEnd = ageEnd;
    }


    public int getAgeStart() {
        return ageStart;
    }

    public int getAgeEnd() {
        return ageEnd;
    }
    public String getAgeRane(){
        if (ageEnd == 2400)
            return ageStart + "+" +" мес";
        return ageStart + "-" + ageEnd +" мес";
    }

}
