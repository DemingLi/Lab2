package com.example.deminglee.lab2;


import android.content.DialogInterface;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView mImage=(ImageView) findViewById(R.id.sysu);
        mImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                //builder.setIcon(R.drawable.ic_launcher);
                builder.setTitle("上传头像");
                //    指定下拉列表的显示数据
                final String[] method = {"拍摄", "从相册选择"};
                //    设置一个下拉的列表选择项
                builder.setItems(method, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(MainActivity.this, "您选择了[" + method[which]+"]", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "您选择了[取消]", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

        final RadioGroup mRadioGroup=(RadioGroup) findViewById(R.id.radio);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedone=(RadioButton) findViewById(checkedId);
                Snackbar msnackbar1=Snackbar.make(findViewById(R.id.radio), "您选择了"+checkedone.getText().toString(), Snackbar.LENGTH_LONG);
                msnackbar1.setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Snackbar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                    }

                }).setActionTextColor(Color.BLUE).show();


            }
        });

        Button btn2=(Button) findViewById(R.id.register);
        final RadioGroup radioSelect=(RadioGroup) findViewById(R.id.radio);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedId=radioSelect.getCheckedRadioButtonId();
                RadioButton checkButton=(RadioButton) findViewById(checkedId);
                Snackbar msnackbar2=Snackbar.make(findViewById(R.id.register), checkButton.getText().toString()+"注册功能尚未启用", Snackbar.LENGTH_LONG);
                msnackbar2.setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Snackbar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                    }

                }).setActionTextColor(Color.BLUE).show();
            }
        });


        Button btn=(Button) findViewById(R.id.login);
        final TextInputLayout t1=(TextInputLayout) findViewById(R.id.number);
        final TextInputLayout t2=(TextInputLayout) findViewById(R.id.password);
        final EditText username= (EditText) findViewById(R.id.num);
        final EditText passowrd= (EditText) findViewById(R.id.pas);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(TextUtils.isEmpty(username.getText().toString())) {
                        t1.setError("学号不能为空");
                    }
                    else {
                        t1.setErrorEnabled(false);
                    }

                    if(TextUtils.isEmpty(passowrd.getText().toString())) {
                        if(TextUtils.isEmpty(username.getText().toString())) {
                            t2.setErrorEnabled(false);
                        }
                        else {
                            t2.setError("密码不能为空");
                        }
                    }
                    else {
                        t2.setErrorEnabled(false);
                    }

                if(username.getText().toString().equals("123456") && passowrd.getText().toString().equals("6666")) {
                    Snackbar msnackbar3=Snackbar.make(findViewById(R.id.login), "登录成功", Snackbar.LENGTH_LONG);
                    msnackbar3.setAction("确定", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "Snackbar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                        }

                    }).setActionTextColor(Color.BLUE).show();
                }
                else if(username.getText().toString().equals("") || passowrd.getText().toString().equals("")) {

                }
                else {
                    Snackbar msnackbar4=Snackbar.make(findViewById(R.id.login), "学号或密码错误", Snackbar.LENGTH_LONG);
                    msnackbar4.setAction("确定", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "Snackbar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                        }

                    }).setActionTextColor(Color.BLUE).show();
                }
            }
        });















    }
}

