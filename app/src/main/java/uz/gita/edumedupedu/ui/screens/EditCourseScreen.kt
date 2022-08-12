package uz.gita.edumedupedu.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import uz.gita.edumedupedu.R
import uz.gita.edumedupedu.data.room.entities.CourseEntity
import uz.gita.edumedupedu.viewModels.EditCourseViewModel
import uz.gita.edumedupedu.viewModels.impl.EditCourseViewModelImpl

class EditScreen : Fragment(R.layout.screen_edit) {
    private lateinit var btnBackToHome: ImageView
    private lateinit var input: EditText
    private lateinit var btnEdit: Button
    private val viewModel: EditCourseViewModel by viewModels<EditCourseViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.backToHomeLiveData.observe(this) {
            findNavController().popBackStack()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init(view)
        btnBackToHome.setOnClickListener { viewModel.setBackToHome() }
        btnEdit.setOnClickListener {
            val id = arguments?.getInt("ID")!!
            val newCourseName = input.text.toString()
            val course = CourseEntity(id, newCourseName)
            viewModel.update(course)
            viewModel.setBackToHome()
        }
    }

    private fun init(view: View) {
        btnBackToHome = view.findViewById(R.id.ivBackToHomeFromCourseEdit)
        input = view.findViewById(R.id.etAddFromCourseEdit)
        btnEdit = view.findViewById(R.id.btnAddFromCourseEdit)
    }
}