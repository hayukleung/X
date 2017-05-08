package com.hayukleung.x.base.common.wrapper;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/**
 * 图片显示工具
 */
public class XImage {

  /**
   * @param context
   * @param source
   * @param imageView
   * @param transformations
   */
  public static void load(Context context, Object source, ImageView imageView,
      Transformation<Bitmap>... transformations) {
    load(context, source, imageView, new RequestListener<Object, GlideDrawable>() {
      @Override public boolean onException(Exception e, Object model, Target<GlideDrawable> target,
          boolean isFirstResource) {
        return false;
      }

      @Override public boolean onResourceReady(GlideDrawable resource, Object model,
          Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
        return false;
      }
    }, transformations);
  }

  /**
   * @param context
   * @param source may be Uri, String, File, ResourceId
   * @param imageView
   * @param requestListener
   * @param transformations Crop - CropTransformation, CropCircleTransformation,
   * CropSquareTransformation, RoundedCornersTransformation
   * Color - ColorFilterTransformation, GrayscaleTransformation
   * Blur - BlurTransformation
   * Mask - MaskTransformation
   */
  public static void load(Context context, Object source, final ImageView imageView,
      RequestListener<Object, GlideDrawable> requestListener,
      Transformation<Bitmap>... transformations) {
    Glide.with(context)
        .load(source)
        .bitmapTransform(transformations)
        // .placeholder(R.drawable.ic_image_stub)
        .listener(requestListener)
        .into(imageView);
  }

  /**
   * @param context
   * @param source
   * @param imageView
   * @param requestListener
   */
  public static void load(Context context, Object source, ImageView imageView,
      RequestListener<Object, GlideDrawable> requestListener) {
    load(context, source, imageView, requestListener, new CenterCrop(context));
  }

  /**
   * @param context
   * @param source
   * @param imageView
   */
  public static void load(Context context, Object source, ImageView imageView) {
    load(context, source, imageView, new RequestListener<Object, GlideDrawable>() {
      @Override public boolean onException(Exception e, Object model, Target<GlideDrawable> target,
          boolean isFirstResource) {
        return false;
      }

      @Override public boolean onResourceReady(GlideDrawable resource, Object model,
          Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
        return false;
      }
    }, new CenterCrop(context));
  }
}
