package uz.gita.edumedupedu.ui.utils

import androidx.recyclerview.widget.DiffUtil
import uz.gita.edumedupedu.data.room.entities.CourseEntity

class CourseDiffUtil(
    private val oldList: List<CourseEntity>,
    private val newList: List<CourseEntity>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id && oldList[oldItemPosition].name == newList[newItemPosition].name

}