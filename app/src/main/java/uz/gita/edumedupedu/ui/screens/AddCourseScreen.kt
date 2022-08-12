package uz.gita.edumedupedu.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import uz.gita.edumedupedu.R
import uz.gita.edumedupedu.data.room.entities.CourseEntity
import uz.gita.edumedupedu.viewModels.AddCourseViewModel
import uz.gita.edumedupedu.viewModels.impl.AddCourseViewModelImpl

class AddCourseScreen : Fragment(R.layout.screen_add_course) {
    lateinit var ivBackToHome: ImageView
    lateinit var userInput: EditText
    lateinit var btnAdd: Button
    private val viewModel: AddCourseViewModel by viewModels<AddCourseViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init(view)
        btnAdd.setOnClickListener {
            val input = userInput.text.toString()
            if (input.isEmpty()) {
                Toast.makeText(requireContext(), "pls write course name", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.insert(input)
                viewModel.setBackToHome()
            }
        }

        ivBackToHome.setOnClickListener {
            viewModel.setBackToHome()
        }

        viewModel.backToHomeLiveData.observe(viewLifecycleOwner){
            findNavController().popBackStack()
        }

    }

    private fun init(view: View) {
        ivBackToHome = view.findViewById(R.id.ivBackToHomeFromCourseAdd)
        userInput = view.findViewById(R.id.etAddFromCourseAdd)
        btnAdd = view.findViewById(R.id.btnAddFromCourseAdd)
    }
}