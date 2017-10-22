package demo.service.impl;

import demo.domain.SupplyLocation;
import demo.domain.SupplyLocationRepository;
import demo.service.SupplyLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplyLocationServiceImpl implements SupplyLocationService {

    private SupplyLocationRepository supplyLocationRepository;

    @Autowired
    public SupplyLocationServiceImpl(SupplyLocationRepository supplyLocationRepository){
        this.supplyLocationRepository = supplyLocationRepository;
    }

    @Override
    public List<SupplyLocation> saveSupplyLocationZipContains504(List<SupplyLocation> locations){
        return (ArrayList<SupplyLocation>)this.supplyLocationRepository.save(this.fillterList(locations,"504"));
    }

    private List<SupplyLocation> fillterList(List<SupplyLocation> listToFillter, String keyword){
        List<SupplyLocation> save = new ArrayList<>();
        for (SupplyLocation supplyLocation : listToFillter){
            if (supplyLocation.getZip().contains(keyword)){
                save.add(supplyLocation);
            }
        }
        return save;
    }
}
