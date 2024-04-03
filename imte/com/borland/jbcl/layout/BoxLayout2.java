// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 2007-3-11 17:48:23
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   BoxLayout2.java

package com.borland.jbcl.layout;

import java.awt.*;
import java.io.Serializable;
import javax.swing.BoxLayout;

public class BoxLayout2
    implements LayoutManager2, Serializable
{

    public BoxLayout2()
    {
        axis = 0;
    }

    public BoxLayout2(Container parent, int axis)
    {
        this.axis = 0;
        this.axis = axis;
        layout = new BoxLayout(parent, axis);
    }

    public int getAxis()
    {
        return axis;
    }

    public void setAxis(int axis)
    {
        if(axis != this.axis)
        {
            layout = null;
            this.axis = axis;
        }
    }

    void verifyInstance(Container parent)
    {
        if(layout == null)
            layout = new BoxLayout(parent, axis);
    }

    public void addLayoutComponent(Component component, Object constraint)
    {
        try
        {
            component.getParent().invalidate();
        }
        catch(Exception exception) { }
    }

    public Dimension maximumLayoutSize(Container parent)
    {
        verifyInstance(parent);
        return layout.maximumLayoutSize(parent);
    }

    public float getLayoutAlignmentX(Container parent)
    {
        verifyInstance(parent);
        return layout.getLayoutAlignmentX(parent);
    }

    public float getLayoutAlignmentY(Container parent)
    {
        verifyInstance(parent);
        return layout.getLayoutAlignmentY(parent);
    }

    public void invalidateLayout(Container parent)
    {
        verifyInstance(parent);
        layout.invalidateLayout(parent);
    }

    public void addLayoutComponent(String name, Component component)
    {
        try
        {
            component.getParent().invalidate();
        }
        catch(Exception exception) { }
    }

    public void removeLayoutComponent(Component component)
    {
        try
        {
            component.getParent().invalidate();
        }
        catch(Exception exception) { }
    }

    public Dimension preferredLayoutSize(Container parent)
    {
        verifyInstance(parent);
        return layout.preferredLayoutSize(parent);
    }

    public Dimension minimumLayoutSize(Container parent)
    {
        verifyInstance(parent);
        return layout.minimumLayoutSize(parent);
    }

    public void layoutContainer(Container parent)
    {
        verifyInstance(parent);
        layout.layoutContainer(parent);
    }

    BoxLayout layout;
    int axis;
}