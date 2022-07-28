package elbatech.bookshop.Info.Controller;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Info.Entity.Info;
import elbatech.bookshop.Info.Service.ServiceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    ServiceInfo serviceInfo;

    @PostMapping("/addInfo")
    public Info addInfo(@RequestBody Info info){
        return serviceInfo.addInfo(info);
    }

    @PutMapping("/editInfo/{id}")
    public Info editInfo(@RequestBody Info info, @PathVariable (value = "id") String id){
        return serviceInfo.editInfo(info);
    }

    @DeleteMapping("/deleteInfo/{infoId}")
    public DeleteResult deleteInfo(@PathVariable (value = "infoId") String infoId){
        return serviceInfo.deleteInfo(infoId);
    }

    @GetMapping("/getInfobyId/{infoId}")
    public Info getInfobyId(@PathVariable(value = "infoId") String infoId){
        return serviceInfo.getInfobyId(infoId);
    }

    @GetMapping("/getAllInfos")
    public List<Info> getAllInfos(Info info){
        return serviceInfo.getAllInfos(info);
    }


}
