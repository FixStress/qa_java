package com.example;

import java.util.List;

public class AlexLion extends Lion {

    public AlexLion(Feline feline) throws Exception {
        super("Самец", feline);
    }

    // Нет львят
    @Override
    public int getKittens() {
        return 0;
    }

    // Друзья Алекса
    public List<String> getFriends() {
        return List.of("Марти", "Глория", "Мелман");
    }

    // Место жительства
    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }
}
