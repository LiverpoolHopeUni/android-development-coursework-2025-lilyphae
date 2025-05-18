package uk.ac.hope.mcse.android.coursework;

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
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new MoodViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MoodViewHolder holder, int position) {
        holder.moodText.setText(moodList.get(position));
    }

    @Override
    public int getItemCount() {
        return moodList.size();
    }

    public static class MoodViewHolder extends RecyclerView.ViewHolder {
        TextView moodText;

        public MoodViewHolder(@NonNull View itemView) {
            super(itemView);
            moodText = itemView.findViewById(android.R.id.text1);

        }
    }
}
