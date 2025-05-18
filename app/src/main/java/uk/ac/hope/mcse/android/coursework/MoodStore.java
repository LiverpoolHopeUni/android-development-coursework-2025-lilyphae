package uk.ac.hope.mcse.android.coursework;

import java.util.ArrayList;
import java.util.List;

public class MoodStore {
    private static final List<String> moodList = new ArrayList<>();

    public static void addMood(String mood) {

        moodList.add(0, mood);
    }

    public static List<String> getMoods() {

        return moodList;
    }
}
