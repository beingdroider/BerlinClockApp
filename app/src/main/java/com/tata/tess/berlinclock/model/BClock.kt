package com.tata.tess.berlinclock.model

data class BClock (
    val secondsLight: Boolean,
    val fiveHoursLights: List<Boolean>,
    val singleHoursLights: List<Boolean>,
    val fiveMinutesLights: List<LightColor>,
    val singleMinutesLights: List<Boolean>,
    val currentTimeString: String
) {
    init {
        require(currentTimeString.isNotEmpty()) { "currentTime cannot be Empty" }
        require(currentTimeString.isNotBlank()) { "currentTime cannot be Blank" }
        require(fiveHoursLights.size == 4 ) {"Five hours row can have only 4 lights"}
        require(singleHoursLights.size == 4 ) {"Single hours row can have only 4 lights"}
        require(fiveMinutesLights.size == 11 ) {"Five Minutes row can have only 11 lights"}
        require(singleMinutesLights.size == 4 ) {"Five Minutes row can have only 4"}
    }
}

enum class LightColor {
    RED, YELLOW, OFF
}