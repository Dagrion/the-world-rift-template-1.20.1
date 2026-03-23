package dagrion.the_world_rift.component.weapons;

import dagrion.the_world_rift.component.ModComponents;
import dev.onyxstudios.cca.api.v3.component.Component;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.CommonTickingComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public class WeaponChargeComponent implements Component, CommonTickingComponent, AutoSyncedComponent {
    public static final int MAX = 100;

    public final PlayerEntity player;
    public ItemStack stack;

    private int claymore = 0;
    private int scythe = 0;
    private int hammer = 0;
    private int dualblade = 0;
    private int halebard = 0;
    private int knife = 0;
    private int glaive = 0;

    public WeaponChargeComponent(PlayerEntity player) {
        this.player = player;
    }

    @Override
    public void tick() { }

    @Override
    public void readFromNbt(NbtCompound nbt) {
        claymore = nbt.getInt("claymore");
        scythe = nbt.getInt("scythe");
        hammer = nbt.getInt("hammer");
        dualblade = nbt.getInt("dualblade");
        halebard = nbt.getInt("halebard");
        knife = nbt.getInt("knife");
        glaive = nbt.getInt("glaive");
    }

    @Override
    public void writeToNbt(NbtCompound nbt) {
        nbt.putInt("claymore", claymore);
        nbt.putInt("scythe", scythe);
        nbt.putInt("hammer", hammer);
        nbt.putInt("dualblade", dualblade);
        nbt.putInt("halebard", halebard);
        nbt.putInt("knife", knife);
        nbt.putInt("glaive", glaive);
    }

    public void chargeAll() {
        claymore = MAX;
        scythe = MAX;
        hammer = MAX;
        dualblade = MAX;
        halebard = MAX;
        knife = MAX;
        glaive = MAX;
        sync();
    }

    private void sync() {
        ModComponents.CHARGE.sync(player);
    }

    public int getClaymore() { return claymore; }
    public int getScythe() { return scythe; }
    public int getHammer() { return hammer; }
    public int getDualblade() { return dualblade; }
    public int getHalebard() { return halebard; }
    public int getKnife() { return knife; }
    public int getGlaive() { return glaive; }

    public void useClaymore(int value) { claymore = Math.max(claymore - value, 0); sync(); }
    public void incrementClaymore(int value) { claymore = Math.min(claymore + value, MAX); sync(); }
    public void useScythe(int value) { scythe = Math.max(scythe - value, 0); sync(); }
    public void incrementScythe(int value) { scythe = Math.min(scythe + value, MAX); sync(); }
    public void useHammer(int value) { hammer = Math.max(hammer - value, 0); sync(); }
    public void incrementHammer(int value) { hammer = Math.min(hammer + value, MAX); sync(); }
    public void useDualblade(int value) { dualblade = Math.max(dualblade - value, 0); sync(); }
    public void incrementDualblade(int value) { dualblade = Math.min(dualblade + value, MAX); sync(); }
    public void useHalebard(int value) { halebard = Math.max(halebard - value, 0); sync(); }
    public void incrementHalebard(int value) { halebard = Math.min(halebard + value, MAX); sync(); }
    public void useKnife(int value) { knife = Math.max(knife - value, 0); sync(); }
    public void incrementKnife(int value) { knife = Math.min(knife + value, MAX); sync(); }
    public void useGlaive(int value) { glaive = Math.max(glaive - value, 0); sync(); }
    public void incrementGlaive(int value) { glaive = Math.min(glaive + value, MAX); sync(); }

    /** Gets the component for a player, or null if not a player. */
    public static WeaponChargeComponent get(PlayerEntity player) {
        return player != null ? ModComponents.CHARGE.get(player) : null;
    }

    /** Gets charge for HUD/item bar display (client-only, uses local player). */
    public static WeaponChargeComponent getForDisplay() {
        if (FabricLoader.getInstance().getEnvironmentType() != EnvType.CLIENT) return null;
        try {
            net.minecraft.client.MinecraftClient client = net.minecraft.client.MinecraftClient.getInstance();
            return client.player != null ? ModComponents.CHARGE.get(client.player) : null;
        } catch (NoClassDefFoundError e) {
            return null; // Dedicated server
        }
    }
}
