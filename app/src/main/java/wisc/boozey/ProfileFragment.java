package wisc.boozey;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 */

public class ProfileFragment extends Fragment {
    View myView;
    DBHandler db = new DBHandler(getActivity());
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.profile_screen, container, false);
        String userName = db.getUser(1).getName();
        EditText text = myView.findViewById(R.id.Profile_Name);
        text.setText(userName);
        return myView;
    }
}
