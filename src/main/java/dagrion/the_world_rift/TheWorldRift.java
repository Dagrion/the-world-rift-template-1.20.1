package dagrion.the_world_rift;

import dagrion.the_world_rift.block.DungeonDoorKeyholeBlock;
import dagrion.the_world_rift.block.ModBlocks;
import dagrion.the_world_rift.effect.ModEffect;
import dagrion.the_world_rift.item.ModItemGroups;
import dagrion.the_world_rift.item.ModItems;
import dagrion.the_world_rift.item.custom.HalfMoon;
import dagrion.the_world_rift.item.custom.Hypernova;
import dagrion.the_world_rift.item.custom.TemporaryBlockBreaker;
import dagrion.the_world_rift.block.entity.ModBlockEntities;
import dagrion.the_world_rift.util.DungeonProtectionManager;
import dagrion.the_world_rift.util.HammerUsageEvent;
import dagrion.the_world_rift.world.ModFeatures;
import dagrion.the_world_rift.world.vegetation.tree.ModTrunkPlacer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheWorldRift implements ModInitializer {
	public static final String MOD_ID = "the_world_rift";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModBlockEntities.register();
		ModFeatures.register();
		ModEffect.registerEffects();
		ModTrunkPlacer.register();

		ServerTickEvents.START_SERVER_TICK.register(server ->
				server.getWorlds().forEach(DungeonProtectionManager::beginTick));

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) ->
				player.getAbilities().creativeMode || !DungeonProtectionManager.isProtected(world, pos));

		TemporaryBlockBreaker.registerTickEvent();
		DungeonDoorKeyholeBlock.registerTickEvent();

		CustomPortalBuilder.beginPortal()
				.frameBlock(ModBlocks.PORTAL_BLOCK)
				.lightWithItem(ModItems.BLOOD_VIAL)
				.setPortalSearchYRange(-64,320)
				.setReturnPortalSearchYRange(-64,320)
				.destDimID(new Identifier(TheWorldRift.MOD_ID, "the_scarlet_realm_behind_the_dark_veil_dimension"))
				.tintColor(0x000000)
				.registerPortal();


		ServerLivingEntityEvents.AFTER_DEATH.register((entity, source) -> {
			if (!(entity instanceof ServerPlayerEntity player)) return;
			// Loop through inventory
			for (int i = 0; i < player.getInventory().size(); i++) {
				ItemStack stack = player.getInventory().getStack(i);
				if (stack.getItem() instanceof HalfMoon || stack.getItem() instanceof Hypernova) {
					// Drop item manually
					player.dropItem(stack.copy(), true, false);
					// Remove from inventory
					player.getInventory().setStack(i, ItemStack.EMPTY);
				}
			}
		});


	}


}