package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AlexLionTest {

    AlexLion alexLion;


    @Before
    public void setUp() throws Exception {
        Feline feline = new Feline();
        alexLion = new AlexLion(feline);
    }

    // Проверка возвращаемого количества львят в методе getKittens()
    @Test
    public void getKittensTest() {
        int expectedKittensCount = 0;
        int actualKittensCount = alexLion.getKittens();
        assertEquals("Некорректное количество львят", expectedKittensCount, actualKittensCount);
    }

    // Проверка возвращаемого списка друзей в методе getFriends()
    @Test
    public void getFriendsTest() {
        List<String> expectedListFriends = List.of("Марти", "Глория", "Мелман");
        List<String> actualListFriends = alexLion.getFriends();
        assertEquals("Некорректный список друзей", expectedListFriends, actualListFriends);
    }

    // Проверка возвращаемого места жительства в методе getPlaceOfLiving()
    @Test
    public void getPlaceOfLivingTest() {
        String expectedPlaceOfLiving = "Нью-Йоркский зоопарк";
        String actualPlaceOfLiving = alexLion.getPlaceOfLiving();
        assertEquals("Некорректное место жительства", expectedPlaceOfLiving, actualPlaceOfLiving);
    }
}
