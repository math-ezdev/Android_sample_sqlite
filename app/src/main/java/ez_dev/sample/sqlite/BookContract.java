package ez_dev.sample.sqlite;

import android.provider.BaseColumns;

public final class BookContract {
    /**
     * private constructor to prevent init contract class
    * */
    private BookContract(){}

    /**
     * table content
     */
    public static class BookTable implements BaseColumns{
        public static final String NAME = "BOOK";
        public static final String COLUMN_TITLE = "TITLE";
        public static final String COLUMN_PRICE = "PRICE";
    }
}
