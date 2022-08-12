package uz.gita.edumedupedu.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import uz.gita.edumedupedu.R
import uz.gita.edumedupedu.ui.adapters.CourseAdapter
import uz.gita.edumedupedu.viewModels.CourseViewModel
import uz.gita.edumedupedu.viewModels.impl.CourseViewModelImpl

class CourseScreen : Fragment(R.layout.screen_course) {
    lateinit var countCourse:TextView
    private lateinit var container: RecyclerView
    private lateinit var fabAddCourse: FloatingActionButton
    private val adapter by lazy { CourseAdapter() }
    private val viewModel: CourseViewModel by viewModels<CourseViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.addCourseLiveData.observe(this) {
            findNavController().navigate(R.id.action_courseScreen_to_addScreen)
        }

        viewModel.updateLivedata.observe(this) {
            val id = Bundle()
            id.putInt("ID", it)
            findNavController().navigate(R.id.action_courseScreen_to_editScreen, id)
        }

        viewModel.openGroupLiveData.observe(this) {
            val id = Bundle()
            id.putInt("ID", it)
            findNavController().navigate(R.id.action_courseScreen_to_groupScreen, id)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init(view)
        var holder = -1
        //viewModel.getGroupCount(1)
//        viewModel.groupCountLiveData.observe(viewLifecycleOwner) {
//            holder = it
//        }
//        adapter.setCountListener {
//            "${holder++}"
//        }


        adapter.setOnEditClickListener {
            Toast.makeText(requireContext(), "$id", Toast.LENGTH_SHORT).show()
            viewModel.update(it)

        }

        viewModel.coursesLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)

            it.map { course ->
                viewModel.getGroupCount(course.id)
//                adapter.setCountListener { "${course.id}" }
                countCourse.text = "Courses N 😇${course.id}"
            }
        }



        fabAddCourse.setOnClickListener {
            viewModel.setAddCourseLiveData()
        }

        adapter.setOnItemClickListener {
            viewModel.triggerOpenGroupLiveData(it)
        }
    }

    private fun init(view: View) {
        container = view.findViewById(R.id.courseContainer)
        container.adapter = adapter
        fabAddCourse = view.findViewById(R.id.fabAddCourse)
        countCourse = view.findViewById(R.id.countCourse)
    }
}