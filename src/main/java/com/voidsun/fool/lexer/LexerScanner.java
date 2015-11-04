package com.voidsun.fool.lexer;

import com.voidsun.fool.exception.LexerException;
import com.voidsun.fool.util.Keyword;
import com.voidsun.fool.util.reader.CharReader;

import java.util.LinkedList;

/**
 * @Description
 * @Author voidsun
 * @Date 2015/8/19
 * @Email voidsun@126.com
 */
public class LexerScanner {
    private LinkedList<Token> tokens = new LinkedList<>();

    public Token getToken(){
        return tokens.pollFirst();
    }

    public void scan(CharReader reader){
        while(reader.hasNext()){
            char c = reader.read();
            if(c == Keyword.SPACE){
                continue;
            }else if((c>='0' && c<='9') || c=='.'){
                readNumber(c, reader);
            }else if(Sign.mayBeSign(c)){
                readSign(c, reader);
            }else{
                throw new LexerException(reader);
            }
        }
    }

    private void readNumber(char c, CharReader reader){
        StringBuilder build = new StringBuilder();
        int dotNum = 0;
        if(c == '.') dotNum++;
        build.append(c);
        while(reader.hasNext()){
            c = reader.read();
            if(c == '.' && dotNum==0){
                dotNum++;
            }else if(c == Keyword.SPACE){
                break;
            }else if(c<'0' || c>'9'){
                throw new LexerException(reader);
            }
            build.append(c);
        }
        if(dotNum == 0){
            tokens.add(new Token(Kind.LONG, build.toString()));
        }else{
            tokens.add(new Token(Kind.DOUBLE, build.toString()));
        }
    }

    private void readSign(char c, CharReader reader){
        int startIndex = reader.getIndex() - 1;
        StringBuilder build = new StringBuilder();
        build.append(c);
        Sign.SignTreeNode next = Sign.nextNode(c);
        while(reader.hasNext() && next!=null){
            c = reader.read();
            if(c == Keyword.SPACE){
                break;
            }
            if(next.mayBeSign(c)){
                next = next.nextNode(c);
                build.append(c);
                continue;
            }
            reader.backStep();
            break;
        }
        Sign sign = Sign.findSign(build.toString());
        if(sign == null) throw new LexerException(build.toString(), startIndex);
        tokens.add(new Token(Kind.SIGN, build.toString()));
    }
}
