package com.github.anotherjack.aspectkitdemo.ext

import android.content.Context
import android.widget.Toast

/**
 * Created by zhengjie on 2018/11/1.
 */

fun Context.toast(str :String){
    Toast.makeText(this,str,Toast.LENGTH_SHORT).show()
}