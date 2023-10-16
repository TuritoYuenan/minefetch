package vn.turito.minefetch;

import com.mojang.brigadier.Command;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;

import static net.minecraft.server.command.CommandManager.literal;

class Minefetch implements ModInitializer {
	Command<ServerCommandSource> fetchCommand = context -> {
		ServerCommandSource source = context.getSource();

		ServerPlayerEntity player = source.getPlayer();
		String positions = player.getBlockX()+", "+player.getBlockY()+", "+player.getBlockZ();

		String[] lines = {
			"██████████  " + player.getDisplayName() + "@" + source.getServer(),
			"██░░██░░██  " + "Seed: " + source.getWorld().getSeed(),
			"████░░████  " + "Time: " + source.getWorld().getTime(),
			"███░░░░███  " + "Position: " + positions,
			"███░██░███  ",
			"██████████  ",
		};

		for (String i: lines) {
			source.sendFeedback(new LiteralText(i), false);
		}

		return 0;
	};

	@Override
	public void onInitialize() {
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) ->
			dispatcher.register(literal("minefetch").executes(this.fetchCommand))
		);
	}
}
