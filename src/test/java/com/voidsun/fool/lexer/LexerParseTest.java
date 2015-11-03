package com.voidsun.fool.lexer;

import com.voidsun.fool.util.reader.StringCharReader;
import org.junit.Test;

import java.io.*;

/**
 * @Description
 * @Author voidsun
 * @Date 2015/8/19
 * @Email voidsun@126.com
 */
public class LexerParseTest {
    @Test
    public void test() throws IOException {
        LexerScanner lexerParse = new LexerScanner();
        lexerParse.scan(new StringCharReader("1 +&& 5.25"));
        for(Token token : lexerParse.getTokens()){
            System.out.println(token);
        }
    }
}
