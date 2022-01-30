package com.example.soai_project.InboxRecyclerAdapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soai_project.Founderr1.CommonData;
import com.example.soai_project.R;

import org.w3c.dom.Text;

import java.text.BreakIterator;

public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.AllViewHolder>{

    //array to userames from data set
    private String[] userNames;
    private ImageView[] userImages;

    private static final String TAG = InboxAdapter.class.getSimpleName();
    final private ListItemClickListener mOnClickListener;
    // private static int viewHolderCount;
    //  private int mNumberItems;

    public interface ListItemClickListener {
        void onListItemClick(String username,TextView message);
    }

    //String[] users is the array that contains names passed from inbox_activity for now

    public InboxAdapter(ListItemClickListener listener,String[] users) {
        mOnClickListener = listener;
        userNames=users;

    }

  /*  @Override
    public int getItemCount() {
        return mNumberItems;
    }*/

    public class AllViewHolder extends RecyclerView.ViewHolder
            implements OnClickListener {

        public final ImageView userImage;
        public  final TextView username;
        public TextView time;
        public TextView message;
        public TextView counter;
        public TextView seen;

        public AllViewHolder(View view) {
            super(view);

            userImage=(ImageView) view.findViewById(R.id.user_image);
            username=(TextView) view.findViewById(R.id.user_name);
            time=(TextView) view.findViewById(R.id.time);
            message=(TextView) view.findViewById(R.id.message);
            counter=(TextView) view.findViewById(R.id.counter);
            seen=(TextView)view.findViewById(R.id.seen);
            view.setOnClickListener(this);
        }



        /*void bind(int listIndex) {
            listItemNumberView.setText(String.valueOf(listIndex));
        }


        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }*/


        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            String userName =userNames[adapterPosition];
            mOnClickListener.onListItemClick(userName,message);
            showSeen();
        }

        public void showSeen()
        {
            counter.setVisibility(View.INVISIBLE);
            seen.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public AllViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.inbox_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        AllViewHolder viewHolder = new AllViewHolder(view);

        return viewHolder;


        /*viewHolderCount++;
        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: "
                + viewHolderCount);
        return viewHolder;*/

    }

    @Override
    public void onBindViewHolder(AllViewHolder ViewHolder, int position) {
        String name= userNames[position];
        ViewHolder.username.setText(name);
    }


    @Override
    public int getItemCount() {
        if (null == userNames) return 0;
        return userNames.length;
    }


}
