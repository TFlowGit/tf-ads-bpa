package com.techflow.openfda.drug.client;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.memory.MemoryIndex;
import org.apache.lucene.index.memory.PatternAnalyzer;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hit;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.RAMDirectory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;

public class DrugRepositoryImpl implements DrugRepository
{
	private RAMDirectory ramDir;

	public DrugRepositoryImpl(String fileName)
			throws IOException
	{
		//analyzer = PatternAnalyzer.DEFAULT_ANALYZER;
		Analyzer analyzer = new StandardAnalyzer();
		ramDir = new RAMDirectory();
		IndexWriter indexWriter = new IndexWriter(ramDir, analyzer, true);

		Scanner s = null;
		try {
			s = new Scanner(new File(fileName));
			while (s.hasNextLine()) {
				Document document = new Document();
				String drugName = s.nextLine();
				//System.out.println(drugName);
				document.add(new Field("name", drugName, Field.Store.YES, Field.Index.UN_TOKENIZED));
				document.add(new Field("UCNAME", drugName.toUpperCase(), Field.Store.NO, Field.Index.TOKENIZED));
				indexWriter.addDocument(document);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (s != null) {
				s.close();
			}
		}
		indexWriter.optimize();
		System.out.println("Buffered Docs: " + indexWriter.getMaxBufferedDocs() );
		System.out.println("Index Buffer Size MB: " + indexWriter.getRAMBufferSizeMB() );
		indexWriter.close();
	}

	@Override
	public List<String> startsWith(String drugName)
	{
		ArrayList<String> list = new ArrayList<String>();

		IndexSearcher indexSearcher;
		try {

			indexSearcher = new IndexSearcher(ramDir);
			Analyzer analyzer = new StandardAnalyzer();
			QueryParser queryParser = new QueryParser("UCNAME", analyzer);
			Query query = queryParser.parse(drugName);
			Hits hits = indexSearcher.search(query);
			//System.out.println("Number of hits: " + hits.length());

			Iterator<Hit> it = hits.iterator();
			while (it.hasNext()) {
				Hit hit = it.next();
				Document document = hit.getDocument();
				String name = document.get("name");
				System.out.println("Hit: " + name);
				list.add(name);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
