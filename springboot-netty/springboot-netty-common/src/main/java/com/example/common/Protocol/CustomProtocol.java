package com.example.common.Protocol;

import java.io.Serializable;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/13 9:44
 */
public class CustomProtocol implements Serializable {

    private static final long serialVersionUID = -323652305476748635L;
    private Long id;
    private String content;

    public CustomProtocol(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CustomProtocol{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
