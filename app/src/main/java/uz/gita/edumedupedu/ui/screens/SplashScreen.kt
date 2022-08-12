package uz.gita.edumedupedu.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import uz.gita.edumedupedu.R
import uz.gita.edumedupedu.viewModels.SplashViewModel
import uz.gita.edumedupedu.viewModels.impl.SplashViewModelImpl

class SplashScreen : Fragment(R.layout.screen_splash) {
    private val viewModel: SplashViewModel by viewModels<SplashViewModelImpl>()
    private val navController by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openCourseScreen.observe(this){
            navController.navigate(R.id.action_splashScreen_to_courseScreen)
        }
    }
}