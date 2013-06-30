package de.paleocrafter.netcraft;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.crafting.CraftingManager;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import de.paleocrafter.netcraft.client.CreativeTabNetCraft;
import de.paleocrafter.netcraft.configuration.ConfigurationHandler;
import de.paleocrafter.netcraft.core.handlers.LocalizationHandler;
import de.paleocrafter.netcraft.core.proxy.CommonProxy;
import de.paleocrafter.netcraft.item.ModItems;
import de.paleocrafter.netcraft.item.recipe.RecipesArcPad;
import de.paleocrafter.netcraft.lib.Reference;

/**
 * 
 * NetCraft
 * 
 * NetCraft
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER, dependencies = Reference.DEPENDENCIES, certificateFingerprint = Reference.FINGERPRINT)
@NetworkMod(channels = { Reference.CHANNEL_NAME }, clientSideRequired = true, serverSideRequired = false)
public class NetCraft {
    @Instance(Reference.MOD_ID)
    public static NetCraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static CreativeTabNetCraft tabsNetCraft = new CreativeTabNetCraft(
            CreativeTabs.getNextID(), Reference.MOD_ID);

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {

        // Initialize the log helper
        // LogHelper.init();

        // Load the localization files into the LanguageRegistry
        LocalizationHandler.loadLanguages();

        // Initialize the configuration
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory()
                .getAbsolutePath()
                + File.separator
                + Reference.CHANNEL_NAME
                + File.separator + Reference.MOD_ID + ".cfg"));

        // Conduct the version check and log the result
        // VersionHelper.execute();

        // Initialize the Version Check Tick Handler (Client only)
        // TickRegistry.registerTickHandler(new VersionCheckTickHandler(),
        // Side.CLIENT);

        // Initialize the Render Tick Handler (Client only)
        // proxy.registerRenderTickHandler();

        // Register the KeyBinding Handler (Client only)
        // proxy.registerKeyBindingHandler();

        // Register the Sound Handler (Client only)
        // proxy.registerSoundHandler();

        // Initialize mod blocks
        // ModBlocks.init();

        // Initialize mod items
        ModItems.init();
    }

    @SuppressWarnings("unchecked")
    @Init
    public void load(FMLInitializationEvent event) {

        // Register the GUI Handler
        // NetworkRegistry.instance().registerGuiHandler(instance, proxy);

        // Initialize mod tile entities
        proxy.registerTileEntities();

        // Initialize custom rendering and pre-load textures (Client only)
        proxy.initRenderingAndTextures();

        CraftingManager.getInstance().getRecipeList().add(new RecipesArcPad());
    }
}
