package com.odtheking.odin.features.impl.render

import com.odtheking.odin.events.RenderEvent
import com.odtheking.odin.events.WorldEvent
import com.odtheking.odin.events.core.on
import com.odtheking.odin.utils.render.drawTexturedQuad
import com.odtheking.odin.utils.skyblock.dungeon.DungeonUtils
import net.minecraft.resources.Identifier
import net.minecraft.world.phys.Vec3
import java.time.Instant
import java.time.ZoneOffset

object Shenanigans {

    private data class Logos(
        val identifier: Identifier,
        val position: Vec3,
        val width: Float,
        val height: Float,
        val yaw: Float
    )

    private val logoList = listOf(

        Logos(Identifier.fromNamespaceAndPath("odin", "textures/job.png"), Vec3(54.5, 23.5, 40.0), 25f, 35f, 0f)
    )

    private var enabled = true

    init {
        on<RenderEvent.Extract> {
            if (!enabled) return@on
            if (!DungeonUtils.isFloor(7) || !DungeonUtils.inBoss) return@on

            logoList.forEach { (identifier, pos, width, height, yaw) ->
                drawTexturedQuad(identifier, pos, width, height, yaw)
            }
        }


        }
    }
}
