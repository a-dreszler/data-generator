package pl.adreszler.datagenerator;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
class DataGeneratorService {
    
    List<List<String>> getDataTableRows(int entries, Map<String, List<String>> dataMap) {
        List<List<String>> dataTable = new ArrayList<>();
        List<String> headerRow = new ArrayList<>(dataMap.keySet());
        dataTable.add(headerRow);
        for (int i = 0; i < entries; i++) {
            List<String> row = new ArrayList<>();
            for (Map.Entry<String, List<String>> column : dataMap.entrySet()) {
                row.add(column.getValue().get(i));
            }
            dataTable.add(row);
        }

        return dataTable;
    }

    Map<String, List<String>> getDataMap(int entries, String lang, boolean firstNameFlag, boolean lastNameFlag,
                                         boolean universityFlag, boolean countryFlag) {
        Faker generator = new Faker(new Locale(lang));
        Map<String, List<String>> dataMap = new LinkedHashMap<>();
        if (firstNameFlag) {
            List<String> firstNames = Stream.generate(() -> generator.name().firstName())
                    .limit(entries)
                    .toList();
            dataMap.put("First name", firstNames);
        }
        if (lastNameFlag) {
            List<String> lastNames = Stream.generate(() -> generator.name().lastName())
                    .limit(entries)
                    .toList();
            dataMap.put("Last name", lastNames);
        }
        if (universityFlag) {
            List<String> universities = Stream.generate(() -> generator.university().name())
                    .limit(entries)
                    .toList();
            dataMap.put("Universities", universities);
        }
        if (countryFlag) {
            List<String> countries = Stream.generate(() -> generator.country().name())
                    .limit(entries)
                    .toList();
            dataMap.put("Countries", countries);
        }

        return dataMap;
    }
}
