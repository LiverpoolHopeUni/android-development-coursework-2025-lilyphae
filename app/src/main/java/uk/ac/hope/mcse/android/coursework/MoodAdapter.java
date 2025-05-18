package uk.ac.hope.mcse.android.coursework;

import android.graphics.Color;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class MoodAdapter extends RecyclerView.Adapter<MoodAdapter.MoodViewHolder> {

    private List<MoodStore.MoodEntry> moodList;

    public MoodAdapter(List<MoodStore.MoodEntry> moodList) {
        this.moodList = moodList;
    }

    @NonNull
    @Override
    public MoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mood, parent, false);
        return new MoodViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MoodViewHolder holder, int position) {
        MoodStore.MoodEntry entry = moodList.get(position);
        String mood = entry.mood;
        String time = entry.getFormattedTime();
        String displayText = time + " - ";
        int color = Color.LTGRAY;
        Log.d("MoodAdapter", "Binding mood: " + entry.mood + ", note: " + entry.note);



        if ("happy".equalsIgnoreCase(mood)) {
            color = Color.parseColor("#A5D6A7");
            displayText = time + " - \uD83D\uDE0A Happy";
        } else if ("sad".equalsIgnoreCase(mood)) {
            color = Color.parseColor("#90CAF9");
            displayText = time + " - \uD83D\uDE22 Sad";
        } else if ("angry".equalsIgnoreCase(mood)) {
            color = Color.parseColor("#EF9A9A");
            displayText = time + " - \uD83D\uDE20 Angry";
        } else if ("neutral".equalsIgnoreCase(mood)) {
            color = Color.parseColor("#FFF59D");
            displayText = time + " - \uD83D\uDE10 Neutral";
        }


        if (entry.note != null && !entry.note.trim().isEmpty()) {
            displayText += "\n " + entry.note.trim();
        }

        holder.itemLayout.setBackgroundColor(color);
        holder.moodText.setText(displayText);
    }


    @Override
    public int getItemCount() {
        return moodList.size();
    }

    public static class MoodViewHolder extends RecyclerView.ViewHolder {
        TextView moodText;
        View itemLayout;

        public MoodViewHolder(@NonNull View itemView) {
            super(itemView);
            moodText = itemView.findViewById(R.id.moodText);
            itemLayout = itemView.findViewById(R.id.itemLayout);

        }
    }
}
