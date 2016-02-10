package cc.moden.android.practiceapp;

/**
 * Manage the state for a Pet Rock.
 * Created by tyler on 2/9/16.
 */
public class PetRock {
    @Override
    public String toString() {
        return "I'm feeling " + currentEmotion.toString() + ".";
    }

    public enum Emotion {TIRED, HAPPY, SAD};
    private Emotion currentEmotion = Emotion.TIRED;

    public Emotion getCurrentEmotion() {
        return currentEmotion;
    }

    public void setCurrentEmotion(Emotion currentEmotion) {
        this.currentEmotion = currentEmotion;
    }
}
