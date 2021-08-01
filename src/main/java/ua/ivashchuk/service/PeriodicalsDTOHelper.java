package ua.ivashchuk.service;

//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.web.multipart.MultipartFile;
import ua.ivashchuk.domain.Periodical;

import java.io.IOException;
import java.util.Base64;

public class PeriodicalsDTOHelper {

    public static Periodical createEntity(MultipartFile file, String name, String description, Double price) throws IOException {
        Periodical periodical = new Periodical();
        periodical.setName(name);
        periodical.setDescription(description);
        periodical.setPrice(price);
        periodical.setImage(file.getBytes());
        periodical.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));


        return periodical;
    }
}
