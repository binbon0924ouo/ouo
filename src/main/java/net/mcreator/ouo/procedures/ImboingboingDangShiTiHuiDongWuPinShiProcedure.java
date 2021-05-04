package net.mcreator.ouo.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.ouo.OuoModElements;
import net.mcreator.ouo.OuoMod;

import java.util.Map;

@OuoModElements.ModElement.Tag
public class ImboingboingDangShiTiHuiDongWuPinShiProcedure extends OuoModElements.ModElement {
	public ImboingboingDangShiTiHuiDongWuPinShiProcedure(OuoModElements instance) {
		super(instance, 14);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OuoMod.LOGGER.warn("Failed to load dependency entity for procedure ImboingboingDangShiTiHuiDongWuPinShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("i'm boingboing"), (false));
		}
	}
}
