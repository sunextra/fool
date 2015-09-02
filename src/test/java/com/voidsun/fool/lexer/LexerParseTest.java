package com.voidsun.fool.lexer;

import org.junit.Test;

import java.io.*;
import java.net.URLClassLoader;

/**
 * @Description
 * @Author voidsun
 * @Date 2015/8/19
 * @Email voidsun@126.com
 */
public class LexerParseTest {
    @Test
    public void test() throws IOException {
        File file = new File(URLClassLoader.getSystemResource("fool").getPath());
        InputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[(int)file.length()];
        inputStream.read(bytes);
        String s = new String(bytes);
        Lexer lexerParse = new Lexer();
        lexerParse.scan(s.toCharArray());
        for(Token token : lexerParse.getTokens()){
            System.out.println(token);
        }
    }


}
