package com.mukeshsolanki.dynamicappicons

import android.app.Activity
import android.content.ComponentName
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.mukeshsolanki.dynamicappicons.ui.theme.DynamicAppIconsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DynamicAppIconsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Button(onClick = {
                            setIcon(enable = "MainActivity", disable = "MainActivityAlias")
                        }) {
                            Text(text = "Enable Default Icon")
                        }
                        Button(onClick = {
                            setIcon(enable = "MainActivityAlias", disable = "MainActivity")
                        }) {
                            Text(text = "Enable Holiday Icon")
                        }
                    }
                }
            }
        }
    }
}

fun Activity.setIcon(enable: String, disable: String) {
    packageManager.setComponentEnabledSetting(
        ComponentName(this, "$packageName.$enable"),
        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
        PackageManager.DONT_KILL_APP
    )
    packageManager.setComponentEnabledSetting(
        ComponentName(this, "$packageName.$disable"),
        PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
        PackageManager.DONT_KILL_APP
    )
}