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
        String[]names = {Chris.getName() + " 2 1 1", Dan.getName() + " 3 2 1", Brendan.getName() + " 3 1 2"};
        final ListView profileViewList = myView.findViewById(R.id.profileViewList);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_expandable_list_item_1,
                names);
        profileViewList.setAdapter(listViewAdapter);
        profileViewList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String test = (String) profileViewList.getItemAtPosition(i);
                Toast.makeText(getActivity(), test, Toast.LENGTH_SHORT).show();
            }
        });
        return myView;
    }
}
