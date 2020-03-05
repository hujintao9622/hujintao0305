package com.bawei.hujintao;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bawei.hujintao.database.AdderssBeanDao;
import com.bawei.hujintao.database.DaoMaster;
import com.bawei.hujintao.database.DaoSession;

import org.greenrobot.greendao.database.Database;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_visible)
    TextView tvVisible;
    @BindView(R.id.bt_ok)
    Button btOk;
    @BindView(R.id.tv_s)
    TextView tvS;
    @BindView(R.id.tv_si)
    TextView tvSi;
    @BindView(R.id.tv_q)
    TextView tvQ;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.ll3)
    LinearLayout ll3;
    String address="";
    private AdderssBeanDao adderssBeanDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "app.db");
        Database writableDb = devOpenHelper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(writableDb);
        DaoSession daoSession = daoMaster.newSession();
        adderssBeanDao = daoSession.getAdderssBeanDao();

    }

    @OnClick({R.id.tv_visible, R.id.bt_ok, R.id.tv_s, R.id.tv_si, R.id.tv_q})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.tv_visible:
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll3.setVisibility(View.VISIBLE);
                break;
            case R.id.bt_ok:
                String[] s1 = tvAddress.getText().toString().split(" ");
                //存储到数据库
                adderssBeanDao.insert(new AdderssBean(null,s1[0],s1[1],s1[2]));
                Toast.makeText(this, "存储成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_s:
                String s = tvS.getText().toString();
                address=s+" ";
                tvAddress.setText(address);
                break;
            case R.id.tv_si:
                String s2 = tvSi.getText().toString();
                address+=s2+" ";
                tvAddress.setText(address);
                break;
            case R.id.tv_q:
                String s3 = tvQ.getText().toString();
                address+=s3;
                tvAddress.setText(address);
                break;
        }
    }
}
