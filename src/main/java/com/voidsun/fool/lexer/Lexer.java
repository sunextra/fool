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
    private int idx = -1;
    private List<Token> tokens = new ArrayList<Token>();

    public List<Token> getTokens(){
        return tokens;
    }

    private Token read(char[] inStream){
        char ch = inStream[idx];
        switch(ch){
            case 32:
                break;
            case '+'://FIX ME 可能出现+ ++ +++ +++++
                if(++idx < inStream.length){
                    if(inStream[idx] == '+'){
                        return new Token(Kind.SLF_PLUS);
                    }else{
                        --idx;
                        return new Token(Kind.PLUS);
                    }
                }
                return new Token(Kind.PLUS);
            case '-'://区分减号 --运算 不区分负数和减号
                if(++idx < inStream.length){
                    if(inStream[idx] == '-'){
                        return new Token(Kind.SLF_MINUS);
                    }else{
                        --idx;
                        return new Token(Kind.MINUS);
                    }
                }
            case '(':
                return new Token(Kind.LPAREN);
            case ')':
                return new Token(Kind.RPAREN);
            case '{':
                return new Token(Kind.LBRACE);
            case '}':
                return new Token(Kind.RBRACE);
            default:
                if((ch >= '0' && ch <= '9') || ch == '.'){
                    int dotNum = 0;//小数点数量
                    if(ch == '.'){
                        dotNum ++;
                    }
                    int chStart = idx;
                    while(++idx < inStream.length){
                        if(inStream[idx] < '0' || inStream[idx] > '9' ){
                            if(inStream[idx] == '.' && dotNum == 0){
                                dotNum ++;
                                continue;
                            }else if(inStream[idx] == '.'){
                                throw new LexerException(inStream, idx);
                            }else{
                                break;
                            }
                        }
                    }

                    if(dotNum == 0){
                        return new Token(Kind.INT, inStream, chStart, idx--);
                    }else if(dotNum == 1){
                        return new Token(Kind.DOUBLE, inStream, chStart, idx--);
                    }
                }else if(true){

                }else{
                    throw new LexerException(inStream, idx);
                }
        }
        return null;
    }

    public void scan(char[] inStream){

        while(++idx < inStream.length){
            Token token = read(inStream);
            if(token != null) {
                tokens.add(token);
            }
        }
    }
}
