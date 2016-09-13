package com.arpaul.customalerts;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Aritra on 13-09-2016.
 */
public class PaletteActivity extends AppCompatActivity {

    private ImageView mImageView;
    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;
    private TextView mTextView4;
    private TextView mTextView5;
    private TextView mTextView6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_palette);

        mImageView = (ImageView) findViewById(R.id.iv_pic);

        mTextView1 = (TextView) findViewById(R.id.tv_1);
        mTextView2 = (TextView) findViewById(R.id.tv_2);
        mTextView3 = (TextView) findViewById(R.id.tv_3);
        mTextView4 = (TextView) findViewById(R.id.tv_4);
        mTextView5 = (TextView) findViewById(R.id.tv_5);
        mTextView6 = (TextView) findViewById(R.id.tv_6);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic_3);

        extract(bitmap);
    }

    private void extract(Bitmap bitmap) {

        mImageView.setImageBitmap(bitmap);

        // Palette palette = Palette.generate(bitmap);
        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                final Palette.Swatch vibrant = palette.getVibrantSwatch();
                final Palette.Swatch darkVibrant = palette.getDarkVibrantSwatch();
                final Palette.Swatch lightVibrant = palette.getLightVibrantSwatch();
                final Palette.Swatch muted = palette.getMutedSwatch();
                final Palette.Swatch darkMuted = palette.getDarkMutedSwatch();
                final Palette.Swatch lightMuted = palette.getLightMutedSwatch();

                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(vibrant.getRgb()));

                mTextView1.setText("Vibrant color");
                if (vibrant != null) {
                    mTextView1.setBackgroundColor(vibrant.getRgb());
                    mTextView1.setTextColor(vibrant.getTitleTextColor());
                }
                mTextView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (vibrant != null) {
                            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(vibrant.getRgb()));
                        }
                    }
                });

                mTextView2.setText("Vibrant dark");
                if (darkVibrant != null) {
                    mTextView2.setBackgroundColor(darkVibrant.getRgb());
                    mTextView2.setTextColor(darkVibrant.getTitleTextColor());
                }
                mTextView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (darkVibrant != null) {
                            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(darkVibrant.getRgb()));
                        }
                    }
                });

                mTextView3.setText("Vibrant bright");
                if (lightVibrant != null) {
                    mTextView3.setBackgroundColor(lightVibrant.getRgb());
                    mTextView3.setTextColor(lightVibrant.getTitleTextColor());
                }
                mTextView3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (lightVibrant != null) {
                            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(lightVibrant.getRgb()));
                        }
                    }
                });

                mTextView4.setText("Pastel colors");
                if (muted != null) {
                    mTextView4.setBackgroundColor(muted.getRgb());
                    mTextView4.setTextColor(muted.getTitleTextColor());
                }
                mTextView4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (muted != null) {
                            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(muted.getRgb()));
                        }
                    }
                });

                mTextView5.setText("Soft dark");
                if (darkMuted != null) {
                    mTextView5.setBackgroundColor(darkMuted.getRgb());
                    mTextView5.setTextColor(darkMuted.getTitleTextColor());
                }
                mTextView5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (darkMuted != null) {
                            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(darkMuted.getRgb()));
                        }
                    }
                });

                mTextView6.setText("Bright pastel");
                if (lightMuted != null) {
                    mTextView6.setBackgroundColor(lightMuted.getRgb());
                    mTextView6.setTextColor(lightMuted.getTitleTextColor());
                }
                mTextView6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (lightMuted != null) {
                            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(lightMuted.getRgb()));
                        }
                    }
                });
            }
        });
    }
}
