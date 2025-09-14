public class Person {
    private final int id;
    private String name;
    private int age;
    private String gender;
    private String phoneNumber;
    public Person(int id,String name,int age,String gender,String phoneNumber){
        this.id=id;
        this.name=name;
        this.gender=gender;
        this.age=age;
        this.phoneNumber=phoneNumber;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "The Person whose:{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone Number='" + phoneNumber + '\'' +
                '}'+"\n";
    }
}

