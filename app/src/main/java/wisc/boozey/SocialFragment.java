package wisc.boozey;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 *
 */

public class SocialFragment extends Fragment {
    View myView;
    Friend Chris = new Friend("Chris",2,1,1);
    Friend Dan = new Friend("Dan",3,2,1);
    Friend Brendan = new Friend("Brendan",3,1,2);
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.social_screen, container, false);
        return myView;
    }
}
