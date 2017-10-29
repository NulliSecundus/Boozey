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

/**
 *
 */

public class GameFragment extends Fragment{
    View myView;
    String[] installedGames = {"Circle of Death","King's Cup","Ride the Bus",
            "Game1","Game2","Game3","Game4","Game5","Game6","Game7","Game8","Game9"};
  
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.game_screen, container, false);

        ListView gameListView = myView.findViewById(R.id.gamesListView);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_expandable_list_item_1,
                installedGames);
        gameListView.setAdapter(listViewAdapter);

        return myView;
    }

}
