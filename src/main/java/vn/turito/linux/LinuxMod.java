package vn.turito.linux;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LinuxMod implements ModInitializer {

    public static final Item ARCH   = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item VOID   = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item GENTOO = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item UBUNTU = new Item(new Item.Settings().group(ItemGroup.MISC));
    
	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("linux", "arch"),   ARCH  );
        Registry.register(Registry.ITEM, new Identifier("linux", "void"),   VOID  );
        Registry.register(Registry.ITEM, new Identifier("linux", "gentoo"), GENTOO);
        Registry.register(Registry.ITEM, new Identifier("linux", "ubuntu"), UBUNTU);
	}
}
