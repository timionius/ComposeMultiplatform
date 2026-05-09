package io.timon.compose

import android.app.Application
import io.timon.android.pixelsampler.PixelSampler

class Application : Application() {
    init {
        PixelSampler.init()
    }
}
