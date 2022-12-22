package Homework9;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FamilyTree implements FamilyTreeInterface {
    private String lastName;
    private String firstName;
    private String secondName;
    private String birthday;
    private String sex;
    private String personalId;
    private String fatherId;
    private String motherId;

    public FamilyTree(String lastName, String firstName, String secondName, String birthday, String sex,
            String personalId,
            String fatherId, String motherId) {// Конструктор объекта.
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthday = birthday;
        this.sex = sex;
        this.personalId = personalId;
        this.fatherId = fatherId;
        this.motherId = motherId;
    }

    @Override
    public String setLastName(String lastName) { // Задаёт фамилию человека.
        return this.lastName = lastName;
    }

    @Override
    public String setFirstName(String firstName) { // Задаёт имя человека.
        return this.firstName = firstName;
    }

    @Override
    public String setSecondName(String secondName) { // Задаёт отчество человека.
        return this.secondName = secondName;
    }

    @Override
    public String setBirthday(String birthday) { // Задаёт день рождения человека.
        return this.birthday = birthday;
    }

    @Override
    public String setSex(String sex) { // Задаёт пол человека.
        return this.sex = sex;
    }

    @Override
    public String setPersonalId(String personalId) { // Задаёт персональный ID человека.
        return this.personalId = personalId;
    }

    @Override
    public String setFatherId(String fatherId) { // Задаёт ID отца человека.
        return this.fatherId = fatherId;
    }

    @Override
    public String setMotherId(String motherId) { // Задаёт ID матери человека.
        return this.motherId = motherId;
    }

    @Override
    public FamilyTree addToList(ArrayList<FamilyTree> family) { // Добавление человека в дерево.
        family.add(this);
        return this;
    }

    @Override
    public String toString() { // Перегрузка метода toString
        return lastName + " " + firstName + " " + secondName + ", " + birthday;
    }

    @Override
    public String getLastName() { // Возвращает фамилию человека.
        return lastName;
    }

    @Override
    public String getFirstName() { // Возвращает имя человека.
        return firstName;
    }

    @Override
    public String getSecondName() { // Возвращает отчество человека.
        return secondName;
    }

    @Override
    public String getPersonalId() { // Возвращает персональный ID человека.
        return personalId;
    }

    @Override
    public String getFatherId() { // Возвращает ID отца человека.
        return fatherId;
    }

    @Override
    public String getMotherId() { // Возвращает ID матери человека.
        return motherId;
    }

    @Override
    public String getSexId() { // Возвращает пол человека.
        return sex;
    }

    @Override
    public void printAll(ArrayList<FamilyTree> familyList) { // Вывод всего дерева в консоль.
        for (FamilyTree person : familyList) {
            System.out.println(person);
        }
    }

    @Override
    public void printParent(ArrayList<FamilyTree> familyList) { // Вывод родителей в консоль.
        System.out.println("Родители " + this.getLastName() + " " + this.firstName + " " + this.secondName + ":");
        for (FamilyTree person : familyList) {
            if (person.getPersonalId() == fatherId) {
                System.out.println("Отец:");
                System.out.println(person);
            } else if (person.getPersonalId() == motherId) {
                System.out.println("Мать:");
                System.out.println(person);
            }
        }
    }

    @Override
    public void printBrotherSister(ArrayList<FamilyTree> familyList) { // Вывод братьев или сестёр в консоль.
        System.out
                .println("Братья и сёстры " + this.getLastName() + " " + this.firstName + " " + this.secondName + ":");
        for (FamilyTree person : familyList) {
            if (person.getFatherId() == fatherId && person.getPersonalId() != personalId) {
                if (person.getSexId() == "м") {
                    System.out.println("Брат:");
                    System.out.println(person);
                } else {
                    System.out.println("Сестра:");
                    System.out.println(person);
                }
            }
        }
    }

    @Override
    public void printChildrens(ArrayList<FamilyTree> familyList) { // Вывод детей в консоль.
        System.out.println("Дети " + this.getLastName() + " " + this.firstName + " " + this.secondName + ":");
        for (FamilyTree person : familyList) {
            if (person.getFatherId() == personalId) {
                if (person.getSexId() == "м") {
                    System.out.println("Сын:");
                    System.out.println(person);
                } else {
                    System.out.println("Дочь:");
                    System.out.println(person);
                }
            }
        }
    }

    @Override
    public void printGrandParent(ArrayList<FamilyTree> familyList) { // Вывод дедушек или бабушек в консоль.
        System.out.println(
                "Бабушки и дедушки " + this.getLastName() + " " + this.firstName + " " + this.secondName + ":");
        for (FamilyTree person : familyList) {
            if (person.getPersonalId() == fatherId || person.getPersonalId() == motherId) {
                for (FamilyTree person2 : familyList) {
                    if (person.getFatherId() == person2.getPersonalId()) {
                        System.out.println("Дедушка:");
                        System.out.println(person2);
                    } else if (person.getMotherId() == person2.getPersonalId()) {
                        System.out.println("Бабушка:");
                        System.out.println(person2);
                    }
                }
            }
        }
    }

    @Override
    public void familyTreeToFile(ArrayList<FamilyTree> familyList) { // Сохранение дерева в файл.
        try (FileWriter writer = new FileWriter("tree.txt", true)) {
            for (FamilyTree person : familyList) {
                writer.write(person.toString() + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void manualCreationTree() { // Ручное создание человека.
        System.out.println("Ручное добавление человека в дерево:");
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите фамилию человека:");
        String data = iScanner.nextLine();
        this.setLastName(data);
        System.out.println("Введите имя человека:");
        data = iScanner.nextLine();
        this.setFirstName(data);
        System.out.println("Введите отчество человека:");
        data = iScanner.nextLine();
        this.setSecondName(data);
        System.out.println("Введите день рождения человека:");
        data = iScanner.nextLine();
        this.setBirthday(data);
        System.out.println("Введите пол человека:");
        data = iScanner.nextLine();
        this.setSex(data);
        System.out.println("Введите ID человека:");
        data = iScanner.nextLine();
        this.setPersonalId(data);
        System.out.println("Введите ID отца человека:");
        data = iScanner.nextLine();
        this.setFatherId(data);
        System.out.println("Введите ID матери человека:");
        data = iScanner.nextLine();
        this.setMotherId(data);
        iScanner.close();
    }
}
