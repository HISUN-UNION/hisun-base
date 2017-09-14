package com.hisun.base.controller.databinder;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;

import java.beans.PropertyEditorSupport;

/**
 * <p>Title: StringEscapeEditor.java</p>
 * <p>Description: 自定义字符串转化，过滤特殊符号</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 湖南海数互联信息技术有限公司</p>
 *
 * @author Jason
 * @version v0.1
 * @email jason4j@qq.com
 * @date 2015-11-16 14:41
 */
public class StringEscapeEditor extends PropertyEditorSupport{

    private boolean escapeHTML;

    private boolean escapeJavaScript;

    private boolean escapeSQL;

    public StringEscapeEditor() { super(); }

    public StringEscapeEditor(boolean escapeHTML, boolean escapeJavaScript, boolean escapeSQL) {
        super();
        this.escapeHTML = escapeHTML;
        this.escapeJavaScript = escapeJavaScript;
        this.escapeSQL = escapeSQL;
    }


    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        //super.setAsText(text);
        if (text == null) {
            setValue(null);
        } else {
            String value = text;
            if (escapeHTML) {
                value = HtmlUtils.htmlEscape(value);
            }

            if (escapeJavaScript) {
                value = JavaScriptUtils.javaScriptEscape(value);
            }

            if (escapeSQL) {
                value = this.transactSQLInjection(value);
            }
            setValue(value);
        }
    }

    @Override
    public String getAsText() {
        Object value = getValue();
        return value != null ? value.toString() : "";
    }

    private String transactSQLInjection(String str) {
        if (StringUtils.isNotBlank(str)){
            //单引号(')，分号(;) 和 注释符号(--)
            return str.replaceAll(".*([']+|(--)+).*", " ");
        }else {
            return "";
        }
    }

}
