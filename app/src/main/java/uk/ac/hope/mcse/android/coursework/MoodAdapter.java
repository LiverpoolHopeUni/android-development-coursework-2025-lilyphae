package uk.ac.hope.mcse.android.coursework;

import android.graphics.Color;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class MoodAdapter extends RecyclerView.Adapter<MoodAdapter.MoodViewHolder> {

    private List<String> moodList;

    public MoodAdapter(List<String> moodList) {
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
        String mood = moodList.get(position);
        holder.moodText.setText(mood);

        int color = Color.LTGRAY;


        if ("happy".equalsIgnoreCase(mood)) {
            color = Color.parseColor("#A5D6A7");
        } else if ("sad".equalsIgnoreCase(mood)) {
            color = Color.parseColor("#90CAF9");
        } else if ("angry".equalsIgnoreCase(mood)) {
            color = Color.parseColor("#EF9A9A");
        } else if ("neutral".equalsIgnoreCase(mood)) {
            color = Color.parseColor("#FFF59D");
        }

        holder.itemLayout.setBackgroundColor(color);
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
