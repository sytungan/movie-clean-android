package com.example.moviedatabase.data.model

import com.example.moviedatabase.data.base.EntityMapper
import com.example.moviedatabase.data.base.ModelEntity
import com.example.moviedatabase.domain.model.Crew
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class CrewEntity(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("credit_id")
    val creditId: String? = "",
    @SerializedName("department")
    val department: String? = "",
    @SerializedName("gender")
    val gender: Int? = 0,
    @SerializedName("job")
    val job: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("profile_path")
    val profilePath: String? = ""
) : ModelEntity()

class CrewEntityMapper @Inject constructor() : EntityMapper<Crew, CrewEntity> {
    override fun mapToDomain(entity: CrewEntity): Crew {
        return Crew(
            id = entity.id,
            creditId = entity.creditId,
            department = entity.department,
            gender = entity.gender,
            job = entity.job,
            name = entity.name,
            profilePath = entity.profilePath
        )
    }

    override fun mapToEntity(model: Crew): CrewEntity {
        return CrewEntity(
            id = model.id,
            creditId = model.creditId,
            department = model.department,
            gender = model.gender,
            job = model.job,
            name = model.name,
            profilePath = model.profilePath
        )
    }
}
