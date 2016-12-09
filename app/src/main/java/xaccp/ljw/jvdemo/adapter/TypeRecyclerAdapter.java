package xaccp.ljw.jvdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mcxtzhang.swipemenulib.SwipeMenuLayout;

import java.util.List;

import xaccp.ljw.jvdemo.R;
import xaccp.ljw.jvdemo.bean.Bean;

/**
 * Created by jv on 2016/10/31.
 */

public class TypeRecyclerAdapter extends RecyclerView.Adapter<TypeRecyclerAdapter.MyHolder> {

    private LayoutInflater mInflater;
    private List<Bean> mDatas;
    private OnItemClickListener mOnItemClickListener;

    public TypeRecyclerAdapter(Context context, List<Bean> datas) {
        this.mInflater = LayoutInflater.from(context);
        this.mDatas = datas;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        int type = 0;

        if (viewType == 1) {
            itemView = mInflater.inflate(R.layout.item_test1, parent, false);
            type = 1;
        } else if (viewType == 2) {
            itemView = mInflater.inflate(R.layout.item_test2, parent, false);
            type = 2;
        }

        return new MyHolder(itemView, type);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        if (getItemViewType(position) == 1 || getItemViewType(position) == 2) {
            holder.setItem(mDatas.get(position));
        } else {
            holder.setItem(null);
        }

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public int getItemViewType(int position) {
         return mDatas.get(position).getType();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name, title;
        private SwipeMenuLayout swipeMenuLayout;


        public MyHolder(View itemView, final int type) {
            super(itemView);

            if (type == 1) {
                name = (TextView) itemView.findViewById(R.id.item_name);
            } else if (type == 2) {
                name = (TextView) itemView.findViewById(R.id.item_name);
                title = (TextView) itemView.findViewById(R.id.item_title);
            }

            swipeMenuLayout = (SwipeMenuLayout) itemView.findViewById(R.id.swipe);

            itemView.findViewById(R.id.content).setOnClickListener(this);
            itemView.findViewById(R.id.btn_delete).setOnClickListener(this);
            itemView.findViewById(R.id.btn_read).setOnClickListener(this);
            itemView.findViewById(R.id.btn_top).setOnClickListener(this);

        }

        public void closeSwipe(){
            swipeMenuLayout.smoothClose();
        }

        public void setItem(Bean bean) {

            if (bean != null) {
                if (bean.getType() == 1) {
                    name.setText(bean.getName());

                } else if (bean.getType() == 2) {
                    name.setText(bean.getName());
                    title.setText(bean.getTitle());
                }
            }

        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition()-2;
            switch (view.getId()) {
                case R.id.btn_delete:
                    mOnItemClickListener.onItemDelete(mDatas.get(position),position);
                    break;
                case R.id.btn_read:
                    mOnItemClickListener.onItemRead(mDatas.get(position),position);
                    swipeMenuLayout.smoothClose();
                    break;
                case R.id.btn_top:
                    mOnItemClickListener.onItemTop(mDatas.get(position),position);
                    break;
                case R.id.content:
                    mOnItemClickListener.onItemClick(mDatas.get(position),position);
                    break;
            }
        }
    }


    //对外提供项点击事件
    public interface OnItemClickListener {
        void onItemClick(Bean bean, int position);

        void onItemDelete(Bean bean, int position);

        void onItemTop(Bean bean, int position);

        void onItemRead(Bean bean, int position);
    }

    public void setOnItemClicklistener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

}
