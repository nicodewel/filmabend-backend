package de.volkswagen.UnserFilmabend.service;

import de.volkswagen.UnserFilmabend.model.EventPlan;
import de.volkswagen.UnserFilmabend.model.Genre;
import de.volkswagen.UnserFilmabend.repository.EventPlanRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EventPlanService {

    private EventPlanRepository eventPlanRepository;


    public EventPlanService(EventPlanRepository eventPlanRepository) {
        this.eventPlanRepository = eventPlanRepository;
    }

    public List<String> calculateFavoriteGenres(EventPlan eventPlan ){
        Map<String, Integer> favs = new HashMap<>();
        eventPlan.getInvitedUsers().forEach(
                user -> user.getFavoriteGenres().forEach(
                    genre -> favs.put(genre.getName(),favs.getOrDefault(genre.getName(),0) + 1 )
        ));
        List<String> top3 = new ArrayList<>();
                favs.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(3)
                .forEach(e -> top3.add(e.getKey()));
        return top3;
    }
}