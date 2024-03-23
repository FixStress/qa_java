package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline felineMock;
    Feline feline;

    // Проверка вызова метода feline.getKittens() внутри метода lion.getKittens()
    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        lion.getKittens();
        verify(felineMock, Mockito.times(1)).getKittens();
    }

    // Проверка вызова метода feline.getFood("Хищник") внутри метода lion.getFood()
    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        lion.getFood();
        verify(felineMock, Mockito.times(1)).getFood("Хищник");
    }

    // Проверка метода getKittens в классе lion через стаб
    @Test
    public void getKittensWithStubTest() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        when(felineMock.getKittens()).thenReturn(1);
        assertEquals(felineMock.getKittens(), lion.getKittens());
    }

    // Проверка метода getFood в классе lion через стаб
    @Test
    public void getFoodWithStubTest() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(felineMock.getFood("Хищник"), lion.getFood());


    }

    // Тест на исключение при некорректном значении пола. Вынес из параметризации.
    @Test
    public void getExeptionTest() {
        String expectedExceptionMessage = "Используйте допустимые значения пола животного - самец или самка";
        Exception actualException = assertThrows(Exception.class, () -> new Lion("Некорректный ввод", feline));
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }
}

