package dagrion.the_world_rift;

import dagrion.the_world_rift.block.ModBlocks;
import dagrion.the_world_rift.effect.ModEffect;
import dagrion.the_world_rift.item.ModItemGroups;
import dagrion.the_world_rift.item.ModItems;
import dagrion.the_world_rift.util.HammerUsageEvent;
import dagrion.the_world_rift.util.ModLootTableModifiers;
import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheWorldRift implements ModInitializer {
	public static final String MOD_ID = "the_world_rift";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Logger clientLogger = LogUtils.getLogger();

	@Override
	public void onInitialize() {
		ModItemGroups.registerModItems();
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();

		ModEffect.registerEffects();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		CustomPortalBuilder.beginPortal()
				.frameBlock(ModBlocks.PORTAL_BLOCK)
				.lightWithItem(ModItems.BLOOD_VIAL)
				.setPortalSearchYRange(-64,320)
				.setReturnPortalSearchYRange(-64,320)
				.destDimID(new Identifier(TheWorldRift.MOD_ID, "the_scarlet_realm_behind_the_dark_veil_dimension"))
				.tintColor(0x000000)
				.registerPortal();
	}
}