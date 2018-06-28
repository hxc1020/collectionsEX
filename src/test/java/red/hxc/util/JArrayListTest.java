package red.hxc.util;

import org.junit.Test;

/**
 * Create by linhao3 on 2018/6/28.
 */
public class JArrayListTest {

    @Test
    public void testMaxBy() {
        JList<User> users = new JArrayList<>();
        users.add(new User(1, 1, "a"));
        users.add(new User(1, 2, "a"));
        users.add(new User(1, 1, "a"));
        users.add(new User(1, 5, "a"));
        users.add(new User(1, 1, "a"));
        users.add(new User(1, 111, "a"));


        User user = users.maxBy(it -> it.age);
        System.out.println(user);

    }

    class User {
        Integer id;
        Integer age;
        String name;

        User(Integer id, Integer age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}