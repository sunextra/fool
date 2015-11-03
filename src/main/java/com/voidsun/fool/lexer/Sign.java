package com.voidsun.fool.lexer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author voidsun
 * @Date 2015/11/3
 * @Email voidsun@126.com
 */
public enum Sign {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    LPARENT("("),
    RPARENT(")"),
    AND("&&"),
    OR("||"),
    LARGETHANOREQUAL(">="),
    LARGETHAN(">")
    ;

    private String sign;

    Sign(String sign){
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    private static SignTreeNode root;
    private static Map<String, Sign> signMap;

    public static class SignTreeNode{
        private Map<Character, SignTreeNode> childrenMap = new HashMap<>();

        public void addChildren(Character c, SignTreeNode node){
            childrenMap.put(c, node);
        }
        public boolean mayBeSign(Character c){
            return childrenMap.get(c) != null;
        }

        public SignTreeNode(Character c, SignTreeNode parent) {
            parent.addChildren(c, this);
        }

        public SignTreeNode() {
        }

        public SignTreeNode nextNode(Character c){
            return childrenMap.get(c);
        }

        public void link(String s){
            SignTreeNode parent = this;
            for(char c : s.toCharArray()){
                parent = new SignTreeNode(c, parent);
            }
        }
    }
    static{
        root = new SignTreeNode();
        signMap = new HashMap<>();
        for(Sign sign : Sign.values()){
            signMap.put(sign.getSign(), sign);
            root.link(sign.getSign());
        }
    }
    public static Sign findSign(String sign){
        return signMap.get(sign);
    }
    public static boolean mayBeSign(Character c){
        return root.mayBeSign(c);
    }
    public static SignTreeNode nextNode(Character c){
        return root.nextNode(c);
    }
}
