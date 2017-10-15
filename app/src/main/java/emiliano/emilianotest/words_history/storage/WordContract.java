package emiliano.emilianotest.words_history.storage;

import android.provider.BaseColumns;

public final class WordContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private WordContract() {
    }

    /* Inner class that defines the table contents */
    public static class WordEntry implements BaseColumns {
        public static final String TABLE_NAME = "history";
        public static final String COLUMN_NAME_TITLE = "word";
    }
}

