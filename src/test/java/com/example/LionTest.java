package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline felineMock;
    Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", felineMock);
    }

    // Проверка вызова метода feline.getKittens() внутри метода lion.getKittens()
    @Test
    public void getKittensTest() throws Exception {
        lion.getKittens();
        verify(felineMock, Mockito.times(1)).getKittens();
    }

    // Проверка вызова метода feline.getFood("Хищник") внутри метода lion.getFood()
    @Test
    public void getFoodTest() throws Exception {
        lion.getFood();
        verify(felineMock, Mockito.times(1)).getFood("Хищник");
    }

    // Проверка метода getKittens в классе lion через стаб
    @Test
    public void getKittensTestWithStub() {
        when(felineMock.getKittens()).thenReturn(1);
        assertEquals(felineMock.getKittens(), lion.getKittens());
    }

    // Проверка метода getFood в классе lion через стаб
    @Test
    public void getFoodTestWithStub() throws Exception {
        when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(felineMock.getFood("Хищник"), lion.getFood());


    }
}

