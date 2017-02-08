package es.iesnervion.fjruiz.mov_08_nervionplayers.notifications;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by fjruiz on 8/02/17.
 */

public class Tokenizer extends FirebaseInstanceIdService {

    @Override
    public void onCreate(){
        onTokenRefresh();
    }

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String refreshedToken) {
        //TODO Llamada a la api para registrar el FCM del teléfono
    }
}
