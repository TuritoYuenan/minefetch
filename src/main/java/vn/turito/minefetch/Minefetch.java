package vn.turito.minefetch;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.command.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

public class Minefetch implements ModInitializer {
	private int Fetch(CommandContext<ServerCommandSource> ctx) throws CommandSyntaxException {
		ServerCommandSource sauce = ctx.getSource();
		ServerPlayerEntity player = sauce.getPlayer();
		ServerWorld world         = sauce.getWorld();

		String positions = player.getBlockX()+", "+player.getBlockY()+", "+player.getBlockZ();

		Text[] fetches = {
			new LiteralText(String.valueOf("██████████  "+"@")+player.getDisplayName()),
			new LiteralText(String.valueOf("██░░██░░██  "+"Seed: "+world.getSeed())),
			new LiteralText(String.valueOf("████░░████  "+"Time: "+world.getTime())),
			new LiteralText(String.valueOf("███░░░░███  "+"Position: "+positions)),
			new LiteralText(String.valueOf("███░██░███  ")),
			new LiteralText(String.valueOf("██████████  ")),
		};

		for (Text i: fetches) {sauce.sendFeedback(i, false);}
		return 1;
	}

	@Override
	public void onInitialize() {
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) ->
			dispatcher.register(CommandManager.literal("minefetch").executes(ctx -> this.Fetch(ctx)))
		);
	}
}
