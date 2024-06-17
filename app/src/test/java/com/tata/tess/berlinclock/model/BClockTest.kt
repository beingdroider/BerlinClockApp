package com.tata.tess.berlinclock.model

import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class BClockTest {

    @Test
    fun testBClockModelInitialization() {
        val bClockModel = BClock(
            secondsLight = true,
            fiveHoursLights = listOf(true, false, false, false),
            singleHoursLights = listOf(true, true, false, false),
            fiveMinutesLights = listOf(LightColor.YELLOW, LightColor.YELLOW, LightColor.RED, LightColor.YELLOW, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF),
            singleMinutesLights = listOf(true, false, false, false),
            currentTimeString = "07:21:00"
        )

        // Assert statements to verify init
        assertEquals(true, bClockModel.secondsLight)
        assertEquals(listOf(true, false, false, false), bClockModel.fiveHoursLights)
        assertEquals(listOf(true, true, false, false), bClockModel.singleHoursLights)
        assertEquals(listOf(LightColor.YELLOW, LightColor.YELLOW, LightColor.RED, LightColor.YELLOW, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF), bClockModel.fiveMinutesLights)
        assertEquals(listOf(true, false, false, false), bClockModel.singleMinutesLights)
        assertEquals("07:21:00", bClockModel.currentTimeString)
    }

    @Test
    fun testBClockModelValidationEmpty() {
        assertThrows(IllegalArgumentException::class.java) {
            BClock(
                secondsLight = true,
                fiveHoursLights = listOf(true, false, false, false),
                singleHoursLights = listOf(true, true, false, false),
                fiveMinutesLights = listOf(LightColor.YELLOW, LightColor.YELLOW, LightColor.RED, LightColor.YELLOW, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF),
                singleMinutesLights = listOf(true, false, false, false),
                currentTimeString = ""
            )
        }
    }

    @Test
    fun testBClockModelValidationBlank() {
        assertThrows(IllegalArgumentException::class.java) {
            BClock(
                secondsLight = true,
                fiveHoursLights = listOf(true, false, false, false),
                singleHoursLights = listOf(true, true, false, false),
                fiveMinutesLights = listOf(LightColor.YELLOW, LightColor.YELLOW, LightColor.RED, LightColor.YELLOW, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF),
                singleMinutesLights = listOf(true, false, false, false),
                currentTimeString = "  "
            )
        }
    }

    @Test
    fun testBClockModelValidationNull() {
        assertThrows(NullPointerException::class.java) {
            BClock(
                secondsLight = true,
                fiveHoursLights = listOf(true, false, false, false),
                singleHoursLights = listOf(true, true, false, false),
                fiveMinutesLights = listOf(LightColor.YELLOW, LightColor.YELLOW, LightColor.RED, LightColor.YELLOW, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF),
                singleMinutesLights = listOf(true, false, false, false),
                currentTimeString = null!!
            )
        }
    }

    @Test
    fun testBClockModel_FiveHoursInvalidListSize() {
        assertThrows(IllegalArgumentException::class.java) {
            BClock(
                secondsLight = true,
                fiveHoursLights = listOf(true, false, false, false,true, false),
                singleHoursLights = listOf(true, true, false, false),
                fiveMinutesLights = listOf(LightColor.YELLOW, LightColor.YELLOW, LightColor.RED, LightColor.YELLOW, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF),
                singleMinutesLights = listOf(true, false, false, false),
                currentTimeString = "07:21:00"
            )
        }

        assertThrows(IllegalArgumentException::class.java) {
            BClock(
                secondsLight = true,
                fiveHoursLights = listOf(),
                singleHoursLights = listOf(true, true, false, false),
                fiveMinutesLights = listOf(LightColor.YELLOW, LightColor.YELLOW, LightColor.RED, LightColor.YELLOW, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF),
                singleMinutesLights = listOf(true, false, false, false),
                currentTimeString = "07:21:00"
            )
        }
    }

    @Test
    fun testBClockModel_SingleHoursInvalidListSize() {
        assertThrows(IllegalArgumentException::class.java) {
            BClock(
                secondsLight = true,
                fiveHoursLights = listOf(true, false, false, false),
                singleHoursLights = listOf(true, true, false, false, false , false),
                fiveMinutesLights = listOf(LightColor.YELLOW, LightColor.YELLOW, LightColor.RED, LightColor.YELLOW, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF),
                singleMinutesLights = listOf(true, false, false, false),
                currentTimeString = "07:21:00"
            )
        }

        assertThrows(IllegalArgumentException::class.java) {
            BClock(
                secondsLight = true,
                fiveHoursLights = listOf(true, false, false, false),
                singleHoursLights = listOf(false),
                fiveMinutesLights = listOf(LightColor.YELLOW, LightColor.YELLOW, LightColor.RED, LightColor.YELLOW, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF),
                singleMinutesLights = listOf(true, false, false, false),
                currentTimeString = "07:21:00"
            )
        }
    }

    @Test
    fun testBClockModel_FiveMinutesInvalidListSize() {
        assertThrows(IllegalArgumentException::class.java) {
            BClock(
                secondsLight = true,
                fiveHoursLights = listOf(true, false, false, false),
                singleHoursLights = listOf(true, true, false, false),
                fiveMinutesLights = listOf(LightColor.RED),
                singleMinutesLights = listOf(true, false, false, false),
                currentTimeString = "07:21:00"
            )
        }

        assertThrows(IllegalArgumentException::class.java) {
            BClock(
                secondsLight = true,
                fiveHoursLights = listOf(true, false, false, false),
                singleHoursLights = listOf(false),
                fiveMinutesLights = listOf(LightColor.RED, LightColor.YELLOW, LightColor.OFF, LightColor.RED),
                singleMinutesLights = listOf(true, false, false, false),
                currentTimeString = "07:21:00"
            )
        }
    }


    @Test
    fun testBClockModel_SingleMinutesInvalidListSize() {
        assertThrows(IllegalArgumentException::class.java) {
            BClock(
                secondsLight = true,
                fiveHoursLights = listOf(true, false, false, false),
                singleHoursLights = listOf(true, true, false, false),
                fiveMinutesLights = listOf(LightColor.YELLOW, LightColor.YELLOW, LightColor.RED, LightColor.YELLOW, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF),
                singleMinutesLights = listOf(true, false, false, true, true, false),
                currentTimeString = "07:21:00"
            )
        }

        assertThrows(IllegalArgumentException::class.java) {
            BClock(
                secondsLight = true,
                fiveHoursLights = listOf(true, false, false, false),
                singleHoursLights = listOf(false),
                fiveMinutesLights = listOf(LightColor.YELLOW, LightColor.YELLOW, LightColor.RED, LightColor.YELLOW, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF, LightColor.OFF),
                singleMinutesLights = emptyList(),
                currentTimeString = "07:21:00"
            )
        }
    }
}