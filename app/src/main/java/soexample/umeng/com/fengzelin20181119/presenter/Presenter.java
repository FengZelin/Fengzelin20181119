package soexample.umeng.com.fengzelin20181119.presenter;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import soexample.umeng.com.fengzelin20181119.bean.Bean;
import soexample.umeng.com.fengzelin20181119.inter.ICallBack;
import soexample.umeng.com.fengzelin20181119.ivew.IView;
import soexample.umeng.com.fengzelin20181119.model.Model;

public class Presenter {
    private IView iv;
    private Model mModel;

    public void attch(IView iv){
       this.iv=iv;
       mModel=new Model();
    }
    public void get(String url){
        Type type = new TypeToken<Bean>(){}.getType();
        mModel.get(url, new ICallBack() {
            @Override
            public void onSuccess(Object o) {
                iv.success(o);
            }

            @Override
            public void onFailed(Exception e) {
                iv.failed(e);
            }
        },type);
    }
    public void dele(){
        if(iv!=null){
            iv=null;
        }
    }
}
