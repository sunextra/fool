package com.voidsun.fool.parser;

import com.voidsun.fool.lexer.LexerScanner;
import com.voidsun.fool.lexer.Sign;
import com.voidsun.fool.lexer.Token;

/**
 * @Description
 * @Author voidsun
 * @Date 2015/11/4
 * @Email voidsun@126.com
 */
public class SyntaxParser {

    private LexerScanner lexerScanner;
    private Token token;

    public SyntaxParser(LexerScanner lexerScanner){
        this.lexerScanner = lexerScanner;
    }

    public void parse(){
        while((token = lexerScanner.getToken()) != null){
            switch (token.getKind()){
                case SIGN:
                    sign();
                case ID:
                    ;
                default:
                    ;
            }
        }
    }
    private void sign(){
        Sign sign = Sign.findSign(token.getValue());
        switch (sign){

        }
    }
}
