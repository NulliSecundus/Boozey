package wisc.boozey;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

/**
 *
 */

public class ProfileFragment extends Fragment {
    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.profile_screen, container, false);
        return myView;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        EditText name = getActivity().findViewById(R.id.Profile_Name);
        String user = main.NAME;
        name.setText(user);
    }

}
