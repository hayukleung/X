package com.hayukleung.x.demo.databinding.demo6;

import android.databinding.BindingAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.widget.TextView;

import com.hayukleung.x.demo.databinding.R;

/**
 * demo for `@BindingAdapter`
 */
public class Demo6BindingAdapter {

    @BindingAdapter("spanText")
    public static void setText(TextView textView, String value) {
        Log.d("BindingAdapter", "setText(TextView textView, String value)");
        SpannableString styledText = new SpannableString(value);
        int count = value.length();
        for (int i = 0; i < count; i++) {
            styledText.setSpan(new TextAppearanceSpan(textView.getContext(), 0 == i % 2 ? R.style.style0ForDemo6 : R.style.style1ForDemo6),
                    i, i + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        textView.setText(styledText, TextView.BufferType.SPANNABLE);
    }
}
