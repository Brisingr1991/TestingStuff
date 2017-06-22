package com.publish.shahar91.testingstuff.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.publish.shahar91.testingstuff.R;

public class MainIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intent);
    }

    /**
     * This method is called when the Open Website button is clicked. It will open the website
     * specified by the URL represented by the variable urlAsString using implicit Intents.
     *
     * @param v Button that was clicked.
     */
    public void onClickOpenWebpageButton(View v) {
        String url = "https://www.google.be";
        openWebPage(url);
    }

    /**
     * This method is called when the Open Location in Map button is clicked. It will open the
     * a map to the location represented by the variable addressString using implicit Intents.
     *
     * @param v Button that was clicked.
     */
    public void onClickOpenAddressButton(View v) {
        String address = "Antwerp";
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("geo")
                .path("0,0")
                .query(address);
        Uri addressUri = builder.build();

        showMap(addressUri);
    }

    /**
     * This method is called when the Share Text Content button is clicked. It will simply share
     * the text contained within the String textThatYouWantToShare.
     *
     * @param v Button that was clicked.
     */
    public void onClickShareTextButton(View v) {
        shareText("Hello there");
    }

    /**
     * This is where you will create and fire off your own implicit Intent. Yours will be very
     * similar to what I've done above. You can view a list of implicit Intents on the Common
     * Intents page from the developer documentation.
     *
     * @param v Button that was clicked.
     * @see <http://developer.android.com/guide/components/intents-common.html/>
     */
    public void createYourOwn(View v) {
        Toast.makeText(this,
                "TODO: Create Your Own Implicit Intent",
                Toast.LENGTH_SHORT)
                .show();
    }

    private void openWebPage(String url) {
        Uri webPage = Uri.parse(url);
        Intent openWeb = new Intent(Intent.ACTION_VIEW, webPage);
        if (openWeb != null) {
            startActivity(openWeb);
        }

    }

    private void showMap(Uri uri) {
        Intent showMap = new Intent(Intent.ACTION_VIEW, uri);
        showMap.putExtra("uri", uri);
        if (showMap.resolveActivity(getPackageManager()) != null) {
            startActivity(showMap);
        }
    }

    private void shareText(String mimeText) {
        String mimeType = "text/plain";
        String title = "make a choice";

        ShareCompat.IntentBuilder.from(this)
                .setChooserTitle(title)
                .setType(mimeType)
                .setText(mimeText)
                .startChooser();
    }
}
