import java.util.ArrayList;
import java.util.List;

public class Departement {
    private final int departementId;
    private String departementName;
    private List<Doctor> departementDoctors;
    private List<Patient> departementPatient;

    public Departement(int departementId, String departementName) {
        this.departementId = departementId;
        this.departementName = departementName;
        this.departementDoctors = new ArrayList<>();
        this.departementPatient = new ArrayList<>();

    }

    public int getDepartementId() {
        return departementId;
    }

    public List<Doctor> getDepartementDoctors() {
        return departementDoctors;
    }

    public List<Patient> getDepartementPatient() {
        return departementPatient;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "departementId=" + departementId +
                ", departementName='" + departementName + '\'' +
                ", departementDoctors=" + departementDoctors +
                ", departementPatient=" + departementPatient +
                '}';
    }
}