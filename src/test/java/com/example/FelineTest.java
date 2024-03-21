package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline felineSpy;
    private final Feline feline = new Feline();

    // Проверка вызова метода getFood("Хищник") внутри метода eatMeat()
    @Test
    public void eatMeatTest() throws Exception {
        felineSpy.eatMeat();
        Mockito.verify(felineSpy, Mockito.times(1)).getFood("Хищник");
    }

    // Проверка возвращаемого значения при вызове метода getFamily()
    @Test
    public void getFamilyTest() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals("Некорректное семейство", expectedFamily, actualFamily);
    }

    // Проверка возвращаемого значения при вызове метода getKittens(int kittensCount)
    @Test
    public void getKittensWithArgumentTest() {
        int expectedKittensCount = 5;
        int actualKittensCount = feline.getKittens(5);
        assertEquals("Некорректное количество котят", expectedKittensCount, actualKittensCount);
    }


    // Проверка вызова getKittens(1) внутри метода getKittens()
    @Test
    public void getKittensNoArgumentTest() {
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);

    }


}













