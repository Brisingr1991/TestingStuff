package com.publish.shahar91.testingstuff.petsApp.data;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.publish.shahar91.testingstuff.R;

/**
 * {@link PetAdapter} is an adapter for a list or grid view
 * that uses a {@link Cursor} of pet data as its data source. This adapter knows
 * how to create list items for each row of pet data in the {@link Cursor}.
 */
public class PetAdapter extends CursorAdapter {
    /**
     * Constructs a new {@link PetAdapter}.
     *
     * @param context The context
     * @param c       The cursor from which to get the data.
     */
    public PetAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    /**
     * Makes a new blank list item view. No data is set (or bound) to the views yet.
     *
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already
     *                moved to the correct position.
     * @param parent  The parent to which the new view is attached to
     * @return the newly created list item view.
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.pets_list_item, parent, false);
    }

    /**
     * This method binds the pet data (in the current row pointed to by cursor) to the given
     * list item layout. For example, the name for the current pet can be set on the name TextView
     * in the list item layout.
     *
     * @param view    Existing view, returned earlier by newView() method
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already moved to the
     *                correct row.
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find the individual views that we want to modify in the list item layout
        TextView tvName = (TextView) view.findViewById(R.id.pet_name);
        TextView tvBreed = (TextView) view.findViewById(R.id.pet_breed);

        // Find the columns of pet attributes that we're interested in and
        // read the pet attributes from the Cursor for the current pet
        String name = cursor.getString(cursor.getColumnIndexOrThrow(PetContract.PetEntry.COLUMN_NAME));
        String breed = cursor.getString(cursor.getColumnIndexOrThrow(PetContract.PetEntry.COLUMN_BREED));

        if (TextUtils.isEmpty(breed)) {
            breed = "Unknown breed";
        }
        // Update the TextViews with the attributes for the current pet
        tvName.setText(name);
        tvBreed.setText(breed);
    }
}
