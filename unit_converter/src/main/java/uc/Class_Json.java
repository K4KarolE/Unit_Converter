package uc;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;



public class Class_Json {

    static JsonNode jsonNode;
    static HashMap<String,HashMap<String,Integer>> mapLastUsedUnits;

    static File jsonFile = new File("./unit_converter/src/main/resources/LastUsedUnits.json");
    static ObjectMapper objectMapper = new ObjectMapper();


    static void setIndentForObjectMapper() {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }


    static void generateJsonNode() {
        try {
            jsonNode = objectMapper.readTree(jsonFile);
        } catch (IOException e) {System.out.println("\nERROR: JSON path is not valid.\n");}
    }


    static HashMap<String,HashMap<String,Integer>> generateMapFromJsonNode() {
        return objectMapper.convertValue(jsonNode, HashMap.class);
    }


    static Integer[] getMapValue(Integer UnitNumber) {
        String UnitNumberString = Integer.toString(UnitNumber);
        Integer convert_unit_from =  mapLastUsedUnits.get(UnitNumberString).get("convert_unit_from");
        Integer convert_unit_to =  mapLastUsedUnits.get(UnitNumberString).get("convert_unit_to");
        Integer[] unitsIntArray =  {convert_unit_from, convert_unit_to};
        return unitsIntArray;
    }

    static void writeToMap(Integer UnitNumber, Integer convert_unit_from, Integer convert_unit_to) {
        String UnitNumberString = Integer.toString(UnitNumber);
        mapLastUsedUnits.get(UnitNumberString).put("convert_unit_from", convert_unit_from);
        mapLastUsedUnits.get(UnitNumberString).put("convert_unit_to", convert_unit_to);
    }


    static void generateJsonNodeFromMap() {
        jsonNode = objectMapper.convertValue(mapLastUsedUnits, JsonNode.class);
    }


    static void writeJson(Integer UnitNumber) {
        try {
            objectMapper.writeValue(jsonFile, jsonNode);
        }
        catch (Exception e) {System.out.println("\nERROR: Could not write JSON file.\n");}
    }


    public static void getMapFromJsonGrouped() {
        setIndentForObjectMapper();
        generateJsonNode();
        mapLastUsedUnits = generateMapFromJsonNode();
    }


    public static void editMapWriteJsonGrouped(Integer UnitNumber, Integer convert_unit_from, Integer convert_unit_to) {
        writeToMap(UnitNumber, convert_unit_from, convert_unit_to);
        generateJsonNodeFromMap();
        writeJson(UnitNumber);
    }
    
}
