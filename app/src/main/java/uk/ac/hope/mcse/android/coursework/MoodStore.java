package uk.ac.hope.mcse.android.coursework;

import java.util.ArrayList;
import java.util.List;

public class MoodStore {
    private static final List<String> moodEntries = new ArrayList<>();

    public static void addMood(String mood) {
        moodEntries.add(0, mood);
    }

    public static List<String> getMoods() {
        return moodEntries;
    }
}
