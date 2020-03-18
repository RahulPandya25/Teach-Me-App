package com.teach.me.app.Service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface ParsingExcelFileService {

    void readFile() throws IOException, InvalidFormatException;
}
