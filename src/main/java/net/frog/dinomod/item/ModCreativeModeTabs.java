package net.frog.dinomod.item;

import net.frog.dinomod.DinoMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DinoMod.MOD_ID);

    public static final Supplier<CreativeModeTab> DINO_ITEMS_TAB = CREATIVE_MODE_TAB.register("dino_items_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.FEATHERFOSSIL.get())) // @TODO change the item to be something more representing of the mod
            .title(Component.translatable("creativetab.dino_mod.dino_mod_items"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.FEATHERFOSSIL);
            })
            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
