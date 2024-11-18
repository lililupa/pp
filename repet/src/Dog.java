public class Dog extends Animal implements Voice{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.age = age;
        this.name = name;

    }

    public Dog() {
    }

    @Override
    public String toString() {
        return "возраст собаки " + age +
                " имя собаки "  + name ;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String say() {
        return "гав";
    }
}
