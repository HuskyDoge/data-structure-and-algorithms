package dfa.fst;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Jialun Li on 2019-03-03
 */
public class LuceneTest {
    public static void main(String[] args) throws IOException, ParseException, URISyntaxException {
        StandardAnalyzer analyzer = new StandardAnalyzer(); //自带停用词、lowercase filter
        Directory index = new RAMDirectory();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(index, config);
        List<String> dict = Files.readAllLines(Paths.get("/Users/jialunli/IntelliJ/IdeaProjects/data-structure-and-algorithms/src/main/java/dfa/fst/dictonary.txt"));
        for (String s : dict) {
            addDoc(indexWriter, s);
        }
        indexWriter.close();

        String[] targets = new String[]{
                "cliNical trial", "trial clinical",
                "TRIAL 动物 a", "trial a 动物",
                "BENIFIT（S）：受益",
                "药",
                "REGULATORY",
                "REGULATORY SPECIFICATION 质量",
                "REGULATORY SPECIFICATION 质量 NDA"
        };


        for (String target : targets) {
            doSearch(analyzer, index, target);
        }
    }

    private static void doSearch(StandardAnalyzer analyzer, Directory index, String target) throws ParseException, IOException {
        String queryString = new PhraseQuery("content", target).toString();
        Query query = new QueryParser("content", analyzer).parse(queryString);

        int hitsPerPage = 1000;
        IndexReader reader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(query, hitsPerPage);
        ScoreDoc[] hits = docs.scoreDocs;
        System.out.println("search word: " + target);
        StringBuilder sb = new StringBuilder("results: { \n");
        for (ScoreDoc hit : hits) {
            int docId = hit.doc;
            sb.append("\t").append(searcher.doc(docId).get("content")).append("\n");
        }
        sb.append("} \n");
        System.out.println(sb.toString());
    }


    private static void addDoc(IndexWriter w, String content) throws IOException {
        Document doc = new Document();
        doc.add(new TextField("content", content, Field.Store.YES));
        w.addDocument(doc);
    }
}
