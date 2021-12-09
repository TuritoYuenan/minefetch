package vn.turito.linux;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.*;
import net.fabricmc.fabric.api.command.v1.*;

import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.*;

import vn.turito.linux.commands.MinefetchCommand;

public class LinuxMod implements ModInitializer {
	public static final ItemGroup LINUX = FabricItemGroupBuilder.build(
		new Identifier("linux", "linux"), () -> new ItemStack(Items.IRON_BLOCK));

	public static final Item ARCH   = new Item(new Item.Settings().group(LINUX));
	public static final Item VOID   = new Item(new Item.Settings().group(LINUX));
	public static final Item GENTOO = new Item(new Item.Settings().group(LINUX));
	public static final Item UBUNTU = new Item(new Item.Settings().group(LINUX));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("linux", "arch"),   ARCH  );
		Registry.register(Registry.ITEM, new Identifier("linux", "void"),   VOID  );
		Registry.register(Registry.ITEM, new Identifier("linux", "gentoo"), GENTOO);
		Registry.register(Registry.ITEM, new Identifier("linux", "ubuntu"), UBUNTU);

		CommandRegistrationCallback.EVENT.register(MinefetchCommand::register);
	}
}
