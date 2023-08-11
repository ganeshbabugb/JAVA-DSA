package datastructures.zoho.railway;

public class People {
    private String name;
    private int age;
    private char gender;
    private char berthPreference;

    public People(String name, int age, char gender, char berthPreference) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthPreference = berthPreference;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public char getBerthPreference() {
        return berthPreference;
    }
}