package elbatech.bookshop.Page.Service;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Page.Entity.Page;
import elbatech.bookshop.Page.Repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageService {
    @Autowired
    PageRepository pageRepository;
    public Page addPage(Page page) {
        return pageRepository.addPage(page);
    }

    public DeleteResult deletePage(String id) {
        return pageRepository.deletePage(id);
    }



    public Page getPageById(String id) {
        return pageRepository.getPageById(id);
    }

    public List<Page> getAllPages() {
        return pageRepository.getAllPages();
    }

    public Page editPage(Page page) {
        return pageRepository.editPage(page);
    }
}
