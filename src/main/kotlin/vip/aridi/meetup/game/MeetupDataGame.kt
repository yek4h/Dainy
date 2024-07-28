package vip.aridi.meetup.game

import vip.aridi.meetup.util.CC


/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 26/07/2024
*/

class MeetupDataGame {

    var remainingPlayers: Int = 0
    var initialPlayers: Int = 0
    var borderSize: Int = 100

    var gameTime: Int = 0
    var countdownTime: Int = 15
    var votingDuration: Int = 45
    var endDuration: Int = 10
    var borderDuration: Int = 60
    var elapsedTime: Long = 0L
    var startTime: Long = -1L

    var countdownActive: Boolean = false
    var announcementEnabled: Boolean = false
    var worldGenerated: Boolean = false

    var gameWinner: String? = null
    var activeScenario: String = "None"
    var loadingMessage: String = ""

    var currentState: MeetupState = MeetupState.WAITING

    fun getNextBorderSize(): Int {
        return when (borderSize) {
            100 -> 75
            75 -> 50
            50 -> 25
            else -> 100
        }
    }

    fun getStatus(): String {
        return when (currentState) {
            MeetupState.IN_GAME -> MeetupState.IN_GAME.formatted()
            MeetupState.STARTING_GAME -> MeetupState.STARTING_GAME.formatted()
            MeetupState.WAITING -> MeetupState.WAITING.formatted()
            MeetupState.GAME_ENDED -> MeetupState.GAME_ENDED.formatted()
            else -> "&cSetup"
        }
    }

    fun getFormattedBorderStatus(): String {
        return if (borderDuration > 0) {
            CC.translate("&7 (" + if (borderDuration <= 60) "$borderDuration s" else "${borderDuration / 60 + 1} m" + ")")
        } else {
            ""
        }
    }

    fun decreaseBorderTime(): Int {
        borderDuration -= 1
        return borderDuration
    }

    fun getElapsedTime(): Int {
        return ((System.currentTimeMillis() - startTime) / 1000).toInt()
    }

    fun decreaseEndTime(): Int {
        endDuration -= 1
        return endDuration
    }
}