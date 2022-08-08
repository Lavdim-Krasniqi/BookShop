package elbatech.bookshop.page.Controller;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.page.Entity.Page;
import elbatech.bookshop.page.Service.PageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/page")
@AllArgsConstructor
public class PageController {

    PageService pageService;

    @PostMapping("/addPage")
    public Page addPage(@RequestBody Page page) {
        return pageService.addPage(page);
    }

    @DeleteMapping("/deletePage/{id}")
    public DeleteResult deletePage(@PathVariable(value = "id") String id) {
        return pageService.deletePage(id);
    }

    @PutMapping("/editPage/{id}")
    public Page editPage(@RequestBody Page page, @PathVariable(value = "id") String id) {
        return pageService.editPage(page);
    }

    @GetMapping("/getPageById/{id}")
    public Page getPageById(@PathVariable(value = "id") String id) {
        return pageService.getPageById(id);
    }

    @GetMapping("/getAllPages/{page}/{size}")
    public org.springframework.data.domain.Page<Page> getAllPages(@PathVariable Integer page, @PathVariable Integer size) {
        return pageService.getAllPages(page, size);
    }
}