package com.damola.tech.utils;

import java.util.List;

/**
 * Created by Omoede.Aihe on 3/21/2017.
 */
public interface IFileGenerator extends AutoCloseable{

    void open();
    void createActiveHeaders(List<?> list, List<String> dataFieldNames);
    void appendActiveRow(List<?> list, List<String> dataFieldNames);
    void appendBlank(int num);
	void resizeColumns(Class<?> classType, List<String> dataFieldNames) throws Exception;
}
