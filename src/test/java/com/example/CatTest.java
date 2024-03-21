package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    private Feline felineMock;
    private final Feline feline = new Feline();

    // Проверка возвращаемого значения при вызове метода getSound()
    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals("Некорректное значение звука", expectedSound, actualSound);

    }

    // Проверка вызова метода eatMeat() внутри метода getFood()
    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(felineMock);
        cat.getFood();
        Mockito.verify(felineMock, Mockito.times(1)).eatMeat();


    }
}


















