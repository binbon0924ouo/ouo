
package net.mcreator.ouo.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.ouo.itemgroup.ModItemGroup;
import net.mcreator.ouo.OuoModElements;

@OuoModElements.ModElement.Tag
public class ConversionswordItem extends OuoModElements.ModElement {
	@ObjectHolder("ouo:conversionsword")
	public static final Item block = null;
	public ConversionswordItem(OuoModElements instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2000;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 14f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.DIAMOND, (int) (1)));
			}
		}, 1, 56f, new Item.Properties().group(ModItemGroup.tab).isImmuneToFire()) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("conversionsword"));
	}
}
