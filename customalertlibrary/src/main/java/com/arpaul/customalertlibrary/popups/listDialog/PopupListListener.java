package com.arpaul.customalertlibrary.popups.listDialog;

import android.view.View;

/**
 * Created by Aritra on 05-07-2016.
 */
public interface PopupListListener {
    public void SelectedListClick(View view, int which, String from);
    public void OnListYesClick(String from);
    public void OnListNoClick(String from);
}
