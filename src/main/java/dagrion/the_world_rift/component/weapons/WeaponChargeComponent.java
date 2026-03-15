package dagrion.the_world_rift.component.weapons;
import dev.onyxstudios.cca.api.v3.component.Component;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.CommonTickingComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public class WeaponChargeComponent implements Component, CommonTickingComponent, AutoSyncedComponent {
    public final PlayerEntity player;
    public ItemStack stack;
    public WeaponChargeComponent(PlayerEntity player) {
        this.player = player;
    }

    public static int CLAYMORE = 0;
        public static int MAX_CLAYMORE = 100;
    public static int SCYTHE = 0;
        public static int MAX_SCYTHE = 100;
    public static int HAMMER = 0;
        public static int MAX_HAMMER = 100;
    public static int DUALBLADE = 0;
        public static int MAX_DUALBLADE = 100;
    public static int HALEBARD = 0;
        public static int MAX_HALEBARD = 100;
    public static int KNIFE = 0;
        public static int MAX_KNIFE = 100;
    public static int GLAIVE = 0;
        public static int MAX_GLAIVE = 100;

    @Override
    public void tick() { }

    @Override
    public void readFromNbt(NbtCompound nbtCompound) {
        CLAYMORE = nbtCompound.getInt("claymore");
        SCYTHE = nbtCompound.getInt("scythe");
        HAMMER = nbtCompound.getInt("hammer");
        DUALBLADE = nbtCompound.getInt("dualblade");
        HALEBARD = nbtCompound.getInt("halebard");
        KNIFE = nbtCompound.getInt("knife");
        GLAIVE = nbtCompound.getInt("glaive");
    }

    @Override
    public void writeToNbt(NbtCompound nbtCompound) {
        nbtCompound.putInt("claymore", CLAYMORE);
        nbtCompound.putInt("scythe", SCYTHE);
        nbtCompound.putInt("hammer", HAMMER);
        nbtCompound.putInt("dualblade", DUALBLADE);
        nbtCompound.putInt("halebard", HALEBARD);
        nbtCompound.putInt("knife", KNIFE);
        nbtCompound.putInt("glaive", GLAIVE);
    }

    public static void ChargeAll() {
        CLAYMORE = MAX_CLAYMORE;
        SCYTHE = MAX_SCYTHE;
        HAMMER = MAX_HAMMER;
        DUALBLADE = MAX_DUALBLADE;
        HALEBARD = MAX_HALEBARD;
        KNIFE = MAX_KNIFE;
        GLAIVE = MAX_GLAIVE;
    }
    public static void UseClaymore(int value){ CLAYMORE = Math.max(CLAYMORE - value, 0 ); }
    public static void IncrementClaymore(int value){ CLAYMORE = Math.min(CLAYMORE + value, MAX_CLAYMORE); }
    public static void UseSCYTHE(int value){ SCYTHE = Math.max(SCYTHE - value, 0 ); }
    public static void IncrementSCYTHE(int value){ SCYTHE = Math.min(SCYTHE + value, MAX_SCYTHE); }
    public static void UseHAMMER(int value){ HAMMER = Math.max(HAMMER - value, 0 ); }
    public static void IncrementHAMMER(int value){ HAMMER = Math.min(HAMMER + value, MAX_HAMMER); }
    public static void UseDUALBLADE(int value){ DUALBLADE = Math.max(DUALBLADE - value, 0 ); }
    public static void IncrementDUALBLADE(int value){ DUALBLADE = Math.min(DUALBLADE + value, MAX_DUALBLADE); }
    public static void UseHALEBARD(int value){ HALEBARD = Math.max(HALEBARD - value, 0 ); }
    public static void IncrementHALEBARD(int value){ HALEBARD = Math.min(HALEBARD + value, MAX_HALEBARD); }
    public static void UseKNIFE(int value){ KNIFE = Math.max(KNIFE - value, 0 ); }
    public static void IncrementKNIFE(int value){ KNIFE = Math.min(KNIFE + value, MAX_KNIFE); }
    public static void UseGLAIVE(int value){ GLAIVE = Math.max(GLAIVE - value, 0 ); }
    public static void IncrementGLAIVE(int value){ GLAIVE = Math.min(GLAIVE + value, MAX_GLAIVE); }

}