package net.sealing99.topcomment.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.sealing99.topcomment.entity.ModEntities;
import net.sealing99.topcomment.entity.custom.DiamondShardProjectileEntity;
import net.sealing99.topcomment.entity.custom.GoldNuggetProjectileEntity;
import net.sealing99.topcomment.entity.custom.IronNuggetProjectileEntity;
import net.sealing99.topcomment.item.ModItems;

import java.util.function.Predicate;

public class SlingshotItem extends BowItem {
    public SlingshotItem(Settings settings) {
        super(settings);
    }

    @Override
    protected ProjectileEntity createArrowEntity(World world, LivingEntity shooter, ItemStack weaponStack, ItemStack projectileStack, boolean critical) {
        if (projectileStack.isOf(Items.IRON_NUGGET)) {
            IronNuggetProjectileEntity projectile =
                    new IronNuggetProjectileEntity(
                            ModEntities.IRON_NUGGET_PROJECTILE,
                            shooter,
                            world,
                            projectileStack.copyWithCount(1),
                            weaponStack
                    );

            if (critical) {
                projectile.setCritical(true);
            }

            return projectile;

        } else if (projectileStack.isOf(Items.GOLD_NUGGET)) {
            GoldNuggetProjectileEntity projectile =
                    new GoldNuggetProjectileEntity(
                            ModEntities.GOLD_NUGGET_PROJECTILE,
                            shooter,
                            world,
                            projectileStack.copyWithCount(1),
                            weaponStack
                    );

            if (critical) {
                projectile.setCritical(true);
            }

            return projectile;
        } else if (projectileStack.isOf(ModItems.DIAMOND_SHARD)) {
            DiamondShardProjectileEntity projectile =
                    new DiamondShardProjectileEntity(
                            ModEntities.DIAMOND_SHARD_PROJECTILE,
                            shooter,
                            world,
                            projectileStack.copyWithCount(1),
                            weaponStack
                    );

            if (critical) {
                projectile.setCritical(true);
            }

            return projectile;
        }

        return super.createArrowEntity(
                world,
                shooter,
                weaponStack,
                projectileStack,
                critical
        );
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return stack -> stack.isOf(Items.IRON_NUGGET) || stack.isOf(Items.GOLD_NUGGET) || stack.isOf(ModItems.DIAMOND_SHARD);
    }
}
