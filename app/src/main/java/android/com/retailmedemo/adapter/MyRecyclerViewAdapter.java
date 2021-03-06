package android.com.retailmedemo.adapter;

import android.com.retailmedemo.Modals.DataObject;
import android.com.retailmedemo.R;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by amitrai on 15/3/16.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter
.DataObjectHolder> implements AppBarLayout.OnOffsetChangedListener{
private static String LOG_TAG = "MyRecyclerViewAdapter";
private ArrayList<DataObject> mDataset;
private static MyClickListener myClickListener;
private static final float SCALE_MINIMUM=0.5f;

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder
        implements View
        .OnClickListener {
    ImageView image;
    AppBarLayout layout_appbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
//    TextView dateTime;

    public DataObjectHolder(View itemView) {
        super(itemView);


        image = (ImageView) itemView.findViewById(R.id.image);
        collapsingToolbarLayout = (CollapsingToolbarLayout) itemView.findViewById(R.id.collapsing_toolbar);
//        dateTime = (TextView) itemView.findViewById(R.id.textView2);
        Log.i(LOG_TAG, "Adding Listener");
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        myClickListener.onItemClick(getPosition(), v);
    }
}

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyRecyclerViewAdapter(ArrayList<DataObject> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.design_list, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(final DataObjectHolder holder, int position) {
//        holder.label.setText(mDataset.get(position).getmText1());
//        holder.dateTime.setText(mDataset.get(position).getmText2());



    }

    public void addItem(DataObject dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

public interface MyClickListener {
    public void onItemClick(int position, View v);
}
}