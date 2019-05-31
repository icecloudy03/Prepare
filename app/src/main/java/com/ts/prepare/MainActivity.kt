package com.ts.prepare

import android.graphics.drawable.BitmapDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import android.os.Handler
import android.view.View
import android.widget.Toast
import android.provider.MediaStore
import android.util.Log
import java.io.File


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
//        iv_1.setBackgroundResource(R.drawable.m7)
        Thread(Runnable {
//            val drawable = resources.getDrawable(R.drawable.m7)
//            val bitmap = (drawable as BitmapDrawable).bitmap
//            val bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri)

            BitmapFactory.decodeResource(resources,R.drawable.m7)
            val saveFile = File(externalCacheDir, "终极压缩.jpg")

            NativeUtil.compressBitmap(bitmap, saveFile.getAbsolutePath())

//            val path = Environment.getExternalStorageDirectory().absolutePath
            NativeUtil.compressBitmap(bitmap,saveFile.absolutePath)
            Log.w("tsss","complete")
        }).start()
//        iv_2.setOnClickListener(View.OnClickListener {
//            Toast.makeText(this,)
//        })
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
//    external fun stringFromJNI(): String
//
//    companion object {
//
//        // Used to load the 'native-lib' library on application startup.
//        init {
//            System.loadLibrary("native-lib")
//        }
//    }
}
