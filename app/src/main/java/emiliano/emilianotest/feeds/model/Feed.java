package emiliano.emilianotest.feeds.model;

/**
 * Created by Emiliano on 30/8/17.
 */

public class Feed {

    private String text;

    public Feed(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
