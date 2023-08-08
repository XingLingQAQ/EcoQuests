package com.willfp.ecoquests.libreforge

import com.willfp.eco.core.config.interfaces.Config
import com.willfp.ecoquests.quests.Quests
import com.willfp.libreforge.NoCompileData
import com.willfp.libreforge.arguments
import com.willfp.libreforge.conditions.Condition
import org.bukkit.entity.Player

object ConditionHasCompletedQuest : Condition<NoCompileData>("has_completed_quest") {
    override val arguments = arguments {
        require("quest", "You must specify the quest ID!")
    }

    override fun isMet(player: Player, config: Config, compileData: NoCompileData): Boolean {
        val quest = Quests[config.getString("quest")] ?: return false

        return quest.hasCompleted(player)
    }
}