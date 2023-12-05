package com.techyourchance.coroutines.exercises.exercise1

import com.techyourchance.coroutines.common.ThreadInfoLogger
import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

class GetReputationEndpoint {

    companion object {
        private val DELAY = 3.seconds.inWholeMilliseconds
    }
    suspend fun getReputation(userId: String): Int {
        ThreadInfoLogger.logThreadInfo("GetReputationEndpoint#getReputation(): called")
        delay(DELAY)
        ThreadInfoLogger.logThreadInfo("GetReputationEndpoint#getReputation(): return data")
        return Random.nextInt(0, 100)
    }
}