package com.sikar.tinderaiapi.profiles;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    private final ProfileRepository profileRepository;

    public ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @GetMapping("/profiles/random")
    public Profile getRandomProfile() {
        return profileRepository.getRandomProfile();
    }

    // @GetMapping("/profiles")
    // public List<Profile> getProfiles() {
    //     return profileService.getProfiles();
    // }

    // @GetMapping("/profiles/{id}")
    // public Profile getProfile(@PathVariable String id) {
    //     return profileService.getProfile(id);
    // }

    // @PostMapping("/profiles")
    // public Profile createProfile(@RequestBody CreateProfileRequest createProfileRequest) {
    //     return profileService.createProfile(createProfileRequest);
    // }

    // @PutMapping("/profiles/{id}")
    // public Profile updateProfile(@PathVariable String id, @RequestBody UpdateProfileRequest updateProfileRequest) {
    //     return profileService.updateProfile(id, updateProfileRequest);
    // }

    // @DeleteMapping("/profiles/{id}")
    // public void deleteProfile(@PathVariable String id) {
    //     profileService.deleteProfile(id);
    // }
}
