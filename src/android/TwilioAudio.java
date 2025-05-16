package com.medleymed.TwilioAudio;

import android.content.Context;
import android.content.Intent;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * This class echoes a string called from JavaScript.
 */
public class
TwilioAudio extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String number = args.getString(0);
            String accestokenURL  = args.getString(1);
            String callerId = args.getString(2);
            String name = args.getString(3);
            //this.coolMethod(message, callbackContext);
            Context context = cordova.getActivity().getApplicationContext();
            this.openCustomDeviceActivity(context,number,accestokenURL,callerId,name);
            return true;
        }
        return false;
    }

    private void openCustomDeviceActivity(Context context, String number, String accestokenURL, String callerId, String name){

        cordova.getThreadPool().execute(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(context.getApplicationContext(), com.medleymed.TwilioAudio.VoiceActivity.class);
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("number", number);
                intent.putExtra("accestokenURL", accestokenURL);
                intent.putExtra("callerId", callerId);
                intent.putExtra("name", name);
                cordova.getContext().getApplicationContext().startActivity(intent);

            }
        });
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
