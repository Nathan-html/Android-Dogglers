/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.data.DataSource
import com.example.dogglers.model.Dog

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    companion object {
        const val TAG = "Nathan-html"
        const val VERTICAL = 1
        const val HORIZONTAL = 2
        // const val GRID = 3
    }

    private val data : List<Dog> = DataSource.dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val dog_image : ImageView = view!!.findViewById(R.id.image)
        val dog_name : TextView = view!!.findViewById(R.id.name)
        val dog_age : TextView = view!!.findViewById(R.id.age)
        val dog_hobbies : TextView = view!!.findViewById(R.id.hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        Log.d(TAG, "parent $parent")
        if (layout == VERTICAL || layout == HORIZONTAL) {
            val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.vertical_horizontal_list_item, parent, false)
            return DogCardViewHolder(adapterLayout)
        } else {
            val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.grid_list_item, parent, false)
            return DogCardViewHolder(adapterLayout)
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val current : Dog = data[position]
        Log.d(TAG, "current $current")
        holder.itemView.rootView
        holder.dog_image.setImageResource(current.imageResourceId)
        holder.dog_name.text = current.name
        holder.dog_age.text = current.age
        holder.dog_hobbies.text = current.hobbies
//        val resources = context?.resources
//        holder.dog_age.text = resources?.getString(R.string.dog_age, current.age)
//        holder.dog_hobbies.text = resources?.getString(R.string.dog_hobbies, current.hobbies)
    }
}
