package uz.gita.edumedupedu.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.gita.edumedupedu.R
import uz.gita.edumedupedu.data.room.entities.CourseEntity

class CourseAdapter : RecyclerView.Adapter<CourseAdapter.VH>() {
    private val oldList: ArrayList<CourseEntity> = ArrayList()
    private var onItemClickListener: ((Int) -> Unit)? = null
    private var onEditClickListener: ((id: Int) -> Unit)? = null
    private var onCountListener: ((Unit) -> String)? = null

    fun submitList(newItems: List<CourseEntity>) {
        oldList.clear()
        oldList.addAll(newItems)
        notifyDataSetChanged()
    }

    fun setCountText(string: String  = "-1"):String {
        return string
    }


    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        private val name: TextView = view.findViewById(R.id.tvCourseName)
        private val count: TextView = view.findViewById(R.id.tvGroupCount)
        private val edit: ImageView = view.findViewById(R.id.ivEditCourse)

        fun bind() {
            val item = oldList[adapterPosition]
            name.text = item.name
            count.text = onCountListener?.invoke(Unit)
        }

        init {
            view.setOnClickListener {
                onItemClickListener?.invoke(oldList[adapterPosition].id)
            }

            edit.setOnClickListener {
                onEditClickListener?.invoke(oldList[adapterPosition].id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        VH(LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind()

    override fun getItemCount(): Int = oldList.size

    fun setOnItemClickListener(block: (Int) -> Unit) {
        onItemClickListener = block
    }

    fun setOnEditClickListener(block: (id: Int) -> Unit) {
        onEditClickListener = block
    }

    fun setCountListener(block: (Unit) -> String) {
        onCountListener = block
    }
}