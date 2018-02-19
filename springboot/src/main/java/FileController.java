//https://github.com/salmana1/aurelia-springboot
// viidatud giti repo kasutab vanemat springi versiooni ja on kaasanud lisaks väga palju väliseid dipendancies, seega copy-past otse ei tööta, kuid väga hea materjal muidu






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


@RestController
@RequestMapping("/api")
public class FileController {

    @Autowired
    private StorageService storageService;



    //should be one of the ways how to get post request data
    //should work well without value parameter
    @RequestMapping(
            value = "/process",
            method = RequestMethod.POST)
    public void process(@RequestBody Map<String, Object> payload)
            throws Exception {

        System.out.println(payload);

    }


    //Solution 2: otherwise you can get the POST payload as a String
    //should work well without value parameter
    @RequestMapping(
            value = "/process",
            method = RequestMethod.POST,
            consumes = "text/plain")
    public void process(@RequestBody String payload) throws Exception {

        System.out.println(payload);

    }


    //and another way
    @PostMapping("/file")
    public ResponseEntity addFile(UserFile userFile, @RequestParam("file") MultipartFile file) {
        storageService.add(userFile, file);

        ResponseEntity response = new ResponseEntity(HttpStatus.OK);
        return response;
    }


    @GetMapping("/files")
    public Page<UserFile> getFiles(Pageable pageable) {

        Page<UserFile> files = storageService.findAll(pageable);

        return files;
    }


    @GetMapping("/file/{id}")
    public Resource serveFile(@PathVariable String id) {

        Resource file = storageService.findOne(id);

        return file;
    }
}