package com.pain.flame.lab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String text = "<input high=\"20\" weight=\"70\">test</input>";
        String reg="(?:<input.*?>)(.*?)(?:</input>)";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.groupCount());
        }
    }
}
