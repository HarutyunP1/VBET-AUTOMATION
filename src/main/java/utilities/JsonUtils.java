package utilities;

import com.google.gson.*;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JsonUtils {
    private static final Logger LOGGER = Logger.getLogger(JsonUtils.class);


    /**
     * Convert to json from file
     *
     * @param file
     * @return
     * @throws FileNotFoundException
     */

    public static JsonElement fromFile(File file) throws FileNotFoundException {
        FileReader fileReader = new FileReader(file);
        return JsonParser.parseReader(fileReader);
    }


    /**
     * Convert to json from path(String)
     *
     * @param path
     * @return
     * @throws FileNotFoundException
     */
    public static JsonElement fromPath(String path) throws FileNotFoundException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        return JsonParser.parseReader(fileReader);
    }

    /**
     * Convert String with structure json to jsonObject
     *
     * @param jsonString
     * @return
     */
    public static JsonElement convertStringToJson(String jsonString) {
        JsonElement jsonObject = JsonParser.parseString(jsonString);
        return jsonObject;
    }

    public static JsonElement editValue(JsonElement jsonElement, String parentKey, String key, Object value) {
        Configuration configuration = Configuration.builder()
                .jsonProvider(new GsonJsonProvider())
                .mappingProvider(new JacksonMappingProvider())
                .build();
        String path = getPath(jsonElement, parentKey, key);
        if ("$".equals(path)) {
            return jsonElement;
        } else {
            path = path.substring(0, path.lastIndexOf(key)).concat(key);
            JsonElement parse = JsonParser.parseString(JsonPath.using(configuration).parse(jsonElement.toString()).set(path, value).jsonString());
            return parse;
        }
    }

    /**
     * Edit value of given key
     * * @param parentJson can be any child class of JsonElement
     *
     * @param path  path of exact value/node should be replaced, should be key1.key2.[0-n].key3.key3
     * @param value new value of given key
     * @return true if value was edited, false otherwise
     */

    public static JsonElement editValueWithPath(JsonElement parentJson, String path, Object value) {
        Configuration configuration = Configuration.builder()
                .jsonProvider(new GsonJsonProvider())
                .mappingProvider(new JacksonMappingProvider())
                .build();
        String jsonString = JsonPath.using(configuration).parse(parentJson.toString()).set("$." + path, value).jsonString();
        return JsonParser.parseString(jsonString);
    }

    /**
     * edit the value in json, edits value of give key only if key exists
     * NOTE: it does not replace given json but return new JsonElementObject
     * usage: jsonElement = edit(jsonElement, parentKey, key, value)
     *
     * @param jsonElement can be any child class of JsonElement
     * @param key         name of key in json
     * @param value       new value of given key
     * @return jsonElement with edited values
     */
    public static JsonElement editValue(JsonElement jsonElement, String key, Object value) {
        Configuration configuration = Configuration.builder()
                .jsonProvider(new GsonJsonProvider())
                .mappingProvider(new JacksonMappingProvider())
                .build();
        String path = getPath(jsonElement, key);
        if (!"$".equals(path)) {
            path = path.substring(0, path.lastIndexOf(key)).concat(key);
        }
        return JsonParser.parseString(JsonPath.using(configuration).parse(jsonElement.toString()).set(path, value).jsonString());
    }

    /**
     * Get path
     *
     * @param jsonElement
     * @param key
     * @return
     */
    private static String getPath(JsonElement jsonElement, String key) {
        List<String> paths = getPathsFromJson(jsonElement).stream().filter(item -> item.contains(key + ".")).collect(Collectors.toList());
        paths = paths.stream().filter(item -> item.startsWith(key) || item.contains("." + key + ".")).collect(Collectors.toList());
        if (paths.size() == 0) {
            LOGGER.info("json path containing  key : " + key + " is not found");
            return "$";
        }
        int itemPathAmount = (int) paths.get(0).chars().filter(ch -> ch == '.').count();
        int itemIndex = 0;
        for (int i = 0; i < paths.size(); i++) {
            int tempPathAmount = (int) paths.get(i).chars().filter(ch -> ch == '.').count();
            if (tempPathAmount < itemPathAmount) {
                itemPathAmount = tempPathAmount;
                itemIndex = i;
            }
        }
        return "$." + paths.get(itemIndex);
    }


    private static String getPath(JsonElement jsonElement, String parentKey, String key) {
        List<String> paths;
        paths = getPathsFromJson(jsonElement).stream().filter(item -> item.contains(parentKey + ".") && item.contains(key + ".")).collect(Collectors.toList());
        paths = paths.stream().filter(item -> item.startsWith(parentKey) || item.contains("." + parentKey + ".")).collect(Collectors.toList());
        if (paths.size() == 0) {
            paths = getPathsFromJson(jsonElement).stream().filter(item -> (item.contains(parentKey + ".")) && (item.startsWith(parentKey) || item.contains("." + parentKey + "."))).collect(Collectors.toList());
            if (paths.size() == 0) {
                return "$";
            }
        }
        int itemPathAmount = (int) paths.get(0).chars().filter(ch -> ch == '.').count();
        int itemIndex = 0;
        for (int i = 0; i < paths.size(); i++) {
            int tempPathAmount = (int) paths.get(i).chars().filter(ch -> ch == '.').count();
            if (tempPathAmount < itemPathAmount) {
                itemPathAmount = tempPathAmount;
                itemIndex = i;
            }
        }
        return "$." + paths.get(itemIndex);
    }

    /**
     * @param jsonElement to be parsed to paths
     * @return list of each item path
     */
    public static List<String> getPathsFromJson(JsonElement jsonElement) {
        List<String> paths = new ArrayList<>();
        convertJsonIntoPaths(jsonElement, paths, "", "");
        return paths;
    }


    private static void convertJsonIntoPaths(JsonElement json, List<String> paths, String curPath, String newPath) {
        curPath = curPath + "." + newPath;
        if (json instanceof JsonArray) {
            for (int i = 0; i < ((JsonArray) json).size(); i++) {
                convertJsonIntoPaths(((JsonArray) json).get(i), paths, curPath, "[" + i + "]");
            }
        } else if (json instanceof JsonObject) {
            Set<String> keys = ((JsonObject) json).keySet();
            for (String currentKey : keys) {
                convertJsonIntoPaths(((JsonObject) json).get(currentKey), paths, curPath, currentKey);
            }
        } else if (json instanceof JsonPrimitive || json instanceof JsonNull) {
            String item = curPath + "." + json;
            item = item.substring(2);
            paths.add(item);
        }
    }

    /**
     * get value of given key
     *
     * @param jsonElement json to get value from
     * @param key         name of key in json
     * @return value of given key, can be JsonElement or JsonPrimitive
     */
    public static JsonElement getValue(JsonElement jsonElement, String key) {
        if (jsonElement instanceof JsonArray) {
            return getValue(jsonElement, null, key);
        } else if (jsonElement instanceof JsonObject) {
            JsonElement result = ((JsonObject) jsonElement).get(key);
            if (result != null) {
                return result;
            } else return getValue(jsonElement, null, key);
        } else {
            LOGGER.info("Value with key : " + key + " is not found ");
            return null;
        }
    }

    /**
     * get value of given key
     *
     * @param jsonElement json to get value from
     * @param parentKey   name of parent key in json
     * @param key         name of key in json
     * @return value of given key, can be JsonElement or JsonPrimitive
     */
    public static JsonElement getValue(JsonElement jsonElement, String parentKey, String key) {
        JsonElement result = null;
        if (jsonElement instanceof JsonObject) {
            result = getValue(((JsonObject) jsonElement).get(parentKey), key);
        }
        if (result != null) return result;

        JsonElement[] searchedJsonNode = new JsonElement[1];
        if (parentKey != null) {
            try {
                getRecNode(jsonElement, parentKey, searchedJsonNode);
            } catch (Exception ignored) {
                //ignore
            }
        } else {
            searchedJsonNode[0] = jsonElement;
        }
        JsonElement[] searchedJsonValue = new JsonElement[1];
        try {
            getRecValue(searchedJsonNode[0], key, searchedJsonValue);
        } catch (Exception ignored) {
            //ignore
        }
        result = searchedJsonValue[0];
        if (result == null) {
            LOGGER.info("Value with key : " + key + " is not found ");
        }
        return result;
    }


    private static void getRecNode(JsonElement json, String key, JsonElement[] values) throws Exception {
        if (json instanceof JsonArray) {
            for (int i = 0; i < ((JsonArray) json).size(); i++) {
                getRecNode(((JsonArray) json).get(i), key, values);
            }
        } else if (json instanceof JsonObject) {
            Set<String> keys = ((JsonObject) json).keySet();
            Iterator<String> iterator = keys.iterator();
            while (iterator.hasNext()) {
                String currentKey = iterator.next();
                if (currentKey.equals(key)) {
                    values[0] = ((JsonObject) json).get(currentKey);
                    throw new Exception();
                }
                getRecNode(((JsonObject) json).get(currentKey), key, values);
            }
        } else if (json instanceof JsonPrimitive) {
        }
    }

    private static void getRecValue(JsonElement json, String key, JsonElement[] values) throws Exception {
        if (json instanceof JsonArray) {
            for (int i = 0; i < ((JsonArray) json).size(); i++) {
                getRecValue(((JsonArray) json).get(i), key, values);
            }
        } else if (json instanceof JsonObject) {
            Set<String> keys = ((JsonObject) json).keySet();
            for (String currentKey : keys) {
                if (currentKey.equals(key)) {
                    values[0] = ((JsonObject) json).get(currentKey);
                    throw new Exception();
                }
                getRecValue(((JsonObject) json).get(currentKey), key, values);
            }
        } else if (json instanceof JsonPrimitive) {
        }
    }


}


