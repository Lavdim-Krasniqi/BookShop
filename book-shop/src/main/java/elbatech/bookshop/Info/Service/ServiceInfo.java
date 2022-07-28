package elbatech.bookshop.Info.Service;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Info.Entity.Info;
import elbatech.bookshop.Info.Repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceInfo {

    @Autowired
    InfoRepository infoRepository;

    public Info addInfo(Info info) {
        return infoRepository.addInfo(info);
    }

    public Info editInfo(Info info) {
        return infoRepository.editInfo(info);
    }

    public DeleteResult deleteInfo(String infoId) {
        return infoRepository.deleteInfo(infoId);
    }

    public Info getInfobyId(String info) {
        return infoRepository.getInfobyId(info);
    }

    public List<Info> getAllInfos(Info info) {
        return infoRepository.getAllInfos(info);
    }

    public boolean getByBookIdAndEditionNumber(String bookId, Integer editionNumber) {
        return infoRepository.getByBookIdAndEditionNumber(bookId, editionNumber);
    }


}
