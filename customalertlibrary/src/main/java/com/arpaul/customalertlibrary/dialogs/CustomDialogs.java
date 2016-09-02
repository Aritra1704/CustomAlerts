package com.arpaul.customalertlibrary.dialogs;


import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

/** class to create the Custom Dialog **/
public class CustomDialogs extends Dialog
{
	//initializations
	boolean isCancellable = true;
	/**
	 * Constructor
	 * @param context
	 * @param view
	 */
	protected CustomDialogs(Context context, View view)
	{
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(view);
	}
	/**
	 * Constructor 
	 * @param context
	 * @param view
	 * @param lpW
	 * @param lpH
	 */
	protected CustomDialogs(Context context, View view, int lpW, int lpH)
	{
		this(context, view, lpW, lpH, true);
	}
	/**
	 * Constructor 
	 * @param context
	 * @param view
	 * @param lpW
	 * @param lpH
	 * @param isCancellable
	 */
	protected CustomDialogs(Context context, View view, int lpW, int lpH, boolean isCancellable)
	{
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(view, new LayoutParams(lpW, lpH));
		this.isCancellable = isCancellable;
	}

	/**
	 *
	 * @param context
	 * @param view
	 * @param isCancellable
     */
	protected CustomDialogs(Context context, View view, boolean isCancellable)
	{
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(view);
		this.isCancellable = isCancellable;
	}

	protected CustomDialogs(Context context, View view, int lpW, int lpH, boolean isCancellable, int style)
	{
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(view, new LayoutParams(lpW, lpH));
		this.isCancellable = isCancellable;
	}
	
	@Override
	public void onBackPressed()
	{
		if(isCancellable)
			super.onBackPressed();
	}
	@Override
	public void setCanceledOnTouchOutside(boolean cancel) 
	{
		super.setCanceledOnTouchOutside(cancel);
	}
}
