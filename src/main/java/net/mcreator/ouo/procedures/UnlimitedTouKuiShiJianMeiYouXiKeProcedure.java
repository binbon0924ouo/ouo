package net.mcreator.ouo.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.ouo.item.FlyItem;
import net.mcreator.ouo.OuoModElements;
import net.mcreator.ouo.OuoMod;

import java.util.Map;

@OuoModElements.ModElement.Tag
public class UnlimitedTouKuiShiJianMeiYouXiKeProcedure extends OuoModElements.ModElement {
	public UnlimitedTouKuiShiJianMeiYouXiKeProcedure(OuoModElements instance) {
		super(instance, 6);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OuoMod.LOGGER.warn("Failed to load dependency entity for procedure UnlimitedTouKuiShiJianMeiYouXiKe!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).abilities.isFlying = ((entity instanceof PlayerEntity)
					? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(FlyItem.block, (int) (1)))
					: false);
			((PlayerEntity) entity).sendPlayerAbilities();
		}
	}
}
