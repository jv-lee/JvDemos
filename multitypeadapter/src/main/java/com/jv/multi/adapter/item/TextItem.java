package com.jv.multi.adapter.item;

import android.view.View;

import com.jv.multi.R;
import com.jv.multi.adapter.MultiTypeAdapter;
import com.jv.multi.model.TextModel;

/**
 * Created by Administrator on 2017/2/23.
 */

public class TextItem extends BaseItem {
    @Override
    public int getLayout() {
        return R.layout.item_text;
    }

    ///////////////////////////////////////////
    private final TextModel textModel;

    public TextItem(final MultiTypeAdapter adapter, TextModel textModel) {
        this.textModel = textModel;

        setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.tv_like:
                        toggleLiked();
                        adapter.notifyItemChanged(adapter.findPosition(TextItem.this));
                        break;
                    case R.id.tv_hide:
                        adapter.notifyItemRemoved(adapter.removeItem(TextItem.this));
                        break;
                    case R.id.tv_comment:
                        // TODO: jump to another activity
                        break;
                }
            }
        });
    }

    public String getContent() {
        return textModel.content;
    }

    public boolean isLiked() {
        return textModel.liked;
    }

    private void toggleLiked() {
        textModel.liked = !textModel.liked;
    }
}
