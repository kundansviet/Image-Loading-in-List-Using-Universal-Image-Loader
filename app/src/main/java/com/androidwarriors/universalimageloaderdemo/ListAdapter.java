package com.androidwarriors.universalimageloaderdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by kundan on 6/19/2016.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {

    private ImageLoader imageLoader;
    private DisplayImageOptions options;
    private LayoutInflater inflater;
    private Context context;
    String[] images = {"https://2.bp.blogspot.com/-qdVGBrZpNEo/Vzs7Dyba8eI/AAAAAAAANXg/oQGukisNydIcTA733Q8qNX1xryCNrP1-gCLcB/s640/AndroidNotification.png",
            "https://2.bp.blogspot.com/-MtTDhb_9QGw/Vr9OXfE0hqI/AAAAAAAAMZo/e9Advd4xPmY/s1600/Googleplus.png",
            "http://3.bp.blogspot.com/-hEsy8I3DVrA/ViFFalr14kI/AAAAAAAAL74/nfZd4behDE0/s1600/material-tabs.png",
            "https://4.bp.blogspot.com/-fzCN1en9BXY/VslDs985vvI/AAAAAAAAMbU/JycBEflEJcI/s1600/sqlitedemo.png",
            "https://3.bp.blogspot.com/-0CvhPeUCDes/VtGVTINSNhI/AAAAAAAAMc8/CzGr-nlqgS8/s1600/FacebookIntegration.png",
            "http://2.bp.blogspot.com/-DpC34QctSsI/Vh6JZjWY-0I/AAAAAAAAL5c/-UgJEDKYays/s1600/pushNotification.png",
            "http://4.bp.blogspot.com/-8u_hqbGb30g/VjR9WflhCNI/AAAAAAAAMFs/namqhGH1AE0/s1600/material_mcs1_original.png",
            "http://1.bp.blogspot.com/-5nkpiqWiPkg/Vj9jWk0IyiI/AAAAAAAAMIQ/uEBdjXr3jCY/s1600/TwitterloginAndroid.png",
            "http://3.bp.blogspot.com/-oY46UYNjKFk/Vike7jlX05I/AAAAAAAAMBA/OjeJp6BAio8/s640/studio-hero.jpg",
            "http://4.bp.blogspot.com/-UgboLypyx9s/Vq5LeA35rbI/AAAAAAAAMXs/4fGJQPURYwg/s1600/seekbarinandroid.png"};

    public ListAdapter(Context context) {

        this.context = context;
        inflater = LayoutInflater.from(context);

        imageLoader = ImageLoader.getInstance();

        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.place_holder)
                .showImageForEmptyUri(R.drawable.place_holder)
                .showImageOnFail(R.drawable.place_holder)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();


    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.single_row, parent, false);
        ListHolder holder = new ListHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        imageLoader.displayImage(images[position], holder.imageView, options);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    class ListHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ListHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
