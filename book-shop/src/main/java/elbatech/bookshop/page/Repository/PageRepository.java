package elbatech.bookshop.page.Repository;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.page.Entity.Page;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class PageRepository {

    MongoTemplate repo;

    public Page addPage(Page page) {
        return repo.save(page);
    }

    public DeleteResult deletePage(String id) {
        Query query = new Query(Criteria.where(Page.ID).is(id));
        return repo.remove(query, Page.class);
    }


    public Page getPageById(String id) {
        return repo.findById(id, Page.class);
    }

    public org.springframework.data.domain.Page<Page> getAllPages(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Query query = new Query();
        query.with(pageable);

        return PageableExecutionUtils.getPage(
                repo.find(query, Page.class),
                pageable,
                () -> repo.count(query.skip(0).limit(0), Page.class)
        );

    }

    public Page editPage(Page page) {
        return repo.save(page, "page");
    }

    public boolean doesExists(Integer pageNumber, String bookId) {
        val c1 = Criteria.where(Page.PAGE_NUMBER).is(pageNumber);
        val c2 = Criteria.where(Page.BOOK_ID).is(bookId);

        return repo.exists(Query.query(new Criteria().andOperator(c1, c2)), Page.class);
    }
}
