package net.aerokit.tutorialmod.screen;

import net.aerokit.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<GempolishingScreenHandler> GEM_POLISHING_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(TutorialMod.MOD_ID, "gem_polishing"),
                    new ExtendedScreenHandlerType<>(GempolishingScreenHandler::new));

    public static void registerScreenHandlers() {
        TutorialMod.LOGGER.info("Registering Screen Handlers for " + TutorialMod.MOD_ID);
    }
}
