
package net.mcreator.ouo.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.ouo.procedures.UnlimitedTouKuiShiJianMeiYouXiKeProcedure;
import net.mcreator.ouo.procedures.FlyDangWanJiaFangXiaWuPinShiProcedure;
import net.mcreator.ouo.itemgroup.ModItemGroup;
import net.mcreator.ouo.OuoModElements;

import java.util.Map;
import java.util.HashMap;

import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap;

@OuoModElements.ModElement.Tag
public class FlyItem extends OuoModElements.ModElement {
	@ObjectHolder("ouo:fly")
	public static final Item block = null;
	public FlyItem(OuoModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ModItemGroup.tab).maxStackSize(1).isImmuneToFire().rarity(Rarity.EPIC));
			setRegistryName("fly");
		}

		@Override
		public int getItemEnchantability() {
			return 30;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot) {
			if (slot == EquipmentSlotType.MAINHAND) {
				ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
				builder.putAll(super.getAttributeModifiers(slot));
				builder.put(Attributes.ATTACK_DAMAGE,
						new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Item modifier", (double) 8, AttributeModifier.Operation.ADDITION));
				builder.put(Attributes.ATTACK_SPEED,
						new AttributeModifier(ATTACK_SPEED_MODIFIER, "Item modifier", -2.4, AttributeModifier.Operation.ADDITION));
			}
			return super.getAttributeModifiers(slot);
		}

		@Override
		public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (selected) {
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				UnlimitedTouKuiShiJianMeiYouXiKeProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public boolean onDroppedByPlayer(ItemStack itemstack, PlayerEntity entity) {
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			World world = entity.world;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				FlyDangWanJiaFangXiaWuPinShiProcedure.executeProcedure($_dependencies);
			}
			return true;
		}
	}
}
