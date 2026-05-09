package io.timon.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.timon.android.pixelsampler.PixelSampler

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        PixelSampler.start(this)
        setContent {
            App()
        }
    }

    override fun onDestroy() {
        PixelSampler.stop()
        super.onDestroy()
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        PixelSampler.onActivityResult(requestCode, resultCode, data)
    }
}

@Preview
@Composable
private fun AppAndroidPreview() {
    App()
}
