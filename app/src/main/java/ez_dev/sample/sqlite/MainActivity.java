package ez_dev.sample.sqlite;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ez_dev.sample.sqlite.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  binding library
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View rootView = binding.getRoot();
        setContentView(rootView);

        BookDAO bookDAO = new BookDAO(this);

        //  CRUD task
        binding.btnRead.setOnClickListener(v -> {
            String textDatabase = bookDAO.getData().toString();
            binding.tvDatabase.setText(textDatabase);
        });
        binding.btnRead.performClick();
        binding.btnCreate.setOnClickListener(v -> {
            Book book = new Book(-1, "title", 10);
            bookDAO.insertData(book);
            binding.btnRead.performClick();
        });
        binding.btnUpdate.setOnClickListener(v -> {
            Book book = new Book(-1, "update", 9);
            Book lastBook = bookDAO.getLastData();
            if(lastBook != null){
                bookDAO.updateData(lastBook.getId(), book);
                binding.btnRead.performClick();
            }
        });
        binding.btnDelete.setOnClickListener(v -> {
            Book lastBook = bookDAO.getLastData();
            if(lastBook != null){
                bookDAO.deleteData(lastBook.getId());
                binding.btnRead.performClick();
            }
        });

    }
}