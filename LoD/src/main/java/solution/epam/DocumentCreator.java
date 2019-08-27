package solution.epam;

import solution.epam.domain.Document;
import solution.epam.domain.Paragraph;

import java.util.List;

public class DocumentCreator {

    public Document createDocument(List<Paragraph> paragraphs) {
        return new Document(paragraphs);
    }

}
