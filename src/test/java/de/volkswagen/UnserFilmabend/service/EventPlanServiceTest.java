package de.volkswagen.UnserFilmabend.service;


import de.volkswagen.UnserFilmabend.model.Account;
import de.volkswagen.UnserFilmabend.model.EventPlan;
import de.volkswagen.UnserFilmabend.model.Genre;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
public class EventPlanServiceTest {

    @Autowired
    private EventPlanService eventPlanService;

    @Test
    void calculateFavoriteGenres(@Autowired AccountService accountService) {
        Genre gen1 = new Genre();
        gen1.setName("Action");
        Genre gen2 = new Genre();
        gen2.setName("Comedy");
        Genre gen3 = new Genre();
        gen3.setName("Thriller");
        Genre gen4 = new Genre();
        gen4.setName("Horror");
        Account acc1 = new Account();
        acc1.setFavoriteGenres(new HashSet<>(Arrays.asList(gen1,gen2,gen3)));
        Account acc2 = new Account();
        acc2.setFavoriteGenres(new HashSet<>(Arrays.asList(gen1,gen3)));
        Account acc3 = new Account();
        acc3.setFavoriteGenres(new HashSet<>(Arrays.asList(gen1,gen2,gen4)));
        EventPlan plan = new EventPlan();
        plan.setInvitedUsers(new HashSet<>(Arrays.asList(acc1,acc2,acc3)));
        List<String> result = eventPlanService.calculateFavoriteGenres(plan);
        assertThat(eventPlanService.calculateFavoriteGenres(plan).size()).isEqualTo(3);
        assertThat(result.contains(gen1));
        assertThat(result.contains(gen2));
        assertThat(result.contains(gen3));
    }
}