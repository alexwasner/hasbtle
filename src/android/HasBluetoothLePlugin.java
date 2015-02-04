package com.wasner.hasbluetoothle;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import android.app.Activity;
import android.content.pm.PackageManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HasBluetoothLePlugin extends CordovaPlugin 
{
  //Callback variables
  private final String hasBluetoothLE = "check";
  
  //Object keys
  //Actions
  @Override
  public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException
  {
    //Execute the specified action
    if (hasBluetoothLE.equals(action))
    {
      cordova.getThreadPool().execute(new Runnable() {
        public void run() {
          try {
            check(callbackContext);
          } catch (JSONException e) {
            callbackContext.error("error");
          }
        }
      });
      return true;
    }
    return false;
  }

  private void check(CallbackContext callbackContext) throws JSONException
  {
    boolean result = false;
    if(Integer.valueOf(android.os.Build.VERSION.SDK_INT) >= 18){
      result = cordova.getActivity().getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE);
    }
    JSONObject returnObj = new JSONObject();
    returnObj.put("status", result);
    callbackContext.success(returnObj);
  }
}
