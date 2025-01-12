package com.sikar.tinderaiapi.matches;

import com.sikar.tinderaiapi.profiles.Profile;

public record Match(String id, Profile profile, String conversationId) {
}
