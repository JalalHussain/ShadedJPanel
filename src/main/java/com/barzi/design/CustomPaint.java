/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barzi.design;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;

/**
 *
 * @author Jalal.Hussain
 */
public class CustomPaint implements Paint {
    
    Point2D originP, radiusP;
    int radius, border;
    Color colorIn, colorOut;
    
    public CustomPaint(int x, int y, Point2D radiusP,
            int radius, int border,
            Color colorIn, Color colorOut) {
        originP = new Point2D.Double(x, y);
        this.radiusP = radiusP;
        this.radius = radius;
        this.border = border;
        this.colorIn = colorIn;
        this.colorOut = colorOut;
    }
    
    @Override
    public PaintContext createContext(ColorModel cm, Rectangle deviceBounds, Rectangle2D userBounds, AffineTransform xform, RenderingHints hints) {
        Point2D xformOrigin = xform.transform(originP, null), xformRadius = xform.deltaTransform(radiusP, null);
        return new CustomPaintContext(xformOrigin, xformRadius, radius, border, colorIn, colorOut);
    }
    
    @Override
    public int getTransparency() {
        int alphaIn = colorIn.getAlpha();
        int alphaOut = colorOut.getAlpha();
        return (((alphaIn & alphaOut) == 0xff) ? OPAQUE : TRANSLUCENT);
    }
}

