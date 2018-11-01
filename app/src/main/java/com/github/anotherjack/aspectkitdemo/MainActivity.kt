package com.github.anotherjack.aspectkitdemo

import android.Manifest
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.anotherjack.aspectkit.annotation.RequestPermissions
import com.github.anotherjack.aspectkitdemo.ext.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        take_photo.setOnClickListener{
            takePhoto()
        }
    }

    @RequestPermissions(Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE)
    private fun takePhoto(){
        toast("咔嚓！拍了一张照片！")
    }
}
