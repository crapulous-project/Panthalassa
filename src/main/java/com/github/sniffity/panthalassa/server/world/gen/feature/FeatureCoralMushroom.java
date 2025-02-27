package com.github.sniffity.panthalassa.server.world.gen.feature;

import com.github.sniffity.panthalassa.server.registry.PanthalassaBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.CoralFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class FeatureCoralMushroom extends FeatureAbstractCoral {
    public FeatureCoralMushroom(Codec<NoFeatureConfig> p_i231941_1_) {
        super(p_i231941_1_);
    }

    protected boolean placeFeature(IWorld p_204623_1_, Random p_204623_2_, BlockPos p_204623_3_, BlockState p_204623_4_) {
        double r = Math.floor(Math.random() * (81) + 20);
        BlockPos blockposAdjusted = new BlockPos(p_204623_3_.getX(), r, p_204623_3_.getZ());

        if (p_204623_1_.getBlockState(blockposAdjusted.below()).is(PanthalassaBlocks.PANTHALASSA_SAND.get())) {

            int i = p_204623_2_.nextInt(3) + 3;
            int j = p_204623_2_.nextInt(3) + 3;
            int k = p_204623_2_.nextInt(3) + 3;
            int l = p_204623_2_.nextInt(3) + 1;
            BlockPos.Mutable blockpos$mutable = blockposAdjusted.mutable();

            for (int i1 = 0; i1 <= j; ++i1) {
                for (int j1 = 0; j1 <= i; ++j1) {
                    for (int k1 = 0; k1 <= k; ++k1) {
                        blockpos$mutable.set(i1 + blockposAdjusted.getX(), j1 + blockposAdjusted.getY(), k1 + blockposAdjusted.getZ());
                        blockpos$mutable.move(Direction.DOWN, l);
                        if ((i1 != 0 && i1 != j || j1 != 0 && j1 != i) && (k1 != 0 && k1 != k || j1 != 0 && j1 != i) && (i1 != 0 && i1 != j || k1 != 0 && k1 != k) && (i1 == 0 || i1 == j || j1 == 0 || j1 == i || k1 == 0 || k1 == k) && !(p_204623_2_.nextFloat() < 0.1F) && !this.placeSecondaryCoralBlock(p_204623_1_, p_204623_2_, blockpos$mutable, p_204623_4_)) {
                        }
                    }
                }
            }

        }
        return true;

    }
}