package solution.epam.domain;

import java.util.Collections;
import java.util.List;

public final class Paragraph {

    private final List<Line> lines;

    public Paragraph(final List<Line> lines) {
        this.lines = lines;
    }

    public Iterable<Line> getLines() {
        return Collections.unmodifiableCollection(lines);
    }

}
