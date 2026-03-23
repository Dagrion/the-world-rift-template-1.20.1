package dagrion.the_world_rift.util;

import dagrion.the_world_rift.TheWorldRift;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_BLOODSTAINED_TOOL = createTag("needs_bloodstained_tool");
        public static final TagKey<Block> INCORRECT_FOR_BLOODSTAINED_TOOL = createTag("incorrect_for_bloodstained_tool");
        public static final TagKey<Block> DUNGEON_BLOCK = createTag("dungeon_block");
        public static final TagKey<Block> NEEDS_NETHERITE_TOOL = createTag("needs_netherite_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TheWorldRift.MOD_ID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TheWorldRift.MOD_ID, name));
        }
    }
}
