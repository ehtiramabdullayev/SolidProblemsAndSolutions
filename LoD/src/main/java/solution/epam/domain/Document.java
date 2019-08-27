package solution.epam.domain;

import java.util.Collections;
import java.util.List;

public final class Document {

	private final List<Paragraph> paragraphs;

	public Document(final List<Paragraph> paragraphs) {
		this.paragraphs = paragraphs;
	}

	public Iterable<Paragraph> getParagraphs() {
		return Collections.unmodifiableCollection(paragraphs);
	}

	public void printDocument() {
		for (Paragraph paragraph : this.getParagraphs()) {
			for (Line line : paragraph.getLines()) {
				System.out.println(line.getContent());
			}
			System.out.println();
		}
	}


}
