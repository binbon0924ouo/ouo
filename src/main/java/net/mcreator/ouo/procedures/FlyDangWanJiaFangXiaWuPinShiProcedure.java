package net.mcreator.ouo.procedures;

import net.minecraft.world.GameType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.ouo.OuoModElements;
import net.mcreator.ouo.OuoMod;

import java.util.Map;

@OuoModElements.ModElement.Tag
public class FlyDangWanJiaFangXiaWuPinShiProcedure extends OuoModElements.ModElement {
	public FlyDangWanJiaFangXiaWuPinShiProcedure(OuoModElements instance) {
		super(instance, 10);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OuoMod.LOGGER.warn("Failed to load dependency entity for procedure FlyDangWanJiaFangXiaWuPinShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).abilities.isFlying = (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
					}
					return false;
				}
			}.checkGamemode(entity));
			((PlayerEntity) entity).sendPlayerAbilities();
		}
	}
}
