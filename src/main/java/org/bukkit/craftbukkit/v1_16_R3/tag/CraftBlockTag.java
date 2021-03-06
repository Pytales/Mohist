package org.bukkit.craftbukkit.v1_16_R3.tag;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import net.minecraft.block.Block;
import net.minecraft.tags.ITagCollection;
import net.minecraft.util.ResourceLocation;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.util.CraftMagicNumbers;

public class CraftBlockTag extends CraftTag<Block, Material> {

    public CraftBlockTag(ITagCollection<Block> registry, ResourceLocation tag) {
        super(registry, tag);
    }

    @Override
    public boolean isTagged(Material item) {
        return getHandle().contains(CraftMagicNumbers.getBlock(item));
    }

    @Override
    public Set<Material> getValues() {
        return Collections.unmodifiableSet(getHandle().getAllElements().stream().map((block) -> CraftMagicNumbers.getMaterial(block)).collect(Collectors.toSet()));
    }
}
