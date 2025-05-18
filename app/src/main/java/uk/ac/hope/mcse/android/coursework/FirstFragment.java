package uk.ac.hope.mcse.android.coursework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Date;

import uk.ac.hope.mcse.android.coursework.databinding.FragmentFirstBinding;


/**
 *
 */
public class FirstFragment extends Fragment {

    private MoodAdapter adapter;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView todaysDateText = view.findViewById(R.id.todaysDateText);
        String formattedDate = new SimpleDateFormat("EEEE, d MMMM yyyy", Locale.getDefault()).format(new Date());
        todaysDateText.setText(formattedDate);

        Button nextButton = view.findViewById(R.id.button_first);
        nextButton.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_PastMoodsFragment)
        );


        RecyclerView moodRecyclerView = view.findViewById(R.id.moodRecyclerView);
        TextView emptyMessageText = view.findViewById(R.id.emptyMessageText);

        List<MoodStore.MoodEntry> todaysMoods = MoodStore.getTodaysMoods();

        if (todaysMoods.isEmpty()) {
            emptyMessageText.setVisibility(View.VISIBLE);
        } else {
            emptyMessageText.setVisibility(View.GONE);
        }

        adapter = new MoodAdapter(todaysMoods);
        moodRecyclerView.setAdapter(adapter);
        moodRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



    }

    @Override
    public void onResume() {
        super.onResume();

        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }

        TextView emptyMessageText = requireView().findViewById(R.id.emptyMessageText);
        if (MoodStore.getTodaysMoods().isEmpty()) {
            emptyMessageText.setVisibility(View.VISIBLE);
        } else {
            emptyMessageText.setVisibility(View.GONE);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}