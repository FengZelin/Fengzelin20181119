package soexample.umeng.com.fengzelin20181119.ivew;

public interface IView<T> {
    void success(T t);
    void failed(Exception e);
}
