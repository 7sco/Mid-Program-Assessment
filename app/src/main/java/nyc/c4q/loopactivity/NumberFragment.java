package nyc.c4q.loopactivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NumberFragment extends Fragment {

    private TextView showNumber;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_number, container, false);

        showNumber= view.findViewById(R.id.number_from_bundle);
        Bundle bundle = getArguments();
        String getNumber= String.valueOf(bundle.getString("number"));
        showNumber.setText(getNumber);


        return view;
    }

}
