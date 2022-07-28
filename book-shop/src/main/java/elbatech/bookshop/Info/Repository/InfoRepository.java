package elbatech.bookshop.Info.Repository;

import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import elbatech.bookshop.Info.Entity.Info;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InfoRepository {
    @Autowired
    MongoTemplate repo;

    public Info addInfo(Info info) {
        return repo.save(info);
    }

    public Info editInfo(Info info) {
        return repo.save(info, "info");
    }

    public DeleteResult deleteInfo(String infoId) {
        Query query = new Query(Criteria.where(Info.ID).is(infoId));
        return repo.remove(query, Info.class);
    }

    public Info getInfobyId(String infoId) {
//      val c1 = Criteria.where(Info.ID).is(infoId);
        return repo.findById(infoId, Info.class);
    }

    public boolean getByBookIdAndEditionNumber(String bookId, Integer editionNumber) {
        val c1 = Criteria.where(Info.BOOK_ID).is(bookId).and(Info.EDITION_NUMBER).is(editionNumber);
        return repo.exists(Query.query(c1), Info.class);


    }

    public List<Info> getAllInfos(Info info) {
        return repo.findAll(Info.class);
    }
}
