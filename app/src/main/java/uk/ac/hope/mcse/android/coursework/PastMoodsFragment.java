package uk.ac.hope.mcse.android.coursework;

import android.os.Bundle;
import android.widget.DatePicker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class PastMoodsFragment extends Fragment {

    private MoodAdapter adapter;
    private RecyclerView recyclerView;
    private DatePicker datePicker;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_past_moods, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        datePicker = view.findViewById(R.id.datePicker);
        recyclerView = view.findViewById(R.id.pastMoodRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new MoodAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        updateListForSelectedDate();

        datePicker.setOnDateChangedListener((view1, year, monthOfYear, dayOfMonth) -> {
            updateListForSelectedDate();
        });
    }

    private void updateListForSelectedDate() {
        Calendar selectedDate = Calendar.getInstance();
        selectedDate.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());

        String formattedDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(selectedDate.getTime());

        List<MoodStore.MoodEntry> allMoods = MoodStore.getAllMoods();
        List<MoodStore.MoodEntry> filtered = new ArrayList<>();

        for (MoodStore.MoodEntry mood : allMoods) {
            if (mood.getFormattedDate().equals(formattedDate)) {
                filtered.add(mood);
            }
        }

        adapter = new MoodAdapter(filtered);
        recyclerView.setAdapter(adapter);
    }
}
