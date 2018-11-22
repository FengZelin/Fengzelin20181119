package soexample.umeng.com.fengzelin20181119.model;

import java.lang.reflect.Type;

import soexample.umeng.com.fengzelin20181119.inter.ICallBack;
import soexample.umeng.com.fengzelin20181119.utils.HttpUtils;

public class Model {
    public void get(String url, ICallBack callBack, Type type){
        HttpUtils.getInstance().get(url,callBack,type);
    }
}
