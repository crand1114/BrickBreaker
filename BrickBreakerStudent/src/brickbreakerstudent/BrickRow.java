/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreakerstudent;

import javafx.scene.paint.Color;

/**
 *
 * @author CDOGG_000
 */
public class BrickRow {

    private int pointValue;
    private Color color;
    private int[] brickmask;  // didnt change the brickmask to boolean I got confused when I saw the update

    /*initializes to java default values*/
    public BrickRow() {
        pointValue = 0;
        color = new Color(0, 0, 0, 0);
        brickmask = new int[20];

    }

    /*assigns variables to default and puts the values of bMask in the array brickmask in location i*/
    public BrickRow(int ptVal, Color clr, String bMask) {
        pointValue = ptVal;
        color = clr;
        brickmask = new int[(bMask.length())];
        for (int i = 0; i < brickmask.length; i++) {
            if (bMask.charAt(i) == '0') {
                brickmask[i] = 0;
            } else {
                brickmask[i] = 1;
            }
        }
    }

    /*gets the value of brickmask in location index either 1(true) or 0(false)and returns value*/
    /**
     *
     * @param index
     * @return
     */
    public boolean getBrickMaskValue(int index) {

        if (brickmask[index] == 0) {
            return false;

        } else {
            return true;
        }
    }

    /*sets the brickmask value at location of index to boolean of value*/
    public void setBrickMaskValue(int index, boolean value) {
        if (value == false) {
            brickmask[index] = 0;
        } else {
            brickmask[index] = 1;
        }
    }

    /*returns the length of the brickmask array*/
    public int getBrickMaskLength() {
        return brickmask.length;
    }

    /**
     * @return the pointValue
     */
    public int getPointValue() {
        return pointValue;
    }

    /**
     * @param pointValue the pointValue to set
     */
    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /* converting the red green and blue values from 1-0 to 0-255 and separating them with space*/
    @Override
    public String toString() {
        String RGB = " ";
        RGB += (int) (color.getRed() * 255) + " " + (int) (color.getGreen() * 255) + " " + (int) (color.getBlue() * 255);
        String brick = " ";

        for (int i = 0; i < brickmask.length; i++) {
            brick += brickmask[i];

        }
        return RGB + System.lineSeparator() + pointValue + System.lineSeparator() + brick;
    }

}
