package sh.okx.civmodern.mod.config;

import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.controller.EnumControllerBuilder;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

public enum TooltipLineOption {
    ALWAYS, ADVANCED, NEVER;

    public static @NotNull EnumControllerBuilder<TooltipLineOption> controller(
        final @NotNull Option<TooltipLineOption> option
    ) {
        return EnumControllerBuilder.create(option)
            .enumClass(TooltipLineOption.class)
            .formatValue((value) -> switch (value) {
                case ALWAYS -> Component.translatable("civmodern.config.type.tooltip.always");
                case ADVANCED -> Component.translatable("civmodern.config.type.tooltip.advanced");
                case NEVER -> Component.translatable("civmodern.config.type.tooltip.never");
            });
    }
}
