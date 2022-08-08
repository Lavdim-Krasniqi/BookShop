package elbatech.bookshop.page.Service;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.book.services.BookService;
import elbatech.bookshop.page.Entity.Page;
import elbatech.bookshop.page.Repository.PageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PageService {

    PageRepository pageRepository;
    BookService bookService;

    public Page addPage(Page page) {
        if (bookService.doesExists(page.getBookId()))
            return pageRepository.addPage(page);

        throw new RuntimeException("Given book id does not exists in out database.");
    }

    public DeleteResult deletePage(String id) {
        return pageRepository.deletePage(id);
    }


    public Page getPageById(String id) {
        return pageRepository.getPageById(id);
    }

    public org.springframework.data.domain.Page<Page> getAllPages(Integer page, Integer size) {
        return pageRepository.getAllPages(page, size);
    }

    public Page editPage(Page page) {
        return pageRepository.editPage(page);
    }

    public boolean doesExists(Integer pageNumber, String bookId) {
        return pageRepository.doesExists(pageNumber, bookId);
    }
}
