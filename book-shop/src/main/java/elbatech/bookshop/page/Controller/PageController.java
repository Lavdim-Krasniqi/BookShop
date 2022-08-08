package elbatech.bookshop.Page.Controller;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Page.Entity.Page;
import elbatech.bookshop.Page.Service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.ServerEndpoint;
import java.util.List;

@RestController
@RequestMapping("/page")
public class PageController {

    @Autowired
    PageService pageService;

    @PostMapping("/addPage")
    public Page addPage(@RequestBody Page page){
        return pageService.addPage(page);
    }

    @DeleteMapping("/deletePage/{id}")
    public DeleteResult deletePage(@PathVariable (value = "id") String id){
        return pageService.deletePage(id);
    }

    @PutMapping("/editPage/{id}")
    public Page editPage(@RequestBody Page page, @PathVariable (value ="id") String id){
        return pageService.editPage(page);
    }

    @GetMapping("/getPageById/{id}")
    public Page getPageById(@PathVariable (value ="id")  String id){
        return pageService.getPageById(id);
    }

    @GetMapping("/getAllPages")
    public List<Page> getAllPages(){
        return pageService.getAllPages();
    }
}