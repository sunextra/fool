package com.voidsun.fool.exception;

import com.voidsun.fool.util.reader.CharReader;

/**
 * @Description
 * @Author voidsun
 * @Date 2015/8/20
 * @Email voidsun@126.com
 */
public class LexerException extends CompileException {

    private static String buildMessage(CharReader reader){
        reader.backStep();
        return "Illegal Lexer [" + reader.charAtCurrent() + "] at index " + reader.getIndex();
    }
    private static String buildMessage(String charSeq, int index){
        return "Illegal Lexer [" + charSeq + "] at index " + index;
    }
    public LexerException(CharReader reader) {
        super(buildMessage(reader));
    }
    public LexerException(String charSeq, int index) {
        super(buildMessage(charSeq, index));
    }
}
