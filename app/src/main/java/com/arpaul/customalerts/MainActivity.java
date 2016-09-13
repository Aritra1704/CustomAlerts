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

import com.arpaul.customalertlibrary.dialogs.CustomDialog;
import com.arpaul.customalertlibrary.popups.common.CustomPopupTypeFace;
import com.arpaul.customalertlibrary.popups.listDialog.CustomListPopup;
import com.arpaul.customalertlibrary.popups.listDialog.CustomPopupListType;
import com.arpaul.customalertlibrary.popups.listDialog.PopupListListener;
import com.arpaul.customalertlibrary.popups.repeatDialog.CustomRepeatPopup;
import com.arpaul.customalertlibrary.popups.repeatDialog.PopupRepeatListener;
import com.arpaul.customalertlibrary.popups.statingDialog.CustomPopup;
import com.arpaul.customalertlibrary.popups.statingDialog.CustomPopupType;
import com.arpaul.customalertlibrary.popups.statingDialog.CustomSuccessPopup;
import com.arpaul.customalertlibrary.popups.statingDialog.PopupListener;
import com.arpaul.customalertlibrary.popups.textSpinner.CustomSpinner;
import com.arpaul.customalertlibrary.popups.textSpinner.SpinnerCellListener;
import com.arpaul.utilitieslib.ColorUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PopupListener, PopupRepeatListener {

    private Context mContext;
    private CustomDialog cDialog;
    private CustomPopup cPopup;
    private CustomRepeatPopup cRepeatDialog;
    private CustomListPopup cListDialog;
    private CustomSpinner csTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;

//        showCustomDialog(getString(R.string.gpssettings),getString(R.string.gps_not_enabled),getString(R.string.settings),getString(R.string.cancel),getString(R.string.settings), CustomPopupType.DIALOG_ALERT,false);
        findViewById(R.id.btnDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showCustomDialog(getString(R.string.gpssettings),getString(R.string.gps_not_enabled),getString(R.string.settings),getString(R.string.cancel),getString(R.string.settings), CustomPopupType.DIALOG_ALERT,false);
//                showDialog(MainActivity.this,"Title","Content body","Accept","Discard","test",false);
                startActivity(new Intent(MainActivity.this, PaletteActivity.class));
            }
        });

//        new CustomDialog(MainActivity.this, MainActivity.this, "Success","Message success",
//                null, null, "Success", CustomPopupType.DIALOG_SUCCESS).show();
        findViewById(R.id.btnDialogSuccess).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cDialog = new CustomDialog(MainActivity.this, MainActivity.this, "Success","Message success",
                        null, null, "Success", CustomPopupType.DIALOG_SUCCESS);
//                cPopup.setHeaderColor(ColorUtils.getColor(MainActivity.this,R.color.colorBrightRed));
                cDialog.show();
            }
        });

        findViewById(R.id.btnDialogAlert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cDialog = new CustomDialog(MainActivity.this, MainActivity.this, getString(R.string.gpssettings),getString(R.string.gps_not_enabled),getString(R.string.settings),getString(R.string.cancel),getString(R.string.settings), CustomPopupType.DIALOG_ALERT);
//                cPopup.setHeaderColor(ColorUtils.getColor(MainActivity.this,R.color.colorBrightRed));
                cDialog.show();
            }
        });

        findViewById(R.id.btnDialogFaiure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cDialog = new CustomDialog(MainActivity.this, MainActivity.this, "Failure","Message failure",
                        getString(R.string.ok), null, "Alert", CustomPopupType.DIALOG_FAILURE);
//                cPopup.setHeaderColor(ColorUtils.getColor(MainActivity.this,R.color.colorBrightRed));
                cDialog.show();
            }
        });

        findViewById(R.id.btnCustomDialogAccept).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cPopup = new CustomPopup(MainActivity.this, MainActivity.this, "Success","Message success",
                        null, null, "Success", CustomPopupType.DIALOG_SUCCESS);
//                cPopup.setHeaderColor(ColorUtils.getColor(MainActivity.this,R.color.colorBrightRed));
                cPopup.show();
            }
        });

        findViewById(R.id.btnDialogSuccessNobody).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CustomSuccessPopup(MainActivity.this, MainActivity.this, "Success", "Success").show();
            }
        });

        findViewById(R.id.btnCustomDialogDecline).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cPopup = new CustomPopup(MainActivity.this, MainActivity.this,"Failure","Message failure.",
                        getString(R.string.ok), null, "Failure", CustomPopupType.DIALOG_FAILURE);
                Typeface tfBold = Typeface.createFromAsset(getAssets(),"fonts/Muli-Bold.ttf");
//                cPopup.setTypefaceFor(CustomDialogTypeFace.DIALOG_BODY, tfBold, Typeface.BOLD);
//                cPopup.setTypefaceFor(CustomDialogTypeFace.DIALOG_TITLE, tfBold, Typeface.BOLD);
                cPopup.show();
            }
        });

        findViewById(R.id.btnCustomDialogAlert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CustomPopup(MainActivity.this, MainActivity.this,"Alert","Message alert",
                        getString(R.string.ok), null, "Alert", CustomPopupType.DIALOG_ALERT).show();
            }
        });

        findViewById(R.id.btnCustomDialogNormal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cPopup = new CustomPopup(MainActivity.this, MainActivity.this,"Normal","Message normal",
                        getString(R.string.ok), null, "Normal", CustomPopupType.DIALOG_NORMAL);
                cPopup.setTextColorFor(CustomPopupTypeFace.DIALOG_TITLE, ColorUtils.getColor(MainActivity.this, R.color.colorMediumGrey));
                cPopup.show();
            }
        });

        findViewById(R.id.btnCustomDialogWait).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cPopup = new CustomPopup(MainActivity.this, MainActivity.this,"Wait","Please wait..",
                        getString(R.string.ok), null, "Wait", CustomPopupType.DIALOG_WAIT);
//                cPopup.setTextColorFor(CustomDialogTypeFace.DIALOG_TITLE, ColorUtils.getColor(MainActivity.this, R.color.bpLight_gray));
                cPopup.show();
            }
        });

        findViewById(R.id.btnCustomList).setOnClickListener(new View.OnClickListener() {
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

        findViewById(R.id.btnTwoway).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRepeatDialog = new CustomRepeatPopup(MainActivity.this, MainActivity.this,"Repeat",
                        getString(R.string.ok), null, "Repeat");
                cRepeatDialog.show();
            }
        });

        findViewById(R.id.btnMaterial).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        findViewById(R.id.btnDeterminateTwoway).setOnClickListener(new View.OnClickListener() {
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
