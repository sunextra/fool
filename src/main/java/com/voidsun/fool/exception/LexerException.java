package com.voidsun.fool.exception;

import java.util.Arrays;

/**
 * @Description
 * @Author voidsun
 * @Date 2015/8/20
 * @Email voidsun@126.com
 */
public class LexerException extends CompileException {

    static String buildMessage(char[] inStream, int idx){
        int start = idx-16;
        if(start<0) start=0;
        int end = idx+16;
        if(end>inStream.length)end = inStream.length;
        return "error at index [" + (idx-start+1) + "] in " + new String(Arrays.copyOfRange(inStream, start, end));
    }

    public LexerException(char[] inStream, int idx) {
        super(buildMessage(inStream, idx));
    }
}
