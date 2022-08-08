package elbatech.bookshop.Page.Repository;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Page.Entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PageRepository {

    @Autowired
    MongoTemplate repo;
    public Page addPage(Page page) {
       return repo.save(page);
    }

    public DeleteResult deletePage(String id) {
        Query query = new Query(Criteria.where(Page.ID).is(id));
        return repo.remove(query,Page.class);
    }



    public Page getPageById(String id) {
        return repo.findById(id,Page.class);
    }

    public List<Page> getAllPages() {
        return repo.findAll(Page.class);
    }

    public Page editPage(Page page) {
        return repo.save(page,"page");
    }
}
