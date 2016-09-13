package com.arpaul.customalertlibrary.popups.statingDialog;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.arpaul.customalertlibrary.R;
import com.arpaul.customalertlibrary.popups.common.CustomPopupTypeFace;
import com.arpaul.customalertlibrary.popups.common.TypefaceDO;

/**
 * Created by Aritra on 13-09-2016.
 */
public class CustomSuccessPopup {

    private Context context;
    private PopupWindow pwindo;
    private CollapsingToolbarLayout toolbar_layout;
    private PopupListener listener;
    private TextView tvContentTitle;
    private LinearLayout llBody;

    private Typeface tfNormal, tfBold;
    private String messageTitle;
    private String reason;
    protected LayoutInflater inflater;
    private int textColor = -1;
    private int headerColor = -1;
    private int bodyColor = -1;

    /**
     * Constructor for success only.
     * @param context
     * @param listener
     * @param messageTitle
     * @param reason
     */
    public CustomSuccessPopup(@NonNull Context context, @NonNull PopupListener listener, @NonNull String messageTitle, @NonNull String reason) {
        this.context        = context;
        this.listener       = listener;
        this.messageTitle   = messageTitle;
        this.reason         = reason;

        inflater = LayoutInflater.from(this.context);
    }

    /**
     * Set Typeface normal and bold.
     * @param tfNormal
     * @param tfBold
     */
    public void setTypeface(Typeface tfNormal, Typeface tfBold){
        this.tfNormal   = tfNormal;
        this.tfBold     = tfBold;
    }

    /**
     *
     * @param color
     */
    public void setTitleTextColor(int color){
        this.textColor = color;
    }

    /**
     * Sets Header color.
     * @param color
     */
    public void setHeaderColor(int color){
        this.headerColor = color;
    }

    /**
     *
     * @param color
     */
    public void setBodyColor(int color){
        this.bodyColor = color;
    }

    /**
     * Return whether popup window is showing or not.
     * @return
     */
    public boolean isShowing(){
        if(pwindo != null && pwindo.isShowing())
            return true;

        return false;
    }

    /**
     * Dismisses popup window.
     */
    public void dismiss(){
        if(pwindo != null && pwindo.isShowing())
            pwindo.dismiss();
    }

    public void show(){
        initiatePopupWindow();
    }

    private void initiatePopupWindow() {

        try {
            View layout = inflater.inflate(R.layout.custom_popup_success_nobody, null);

            pwindo = new PopupWindow(layout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

            pwindo.setAnimationStyle(R.style.AnimationPopUp);

            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);


            tvContentTitle      = (TextView) layout.findViewById(R.id.tvContentTitle);
            llBody              = (LinearLayout) layout.findViewById(R.id.llBody);

            toolbar_layout      = (CollapsingToolbarLayout) layout.findViewById(R.id.toolbar_layout);

            if(tfNormal == null)
                createTypeFace();
            applyTypeface(getParentView(layout), tfNormal, Typeface.NORMAL);

            tvContentTitle.setText(messageTitle);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    pwindo.dismiss();
                    listener.OnButtonYesClick(reason);
                }
            }, 2500);

            if(headerColor >= 0)
                toolbar_layout.setBackgroundColor(headerColor);

            if(bodyColor >= 0)
                llBody.setBackgroundColor(bodyColor);

            if(tfBold != null)
                tvContentTitle.setTypeface(tfBold, Typeface.BOLD);
            else if(tfNormal != null)
                tvContentTitle.setTypeface(tfNormal, Typeface.NORMAL);

            if(textColor >= 0)
                tvContentTitle.setText(textColor);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createTypeFace(){
        tfBold = Typeface.createFromAsset(context.getAssets(),"fonts/Muli-Bold.ttf");
        tfNormal = Typeface.createFromAsset(context.getAssets(),"fonts/Muli-Light.ttf");
    }

    public static ViewGroup getParentView(View v) {
        ViewGroup vg = null;

        if(v != null)
            vg = (ViewGroup) v.getRootView();

        return vg;
    }

    public static void applyTypeface(ViewGroup v, Typeface f, int style) {
        if(v != null) {
            int vgCount = v.getChildCount();
            for(int i=0;i<vgCount;i++) {
                if(v.getChildAt(i) == null) continue;
                if(v.getChildAt(i) instanceof ViewGroup)
                    applyTypeface((ViewGroup)v.getChildAt(i), f, style);
                else {
                    View view = v.getChildAt(i);
                    if(view instanceof TextView)
                        ((TextView)(view)).setTypeface(f, style);
                    else if(view instanceof EditText)
                        ((EditText)(view)).setTypeface(f, style);
                    else if(view instanceof Button)
                        ((Button)(view)).setTypeface(f, style);
                }
            }
        }
    }
}
