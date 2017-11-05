/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreakerstudent;

/**
 *
 * @author CDOGG_000
 */
public class Level {

    private int levelNum;
    private BrickRow[] brickRows;

    public Level() {

        brickRows = new BrickRow[12];

    }

    public Level(int levelNum, int numBrickRows) {
        this.levelNum = levelNum;
        brickRows = new BrickRow[numBrickRows];
        for (int i = 0; i < numBrickRows; i++) {
            brickRows[i] = new BrickRow();
        }
    }

    public int getBricksPerRow() {
        return brickRows[0].getBrickMaskLength();
    }

    public int getNumBrickRows() {
        return brickRows.length;
    }

    /**
     * @return the levelNum
     */
    public int getLevelNum() {
        return levelNum;
    }

    /**
     * @param levelNum the levelNum to set
     */
    public void setLevelNum(int levelNum) {
        this.levelNum = levelNum;
    }

    /**
     * @return the brickRows
     */
    public BrickRow getBrickRows(int index) {
        return brickRows[index];
    }

    /**
     * @param brickRows the brickRows to set
     */
    public void setBrickRows(int index, BrickRow bkRow) {
        brickRows[index] = bkRow;
    }

    /*formats the string level to have the level number go to next line show the num of 
    brickrows in the specific level go to next line and show the brickrow */

    public String toString() {
        String level = +levelNum + System.lineSeparator() + brickRows.length;
        for (int i = 0; i < brickRows.length; i++) {
            level += System.lineSeparator() + i + System.lineSeparator() + brickRows[i];
        }
        return level;
    }

}
