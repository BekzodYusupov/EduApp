package uz.gita.edumedupedu.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import uz.gita.edumedupedu.R
import uz.gita.edumedupedu.ui.adapters.GroupAdapter
import uz.gita.edumedupedu.viewModels.GroupViewModel
import uz.gita.edumedupedu.viewModels.impl.GroupViewModelImpl

class GroupScreen : Fragment(R.layout.screen_group) {
    private lateinit var ivBack:ImageView
    private lateinit var container: RecyclerView
    private lateinit var addGroup: FloatingActionButton
    private val adapter: GroupAdapter by lazy { GroupAdapter() }
    private val viewModel: GroupViewModel by viewModels<GroupViewModelImpl>()
    private val navController: NavController by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.backToCourseLiveData.observe(this) {
            navController.popBackStack()
        }
        viewModel.addLiveData.observe(this) {
            navController.navigate(
                R.id.action_groupScreen_to_addGroupScreen,
                bundleOf(Pair("IDFromGroup", it))
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init(view)
        val id = arguments?.getInt("ID")!!
        viewModel.getGroups(id)
        viewModel.groupsLivedata.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        addGroup.setOnClickListener {
            viewModel.triggerAdd(id)
        }
        ivBack.setOnClickListener {
            viewModel.triggerBackCourseLivedata()
        }
        adapter.setOnDeleteClickListener {
            viewModel.delete(it)
        }
    }

    private fun init(view: View) {
        view.apply {
            container = findViewById(R.id.groupContainer)
            addGroup = findViewById(R.id.fabAddGroup)
            container.adapter = adapter
            ivBack = findViewById(R.id.ivBackToCoursesFromGroups)
        }
    }
}