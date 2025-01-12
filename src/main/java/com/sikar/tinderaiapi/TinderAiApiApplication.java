package com.sikar.tinderaiapi;

import com.sikar.tinderaiapi.conversations.ConversationRepository;
import com.sikar.tinderaiapi.profiles.ProfileCreationService;
import com.sikar.tinderaiapi.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TinderAiApiApplication implements CommandLineRunner {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private ProfileCreationService profileCreationService;

    public static void main(String[] args) {
        SpringApplication.run(TinderAiApiApplication.class, args);
    }


    @Override
    public void run(String... args) {
        profileCreationService.createProfiles(0);
        profileCreationService.saveProfilesToDB();
    }

    private void clearAllData() {
        conversationRepository.deleteAll();
        profileRepository.deleteAll();
    }
}
