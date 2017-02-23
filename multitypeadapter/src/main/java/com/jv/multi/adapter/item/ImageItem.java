package com.jv.multi.adapter.item;

import android.view.View;

import com.jv.multi.R;
import com.jv.multi.adapter.MultiTypeAdapter;
import com.jv.multi.model.ImageModel;

/**
 * Created by Administrator on 2017/2/20.
 */

public class ImageItem extends BaseItem {
    @Override
    public int getLayout() {
        return R.layout.item_image;
    }

    ////////////////////////////////////////////////
    private final ImageModel imageModel;

    public ImageItem(final MultiTypeAdapter adapter, ImageModel imageModel) {
        this.imageModel = imageModel;

        setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.tv_like:
                        toggleLiked();
                        adapter.notifyItemChanged(adapter.findPosition(ImageItem.this));
                        break;
                    case R.id.tv_hide:
                        adapter.notifyItemRemoved(adapter.removeItem(ImageItem.this));
                        break;
                    case R.id.tv_comment:
                        // TODO: jump to another activity
                        break;
                }
            }
        });
    }

    public String getUrl() {
        return imageModel.url;
    }

    public boolean isLiked() {
        return imageModel.liked;
    }

    private void toggleLiked() {
        imageModel.liked = !imageModel.liked;
    }
}
