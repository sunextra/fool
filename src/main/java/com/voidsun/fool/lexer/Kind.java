package com.voidsun.fool.lexer;

/**
 * @Description
 * @Author voidsun
 * @Date 2015/8/19
 * @Email voidsun@126.com
 */
public enum Kind {
    //基本类型
    ID,
    INT,
    DOUBLE,
    VOID,
    RETURN,

    //符号
    LPAREN,
    RPAREN,
    LBRACE,
    RBRACE,

    //运算符
    PLUS,
    MINUS,
    SLF_PLUS,
    SLF_MINUS
    ;
}
