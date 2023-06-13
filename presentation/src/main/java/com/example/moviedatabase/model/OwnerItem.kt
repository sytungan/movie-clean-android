package com.example.moviedatabase.model

import android.os.Parcelable
import com.example.moviedatabase.base.ItemMapper
import com.example.moviedatabase.base.ModelItem
import com.example.moviedatabase.domain.model.Owner
import kotlinx.android.parcel.Parcelize
import javax.inject.Inject

@Parcelize
data class OwnerItem(val id: Int, val login: String?, val avatar: String?) : ModelItem(), Parcelable

class OwnerItemMapper @Inject constructor() : ItemMapper<Owner, OwnerItem> {
    override fun mapToPresentation(model: Owner) = OwnerItem(
        model.id, model.login, model.avatar
    )

    override fun mapToDomain(modelItem: OwnerItem) = Owner(
        modelItem.id, modelItem.login, modelItem.avatar
    )
}