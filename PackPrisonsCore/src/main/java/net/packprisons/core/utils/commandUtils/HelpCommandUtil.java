package net.packprisons.core.utils.commandUtils;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.packprisons.core.utils.ChatUtil;
import org.bukkit.entity.Player;

public abstract class HelpCommandUtil {

   public void buildHelpMessage(Player player,
                                String Header,
                                String firstHelpComponent,
                                String secondHelpComponent,
                                String thirdHelpComponent,
                                String fourthHelpComponent,
                                String fifthHelpComponent,
                                String firstHelpMessage,
                                String secondHelpMessage,
                                String thirdHelpMessage,
                                String fourthHelpMessage,
                                String fifthHelpMessage,
                                String firstHover,
                                String secondHover,
                                String thirdHover,
                                String fourthHover,
                                String fifthHover,
                                String firstClick,
                                String secondClick,
                                String thirdClick,
                                String fourthClick,
                                String fifthClick,
                                String Footer) {

       TextComponent firstMessage = new TextComponent(ChatUtil.translate(firstHelpMessage) + " ");
       TextComponent secondMessage = new TextComponent(ChatUtil.translate(secondHelpMessage) + " ");
       TextComponent thirdMessage= new TextComponent(ChatUtil.translate(thirdHelpMessage) + " ");
       TextComponent fourthMessage = new TextComponent(ChatUtil.translate(fourthHelpMessage) + " ");
       TextComponent fifthMessage = new TextComponent(ChatUtil.translate(fifthHelpMessage) + " ");

       TextComponent firstComponent = new TextComponent(firstHelpComponent);
       TextComponent secondComponent = new TextComponent(secondHelpComponent);
       TextComponent thirdComponent = new TextComponent(thirdHelpComponent);
       TextComponent fourthComponent = new TextComponent(fourthHelpComponent);
       TextComponent fifthComponent = new TextComponent(fifthHelpComponent);

       firstComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(firstHover).create()));
       firstComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, firstClick));

       secondComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(secondHover).create()));
       secondComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, secondClick));

       thirdComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(thirdHover).create()));
       thirdComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, thirdClick));

       fourthComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(fourthHover).create()));
       fourthComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, fourthClick));

       fifthComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(fifthHover).create()));
       fifthComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, fifthClick));

       firstMessage.addExtra(firstComponent);
       secondMessage.addExtra(secondComponent);
       thirdMessage.addExtra(thirdComponent);
       fourthMessage.addExtra(fourthComponent);
       fifthMessage.addExtra(fifthComponent);

       player.sendColorMessage(Header);
       player.sendMessage(" ");
       player.spigot().sendMessage(firstMessage);
       player.spigot().sendMessage(secondMessage);
       player.spigot().sendMessage(thirdMessage);
       player.spigot().sendMessage(fourthMessage);
       player.spigot().sendMessage(fifthMessage);
       player.sendMessage(" ");
       player.sendColorMessage(Footer);
   }
}
