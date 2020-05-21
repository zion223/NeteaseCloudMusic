package com.imooc.lib_common_ui.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.imooc.lib_common_ui.R;
import com.lxj.xpopup.core.CenterPopupView;

//创建歌单
public class CreatePlayListDialog extends CenterPopupView implements View.OnClickListener{

    private EditText mEtName;
    private TextView mTvTextSize;
    private AppCompatButton mButtonCancel;
    private AppCompatButton mButtonConfirm;
    OnConfirmListener listener;

    public CreatePlayListDialog(@NonNull Context context, OnConfirmListener listener) {
        super(context);
        this.listener = listener;
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_create_sublist;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        mEtName = findViewById(R.id.et_create_playlist_name);
        mEtName.setFocusable(true);
        mTvTextSize = findViewById(R.id.tv_create_playlist_text_size);
        mButtonCancel = findViewById(R.id.tv_create_playlist_cancel);
        mButtonConfirm = findViewById(R.id.tv_create_playlist_confirm);
        mButtonCancel.setOnClickListener(this);
        mButtonConfirm.setOnClickListener(this);
        mButtonConfirm.setClickable(false);
        mButtonConfirm.setEnabled(false);
        mEtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if(editable.toString().length() > 0 && editable.toString().length() < 16){
                    mTvTextSize.setEnabled(true);
                    mButtonConfirm.setClickable(true);
                    mButtonConfirm.setEnabled(true);
                    mTvTextSize.setTextColor(getResources().getColor(R.color.color_333333));
                }else if(editable.toString().length() < 16 && editable.toString().length() != 0 ){
                    mButtonConfirm.setClickable(false);
                    mButtonConfirm.setEnabled(false);
                    mTvTextSize.setTextColor(getResources().getColor(R.color.colorAccent));
                }else if(editable.toString().length() == 0){
                    mTvTextSize.setTextColor(getResources().getColor(R.color.color_999999));
                    mTvTextSize.setEnabled(false);
                    mButtonConfirm.setClickable(false);
                    mButtonConfirm.setEnabled(false);
                }
                mTvTextSize.setText(editable.toString().length() + "/16");
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_create_playlist_cancel) {
            dismiss();
        }else if(view.getId() == R.id.tv_create_playlist_confirm){
            listener.onConfirm(mEtName.getText().toString());
            dismiss();
        }
    }

    public interface OnConfirmListener{
        void onConfirm(String name);
    }

}
