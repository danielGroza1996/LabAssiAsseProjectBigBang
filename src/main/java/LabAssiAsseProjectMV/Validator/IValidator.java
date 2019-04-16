package LabAssiAsseProjectMV.Validator;
import LabAssiAsseProjectMV.Exceptions.ValidatorException;
public interface IValidator<E> {
    void validate(E entity) throws ValidatorException;
}