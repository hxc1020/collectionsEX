package red.hxc.util;

import org.junit.Test;
import red.hxc.util.functional.Selector;

/**
 * Create by linhao3 on 2018/6/28.
 */
public class ExArrayListTest {

    @Test
    public void testMaxBy() {
        ExList<User> users = new ExArrayList<>();
        users.add(new User(1, 1, "1a"));
        users.add(new User(2, 2, "2a"));
        users.add(new User(3, 1, "3a"));
        users.add(new User(4, 5, "4a"));
        users.add(new User(5, 1, "5a"));
        users.add(new User(6, 111, "6a"));


        User user = users.maxBy(it -> it.age);
        System.out.println(user);
        System.out.println(users.first());
        System.out.println(users.first(it -> it.age == 5));
        System.out.println(users.sortedDescBy(it -> it.age));
        System.out.println(users.minBy(it -> it.id));

    }

    @Test
    public void testMaxByEmpty() {
        ExList<User> users = new ExArrayList<>();
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