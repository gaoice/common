package com.gaoice.common.json;

import com.google.common.reflect.TypeToken;
import org.junit.Test;

/**
 * @author gaoice
 */
public class JsonUtilsTests {

    @Test
    public void test() {
        // json test
        String s = "小明";
        int num = 123;
        TestObject<String> to = new TestObject<>();

        String json = JsonUtils.toJson(to);
        assert json.equals("{}");

        to.setName(s);
        json = JsonUtils.toJson(to);
        assert json.equals("{\"name\":\"" + s + "\"}");

        json = "{\"name\":\"" + s + "\",\"address\":\"" + s + "\",\"num\":" + num + ",\"testObject\":{\"name\":\"" + s + "\"}}";
        assert JsonUtils.fromJson(json, new TypeToken<TestObject<String>>() {
        }).getName().equals(s);

        // JsonMap test
        JsonMap jsonMap = JsonUtils.jsonMap(json);

        assert jsonMap.getString("name").equals(s);
        assert jsonMap.getInteger("num").equals(num);
        assert jsonMap.getJsonMap("testObject").getString("name").equals(s);
        assert jsonMap.getString("asf") == null;
        assert jsonMap.getInteger("asf") == null;
        assert jsonMap.getJsonMap("asf") == null;
        assert jsonMap.getBean("asf", String.class) == null;
        assert jsonMap.getBean("asf", TestObject.class) == null;
        assert jsonMap.getInteger("asf", 1).equals(1);
        assert jsonMap.getBean("testObject", TestObject.class).getName().equals(s);
    }

    public static class TestObject<T> {

        private T name;

        public T getName() {
            return name;
        }

        public void setName(T name) {
            this.name = name;
        }
    }
}
