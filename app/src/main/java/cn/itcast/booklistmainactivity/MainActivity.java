package cn.itcast.booklistmainactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<BookItem> bookItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        RecyclerView mainRecycleView = findViewById( R.id.recycle_view_books );
        LinearLayoutManager layoutManager = new LinearLayoutManager( this );
        mainRecycleView.setLayoutManager( layoutManager );

        mainRecycleView.setAdapter( new MyRecyclerViewAdapter( bookItems ) );
    }

    public void initData(){
        bookItems=new ArrayList<BookItem>();
        bookItems.add( new BookItem( "信息安全数学基础 (第二版)",R.drawable.book_1 ) );
        bookItems.add( new BookItem("软件项目管理案例教程 (第四版)",R.drawable.book_2 ) );
        bookItems.add( new BookItem("创新工程实践",R.drawable.book_no_name ) );
    }

    private class MyRecyclerViewAdapter extends RecyclerView.Adapter {
        private List<BookItem> bookItems;

        public MyRecyclerViewAdapter(List<BookItem> bookItems) {
            this.bookItems = bookItems;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.book_item_holder, parent, false);

            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder Holder, int position) {
            MyViewHolder holder= (MyViewHolder)Holder;

            holder.getImageView().setImageResource( bookItems.get(position).getCoverResourceId() );
            holder.getTextViewName().setText( bookItems.get(position).getTitle() );

        }

        @Override
        public int getItemCount() {
            return bookItems.size();
        }

        private class MyViewHolder extends RecyclerView.ViewHolder {
            private final ImageView imageView;
            private final TextView textViewName;

            public MyViewHolder(View view) {
                super(view);

                this.imageView = view.findViewById( R.id.image_view_book_cover );
                this.textViewName = view.findViewById( R.id.text_view_book_title );

            }

            public ImageView getImageView() {
                return imageView;
            }

            public TextView getTextViewName() {
                return textViewName;
            }
        }
    }
}