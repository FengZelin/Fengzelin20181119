package soexample.umeng.com.fengzelin20181119.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.List;

import soexample.umeng.com.fengzelin20181119.R;
import soexample.umeng.com.fengzelin20181119.bean.Bean;
import soexample.umeng.com.fengzelin20181119.utils.Http2http;

public class adapter extends RecyclerView.Adapter<adapter.ViewHodel> {
    private Context mContext;
    private List<Bean.DataBean> list;

    public adapter(Context context, List<Bean.DataBean> list) {
        mContext = context;
        this.list = list;
    }


    public void setList(List<Bean.DataBean> list) {
        list.clear();
        list.remove(0);
        list.addAll(list);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public adapter.ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item, null);
        ViewHodel hodel = new ViewHodel(view);
        return hodel;
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.ViewHodel holder, int position) {
        List<Bean.DataBean.ListBean> listBean1 = this.list.get(position).getList();

        if(listBean1.size()>0){
            Bean.DataBean.ListBean listBean = listBean1.get(0);
            String images = listBean.getImages();
            String[] split = images.split("\\|");

            Glide.with(mContext).load(Http2http.https2Http(split[0])).into(holder.image);
            holder.text.setText(listBean.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHodel extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text;
        public ViewHodel(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            image=itemView.findViewById(R.id.image);
        }
    }

}
