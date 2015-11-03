package com.voidsun.fool.util.reader;

/**
 * @Description
 * @Author voidsun
 * @Date 2015/11/2
 * @Email voidsun@126.com
 */
public class StringCharReader extends CharReader {
    private char[] chars;

    public StringCharReader(String expression){
        chars = expression.toCharArray();
    }

    @Override
    protected char read(int index) {
        return chars[index];
    }

    @Override
    public boolean hasNext() {
        return index < chars.length;
    }
}
