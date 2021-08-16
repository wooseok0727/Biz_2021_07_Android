package com.wooseok.word.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.wooseok.word.dao.WordDao;
import com.wooseok.word.model.WordDTO;

import java.util.List;

/**
 * WordDao와 WordDTO 를 사용하여
 * DataBase 핸들링을 하는 중간 Service 클래스
 */
public class WordRepository {

    protected WordDao wordDao;
    protected LiveData<List<WordDTO>> wordList;

    /**
     * Application Context를 매개변수 갖는 생성자 필요
     */
    public WordRepository(Application application) {
    }

    /**
     * wordList를 단순히 return 하고 있는데
     * wordList 데이터를 가져오는 코드는 어디 ??
     *
     * 외주에서 repository.selectAll() method를 호출하면
     * 내부에서
     * 자동으로 Dao 를 거쳐 DB에 Select를 수행하고
     * 그 결과를 return 한다
     */
    public LiveData<List<WordDTO>> selectAll() {
        return wordList;
    }
    public void insert(WordDTO wordDTO) {
        wordDao.insert(wordDTO);
    }
    public void deleteAll() {
        wordDao.deleteAll();
    }
}
