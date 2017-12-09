package nyc.c4q.loopactivity;


import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by yokilam on 12/6/17.
 */

public class NumberViewHolder extends RecyclerView.ViewHolder{


    private TextView numberView;

    Context context;


    public NumberViewHolder(final View itemView) {
        super(itemView);

        numberView= itemView.findViewById(R.id.number_view);
        CardView cardView= itemView.findViewById(R.id.card_view);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NumberFragment numberFragment= new NumberFragment();
                android.support.v4.app.FragmentManager fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                Bundle bundle = new Bundle();
//                bundle.putString("number", numberView.getText().toString());
//                numberFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, numberFragment);
                fragmentTransaction.addToBackStack("next").commit();

                Bundle bundle = new Bundle();
                bundle.putString("number", numberView.getText().toString());
                numberFragment.setArguments(bundle);

            }
        });
    }

    public void bind(NumberModel numberModel, Context context) {
       numberView.setText(String.valueOf(numberModel.getNumber()));

        this.context=context;
    }
}
