package soexample.umeng.com.fengzelin20181119;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioGroup;

import soexample.umeng.com.fengzelin20181119.fragment.FragmentTwo;
import soexample.umeng.com.fengzelin20181119.fragment.Fragmentone;

public class HomeActivity extends FragmentActivity {
    private Fragmentone mFragmentone;
    private FragmentTwo mFragmentTwo;
    private RadioGroup radio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        radio=findViewById(R.id.radio);
        mFragmentone = new Fragmentone();
        mFragmentTwo = new FragmentTwo();
        final FragmentManager manager = getSupportFragmentManager();
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                FragmentTransaction beginTransaction = manager.beginTransaction();
                switch (i){
                    case R.id.radio_one:
                        beginTransaction.replace(R.id.frag_layout,mFragmentone);
                        break;
                    case R.id.radio_two:
                        beginTransaction.replace(R.id.frag_layout,mFragmentTwo);
                        break;
                }
                beginTransaction.commit();
            }
        });
    }
}
