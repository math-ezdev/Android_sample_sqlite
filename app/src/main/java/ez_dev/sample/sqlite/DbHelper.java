package ez_dev.sample.sqlite;

import static ez_dev.sample.sqlite.BookContract.BookTable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, "book.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateTableBook = "CREATE TABLE " + BookTable.NAME + " (" + BookTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + BookTable.COLUMN_TITLE + " TEXT," + BookTable.COLUMN_PRICE + " REAL" + ")";
        db.execSQL(sqlCreateTableBook);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlDeleteTableBook = "DROP TABLE IF EXISTS " + BookTable.NAME;
        db.execSQL(sqlDeleteTableBook);
        onCreate(db);
    }
}
