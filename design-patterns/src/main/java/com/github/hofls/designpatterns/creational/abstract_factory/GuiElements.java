package com.github.hofls.designpatterns.creational.abstract_factory;

public class GuiElements {

    public interface Button {}

    public interface CheckBox{}

    public static class WindowsButton implements Button {}

    public static class WindowsCheckBox implements CheckBox {}

    public static class MacButton implements Button {}

    public static class MacCheckBox implements CheckBox {}

}
