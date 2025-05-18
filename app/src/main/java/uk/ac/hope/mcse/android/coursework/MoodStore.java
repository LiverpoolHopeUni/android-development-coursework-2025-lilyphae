package uk.ac.hope.mcse.android.coursework;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.lang.reflect.Type;

public class MoodStore {

    public static class MoodEntry {
        public String mood;
        public long timestamp;
        public String note;

        public MoodEntry(String mood, long timestamp, String note) {
            this.mood = mood;
            this.timestamp = timestamp;
            this.note = note;
        }

        public String getFormattedDate() {
            return new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date(timestamp));
        }

        public String getFormattedTime() {
            String formatted = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(timestamp));
            Log.d("MoodStore", "Formatted time: " + formatted);
            return formatted;
        }
    }

    private static final List<MoodEntry> moodList = new ArrayList<>();

    public static void addMood(String mood, String note) {
        MoodEntry entry = new MoodEntry(mood, System.currentTimeMillis(), note);
        moodList.add(0, entry);
        Log.d("MoodStore", "Saved: " + mood + " at " + entry.getFormattedTime());
    }

    public static List<MoodEntry> getAllMoods() {
        return moodList;
    }

    public static List<MoodEntry> getTodaysMoods() {
        String today = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        List<MoodEntry> todayList = new ArrayList<>();
        for (MoodEntry entry : moodList) {
            if (entry.getFormattedDate().equals(today)) {
                todayList.add(entry);
            }
        }
        return todayList;
    }
}
