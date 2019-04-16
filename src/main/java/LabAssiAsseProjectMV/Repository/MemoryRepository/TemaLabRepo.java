package LabAssiAsseProjectMV.Repository.MemoryRepository;
import LabAssiAsseProjectMV.Validator.IValidator;
import LabAssiAsseProjectMV.Domain.TemaLab;

public class TemaLabRepo extends AbstractCrudRepo<Integer,TemaLab> {

    public TemaLabRepo(IValidator<TemaLab> v){

        super(v);
    }

    public void prelungireTermenLimita(TemaLab t,int saptCurenta){
        if(saptCurenta<=t.getSaptammanaPredarii()){
            t.setTermenLimita(t.getTermenLimita()+1);
            update(t);
        }
    }

}