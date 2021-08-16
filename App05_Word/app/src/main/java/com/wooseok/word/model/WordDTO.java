package com.wooseok.word.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


/**
 * 이 클래스는 DTO 역할을 수행하면서
 * table을 만들기 위한 구조화 model이다
 */
@Entity(tableName = "tbl_word")
public class WordDTO {
    @PrimaryKey
    @NonNull // android
    @ColumnInfo(name="word")
    private String word; // 영어단어

    @ColumnInfo(name="korea")
    private String korea; // 한글 뜻

    @NonNull
    public String getWord() {
        return word;
    }

    public void setWord(@NonNull String word) {
        this.word = word;
    }

    public String getKorea() {
        return korea;
    }

    public void setKorea(String korea) {
        this.korea = korea;
    }

    @Override
    public String toString() {
        return "WordDTO{" +
                "word='" + word + '\'' +
                ", korea='" + korea + '\'' +
                '}';
    }
}