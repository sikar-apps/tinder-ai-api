package com.sikar.tinderaiapi;

import com.sikar.tinderaiapi.conversations.ChatMessage;
import com.sikar.tinderaiapi.conversations.Conversation;
import com.sikar.tinderaiapi.conversations.ConversationRepository;
import com.sikar.tinderaiapi.profiles.Gender;
import com.sikar.tinderaiapi.profiles.Profile;
import com.sikar.tinderaiapi.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class TinderAiApiApplication implements CommandLineRunner {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ConversationRepository conversationRepository;

    public static void main(String[] args) {
        SpringApplication.run(TinderAiApiApplication.class, args);
    }


    @Override
    public void run(String... args) {
        conversationRepository.deleteAll();

        // TODO: Move profile creation to a separate endpoint
        Profile profile = new Profile("1", "John", "Doe", 25, "Indian", Gender.MALE, "Software Engineer", "foo.jpg", "INTJ");
        profileRepository.save(profile);

        Profile profile2 = new Profile("2", "Jane", "Doe", 25, "Indian", Gender.FEMALE, "Software Engineer", "foo.jpg", "INTJ");
        profileRepository.save(profile2);
        profileRepository.findAll().forEach(System.out::println);

        // TODO: Move conversation creation to a separate endpoint
        conversationRepository.save(new Conversation("1", profile.id(), List.of(new ChatMessage("Hello", profile.id(), LocalDateTime.now()))));
        conversationRepository.findAll().forEach(System.out::println);
    }
}
