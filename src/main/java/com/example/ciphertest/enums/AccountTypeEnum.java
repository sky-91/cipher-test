package com.example.ciphertest.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountTypeEnum {
    /**
     * 地址
     */
    ADDRESS("address", "地址"),
    /**
     * 手机
     */
    PHONE("phone", "手机"),
    ;

    private String code;

    private String name;

    /**
     * 允许返回空
     *
     * @param code code
     * @return {@link AccountTypeEnum}
     */
    public static AccountTypeEnum parseOfNullable(String code) {
        if (code != null) {
            for (AccountTypeEnum e : values()) {
                if (e.code.equals(code)) {
                    return e;
                }
            }
        }
        return null;
    }

    /**
     * 允许返回空
     *
     * @param code code
     * @return name
     */
    public static String getNameNullable(String code) {
        AccountTypeEnum e = parseOfNullable(code);
        if (e != null) {
            return e.name;
        }
        return null;
    }
}
