package soexample.umeng.com.fengzelin20181119.fragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import soexample.umeng.com.fengzelin20181119.R;
import soexample.umeng.com.fengzelin20181119.adapter.adapter;
import soexample.umeng.com.fengzelin20181119.bean.Bean;
import soexample.umeng.com.fengzelin20181119.ivew.IView;
import soexample.umeng.com.fengzelin20181119.presenter.Presenter;

public class Fragmentone extends Fragment implements IView<Bean> {
    private RecyclerView rec;
    private List<Bean.DataBean> list;
    private Presenter mPresenter;
    private adapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragmentone, container, false);
        rec=view.findViewById(R.id.re_view);
        init();
        return view;
    }

    private void init() {
        list=new ArrayList<>();
        mAdapter = new adapter(getActivity(), list);
        rec.setAdapter(mAdapter);
        rec.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        mPresenter=new Presenter();
        mPresenter.attch(this);
        mPresenter.get("http://www.zhaoapi.cn/product/getCarts?uid=71");

    }

    @Override
    public void success(Bean bean) {
        List<Bean.DataBean> data = bean.getData();
        if(data!=null){
            list.clear();
            list.addAll(data);
            mAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public void failed(Exception e) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.dele();
    }
}
