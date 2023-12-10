package model;

public interface ToyItem {

    long getToyId();
    void setToyId(long id);
    String getName();
    void setName(String name);
    AgeRange getEgeRange();
    void setEgeRange(AgeRange ageRange);
    Double getCost();
    boolean isRemoteControl();
    void setRemoteControl(boolean remoteControl);
    String getMadeIn();
    void setMadeIn(County madeIn);
    void setCost(Double cost);
    String getDescription();
    void setDescription(String description);
}
