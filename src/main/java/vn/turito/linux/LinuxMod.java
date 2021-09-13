package vn.turito.linux;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LinuxMod implements ModInitializer {

    // Tux Block (WIP)
    public static final Block TUX_BLOCK = new Block(FabricBlockSettings.of(Material.METAL)
        .strength(6, 5)
        .sounds(BlockSoundGroup.ANVIL)
        .breakByTool(FabricToolTags.PICKAXES)
    );

    // Essences
    public static final Item TUX = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item ARCH = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item VOID = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item GENTOO = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item UBUNTU = new Item(new Item.Settings().group(ItemGroup.MISC));

	@Override
	public void onInitialize() {
        
        Registry.register(Registry.BLOCK, new Identifier("linux", "tux_block"), TUX_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("linux", "tux_block"), new BlockItem(
            TUX_BLOCK, new Item.Settings().group(ItemGroup.DECORATIONS))
        );

        Registry.register(Registry.ITEM, new Identifier("linux", "tux"), TUX);
		Registry.register(Registry.ITEM, new Identifier("linux", "arch"), ARCH);
        Registry.register(Registry.ITEM, new Identifier("linux", "void"), VOID);
        Registry.register(Registry.ITEM, new Identifier("linux", "gentoo"), GENTOO);
        Registry.register(Registry.ITEM, new Identifier("linux", "ubuntu"), UBUNTU);
	}
}
