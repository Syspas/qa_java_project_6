import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

import java.util.List;



public class LionTest {

    @Test
    public void testConstructorWithMaleSex() throws Exception {
        // Тестирование конструктора с аргументом "Самец"
        Lion lion = new Lion("Самец");

        // Проверка значения поля hasMane
        boolean result = lion.doesHaveMane();
        assertEquals(true, result);
    }

    @Test
    public void testConstructorWithFemaleSex() throws Exception {
        // Тестирование конструктора с аргументом "Самка"
        Lion lion = new Lion("Самка");

        // Проверка значения поля hasMane
        boolean result = lion.doesHaveMane();
        assertEquals(false, result);
    }

    @Test
    public void testConstructorWithInvalidSex() {
        // Тестирование конструктора с недопустимым значением пола
        try {
            Lion lion = new Lion("Неизвестный");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }

    @Test
    public void testGetKittens() throws Exception {
        // Создание мока для объекта Feline
        Feline feline = Mockito.mock(Feline.class);

        // Создание объекта Lion с мок-объектом Feline
        Lion lion = new Lion("Самка");
        lion.feline = feline;

        // Установка ожидаемого значения для метода getKittens() объекта Feline
        Mockito.when(feline.getKittens()).thenReturn(3);

        // Проверка результата
        int result = lion.getKittens();
        assertEquals(3, result);
    }


    @Test
    public void testGetFood() throws Exception {
        // Создание мока для объекта Feline
        Feline feline = Mockito.mock(Feline.class);

        // Создание объекта Lion с мок-объектом Feline
        Lion lion = new Lion("Самец");
        lion.feline = feline;

        // Создание мока для списка
        List<String> foodList = Mockito.mock(List.class);

        // Установка ожидаемого поведения для метода getFood() объекта Feline
        Mockito.when(feline.getFood("Хищник")).thenReturn(foodList);

        // Вызов метода getFood() объекта Lion
        List<String> result = lion.getFood();

        // Проверка, что метод getFood() объекта Feline был вызван с ожидаемым аргументом
        Mockito.verify(feline).getFood("Хищник");

        // Проверка, что результат вызова метода getFood() объекта Lion равен моку списка
        Assert.assertEquals(foodList, result);
    }


}