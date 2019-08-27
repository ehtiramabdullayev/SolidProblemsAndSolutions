package solution.epam;

import solution.epam.domain.Document;
import solution.epam.domain.Line;
import solution.epam.domain.Paragraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

	private void start(List<Paragraph> paragraphs) {
		Document document = new DocumentCreator().createDocument(paragraphs);
		document.printDocument();
	}


	public static void main(String[] args) {
		List<Paragraph> paragraphs = new ArrayList<Paragraph>();
		paragraphs.add(new Paragraph(Arrays.asList(new Line("A line."), new Line("Another line."))));
		paragraphs.add(new Paragraph(Arrays.asList(new Line("Second paragraph"))));
		paragraphs.add(new Paragraph(Arrays.asList(new Line("This is the end :("))));

		new Application().start(paragraphs);
	}

}
