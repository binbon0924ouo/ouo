package net.mcreator.ouo.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.ouo.item.ConversionswordItem;
import net.mcreator.ouo.item.ConversionbowItem;
import net.mcreator.ouo.OuoModElements;
import net.mcreator.ouo.OuoMod;

import java.util.Map;

@OuoModElements.ModElement.Tag
public class Conversion2AnXiaAnJianShiProcedure extends OuoModElements.ModElement {
	public Conversion2AnXiaAnJianShiProcedure(OuoModElements instance) {
		super(instance, 20);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OuoMod.LOGGER.warn("Failed to load dependency entity for procedure Conversion2AnXiaAnJianShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		while (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(ConversionswordItem.block, (int) (1)))
				: false)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(ConversionswordItem.block, (int) (1));
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(ConversionbowItem.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
