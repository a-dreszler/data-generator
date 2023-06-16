package pl.adreszler.datagenerator;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Service
class DataGeneratorService {

    Map<String, List<String>> getDataMap(int entries, String lang, boolean firstNameFlag, boolean lastNameFlag,
                                         boolean universityFlag, boolean countryFlag) {
        Faker generator = new Faker(new Locale(lang));
        Map<String, List<String>> dataMap = new LinkedHashMap<>();
        if (firstNameFlag) {
            dataMap.put("First name", generateData(entries, generator.name()::firstName));
        }
        if (lastNameFlag) {
            dataMap.put("Last name", generateData(entries, generator.name()::lastName));
        }
        if (universityFlag) {
            dataMap.put("Universities", generateData(entries, generator.university()::name));
        }
        if (countryFlag) {
            dataMap.put("Countries", generateData(entries, generator.country()::name));
        }

        return dataMap;
    }

    private List<String> generateData(int entries, Supplier<String> supplier) {
        return Stream.generate(supplier)
                .limit(entries)
                .toList();
    }
}
