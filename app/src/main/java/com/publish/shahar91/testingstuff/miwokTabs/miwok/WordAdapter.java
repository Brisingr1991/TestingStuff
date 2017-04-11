package com.publish.shahar91.testingstuff.miwokTabs.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.publish.shahar91.testingstuff.R;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int colorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int color) {
        super(context, 0, words);
        colorResourceId = color;
    }

    @NonNull
    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word words = getItem(position);

        TextView defaultWord = (TextView) listItemView.findViewById(R.id.item_default);
        defaultWord.setText(words.getDefaultWord());

        TextView miwokWord = (TextView) listItemView.findViewById(R.id.item_miwok);
        miwokWord.setText(words.getMiwokWord());

        ImageView resource = (ImageView) listItemView.findViewById(R.id.image);
        if (words.hasImage()) {
            resource.setImageResource(words.getImageResourceId());
        } else {
            resource.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        View imageIcon = listItemView.findViewById(R.id.itemLo);
        int color = ContextCompat.getColor(getContext(), colorResourceId);
        textContainer.setBackgroundColor(color);
        imageIcon.setBackgroundColor(color);
        return listItemView;
    }
}
