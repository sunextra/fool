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
    String value;

    @Override
    public String toString() {
        String s = "<" + kind + "," + value + ">";
        return s;
    }

    public Token(Kind kind, String lexeme){
        this.kind = kind;
        this.value = lexeme;
    }

    public Token(Kind kind, char... lexeme){
        this.kind =  kind;
        this.value = new String(lexeme);
    }

    public Token(Kind kind){
        this.kind = kind;
    }
}