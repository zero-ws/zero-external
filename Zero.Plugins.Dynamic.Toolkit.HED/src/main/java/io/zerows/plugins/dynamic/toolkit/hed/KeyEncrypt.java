package io.zerows.plugins.dynamic.toolkit.hed;

import io.vertx.up.util.Ut;

public class KeyEncrypt {
    public static void main(final String[] args) {
        final String encrypt = Ut.encryptRSAP("pl,okmijn123");
        System.out.println(encrypt);
    }
}
