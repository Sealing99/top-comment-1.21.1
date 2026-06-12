package net.sealing99.topcomment.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.sealing99.topcomment.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class IronNuggetProjectileEntity extends PersistentProjectileEntity implements FlyingItemEntity {
    public IronNuggetProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public IronNuggetProjectileEntity(EntityType<? extends PersistentProjectileEntity> type, double x, double y, double z, World world, ItemStack stack, @Nullable ItemStack weapon) {
        super(type, x, y, z, world, stack, weapon);
    }

    public IronNuggetProjectileEntity(EntityType<? extends PersistentProjectileEntity> type, LivingEntity owner, World world, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(type, owner, world, stack, shotFrom);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(Items.IRON_NUGGET);
    }

    @Override
    public ItemStack getStack() {
        return new ItemStack(Items.IRON_NUGGET);
    }

    @Override
    public void setDamage(double damage) {
        super.setDamage(1.5);
    }
}
