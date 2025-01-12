package com.sikar.tinderaiapi.matches;

import com.sikar.tinderaiapi.conversations.Conversation;
import com.sikar.tinderaiapi.conversations.ConversationRepository;
import com.sikar.tinderaiapi.profiles.Profile;
import com.sikar.tinderaiapi.profiles.ProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class MatchController {

    public record CreateMatchRequest(
            String profileId) {
    }
    private final MatchRepository matchRepository;
    private final ConversationRepository conversationRepository;
    private final ProfileRepository profileRepository;

    public MatchController(MatchRepository matchRepository, ConversationRepository conversationRepository, ProfileRepository profileRepository) {
        this.matchRepository = matchRepository;
        this.conversationRepository = conversationRepository;
        this.profileRepository = profileRepository;
    }

    @PostMapping("/matches")
    public Match createMatch(@RequestBody CreateMatchRequest createMatchRequest) {
        Profile profile = profileRepository.findById(createMatchRequest.profileId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found"));
        // TODO: Make sure there are not existing conversations for this profile.
        Conversation conversation = new Conversation(
                UUID.randomUUID().toString(),
                profile.id(),
                new ArrayList<>()
        );
        conversationRepository.save(conversation);
        Match match = new Match(
                UUID.randomUUID().toString(),
                profile,
                conversation.id()
        );
        return matchRepository.save(match);
    }

     @GetMapping("/matches/{id}")
     public Match getMatch(@PathVariable String id) {
         return matchRepository.findById(id)
                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found"));
     }

    @GetMapping("/matches")
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }
}
