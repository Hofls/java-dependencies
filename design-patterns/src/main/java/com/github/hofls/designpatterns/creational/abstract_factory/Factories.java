package com.github.hofls.designpatterns.creational.abstract_factory;

public class Factories {

    public interface GuiFactory {
        GuiElements.Button createButton();
        GuiElements.CheckBox createCheckBox();
    }

    public static class WindowsFactory implements GuiFactory {
        @Override
        public GuiElements.Button createButton() {
            return new GuiElements.WindowsButton();
        }

        @Override
        public GuiElements.CheckBox createCheckBox() {
            return new GuiElements.WindowsCheckBox();
        }
    }

    public static class MacFactory implements GuiFactory {
        @Override
        public GuiElements.Button createButton() {
            return new GuiElements.MacButton();
        }

        @Override
        public GuiElements.CheckBox createCheckBox() {
            return new GuiElements.MacCheckBox();
        }
    }

}
