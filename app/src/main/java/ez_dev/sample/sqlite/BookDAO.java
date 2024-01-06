package ez_dev.sample.sqlite;

import static ez_dev.sample.sqlite.BookContract.BookTable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private final DbHelper dbHelper;

    public BookDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    /**
     * public method to query database
     */
    public List<Book> getData() {
        List<Book> allBooks = new ArrayList<>();

        SQLiteDatabase database = dbHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM " + BookTable.NAME, null);

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Book book = new Book(cursor.getInt(0), cursor.getString(1), cursor.getDouble(2));
                allBooks.add(book);
            }
        }

        cursor.close();
        database.close();

        return allBooks;
    }

    public boolean insertData(Book book) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(BookTable.COLUMN_TITLE, book.getTitle());
        contentValues.put(BookTable.COLUMN_PRICE, book.getPrice());

        long newRowId = database.insert(BookTable.NAME, null, contentValues);

        return newRowId != -1;
    }

    public boolean updateData(int id, Book book) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(BookTable.COLUMN_TITLE, book.getTitle());
        contentValues.put(BookTable.COLUMN_PRICE, book.getPrice());

        int noRowsAffected = database.update(BookTable.NAME, contentValues, BookTable._ID + " = ? ", new String[]{String.valueOf(id)});

        return noRowsAffected > 0;
    }

    public boolean deleteData(int id) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        int noRowsAffected = database.delete(BookTable.NAME, BookTable._ID + " = ? ", new String[]{String.valueOf(id)});

        return noRowsAffected > 0;
    }

    public Book getLastData() {
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM " + BookTable.NAME + " ORDER BY " + BookTable._ID + " DESC LIMIT 1", null);

        if (cursor.getCount() > 0) {
            cursor.moveToNext();
            Book lastBook = new Book(cursor.getInt(0), cursor.getString(1), cursor.getDouble(2));
            cursor.close();
            database.close();
            return lastBook;
        }

        return null;

    }
}
