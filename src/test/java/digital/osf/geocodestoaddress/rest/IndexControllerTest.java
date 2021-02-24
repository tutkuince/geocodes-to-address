package digital.osf.geocodestoaddress.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class IndexControllerTest {

    @Test
    void index() {
        IndexController indexController = new IndexController();
        String response = indexController.index();
        assertEquals("index", response);
    }
}