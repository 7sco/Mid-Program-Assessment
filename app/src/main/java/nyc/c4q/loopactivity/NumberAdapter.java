package nyc.c4q.loopactivity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yokilam on 12/6/17.
 */

public class NumberAdapter extends RecyclerView.Adapter<NumberViewHolder> {

    ArrayList<NumberModel> numberList;
    Context context;

    public NumberAdapter(ArrayList<NumberModel> numberList, Context context) {

        this.numberList = numberList;
        this.context=context;
    }

    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView= LayoutInflater.from(parent.getContext()).inflate(R.layout.number_itemview, parent, false);
        return new NumberViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        holder.bind(numberList.get(position), context);

    }

    @Override
    public int getItemCount() {
        return numberList.size();
    }
}
