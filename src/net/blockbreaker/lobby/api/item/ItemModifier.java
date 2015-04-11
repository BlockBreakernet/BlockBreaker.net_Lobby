package net.blockbreaker.lobby.api.item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Lukas on 10.04.2015.
 */

public class ItemModifier {

    static ItemStack item;
    static ItemMeta itemmeta;


    public ItemModifier(ItemStack item){
        this.item = item;
        this.itemmeta = item.getItemMeta();
    }


    public static Builder modify() {
        return new Builder();
    }



    public static final class Builder {

        public Builder setLore(String... lore){
            List<String> loreList = new ArrayList<String>();
            for(String lores : lore){
                loreList.add(lores);
            }
            itemmeta.setLore(loreList);
            return this;
        }

        public Builder addEnchantment(Enchantment entchantment,int level){
            itemmeta.addEnchant(entchantment, level, false);
            return this;
        }

        public Builder removeEnchantment(Enchantment entchantment){
            itemmeta.removeEnchant(entchantment);
            return this;
        }

        public Builder setDisplayName(String display){
            itemmeta.setDisplayName(display);
            return this;
        }

        public Builder setUnbreakable(boolean unbreakable){
            itemmeta.spigot().setUnbreakable(unbreakable);
            return this;
        }

        public Builder HideFlag(ItemFlag itemflag){
            itemmeta.addItemFlags(itemflag);
            return this;
        }

        public Builder ShowFlag(ItemFlag itemflag){
            itemmeta.removeItemFlags(itemflag);
            return this;
        }

        public Builder HideFlagsExcept(ItemFlag itemflag){
            HideFlags();
            ShowFlag(itemflag);
            return this;
        }

        public Builder ShowFlagsExcept(ItemFlag itemflag){
            ShowFlags();
            HideFlag(itemflag);
            return this;
        }

        public Builder HideFlags(){
            itemmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemmeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
            itemmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemmeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
            itemmeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            itemmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            return this;
        }

        public Builder ShowFlags(){
            itemmeta.removeItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemmeta.removeItemFlags(ItemFlag.HIDE_DESTROYS);
            itemmeta.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemmeta.removeItemFlags(ItemFlag.HIDE_PLACED_ON);
            itemmeta.removeItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            itemmeta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            return this;
        }

        public ItemStack build(){
            item.setItemMeta(itemmeta);
            return item;
        }

    }


}