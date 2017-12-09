package nyc.c4q.loopactivity;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link BaseFragment} subclass.
 */
public class BaseFragment extends Fragment {

    private RecyclerView recyclerView;
    private View view;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_layout, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);

        ArrayList<NumberModel> numberList= new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            numberList.add(new NumberModel(i));
            Log.d("number" , ""+ numberList);
        }



        recyclerView.setLayoutManager(new LinearLayoutManager((getActivity()), LinearLayoutManager.VERTICAL, false));
        NumberAdapter numberAdapter=new NumberAdapter(numberList, this.getContext());

        recyclerView.setAdapter(numberAdapter);

        return view;
    }

}
