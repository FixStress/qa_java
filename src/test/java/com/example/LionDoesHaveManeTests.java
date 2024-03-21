package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionDoesHaveManeTests {
    private final Feline feline = new Feline();
    private final String sex;
    private final boolean expectedHasMane;

    public LionDoesHaveManeTests(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Некорректный ввод", false},
        };
    }

    // Параметризированный тест метода doesHaveMane() с обработкой исключения
    @Test
    public void doesHaveManeTest() throws Exception {
        if ("Самец".equals(sex) || "Самка".equals(sex)) {
            Lion lion = new Lion(sex, feline);
            boolean actualHasMane = lion.doesHaveMane();
            assertEquals(expectedHasMane, actualHasMane);
        } else {
            String expectedExceptionMessage = "Используйте допустимые значения пола животного - самец или самка";
            Exception actualException = assertThrows(Exception.class, () -> new Lion(sex, feline));
            assertEquals(expectedExceptionMessage, actualException.getMessage());
            // Добавил для информативности
            System.out.println("При передаче некорректного значения: " + sex + "\nОтображается ошибка: " + actualException.getMessage());
        }
    }


}




