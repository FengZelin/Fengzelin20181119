package soexample.umeng.com.fengzelin20181119.fragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.abner.ming.MingUtils;
import com.abner.ming.ResultListener;
import com.abner.ming.UmengBean;

import soexample.umeng.com.fengzelin20181119.R;

public class FragmentTwo extends Fragment implements View.OnClickListener {
    private ImageView iv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_two, container, false);
       iv= view.findViewById(R.id.ivage);
       iv.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ivage:
                MingUtils.login(getActivity(), 0, new ResultListener() {
                    @Override
                    public void success(UmengBean umengBean) {

                    }
                });

                break;
        }
    }
}
