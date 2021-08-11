package com.wooseok.library.service;

import com.wooseok.library.model.NaverBookDTO;

public interface NaverBookService {

    public NaverBookDTO getBooks(String search);
}
