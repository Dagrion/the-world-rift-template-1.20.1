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

		ModLootTableModifiers.modifyLootTables();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}