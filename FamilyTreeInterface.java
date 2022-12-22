package Homework9;

import java.util.ArrayList;

public interface FamilyTreeInterface {
    String setLastName(String lastName); // Задаёт фамилию человека.

    String setFirstName(String firstName); // Задаёт имя человека.

    String setSecondName(String secondName); // Задаёт отчество человека.

    String setBirthday(String birthday); // Задаёт день рождения человека.

    String setSex(String sex); // Задаёт пол человека.

    String setPersonalId(String personalId); // Задаёт персональный ID человека.

    String setFatherId(String fatherId); // Задаёт ID отца человека.

    String setMotherId(String motherId); // Задаёт ID матери человека.

    String getLastName(); // Возвращает фамилию человека.

    String getFirstName(); // Возвращает имя ID человека.

    String getSecondName(); // Возвращает отчество ID человека.

    String getPersonalId(); // Возвращает персональный ID человека.

    String getFatherId(); // Возвращает ID отца человека.

    String getMotherId(); // Возвращает ID матери человека.

    String getSexId(); // Возвращает пол человека.

    FamilyTree addToList(ArrayList<FamilyTree> family); // Добавление человека в дерево.

    void printAll(ArrayList<FamilyTree> family); // Вывод всего дерева в консоль.

    void printParent(ArrayList<FamilyTree> family); // Вывод родителей в консоль.

    void printBrotherSister(ArrayList<FamilyTree> family); // Вывод братьев или сестёр в консоль.

    void printChildrens(ArrayList<FamilyTree> family); // Вывод детей в консоль.

    void printGrandParent(ArrayList<FamilyTree> family); // Вывод дедушек или бабушек в консоль.

    void familyTreeToFile(ArrayList<FamilyTree> family); // Сохранение дерева в файл.

    void manualCreationTree(); // Ручное создание человека.
}
