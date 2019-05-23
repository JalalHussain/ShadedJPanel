/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barzi.design;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

/**
 *
 * @author Jalal.Hussain
 */
public class CustomPaintContext implements PaintContext {
    
    Point2D originP, radiusP;
    Color colorIn, colorOut;
    int radius, border;
    
    public CustomPaintContext(Point2D originP, Point2D radiusP, int radius, int border, Color colorIn, Color colorOut) {
        this.originP = originP;
        this.radiusP = radiusP;
        this.radius = radius;
        this.border = border;
        this.colorIn = colorIn;
        this.colorOut = colorOut;
    }
    
    @Override
    public void dispose() {
    }
    
    @Override
    public ColorModel getColorModel() {
        return ColorModel.getRGBdefault();
    }
    
    @Override
    public Raster getRaster(int x, int y, int w, int h) {
        WritableRaster raster = getColorModel().createCompatibleWritableRaster(w, h);
        int[] data = new int[w * h * 4];
        for (int j = 0; j < h; j++) {
            for (int i = 0; i < w; i++) {
                double distance = originP.distance(x + i, y + j);
                double r = radiusP.distance(radius, radius);
                double ratio = distance - r < 0 ? 0.0 : (distance - r) / border;
                if (ratio > 1.0) {
                    ratio = 1.0;
                }
                int base = (j * w + i) * 4;
                data[base + 0] = (int) (colorIn.getRed() + ratio * (colorOut.getRed() - colorIn.getRed()));
                data[base + 1] = (int) (colorIn.getGreen() + ratio * (colorOut.getGreen() - colorIn.getGreen()));
                data[base + 2] = (int) (colorIn.getBlue() + ratio * (colorOut.getBlue() - colorIn.getBlue()));
                data[base + 3] = (int) (colorIn.getAlpha() + ratio * (colorOut.getAlpha() - colorIn.getAlpha()));
            }
        }
        raster.setPixels(0, 0, w, h, data);
        return raster;
    }
}