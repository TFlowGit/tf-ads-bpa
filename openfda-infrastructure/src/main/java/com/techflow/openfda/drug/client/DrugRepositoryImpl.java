package com.techflow.openfda.drug.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
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

public class DrugRepositoryImpl implements DrugRepository
{

	private static final Logger logger = Logger.getLogger(DrugRepositoryImpl.class.getName());
	private static int MAX_HITS = 5;
	private RAMDirectory ramDir;

	 public DrugRepositoryImpl()
	{
		IndexWriter indexWriter = null;
		Analyzer analyzer = new StandardAnalyzer();
		ramDir = new RAMDirectory();

		try {
			indexWriter = new IndexWriter(ramDir, analyzer, true);
		} catch (Exception e) {
			logger.info("FATAL: Could not create indexWriter.",e);
		}

		Scanner s = null;
		try {
			s = new Scanner( this.getClass().getResourceAsStream("/brand-names.txt"));
			while (s.hasNextLine()) {
				Document document = new Document();
				String drugName = s.nextLine();
				document.add(new Field("name", drugName, Field.Store.YES, Field.Index.UN_TOKENIZED));
				document.add(new Field("UCNAME", drugName.toUpperCase(), Field.Store.NO, Field.Index.TOKENIZED));
				indexWriter.addDocument(document);
			}
		} catch (Exception e) {
			logger.info("ERROR: Exception scanning brand-names.txt",e);
		} finally {
			if (s != null) {
				s.close();
			}
		}
		
		try {
			indexWriter.optimize();
			logger.info("Index Buffer Size MB: " + indexWriter.getRAMBufferSizeMB() );
			indexWriter.close();
		} catch (Exception e) {
			logger.info("ERROR: Exception optimizing brand-names index.",e);
		}

	}

	@Override
	public List<String> startsWith(String drugName)
	{
		String searchName;
		List<String> list = new ArrayList<String>();

		if (!drugName.endsWith("*")) {
			searchName = drugName.concat("*");
		} else {
			searchName = drugName;
		}

		IndexSearcher indexSearcher;
		try {

			indexSearcher = new IndexSearcher(ramDir);
			Analyzer analyzer = new StandardAnalyzer();
			QueryParser queryParser = new QueryParser("UCNAME", analyzer);
			Query query = queryParser.parse(searchName);
			Hits hits = indexSearcher.search(query);

			@SuppressWarnings("unchecked")
			Iterator<Hit> it = hits.iterator();
			int count = 1;
			while (it.hasNext()) {
				Hit hit = it.next();
				Document document = hit.getDocument();
				String name = document.get("name");
				list.add(name);
				if (++count > MAX_HITS) {
					break;
				}
			}

		} catch (Exception e) {
			logger.info("ERROR: Exception searching brand-names.", e);
		}

		return list;
	}

}
