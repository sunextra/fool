package com.voidsun.fool.util.reader;

/**
 * @Description
 * @Author voidsun
 * @Date 2015/11/2
 * @Email voidsun@126.com
 */
public abstract class CharReader {
    protected int index = 0;
    protected abstract char read(int index);
    public abstract boolean hasNext();

    public char read(){
        char c = read(index);
        index++;
        return c;
    }

    public char charAtCurrent(){
        return read(index);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void backStep(){
        index--;
    }

    public void nextStep() {
        index++;
    }

}
