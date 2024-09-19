package edu.temple.inclassuiacvitivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class TextSizeAdapter(
    private val context: Context,
    textSizes1: Int,
    private val textSizes: Array<Int>
): BaseAdapter() {


    override fun getCount(): Int {
        return textSizes.size
    }

    override fun getItem(position: Int): Any {
        return textSizes[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            // Inflate layout for each item
            view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        // Set the text size for the item
        val textSize = textSizes[position]
        viewHolder.textView.text = "$textSize pt"
        viewHolder.textView.textSize = textSize.toFloat()

        return view
    }

    // ViewHolder pattern for efficient view recycling
    private class ViewHolder(view: View) {
        val textView: TextView = view.findViewById(android.R.id.text1)
    }

}