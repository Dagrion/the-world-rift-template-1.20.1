package dagrion.the_world_rift.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import dagrion.the_world_rift.component.weapons.WeaponChargeComponent;
import dagrion.the_world_rift.effect.ModEffect;
import dagrion.the_world_rift.item.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.List;
import java.util.UUID;

public class GlaiveItem extends SwordItem {
    protected static final UUID ATTACK_REACH_MODIFIER_ID = UUID.fromString("66dbd500-02d6-46a9-b510-699af6ac0936");
    protected static final UUID REACH_MODIFIER_ID = UUID.fromString("e7509cce-5ee6-4bb2-97e7-39a01aa58913");
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    final double RANGE = 9;
    final float BASE_DAMAGE = 14;
    double boost = 2;

    public GlaiveItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
            builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", toolMaterial.getAttackDamage() + attackDamage + 0, EntityAttributeModifier.Operation.ADDITION));
            builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
            builder.put(ReachEntityAttributes.ATTACK_RANGE, new EntityAttributeModifier(ATTACK_REACH_MODIFIER_ID, "Weapon modifier", 1.5, EntityAttributeModifier.Operation.ADDITION));
            builder.put(ReachEntityAttributes.REACH, new EntityAttributeModifier(REACH_MODIFIER_ID, "Weapon modifier", 2.0, EntityAttributeModifier.Operation.ADDITION));
            this.attributeModifiers = builder.build();
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (Math.random() < 0.15 && attacker.getMainHandStack().getItem() == ModItems.BLOODSTAINED_GLAIVE) {
            target.addStatusEffect(new StatusEffectInstance(ModEffect.BLOODLOSS,20 * 5,0)); }
        if (attacker instanceof PlayerEntity p) {
            WeaponChargeComponent charge = WeaponChargeComponent.get(p);
            if (charge != null) charge.incrementGlaive(2);
        }
        return true;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Vec3d origin = user.getEyePos();
        Vec3d look = user.getRotationVector().normalize();
        Vec3d end = origin.add(look.multiply(RANGE));
        if (!world.isClient) {
            Vec3d lookingDirection = user.getRotationVec(1.0f);
                if (!(world instanceof ServerWorld serverWorld)) {
                    return super.use(world, user, hand);
                }
                WeaponChargeComponent charge = WeaponChargeComponent.get(user);
                if (charge != null && charge.getGlaive() >= WeaponChargeComponent.MAX) {
                    charge.useGlaive(100);
                    user.setVelocity(
                            lookingDirection.x * boost,
                            lookingDirection.y * boost * 0.6,
                            lookingDirection.z * boost
                    );

                    user.velocityModified = true;
                    user.setSwimming(false);

                    var hit = world.raycast(new RaycastContext(origin, end, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, user));

                    serverWorld.playSound(null, user.getX(), user.getY(), user.getZ(),
                            SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 3.0f, 1.0f);
                    int particleCount = (int) (RANGE * 2.5);
                    for (int i = 0; i < particleCount; i++) {
                        double t = i / 2.5;
                        Vec3d pos = origin.add(look.multiply(t));
                        serverWorld.spawnParticles(ParticleTypes.SWEEP_ATTACK, pos.x, pos.y, pos.z, 1, 0, 0, 0, 0);
                    }

                    Vec3d impact = (hit.getType() == HitResult.Type.MISS) ? end : hit.getPos();
                    LivingEntity directTarget = null;
                    List<LivingEntity> potential = serverWorld.getEntitiesByClass(
                            LivingEntity.class,
                            new Box(origin, end).expand(1.0),
                            e -> e != user && e.isAlive()
                    );

                    double minDist = Double.MAX_VALUE;
                    for (LivingEntity e : potential) {
                        double d = origin.distanceTo(e.getPos());
                        if (d < minDist && d <= RANGE) {
                            minDist = d;
                            directTarget = e;
                        }
                    }

                    if (directTarget != null) {
                        directTarget.damage(serverWorld.getDamageSources().mobAttack(user), BASE_DAMAGE);
                        //impact = directTarget.getPos();
                    }
                }
            }

        return super.use(world, user, hand);
    }

    @Override
    public boolean isItemBarVisible(ItemStack stack) {
        return true;
    }
    @Override
    public int getItemBarStep(ItemStack stack) {
        WeaponChargeComponent charge = WeaponChargeComponent.getForDisplay();
        return charge != null ? Math.round((float) charge.getGlaive() / WeaponChargeComponent.MAX * 13) : 0;
    }
    @Override
    public int getItemBarColor(ItemStack stack) {
        int red = (int) (255);
        int blue = (int) (36);
        int green = (int) (0);
        return (red << 16) | (green << 8) | blue; // RGB mix
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        if (stack.isOf(ModItems.BLOODSTAINED_GLAIVE)) {
            tooltip.add(Text.literal("Have a chance to inflict Blood Loss").formatted(Formatting.DARK_RED));
        }
        if (stack.isOf(ModItems.CARMINE_BLOOM)) {
            tooltip.add(Text.literal("Made for Morislug").formatted(Formatting.GRAY));
        }
    }
}