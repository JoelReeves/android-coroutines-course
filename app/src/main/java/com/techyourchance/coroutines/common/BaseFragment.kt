package com.techyourchance.coroutines.common

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.techyourchance.coroutines.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

abstract class BaseFragment : Fragment() {

    protected open val screenTitle = ""

    protected val compositionRoot get() = (requireActivity() as MainActivity).compositionRoot

    protected lateinit var screensNavigator: ScreensNavigator

    private val defaultDispatcher = Dispatchers.Default
    protected val mainScope = CoroutineScope(Dispatchers.Main.immediate)
    protected val defaultScope = CoroutineScope(mainScope.coroutineContext + defaultDispatcher)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        screensNavigator = compositionRoot.screensNavigator
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val toolbarManipulator = compositionRoot.toolbarManipulator
        toolbarManipulator.setScreenTitle(screenTitle)
        if (screensNavigator.isRootScreen()) {
            toolbarManipulator.hideUpButton()
        } else {
            toolbarManipulator.showUpButton()
        }
    }


}