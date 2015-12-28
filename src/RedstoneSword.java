import net.canarymod.Canary;
import net.canarymod.api.DyeColor;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.chat.ChatStyle;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.factory.ItemFactory;
import net.canarymod.api.inventory.Enchantment;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.inventory.ItemType;
import net.canarymod.api.inventory.recipes.CraftingRecipe;
import net.canarymod.api.inventory.recipes.RecipeRow;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.BlockType;
import net.canarymod.commandsys.commands.playermod.PlayerPrefix;
import net.canarymod.commandsys.commands.vanilla.Enchant;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.BlockRightClickHook;
import net.canarymod.plugin.Plugin;
import net.canarymod.plugin.PluginListener;

public class RedstoneSword extends Plugin implements PluginListener{
    @Override
    public boolean enable() {
        Canary.hooks().registerListener(this, this);

        ItemFactory items = Canary.factory().getItemFactory();
        Item flintandsteel = items.newItem(ItemType.FlintAndSteel);
        Item redstoneblock = items.newItem(ItemType.RedstoneBlock);
        Item ironsword = items.newItem(ItemType.IronSword);

        Item redstonesword = items.newItem(ItemType.IronSword);
        ChatComponent c1 = Canary.factory().getChatComponentFactory().newChatComponent("Right-Click for Special-Ability!");
        ChatStyle style = c1.getChatStyle();
        style.setColor(Canary.factory().getChatComponentFactory().colorRed());
        redstonesword.setDisplayName("Redstone-Sword");
        redstonesword.setLore("Right-Click for Special-Ability!");
        Enchantment SwordEnchantment = items.newEnchantment(Enchantment.Type.FireAspect, (short) 1);
        redstonesword.addEnchantments(SwordEnchantment);

        RecipeRow SwordRow1 = new RecipeRow("FRF", new Item[]{flintandsteel, redstoneblock, flintandsteel});
        RecipeRow SwordRow2 = new RecipeRow(" R ", new Item[]{redstoneblock});
        RecipeRow SwordRow3 = new RecipeRow(" I ", new Item[]{ironsword});
        CraftingRecipe RedstoneSwordRezept = new CraftingRecipe(redstonesword, new RecipeRow[]{SwordRow1, SwordRow2, SwordRow3});
        Canary.getServer().addRecipe(RedstoneSwordRezept);

//        Here starts the code of the "Fire Armor"

        Item FireHelmet = items.newItem(ItemType.LeatherHelmet);
        Item FireChest = items.newItem(ItemType.LeatherChestplate);
        Item FireLeggins = items.newItem(ItemType.LeatherLeggings);
        Item FireBoots = items.newItem(ItemType.LeatherBoots);

//        Enchantments

        Enchantment HelmetEnchantment0 = items.newEnchantment(Enchantment.Type.FireProtection, (short) 10);
        Enchantment HelmetEnchantment1 = items.newEnchantment(Enchantment.Type.Unbreaking, (short) 3);

        Enchantment ChestEnchantment0 = items.newEnchantment(Enchantment.Type.FireProtection, (short) 10);
        Enchantment ChestEnchantment1 = items.newEnchantment(Enchantment.Type.Unbreaking, (short) 3);

        Enchantment LegginsEnchantment0 = items.newEnchantment(Enchantment.Type.FireProtection, (short) 10);
        Enchantment LegginsEnchantment1 = items.newEnchantment(Enchantment.Type.Unbreaking, (short) 3);

        Enchantment BootsEnchantment0 = items.newEnchantment(Enchantment.Type.FireProtection, (short) 10);
        Enchantment BootsEnchantment1 = items.newEnchantment(Enchantment.Type.Unbreaking, (short) 3);

//        Names and Lores

        FireHelmet.setDisplayName("Fire-Helmet");
        FireHelmet.setLore("Protects form Fire");

        FireChest.setDisplayName("Fire-Chestplate");
        FireChest.setLore("Protects from Fire");

        FireLeggins.setDisplayName("Fire-Leggins");
        FireLeggins.setLore("Protects from Fire");

        FireBoots.setDisplayName("Fire-Boots");
        FireBoots.setLore("Plugin made by tooxo!");

//        Crafting

        Item redstone = items.newItem(ItemType.RedStone);
        Item lapis = items.newItem(ItemType.LapisLazuli);
        Item core = items.newItem(ItemType.GlowstoneDust);

//        Helmet

        RecipeRow HelmetRow1 = new RecipeRow("RRR", new Item[]{redstone, redstone, redstone});
        RecipeRow HelmetRow2 = new RecipeRow("RCR", new Item[]{redstone, core, redstone});
        CraftingRecipe HelmetRecipe = new CraftingRecipe(FireHelmet, new RecipeRow[]{HelmetRow1, HelmetRow2});
        Canary.getServer().addRecipe(HelmetRecipe);

//        Chestplate

        RecipeRow ChestRow1 = new RecipeRow("RCR", new Item[]{redstone, core, redstone});
        RecipeRow ChestRow2 = new RecipeRow("RRR", new Item[]{redstone, redstone, redstone});
        RecipeRow ChestRow3 = new RecipeRow("RRR", new Item[]{redstone, redstone, redstone});
        CraftingRecipe ChestRecipe = new CraftingRecipe(FireChest, new RecipeRow[]{ChestRow1, ChestRow2, ChestRow3});
        Canary.getServer().addRecipe(ChestRecipe);

//        Leggins

        RecipeRow LegginsRow1 = new RecipeRow("RRR", new Item[]{redstone, redstone, redstone});
        RecipeRow LegginsRow2 = new RecipeRow("RCR", new Item[]{redstone, core, redstone});
        RecipeRow LegginsRow3 = new RecipeRow("R R", new Item[]{redstone, redstone});
        CraftingRecipe LegginsRecipe = new CraftingRecipe(FireLeggins, new RecipeRow[]{LegginsRow1, LegginsRow2, LegginsRow3});
        Canary.getServer().addRecipe(LegginsRecipe);

//        Boots

        RecipeRow BootsRow1 = new RecipeRow("RCR", new Item[]{redstone, core, redstone});
        RecipeRow BootsRow2 = new RecipeRow("R R", new Item[]{redstone, redstone});
        CraftingRecipe BootsRecipe = new CraftingRecipe(FireBoots, new RecipeRow[]{BootsRow1, BootsRow2});
        Canary.getServer().addRecipe(BootsRecipe);

//        Add Enchantments

        FireHelmet.addEnchantments(HelmetEnchantment0);
        FireHelmet.addEnchantments(HelmetEnchantment1);
        FireChest.addEnchantments(ChestEnchantment0);
        FireChest.addEnchantments(ChestEnchantment1);
        FireLeggins.addEnchantments(LegginsEnchantment0);
        FireLeggins.addEnchantments(LegginsEnchantment1);
        FireBoots.addEnchantments(BootsEnchantment0);
        FireBoots.addEnchantments(BootsEnchantment1);

        return true;
    }

    @Override
    public void disable() {
    }

    @HookHandler
    public void fire(BlockRightClickHook event){
        Player player = event.getPlayer();
        if(player.getItemHeld()!= null && player.getItemHeld().getDisplayName().equals("Redstone-Sword") && player.getItemHeld().getType().equals(ItemType.IronSword)){
            Block block = event.getBlockClicked();
            block = block.getRelative(0,1,0);
        if(block.getType().equals(BlockType.Air)) {
            block.setType(BlockType.FireBlock);
            block.update();}}}


    }





