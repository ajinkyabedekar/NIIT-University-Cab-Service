package niituniversity.nucs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class LoginFragment extends Fragment {

    private static final int RC_SIGN_IN = 123;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        createSignInIntent();
        return view;
    }

    private void createSignInIntent() {
//        ActionCodeSettings actionCodeSettings = ActionCodeSettings.newBuilder()
//                .setAndroidPackageName("com.example.niituniversitycabservice", true,
//                null)
//                .setHandleCodeInApp(true)
//                .setUrl("niit-university-cab-serv-2a6ff.firebaseapp.com")
//                .build();
//
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
//                new AuthUI.IdpConfig.EmailBuilder().enableEmailLinkSignIn()
//                        .setActionCodeSettings(actionCodeSettings).build(),
                new AuthUI.IdpConfig.PhoneBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build(),
//                new AuthUI.IdpConfig.FacebookBuilder().build(),
//                new AuthUI.IdpConfig.TwitterBuilder().build(),
//                new AuthUI.IdpConfig.GitHubBuilder().build(),
                new AuthUI.IdpConfig.AnonymousBuilder().build());

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
//                        .setLogo(R.drawable.my_great_logo)
//                        .setTheme(R.style.MySuperAppTheme)
                        .setTosAndPrivacyPolicyUrls(
                                "https://example.com/terms.html",
                                "https://example.com/privacy.html")
                        .build(),
                RC_SIGN_IN);
//        if (AuthUI.canHandleIntent(getIntent())) {
//            if (getIntent().getExtras() == null) {
//                return;
//            }
//            String link = getIntent().getExtras().getString(ExtraConstants.EMAIL_LINK_SIGN_IN);
//            if (link != null) {
//                startActivityForResult(
//                        AuthUI.getInstance()
//                                .createSignInIntentBuilder()
//                                .setEmailLink(link)
//                                .setAvailableProviders(providers)
//                                .build(),
//                        RC_SIGN_IN);
//            }
//        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            }
        }
    }

//    public void signOut() {
//        AuthUI.getInstance()
//                .signOut(this)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    public void onComplete(@NonNull Task<Void> task) {
//                    }
//                });
//    }
//
//    public void delete() {
//        AuthUI.getInstance()
//                .delete(this)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                    }
//                });
//    }
//
}
