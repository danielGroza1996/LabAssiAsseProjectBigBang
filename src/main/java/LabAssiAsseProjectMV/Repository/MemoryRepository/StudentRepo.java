package LabAssiAsseProjectMV.Repository.MemoryRepository;
import LabAssiAsseProjectMV.Validator.IValidator;
import LabAssiAsseProjectMV.Domain.Student;

public class StudentRepo extends AbstractCrudRepo<String, Student> {
    public StudentRepo(IValidator<Student> v){ super(v);
    }
}