package net.mcreator.ouo.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.ouo.item.JiTuiItem;
import net.mcreator.ouo.OuoModElements;
import net.mcreator.ouo.OuoMod;

import java.util.Map;

@OuoModElements.ModElement.Tag
public class JiTuiDangZiDanJiZhongShiTiShiProcedure extends OuoModElements.ModElement {
	public JiTuiDangZiDanJiZhongShiTiShiProcedure(OuoModElements instance) {
		super(instance, 26);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OuoMod.LOGGER.warn("Failed to load dependency entity for procedure JiTuiDangZiDanJiZhongShiTiShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(JiTuiItem.block, (int) (1));
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
	}
}
