import java.time.OffsetDateTime;
import java.time.ZoneOffset;


public class UserFile {


    public String id;
    public String fileName;

    public String title;

    public String description;
    public OffsetDateTime creationTS;

    public String type;

    // convert to utc
    public void setCreationTS(String creationTS) {
        this.creationTS = OffsetDateTime.parse(creationTS).withOffsetSameInstant(ZoneOffset.UTC);
    }
}
