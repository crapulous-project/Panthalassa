package com.github.sniffity.panthalassa.server.registry;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class PanthalassaItemGroup {

    public static final ItemGroup GROUP = new ItemGroup("group_panthalassa") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Blocks.CYAN_GLAZED_TERRACOTTA);
        }
    };
}
