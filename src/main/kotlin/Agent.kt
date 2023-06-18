@file:Suppress("unused")

import java.lang.Thread.setDefaultUncaughtExceptionHandler
import java.lang.instrument.Instrumentation

internal object Agent {
    @JvmStatic
    fun premain(agentArgs: String?, instrumentation: Instrumentation) =
        setDefaultUncaughtExceptionHandler { _, t -> throw t }
}
