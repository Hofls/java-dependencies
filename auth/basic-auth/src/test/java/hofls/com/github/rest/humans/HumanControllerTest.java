package hofls.com.github.rest.humans;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HumanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HumanController humanController;

    @Test
    public void unauthenticated_is_able_to_get_people() throws Exception {
        mockMvc.perform(get("/people"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void unauthenticated_is_unable_to_post_people() throws Exception {
        mockMvc.perform(post("/people"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(roles = "MODERATOR")
    public void moderator_is_able_to_post_people() throws Exception {
        when(humanController.addHuman(any())).thenReturn(23L);
        mockMvc.perform(post("/people").content("St Peter"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("23"));
    }

    @Test
    @WithMockUser(roles = "MODERATOR")
    public void moderator_is_unable_to_delete_people() throws Exception {
        mockMvc.perform(delete("/people"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void admin_is_able_to_delete_people() throws Exception {
        mockMvc.perform(delete("/people"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
