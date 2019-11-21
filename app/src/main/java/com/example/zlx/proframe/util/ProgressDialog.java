package com.example.zlx.proframe.util;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.zlx.proframe.R;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;


/**
 * @author azheng
 * @date 2018/5/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：圆形进度条Dialog
 */
public class ProgressDialog {

    private static volatile ProgressDialog instance;

    private ProgressDialog() {
    }

    public static ProgressDialog getInstance() {
        if (instance == null) {
            synchronized (ProgressDialog.class) {
                if (instance == null) {
                    instance = new ProgressDialog();
                }
            }
        }
        return instance;
    }

    private QMUITipDialog materialDialog;

    public void show(Context mContext) {
        materialDialog = new QMUITipDialog.Builder(mContext)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord("正在加载")
                .create();
        materialDialog.show();

    }

    public void dismiss() {
        materialDialog.dismiss();
    }
}
