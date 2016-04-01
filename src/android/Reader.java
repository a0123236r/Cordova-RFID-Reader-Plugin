package com.reader.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import com.phychips.rcp.*;

public class Reader extends CordovaPlugin implements iRcpEvent2 {

    String tag_id="";

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        
        if (action.equals("scan")) {

            RcpApi2.getInstance().setOnRcpEventListener(this);
            RcpApi2.getInstance().open();
            if (RcpApi2.getInstance().isOpen()) {
                RcpApi2.getInstance().startReadTagsWithTid(1, 1, 1);
            }

            String message = data.getString(0);
            callbackContext.success(tag_id);

            return true;

        } else {

            return false;

        }
    }

    @Override
    public void onResetReceived() {

    }

    @Override
    public void onSuccessReceived(int[] ints, int i) {

    }

    @Override
    public void onFailureReceived(int[] ints) {

    }

    @Override
    public void onTagReceived(int[] ints) {

    }

    @Override
    public void onTagWithTidReceived(int[] ints, int[] ints1) {
        tag_id = "";
        for(int n= 2;n<ints.length;n++){
            //ints content should divide 16 to EPC number
            if(ints[n]<16){
                tag_id += "0" +Integer.toString(ints[n],16);
            }else {
                tag_id += Integer.toString(ints[n],16);
            }
        }
    }

    @Override
    public void onTagWithRssiReceived(int[] ints, int i) {

    }

    @Override
    public void onReaderInfoReceived(int[] ints) {

    }

    @Override
    public void onRegionReceived(int i) {

    }

    @Override
    public void onSelectParamReceived(int[] ints) {

    }

    @Override
    public void onQueryParamReceived(int[] ints) {

    }

    @Override
    public void onChannelReceived(int i, int i1) {

    }

    @Override
    public void onFhLbtReceived(int[] ints) {

    }

    @Override
    public void onTxPowerLevelReceived(int i) {

    }

    @Override
    public void onTagMemoryReceived(int[] ints) {

    }

    @Override
    public void onTagMemoryLongReceived(int[] ints) {

    }

    @Override
    public void onBatteryStateReceived(int[] ints) {

    }

    @Override
    public void onSessionReceived(int i) {

    }

    @Override
    public void onGenericTransportReceived(int i, int[] ints) {

    }
}
