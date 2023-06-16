package pl.adreszler.datagenerator;

import java.util.List;
import java.util.Map;

class DataGeneratorDto {

    private Map<String, List<String>> dataMap;
    private int entries;

    public DataGeneratorDto(Map<String, List<String>> dataMap, int entries) {
        this.dataMap = dataMap;
        this.entries = entries;
    }

    public Map<String, List<String>> getDataMap() {
        return dataMap;
    }

    public int getEntries() {
        return entries;
    }
}