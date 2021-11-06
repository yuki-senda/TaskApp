package jp.techacademy.senda.yuki.taskapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class TaskAdapter(context: Context): BaseAdapter() {
    private val mLayoutInflater: LayoutInflater
    var mTaskList= mutableListOf<Task>()

    init {
        this.mLayoutInflater = LayoutInflater.from(context)
    }

    //アイテム（データ）の数を返す
    override fun getCount(): Int {
        return mTaskList.size
    }

    //アイテム（データ）を返す
    override fun getItem(position: Int): Any {
        return mTaskList[position]
    }

    //アイテム（データ）のIDを返す
    override fun getItemId(position: Int): Long {
        return 0
    }

    //Viewを返す
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: mLayoutInflater.inflate(android.R.layout.simple_list_item_2, null)

        val textView1 = view.findViewById<TextView>(android.R.id.text1)
        val textView2 = view.findViewById<TextView>(android.R.id.text2)

        textView1.text = mTaskList[position].category + " ： " + mTaskList[position].title

        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.JAPANESE)
        val date = mTaskList[position].date
        textView2.text = simpleDateFormat.format(date)

        return view
    }
}