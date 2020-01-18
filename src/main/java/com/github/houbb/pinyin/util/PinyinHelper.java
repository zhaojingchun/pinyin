package com.github.houbb.pinyin.util;

import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.pinyin.bs.PinyinBs;
import com.github.houbb.pinyin.constant.enums.PinyinStyleEnum;
import com.github.houbb.pinyin.spi.IPinyinTone;
import com.github.houbb.pinyin.support.mapping.PinyinToneStyles;

import java.util.List;

/**
 * 简化用于调用
 * @author binbin.hou
 * @since 0.0.1
 * @see com.github.houbb.pinyin.bs.PinyinBs 提供灵活性
 */
public final class PinyinHelper {

    private PinyinHelper(){}

    /**
     * 转换为拼音
     * @param string 原始信息
     * @return 结果
     * @since 0.0.1
     */
    public static String toPinyin(final String string) {
        return toPinyin(string, PinyinStyleEnum.DEFAULT);
    }

    /**
     * 转换为拼音
     * @param string 原始信息
     * @param styleEnum 样式枚举
     * @return 结果
     * @since 0.0.3
     */
    public static String toPinyin(final String string,
                                  final PinyinStyleEnum styleEnum) {
        if(StringUtil.isEmptyTrim(string)) {
            return string;
        }

        final IPinyinTone pinyinTone = PinyinToneStyles.getTone(styleEnum);
        return PinyinBs.newInstance()
                .pinyinTone(pinyinTone)
                .toPinyin(string);
    }


    /**
     * 返回拼音列表
     * @param chinese 中文字符
     * @return 结果
     * @since 0.0.2
     */
    public static List<String> toPinyin(final char chinese) {
        return PinyinBs.newInstance().toPinyin(chinese);
    }

}
