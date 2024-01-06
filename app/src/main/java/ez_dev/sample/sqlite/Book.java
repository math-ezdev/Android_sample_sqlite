package ez_dev.sample.sqlite;

import android.util.Log;

import androidx.annotation.NonNull;

public class Book {
    private int id;
    private String title;
    private double price;

    //  constructor
    public Book(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
        Log.i("INIT_BOOK",this.toString());
    }

    //  getter - setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @NonNull
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
