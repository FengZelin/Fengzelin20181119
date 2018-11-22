package soexample.umeng.com.fengzelin20181119;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView text_dian;
    private Button but_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        text_dian = findViewById(R.id.text_dian);
        but_login = findViewById(R.id.but_login);

        but_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_login:
                AnimatorSet set = new AnimatorSet();
                set.playTogether(
                        ObjectAnimator.ofFloat(text_dian,"rotationX",0,360),
                        ObjectAnimator.ofFloat(text_dian,"rotationY",0,180),
                        ObjectAnimator.ofFloat(text_dian,"rotation",0,-90),
                        ObjectAnimator.ofFloat(text_dian,"scaleX",1,3f),
                        ObjectAnimator.ofFloat(text_dian,"scaleY",1,3f),
                        ObjectAnimator.ofFloat(text_dian,"alpha",1,0.8f)
                );
                set.setDuration(2*1000).start();
                set.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        Intent it=new Intent(MainActivity.this,HomeActivity.class);
                        startActivity(it);
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
                break;
        }
    }
}
