package com.publish.shahar91.testingstuff.miwokTabs.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */

public class Word {
    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * Default translation for the word
     */
    private String defaultWord;
    /**
     * Miwok translation for the word
     */
    private String miwokWord;
    private int imageResourceId = NO_IMAGE_PROVIDED;
    private int soundResourceId;

    /**
     * Create a new Word object.
     *
     * @param defaultWord is the word in a language that the user is already familiar with (such as English)
     * @param miwokWord   is the word in the Miwok language
     */
    public Word(String defaultWord, String miwokWord, int soundResourceId) {
        this.defaultWord = defaultWord;
        this.miwokWord = miwokWord;
        this.soundResourceId = soundResourceId;
    }

    /**
     * Create a new Word object.
     *
     * @param defaultWord     is the word in a language that the user is already familiar with (such as English)
     * @param miwokWord       is the word in the Miwok language
     * @param imageResourceId is the resource id
     */
    public Word(String defaultWord, String miwokWord, int imageResourceId, int soundResourceId) {
        this.defaultWord = defaultWord;
        this.miwokWord = miwokWord;
        this.imageResourceId = imageResourceId;
        this.soundResourceId = soundResourceId;
    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultWord() {
        return defaultWord;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokWord() {
        return miwokWord;
    }

    /**
     * Get the image resource id.
     */
    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getSoundResourceId() {
        return soundResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return imageResourceId != NO_IMAGE_PROVIDED;
    }

    @Override
    public String toString() {
        return "Word{" +
                "defaultWord='" + defaultWord + '\'' +
                ", miwokWord='" + miwokWord + '\'' +
                ", imageResourceId=" + imageResourceId +
                ", soundResourceId=" + soundResourceId +
                '}';
    }
}
