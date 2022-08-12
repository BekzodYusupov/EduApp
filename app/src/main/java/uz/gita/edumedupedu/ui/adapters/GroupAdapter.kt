package uz.gita.edumedupedu.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.gita.edumedupedu.R
import uz.gita.edumedupedu.data.room.entities.GroupEntity

class GroupAdapter : RecyclerView.Adapter<GroupAdapter.VH>() {
    private val oldList: ArrayList<GroupEntity> = ArrayList()
    private var onDeleteClickListener:((GroupEntity)->Unit)? = null
    private var onEditClickListener:((GroupEntity)->Unit)? = null

    fun submitList(newList: List<GroupEntity>) {
        oldList.clear()
        oldList.addAll(newList)
        notifyDataSetChanged()
    }


    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        private val name: TextView = view.findViewById(R.id.tvGroupName)
        private val mentor: TextView = view.findViewById(R.id.tvMentorName)
        private val delete: ImageView = view.findViewById(R.id.ivDeleteGroup)
        private val edit: ImageView = view.findViewById(R.id.ivEditGroup)

        fun bind() {
            val item = oldList[adapterPosition]
            name.text = item.name
            mentor.text = item.mentor
        }

        init {
            delete.setOnClickListener {
                onDeleteClickListener?.invoke(oldList[adapterPosition])
            }
            edit.setOnClickListener {
                onEditClickListener?.invoke(oldList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        VH(LayoutInflater.from(parent.context).inflate(R.layout.item_group,parent,false))

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind()

    override fun getItemCount(): Int = oldList.size

    fun setOnDeleteClickListener(block: (GroupEntity) -> Unit) {
        onDeleteClickListener = block
    }

    fun setOnEditClickListener(block: (GroupEntity) -> Unit) {
        onEditClickListener = block
    }
}