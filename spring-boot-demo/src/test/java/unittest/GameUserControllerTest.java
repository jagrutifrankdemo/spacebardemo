package unittest;


import com.example.frank.controller.GameUserController;
import com.example.frank.service.GameUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frank.core.dto.UserMaxGamesPlayed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(GameUserController.class)
public class GameUserControllerTest {

        @Autowired
        MockMvc mockMvc;
        @MockBean
        GameUserService gameUserServiceMock;
        @Autowired
        ObjectMapper objectMapper;
        @Test
        public void testCreateClientSuccessfully() throws Exception {
            given(gameUserServiceMock.getUserMaxGamesPlayed()).willReturn(new UserMaxGamesPlayed("demo", 1));
            mockMvc.perform(get("/getMax"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(jsonPath("$.userName", is("demo")))
                    .andExpect(jsonPath("$.id", notNullValue()
                    ))
                    ;
            verify(gameUserServiceMock, times(1)).getUserMaxGamesPlayed();
            verifyNoMoreInteractions(gameUserServiceMock);
        }

    }
