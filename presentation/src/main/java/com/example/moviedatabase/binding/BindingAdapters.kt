package com.example.moviedatabase.binding

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener
import com.example.moviedatabase.R
import com.example.moviedatabase.widget.ExpandableTextView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

@BindingAdapter(value = ["imageUrl", "imageRequestListener"], requireAll = false)
fun ImageView.bindImage(url: String?, listener: RequestListener<Drawable?>?) {
    Glide.with(context)
        .load(url)
        .listener(listener)
        .placeholder(R.drawable.placeholder)
        .into(this)
}

@BindingAdapter("safeClick")
fun View.safeClick(listener: View.OnClickListener?) {
    val blockInMillis: Long = 500
    var lastClickTime: Long = 0
    this.setOnClickListener {
        if (SystemClock.elapsedRealtime() - lastClickTime < blockInMillis) {
            return@setOnClickListener
        }
        lastClickTime = SystemClock.elapsedRealtime()
        listener?.onClick(this)
    }
}

@BindingAdapter(value = ["list", "childLayout"], requireAll = false)
fun ChipGroup.setChipList(list: List<String>?, childLayoutId: Int?) {
    list?.forEach { item ->
        val chip: Chip? = if (childLayoutId == null) {
            Chip(context).apply { text = item }
        } else {
            val inflater = context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
            ) as? LayoutInflater
            inflater?.inflate(childLayoutId, this, false)
        } as? Chip
        chip?.let {
            it.text = item
            addView(it)
        }
    }
}

@BindingAdapter("isExpanding")
fun ExpandableTextView.isExpanding(isExpanding: Boolean?) {
    if (isExpanding == true) {
        expand()
    } else {
        collapse()
    }
}
