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
import uz.gita.edumedupedu.data.room.entities.GroupEntity
import uz.gita.edumedupedu.viewModels.AddGroupViewModel
import uz.gita.edumedupedu.viewModels.impl.AddGroupViewModelImpl

class AddGroupScreen : Fragment(R.layout.screen_add_group) {
    private lateinit var ivBackToGroups: ImageView
    private lateinit var inputGroup: EditText
    private lateinit var inputMentor: EditText
    private lateinit var btnAddGroup: Button
    private val viewModel: AddGroupViewModel by viewModels<AddGroupViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.backGroupsLiveData.observe(this){
            findNavController().popBackStack()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init(view)
        btnAddGroup.setOnClickListener {
            val id = arguments?.getInt("IDFromGroup")!!
            val groupName = inputGroup.text.toString()
            val mentorName = inputMentor.text.toString()
            val group = GroupEntity(0, groupName, mentorName, id)
            viewModel.insert(group)
            viewModel.triggerBackGroups()
        }

        ivBackToGroups.setOnClickListener {
            viewModel.triggerBackGroups()
        }

    }

    private fun init(view: View) {
        view.apply {
            ivBackToGroups = findViewById(R.id.ivBackToHomeFromGroupAdd)
            inputGroup = findViewById(R.id.etAddGroup)
            inputMentor = findViewById(R.id.etAddMentor)
            btnAddGroup = findViewById(R.id.btnAddGroup)
        }
    }
}