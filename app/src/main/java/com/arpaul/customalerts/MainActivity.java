package com.arpaul.customalerts;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.arpaul.customalertlibrary.popups.statingDialog.CustomPopup;
import com.arpaul.customalertlibrary.popups.statingDialog.CustomPopupType;
import com.arpaul.customalertlibrary.popups.statingDialog.PopupListener;

public class MainActivity extends AppCompatActivity implements PopupListener {

    private CustomPopup cPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAlert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog(getString(R.string.gpssettings),getString(R.string.gps_not_enabled),getString(R.string.settings),getString(R.string.cancel),getString(R.string.settings), CustomPopupType.DIALOG_ALERT,false);
            }
        });
    }

    /**
     * Shows Dialog with user defined buttons.
     * @param title
     * @param message
     * @param okButton
     * @param noButton
     * @param from
     * @param isCancelable
     */
    public void showCustomDialog(final String title, final String message, final String okButton, final String noButton, final String from, boolean isCancelable){
        runOnUiThread(new RunShowDialog(title,message,okButton,noButton,from, isCancelable));
    }

    public void showCustomDialog(final String title, final String message, final String okButton, final String noButton, final String from, CustomPopupType dislogType, boolean isCancelable){
        runOnUiThread(new RunShowDialog(title,message,okButton,noButton,from, dislogType, isCancelable));
    }

    public void hideCustomDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (cPopup != null && cPopup.isShowing())
                    cPopup.dismiss();
            }
        });
    }

    class RunShowDialog implements Runnable {
        private String strTitle;// FarmName of the materialDialog
        private String strMessage;// Message to be shown in materialDialog
        private String firstBtnName;
        private String secondBtnName;
        private String from;
        private String params;
        private boolean isCancelable=false;
        private CustomPopupType dislogType = CustomPopupType.DIALOG_NORMAL;
        private int isNormal = 0;
        public RunShowDialog(String strTitle,String strMessage, String firstBtnName, String secondBtnName,	String from, boolean isCancelable)
        {
            this.strTitle 		= strTitle;
            this.strMessage 	= strMessage;
            this.firstBtnName 	= firstBtnName;
            this.secondBtnName	= secondBtnName;
            this.isCancelable 	= isCancelable;
            if (from != null)
                this.from = from;
            else
                this.from = "";

            isNormal = 0;
        }

        public RunShowDialog(String strTitle,String strMessage, String firstBtnName, String secondBtnName,	String from, CustomPopupType dislogType, boolean isCancelable)
        {
            this.strTitle 		= strTitle;
            this.strMessage 	= strMessage;
            this.firstBtnName 	= firstBtnName;
            this.secondBtnName	= secondBtnName;
            this.dislogType     = dislogType;
            this.isCancelable 	= isCancelable;
            if (from != null)
                this.from = from;
            else
                this.from = "";

            isNormal = 1;
        }

        @Override
        public void run() {
            if(isNormal > 0)
                showNotNormal();
            else
                showNormal();
        }

        private void showNotNormal(){
            try{
                if (cPopup != null && cPopup.isShowing())
                    cPopup.dismiss();

                cPopup = new CustomPopup(MainActivity.this, MainActivity.this,strTitle,strMessage,
                        firstBtnName, secondBtnName, from, dislogType);

//                cPopup.setTypeface(tfAdventProMedium,tfAdventProRegular);

                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        cPopup.show();
                    }
                });
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        private void showNormal(){
            try{
                if (cPopup != null && cPopup.isShowing())
                    cPopup.dismiss();

                cPopup = new CustomPopup(MainActivity.this, MainActivity.this,strTitle,strMessage,
                        firstBtnName, secondBtnName, from, CustomPopupType.DIALOG_NORMAL);

//                cPopup.setTypeface(tfAdventProMedium,tfAdventProRegular);

                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        cPopup.show();
                    }
                });
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void OnButtonYesClick(String from) {
        dialogYesClick(from);
    }

    @Override
    public void OnButtonNoClick(String from) {
        dialogNoClick(from);
    }

    public void dialogYesClick(String from) {

    }

    public void dialogNoClick(String from) {
        if(from.equalsIgnoreCase("")){

        }
    }
}
