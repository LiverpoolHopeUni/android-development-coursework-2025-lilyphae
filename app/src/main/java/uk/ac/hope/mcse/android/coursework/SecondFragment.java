package uk.ac.hope.mcse.android.coursework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import uk.ac.hope.mcse.android.coursework.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.saveMoodButton.setOnClickListener(v -> {
            int selectedId = binding.moodRadioGroup.getCheckedRadioButtonId();
            String mood = "";
            if (selectedId != -1) {
                switch (selectedId) {
                    case R.id.radioHappy:
                        mood = "Happy";
                        break;
                    case R.id.radioSad:
                        mood = "Sad";
                        break;
                    case R.id.radioAngry:
                        mood = "Angry";
                        break;
                    case R.id.radioNeutral:
                        mood = "neutral";
                        break;
                }


                MoodStore.addMood(mood);

                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}