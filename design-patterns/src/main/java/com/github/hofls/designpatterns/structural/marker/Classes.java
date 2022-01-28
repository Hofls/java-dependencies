package com.github.hofls.designpatterns.structural.marker;

import java.io.Serializable;
import java.rmi.Remote;

public class Classes  {
    public static class Dto implements Serializable, Cloneable, Remote {
        int position;
    }
}
