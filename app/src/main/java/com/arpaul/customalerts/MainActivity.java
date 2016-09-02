package com.arpaul.customalerts;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.arpaul.customalertlibrary.popups.common.CustomPopupTypeFace;
import com.arpaul.customalertlibrary.popups.listDialog.CustomListPopup;
import com.arpaul.customalertlibrary.popups.listDialog.CustomPopupListType;
import com.arpaul.customalertlibrary.popups.listDialog.PopupListListener;
import com.arpaul.customalertlibrary.popups.repeatDialog.CustomRepeatPopup;
import com.arpaul.customalertlibrary.popups.repeatDialog.PopupRepeatListener;
import com.arpaul.customalertlibrary.popups.statingDialog.CustomPopup;
import com.arpaul.customalertlibrary.popups.statingDialog.CustomPopupType;
import com.arpaul.customalertlibrary.popups.statingDialog.PopupListener;
import com.arpaul.customalertlibrary.popups.textSpinner.CustomSpinner;
import com.arpaul.customalertlibrary.popups.textSpinner.SpinnerCellListener;
import com.arpaul.utilitieslib.ColorUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PopupListener, PopupRepeatListener {

    private CustomPopup cPopup;
    private Button btnDialog,btnProgressBar, btnCustomDialogAccept, btnCustomDialogDecline, btnCustomDialogAlert,
            btnCustomDialogNormal, btnCustomDialogWait;
    private Button btnTwoway, btnMaterial, btnDeterminateTwoway, btnCustomList;
    private Context mContext;
    private CustomPopup cDialog;
    private CustomRepeatPopup cRepeatDialog;
    private CustomListPopup cListDialog;
    private CustomSpinner csTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*findViewById(R.id.btnAlert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog(getString(R.string.gpssettings),getString(R.string.gps_not_enabled),getString(R.string.settings),getString(R.string.cancel),getString(R.string.settings), CustomPopupType.DIALOG_ALERT,false);
            }
        });*/

        mContext = MainActivity.this;
//        setContentView(R.layout.activity_main);

//        showCustomDialog(getString(R.string.gpssettings),getString(R.string.gps_not_enabled),getString(R.string.settings),getString(R.string.cancel),getString(R.string.settings), CustomPopupType.DIALOG_ALERT,false);
        btnDialog = (Button) findViewById(R.id.btnDialog);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog(getString(R.string.gpssettings),getString(R.string.gps_not_enabled),getString(R.string.settings),getString(R.string.cancel),getString(R.string.settings), CustomPopupType.DIALOG_ALERT,false);
//                showDialog(MainActivity.this,"Title","Content body","Accept","Discard","test",false);
            }
        });

        btnProgressBar = (Button) findViewById(R.id.btnProgressBar);
        btnProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*new MaterialDialog.Builder(MainActivity.this)
                        .title("Progress Dialog")
                        .content("Please wait..")
                        .progress(true, 0)
                        .progressIndeterminateStyle(true)
                        .show();

                showProgressDialog(MainActivity.this, "Progress Dialog", "Please wait..", 80, false);*/
            }
        });

        btnCustomDialogAccept = (Button) findViewById(R.id.btnCustomDialogAccept);
        btnCustomDialogAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cDialog = new CustomPopup(MainActivity.this, MainActivity.this, "Success","Message success",
                        null, null, "Success", CustomPopupType.DIALOG_SUCCESS);
//                cDialog.setHeaderColor(ColorUtils.getColor(MainActivity.this,R.color.colorBrightRed));
                cDialog.show();
            }
        });

        btnCustomDialogDecline = (Button) findViewById(R.id.btnCustomDialogDecline);
        btnCustomDialogDecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cDialog = new CustomPopup(MainActivity.this, MainActivity.this,"Failure","Message failure.",
                        getString(R.string.ok), null, "Failure", CustomPopupType.DIALOG_FAILURE);
                Typeface tfBold = Typeface.createFromAsset(getAssets(),"fonts/Muli-Bold.ttf");
//                cDialog.setTypefaceFor(CustomDialogTypeFace.DIALOG_BODY, tfBold, Typeface.BOLD);
//                cDialog.setTypefaceFor(CustomDialogTypeFace.DIALOG_TITLE, tfBold, Typeface.BOLD);
                cDialog.show();
            }
        });

        btnCustomDialogAlert = (Button) findViewById(R.id.btnCustomDialogAlert);
        btnCustomDialogAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CustomPopup(MainActivity.this, MainActivity.this,"Alert","Message alert",
                        getString(R.string.ok), null, "Alert", CustomPopupType.DIALOG_ALERT).show();
            }
        });

        btnCustomDialogNormal = (Button) findViewById(R.id.btnCustomDialogNormal);
        btnCustomDialogNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cDialog = new CustomPopup(MainActivity.this, MainActivity.this,"Normal","Message normal",
                        getString(R.string.ok), null, "Normal", CustomPopupType.DIALOG_NORMAL);
                cDialog.setTextColorFor(CustomPopupTypeFace.DIALOG_TITLE, ColorUtils.getColor(MainActivity.this, R.color.colorMediumGrey));
                cDialog.show();
            }
        });

        btnCustomDialogWait = (Button) findViewById(R.id.btnCustomDialogWait);
        btnCustomDialogWait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cDialog = new CustomPopup(MainActivity.this, MainActivity.this,"Wait","Please wait..",
                        getString(R.string.ok), null, "Wait", CustomPopupType.DIALOG_WAIT);
//                cDialog.setTextColorFor(CustomDialogTypeFace.DIALOG_TITLE, ColorUtils.getColor(MainActivity.this, R.color.bpLight_gray));
                cDialog.show();
            }
        });

        btnCustomList = (Button) findViewById(R.id.btnCustomList);
        btnCustomList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> arrList = new ArrayList<String>();
                arrList.add("Text1");
                arrList.add("Text2");
                arrList.add("Text3");
                arrList.add("Text4");

                cListDialog = new CustomListPopup(MainActivity.this, new PopupListListener() {
                    @Override
                    public void SelectedListClick(View view, int which, String from) {

                    }

                    @Override
                    public void OnListYesClick(String from) {

                    }

                    @Override
                    public void OnListNoClick(String from) {

                    }
                }, "List", arrList, "List", CustomPopupListType.LIST_SINGLESELECT);
//                cListDialog.setTextColorFor(CustomDialogTypeFace.DIALOG_TITLE, ColorUtils.getColor(MainActivity.this, R.color.bpLight_gray));
                cListDialog.show();
            }
        });

        btnTwoway = (Button) findViewById(R.id.btnTwoway);
        btnTwoway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRepeatDialog = new CustomRepeatPopup(MainActivity.this, MainActivity.this,"Repeat",
                        getString(R.string.ok), null, "Repeat");
                cRepeatDialog.show();
            }
        });

        btnMaterial = (Button) findViewById(R.id.btnMaterial);
        btnMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        btnDeterminateTwoway = (Button) findViewById(R.id.btnDeterminateTwoway);
        btnDeterminateTwoway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        csTest = (CustomSpinner) findViewById(R.id.csTest);
        csTest.setTitleText("Title");
        csTest.setHint("Tap here");
        ArrayList<String> arrSpin = new ArrayList<>();
        arrSpin.add("Test 1");
        arrSpin.add("Test 2");
        arrSpin.add("Test 3");
        arrSpin.add("Test 4");
        arrSpin.add("Test 5");
        csTest.setAdapter(arrSpin);
        csTest.setItemlistener(new SpinnerCellListener() {
            @Override
            public void onItemClick(String selectedCell){
                csTest.setText(selectedCell);
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

    @Override
    public void RepeatDialogYesClick(String from, String repeat) {
        Toast.makeText(MainActivity.this, repeat, Toast.LENGTH_LONG).show();
    }

    @Override
    public void RepeatDialogNoClick(String from) {

    }
}
