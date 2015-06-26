package com.techflow.openfda.drug.client;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hit;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.RAMDirectory;
import com.google.common.io.Resources;

public class DrugRepositoryImpl implements DrugRepository
{
	private static int MAX_HITS = 5;
	private	final URL repoUrl = Resources.getResource("brand-names.txt");
	private RAMDirectory ramDir;

	public DrugRepositoryImpl()
	{
		IndexWriter indexWriter = null;
		Analyzer analyzer = new StandardAnalyzer();
		ramDir = new RAMDirectory();

		try {
			indexWriter = new IndexWriter(ramDir, analyzer, true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Scanner s = null;
		try {
			s = new Scanner(new File(repoUrl.getFile()));
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
		
		try {
			indexWriter.optimize();
			//System.out.println("Buffered Docs: " + indexWriter.getMaxBufferedDocs() );
			//System.out.println("Index Buffer Size MB: " + indexWriter.getRAMBufferSizeMB() );
			indexWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

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
			int count = 1;
			while (it.hasNext()) {
				Hit hit = it.next();
				Document document = hit.getDocument();
				String name = document.get("name");
				//System.out.println("Hit: " + name);
				list.add(name);
				if (++count > MAX_HITS) {
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
