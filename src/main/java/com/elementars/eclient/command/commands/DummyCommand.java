package com.elementars.eclient.command.commands;

import com.elementars.eclient.Xulu;
import com.elementars.eclient.command.Command;
import com.elementars.eclient.dummy.DummyMod;
import com.elementars.eclient.module.Module;
import dev.xulu.newgui.NewGUI;
import dev.xulu.newgui.Panel;
import dev.xulu.newgui.elements.ModuleButton;

import java.util.Objects;

public class DummyCommand extends Command {
    public DummyCommand() {
        super("dummymod", "Makes some fake modules >:)", new String[]{"add", "del"});
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            sendChatMessage("Try .enemy add or .enemy del");
            return;
        }
        if (args[1].equalsIgnoreCase("help")) {
            showSyntax(args[0]);
            sendChatMessage("Usage 1: .dummymod add (name)");
            sendChatMessage("Usage 2: .dummymod add (name) (info)");
            sendChatMessage("Info is what is displayed in brackets in the featurelist");
        }
        if (args.length < 3) {
            sendChatMessage("Specify a name");
            return;
        }
        if (args.length == 3) {
            DummyMod mod = new DummyMod(args[2]);
            if (args[1].equalsIgnoreCase("add")) {
                if (!Xulu.MODULE_MANAGER.getModules().contains(mod)) {
                    Xulu.MODULE_MANAGER.getModules().add(mod);
                    Panel p = NewGUI.getPanelByName("Dummy");
                    if (p != null) {
                        p.Elements.add(new ModuleButton(mod, p));
                    }
                    sendChatMessage("Dummy mod " + mod.getName() + " added.");
                }else{
                    sendChatMessage(mod.getName() + " already exists!");
                }
            }
            else if (args[1].equalsIgnoreCase("del")) {
                boolean found = false;
                for (Module m : Xulu.MODULE_MANAGER.getModules()) {
                    if (m.getName().equalsIgnoreCase(mod.getName())) {
                        Xulu.MODULE_MANAGER.getModules().remove(m);
                        Panel p = NewGUI.getPanelByName("Dummy");
                        if (p != null) {
                            p.Elements.stream().filter(button -> button instanceof ModuleButton).map(button -> (ModuleButton) button).forEach(button -> {
                                if (button.mod.getName().equalsIgnoreCase(mod.getName())) p.Elements.remove(button);
                            });
                        }
                        sendChatMessage("Dummy mod " + mod.getName() + " removed.");
                        found = true;
                    }
                }
                if (!found) {
                    sendChatMessage(mod.getName() + " isn't a mod!");
                }
            }
            else {
                sendChatMessage("Unknown attribute '" + args[1] + "'");
            }
        }
        if (args.length == 4) {
            DummyMod mod = new DummyMod(args[2], args[3]);
            if (args[1].equalsIgnoreCase("add")) {
                if (!Xulu.MODULE_MANAGER.getModules().contains(mod)) {
                    Xulu.MODULE_MANAGER.getModules().add(mod);
                    Panel p = NewGUI.getPanelByName("Dummy");
                    if (p != null) {
                        p.Elements.add(new ModuleButton(mod, p));
                    }
                    sendChatMessage("Dummy mod " + mod.getName() + " added.");
                }else{
                    sendChatMessage(mod.getName() + " already exists!");
                }
            }
            else if (args[1].equalsIgnoreCase("del")) {
                boolean found = false;
                for (Module m : Xulu.MODULE_MANAGER.getModules()) {
                    if (m.getName().equalsIgnoreCase(mod.getName())) {
                        Xulu.MODULE_MANAGER.getModules().remove(m);
                        Panel p = NewGUI.getPanelByName("Dummy");
                        if (p != null) {
                            p.Elements.stream().filter(Objects::nonNull).forEach(button -> {
                                if (button.mod.getName().equalsIgnoreCase(mod.getName())) p.Elements.remove(button);
                            });
                        }
                        sendChatMessage("Dummy mod " + mod.getName() + " removed.");
                        found = true;
                    }
                }
                if (!found) {
                    sendChatMessage(mod.getName() + " isn't a mod!");
                }
            }
            else {
                sendChatMessage("Unknown attribute '" + args[1] + "'");
            }
        }
    }
}
