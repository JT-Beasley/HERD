import java.io.IOException;

/**
 *
 * @author jerensuzuki
 */
public interface DataReader {
    void load() throws IOException, ClassNotFoundException;
    public EventSystem getEventSystem();
    void save(EventSystem eventsystem) throws IOException;
}
