package com.voidsun.fool.lexer;

import java.util.Arrays;

/**
 * @Description
 * @Author voidsun
 * @Date 2015/8/19
 * @Email voidsun@126.com
 */
public class Token {
    Kind kind;
    char[] lexeme;

    @Override
    public String toString() {
        String s = "<" + kind + "," + Arrays.toString(lexeme) + ">";
        return s;
    }

    public Token(Kind kind, char[] inStream, int chStart, int chEnd){
        this.kind = kind;
        this.lexeme = Arrays.copyOfRange(inStream, chStart, chEnd);
    }

    public Token(Kind kind, char... lexeme){
        this.kind =  kind;
        this.lexeme = lexeme;
    }

    public Token(Kind kind){
        this.kind = kind;
    }
}