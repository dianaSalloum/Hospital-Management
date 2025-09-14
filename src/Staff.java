public class Staff extends Person{
    private String position;
    private double salaryWorker;

    public Staff(int id,String name,int age,String gender,String phoneNumber,String position,double salaryWorker){
        super(id, name, age, gender, phoneNumber);
        this.position=position;
        this.salaryWorker=salaryWorker;
    }

    @Override
    public String toString() {
        return super.toString()+
                "is a Staff whose{" +
                "position='" + position + '\'' +
                ", salary=" + salaryWorker +
                '}'+"\n";
    }
}
