package vn.turito.linux.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.server.command.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.*;

public class MinefetchCommand {
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
		dispatcher.register(CommandManager.literal("minefetch").executes(MinefetchCommand::run));
	}

	private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
		ServerCommandSource source = context.getSource();
		ServerWorld world = context.getSource().getWorld();
		//long seed = world.getSeed();
		Text seed = new LiteralText(String.valueOf(world.getSeed()));
		Text time = new LiteralText(String.valueOf(world.getTime()));

		source.sendFeedback(seed, false);
		source.sendFeedback(time, false);
		return 1;
	}
}
