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
}