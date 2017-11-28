package wisc.boozey;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.login.LoginManager;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 *
 */
public class SettingsFragment extends Fragment implements OnClickListener{
    View myView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.settings_screen, container, false);
        return myView;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button newBlockButton = getActivity().findViewById(R.id.Logout);
        newBlockButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        LoginManager.getInstance().logOut();
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }
}