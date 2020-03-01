package springpackage.utils;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
	
	public static List<Object> readFromCsvFile(InputStream inputStream, Class<?> c) throws Exception {
		CSVParser csvParser = CSVParser.parse(inputStream,
				Charset.defaultCharset(), CSVFormat.DEFAULT.withFirstRecordAsHeader());
		Stream<CSVRecord> csvRecordStream = StreamSupport.stream(csvParser.spliterator(), true);
		List<Map<String, String>> rowList = csvRecordStream
				.map(csvRecord -> csvRecord.toMap())
				.collect(Collectors.toList());
		return convertMapToListObject(rowList, c);
	}
	
	private static List<Object> convertMapToListObject(List<Map<String, String>> map, Class<?> c){
		ObjectMapper mapper = new ObjectMapper();
		List<Object> listObject = new ArrayList<>();
		JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, Object.class);
		listObject = mapper.convertValue(map, javaType);
		return listObject;
	}
}