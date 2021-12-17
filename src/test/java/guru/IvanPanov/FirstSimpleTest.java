package guru.IvanPanov;

import org.junit.jupiter.api.*;

@DisplayName("Первый тест")//Аннотация
public class FirstSimpleTest {

    @BeforeAll//должен быть в статичным
    static void beforeAll(){
    }
    @BeforeEach//Медот "Перед каждым последующим"
    void beforeEach(){

    }

    @Test
    void FirstTest(){
    }

    @AfterEach//после каждого
    void arterEach(){

    }

    @AfterAll
    static void afterAll(){

    }
}
