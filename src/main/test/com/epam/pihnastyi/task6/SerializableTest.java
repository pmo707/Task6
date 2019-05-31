package com.epam.pihnastyi.task6;

import com.epam.pihnastyi.task4.entity.Food;
import com.epam.pihnastyi.task4.entity.Product;
import com.epam.pihnastyi.task4.util.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

public class SerializableTest {
    private static final String SERIALIZE_PRODUCT_FILE_NAME_PATH = "test1File";
    private static final String GZIP_SERIALIZE_PRODUCT_FILE_NAME_PATH = "test2File";
    private static final int NUMBER_OF_ELEMENT_TO_ADD_INTO_MAP = 6;

    private Map<Integer, Product> map;

    public static void main(String[] args) throws IOException {

        SerializableTest test = new SerializableTest();
        test.setMap(test.fill());

        test.serializeProduct();
        test.gZIPSerializeProduct();

    }

    public Map<Integer, Product> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Product> map) {
        this.map = map;
    }

    private void serializeProduct() {
        System.err.println("Length Serialize start = " + new File(SERIALIZE_PRODUCT_FILE_NAME_PATH).length());
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERIALIZE_PRODUCT_FILE_NAME_PATH))) {
            for (int index = 0; index < 10; index++) {
                oos.writeObject(map);
            }
        } catch (IOException e) {
            System.err.println("Err Serialize");
        }
        System.err.println("Length Serialize end = " + new File(SERIALIZE_PRODUCT_FILE_NAME_PATH).length());
        new File(SERIALIZE_PRODUCT_FILE_NAME_PATH).delete();
    }

    private void gZIPSerializeProduct() {
        System.err.println("Length GZIPSerialize start = " + new File(GZIP_SERIALIZE_PRODUCT_FILE_NAME_PATH).length());
        try (ObjectOutputStream oos = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(GZIP_SERIALIZE_PRODUCT_FILE_NAME_PATH)))) {
            for (int index = 0; index < 10; index++) {
                oos.writeObject(map);
            }
        } catch (IOException e) {
            System.err.println("Err GZIPSerialize");
        }
        System.err.println("GZIPLength Serialize end = " + new File(GZIP_SERIALIZE_PRODUCT_FILE_NAME_PATH).length());
        new File(GZIP_SERIALIZE_PRODUCT_FILE_NAME_PATH).delete();
    }

    private Map<Integer, Product> fill() {
        Map<Integer, Product> map = new HashMap<>();
        for (int index = 1; index < NUMBER_OF_ELEMENT_TO_ADD_INTO_MAP; index++) {
            Food food = new Food();
            food.setId(index);
            food.setPrice(index * 100);
            food.setCountry(Util.randomWord(1, 100) + index);
            map.put(food.getId(), food);
        }
        return map;
    }
}
