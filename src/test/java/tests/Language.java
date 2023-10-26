package tests;

public enum Language {
    ITALIANO("Italiano"),
    ENGLISH("English"),
    UKRAINIAN ("Українська");
    private String name;

    Language(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
