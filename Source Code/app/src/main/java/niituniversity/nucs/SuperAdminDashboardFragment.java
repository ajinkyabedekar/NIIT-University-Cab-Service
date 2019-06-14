package niituniversity.nucs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;

public class SuperAdminDashboardFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_super_admin_dashboard, container, false);
        ProgressBar progressBar = view.findViewById(R.id.progress_circular);
        progressBar.setVisibility(View.VISIBLE);
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            getFragmentManager().beginTransaction().replace(R.id.main_activity, new LoginFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
        }
        return view;
    }
}
