package wisc.boozey;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import wisc.boozey.games.RideTheBus;
import wisc.boozey.games.TestGame;

/**
 *
 */

public class GameFragment extends Fragment{
    View myView;
    String[] installedGames = {"Test Game","Ride The Bus","Circle of Death","King's Cup",
            "Game1","Game2","Game3","Game4","Game5","Game6","Game7","Game8","Game9"};
  
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.game_screen, container, false);
        final ListView gameListView = myView.findViewById(R.id.gamesListView);
        final FragmentManager fragmentManager = getFragmentManager();

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_expandable_list_item_1,
                installedGames);

        gameListView.setAdapter(listViewAdapter);
        gameListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String gameName = (String) gameListView.getItemAtPosition(i);
                Toast.makeText(getActivity(), gameName, Toast.LENGTH_SHORT).show();

                if(gameName.contentEquals("Test Game")){
                    fragmentManager.beginTransaction()
                            .replace(R.id.main_layout, new TestGame())
                            .commit();
                }
                else if(gameName.contentEquals("Ride The Bus")){
                    fragmentManager.beginTransaction()
                            .replace(R.id.main_layout, new RideTheBus())
                            .commit();
                }
            }
        });
        return myView;
    }

}
