package uk.ac.hope.mcse.android.coursework;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.core.content.ContextCompat;

import uk.ac.hope.mcse.android.coursework.databinding.FragmentSecondBinding;


public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RadioGroup moodRadioGroup = view.findViewById(R.id.moodRadioGroup);
        Button saveMoodButton = view.findViewById(R.id.saveMoodButton);

        saveMoodButton.setOnClickListener(v -> {
            int selectedId = moodRadioGroup.getCheckedRadioButtonId();
            String mood = "";
            String feedbackMessage = "";


            if (selectedId != -1) {
                if (selectedId == R.id.radioHappy) {
                    mood = "Happy";
                    feedbackMessage = "Glad you're feeling happy!";
                } else if (selectedId == R.id.radioSad) {
                    mood = "Sad";
                    feedbackMessage = "Sorry you're feeling sad.";
                } else if (selectedId == R.id.radioAngry) {
                    mood = "Angry";
                    feedbackMessage = "Take a deep breath, it's okay to be angry.";
                } else if (selectedId == R.id.radioNeutral) {
                    mood = "Neutral";
                    feedbackMessage = "Thanks for checking in.";
                }

                Toast.makeText(getContext(), feedbackMessage, Toast.LENGTH_SHORT).show();


                MoodStore.addMood(mood);
                Log.d("MoodStore", "Mood list size: " + MoodStore.getMoods().size());

                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}