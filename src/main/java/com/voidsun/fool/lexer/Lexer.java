package com.voidsun.fool.lexer;

import com.voidsun.fool.exception.LexerException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author voidsun
 * @Date 2015/8/19
 * @Email voidsun@126.com
 */
public class Lexer {

    private List<Token> tokens = new ArrayList<Token>();

    public List<Token> getTokens(){
        return tokens;
    }

    public void scan(char[] inStream){
        int idx = -1;
        while(++idx < inStream.length){
            char ch = inStream[idx];
            switch(ch){
                case 32:
                    break;
                case '+':
                    tokens.add(new Token(Kind.PLUS));
                    break;
                case '-':
                    tokens.add(new Token(Kind.MINUS));
                    break;
                default:
                    if(ch >= '0' && ch <= '9'){
                        int chStart = idx;
                        while(++idx < inStream.length){
                            if(inStream[idx] < '0' || ch > inStream[idx]){
                                break;
                            }
                        }
                        tokens.add(new Token(Kind.INT, inStream, chStart, idx--));
                    }else{
                        throw new LexerException();
                    }
            }
        }
    }
}
