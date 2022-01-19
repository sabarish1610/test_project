package com.example.test_project

import android.content.Intent
import com.ferring.flutterlibrary.EmptyActivity
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {

    private val BATTERY_CHANNEL = "com.example.libraryflutter/battery"
    private lateinit var channel: MethodChannel

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        channel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, BATTERY_CHANNEL)
        channel.setMethodCallHandler { call, result ->
            if (call.method == "native_screen") {
                startActivity(Intent(this, EmptyActivity::class.java))

            }
        }
    }
}
