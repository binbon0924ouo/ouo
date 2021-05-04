
package net.mcreator.ouo.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;

import net.mcreator.ouo.procedures.ImboingboingDangShiTiHuiDongWuPinShiProcedure;
import net.mcreator.ouo.itemgroup.ModItemGroup;
import net.mcreator.ouo.OuoModElements;

import java.util.Map;
import java.util.HashMap;

@OuoModElements.ModElement.Tag
public class ImboingboingItem extends OuoModElements.ModElement {
	@ObjectHolder("ouo:imboingboing")
	public static final Item block = null;
	public ImboingboingItem(OuoModElements instance) {
		super(instance, 14);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 99999;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 99997f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.IRON_INGOT, (int) (1)));
			}
		}, 3, 95f, new Item.Properties().group(ModItemGroup.tab).isImmuneToFire()) {
			@Override
			public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
				boolean retval = super.onEntitySwing(itemstack, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ImboingboingDangShiTiHuiDongWuPinShiProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("imboingboing"));
	}
}
