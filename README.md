# CS7IS3-Projecf 1

The first individual assignment for CS7IS3-Information Retrieval.

## Author

**Mingwei**

- Email: mshi@tcd.ie

# My Project Root folder: `~/crandproject`.
## Postion in Azure for IP addrrss:Public IP address: 20.56.158.28

![Project poistion](https://github.com/mingweiiiiiiiiii/Crandproject/blob/master/crandproject/PoSITION.jpg)
## The project tree structure


```txt

├── ExternalFile
│   ├── cran.all.1400
│   └── cran.qry
├── FIG
│   └── standardA_VSB_Allfeature.png
├── MarkingRubrics.pdf
├── OUTPUTFILE
│   ├── outputa1-s1-f1.txt
│   ├── outputa1-s1-f2.txt
│   ├── outputa1-s1-f3.txt
│   ├── outputa1-s2-f1.txt
│   ├── outputa1-s2-f2.txt
│   ├── outputa1-s2-f3.txt
│   ├── outputa1-s3-f1.txt
│   ├── outputa1-s3-f2.txt
│   ├── outputa1-s3-f3.txt
│   ├── outputa2-s1-f1.txt
│   ├── outputa2-s1-f2.txt
│   ├── outputa2-s1-f3.txt
│   ├── outputa2-s2-f1.txt
│   ├── outputa2-s2-f2.txt
│   ├── outputa2-s2-f3.txt
│   ├── outputa2-s3-f1.txt
│   ├── outputa2-s3-f2.txt
│   ├── outputa2-s3-f3.txt
│   ├── outputa3-s1-f1.txt
│   ├── outputa3-s1-f2.txt
│   ├── outputa3-s1-f3.txt
│   ├── outputa3-s2-f1.txt
│   ├── outputa3-s2-f2.txt
│   ├── outputa3-s2-f3.txt
│   ├── outputa3-s3-f1.txt
│   ├── outputa3-s3-f2.txt
│   └── outputa3-s3-f3.txt
├── README.md
├── Report
│   └── InformationRetrivalReport_Cranfield.pdf
├── SelfDefienStopWord
│   ├── 173Stopwords.txt
│   ├── 495Stopwords.txt
│   ├── largeStopWords.txt
│   └── stopwords.txt
├── cran
│   ├── cran.all.1400
│   ├── cran.qry
│   ├── cranqrel
│   ├── cranqrel.readme
│   └── cranqrel_corrctedVerion
├── dataS
│   ├── Results.csv
│   ├── environemnt.xlsx
│   ├── latestData.csv
│   ├── newResult copy.csv
│   ├── newResult.csv
│   ├── sorted_data.csv
│   ├── www.csv
│   └── www.xls
├── dir
│   ├── _20.cfe
│   ├── _20.cfs
│   ├── _20.si
│   ├── segments_21
│   └── write.lock
├── execute.sh
├── myJar
│   └── crandproject.jar
├── out
│   └── artifacts
│       └── crandproject_jar
│           └── crandproject.jar
├── output
│   ├── cran.qry
│   └── cranqrel_corrctedVerion
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── org
│       │       └── example
│       │           ├── CranfildStructure.java
│       │           ├── DocumentParser.java
│       │           ├── Empty.java
│       │           ├── Main.java
│       │           ├── MyIndexer.java
│       │           ├── Stopremoval_173CustomisedAnalyzer.java
│       │           ├── Stopremoval_495CustomisedAnalyzer.java
│       │           ├── crandproject.jar
│       │           └── queryParser.java
│       └── resources
│           └── META-INF
│               └── MANIFEST.MF
├── target
│   ├── classes
│   │   ├── META-INF
│   │   │   └── MANIFEST.MF
│   │   └── org
│   │       └── example
│   │           ├── CranfildStructure.class
│   │           ├── DocumentParser.class
│   │           ├── Empty.class
│   │           ├── Main.class
│   │           ├── MyIndexer.class
│   │           ├── Stopremoval_173CustomisedAnalyzer.class
│   │           ├── Stopremoval_495CustomisedAnalyzer.class
│   │           └── queryParser.class
│   ├── crandproject-1.0-SNAPSHOT.jar
│   ├── generated-sources
│   │   └── annotations
│   ├── maven-archiver
│   │   └── pom.properties
│   ├── maven-status
│   │   └── maven-compiler-plugin
│   │       └── compile
│   │           └── default-compile
│   │               ├── createdFiles.lst
│   │               └── inputFiles.lst
│   └── original-crandproject-1.0-SNAPSHOT.jar
└── trec_eval-9.0.7
    ├── CHANGELOG
    ├── Makefile
    ├── bpref_bug
    ├── common.h
    ├── convert_zscores.c
    ├── form_prefs_counts.c
    ├── form_res_rels.c
    ├── form_res_rels_jg.c
    ├── formats.c
    ├── functions.h
    ├── get_prefs.c
    ├── get_qrels.c
    ├── get_qrels_jg.c
    ├── get_qrels_prefs.c
    ├── get_trec_results.c
    ├── get_zscores.c
    ├── m_11pt_avg.c
    ├── m_G.c
    ├── m_P.c
    ├── m_P_avgjg.c
    ├── m_Rndcg.c
    ├── m_Rprec.c
    ├── m_Rprec_mult.c
    ├── m_Rprec_mult_avgjg.c
    ├── m_binG.c
    ├── m_bpref.c
    ├── m_gm_bpref.c
    ├── m_gm_map.c
    ├── m_infap.c
    ├── m_iprec_at_recall.c
    ├── m_map.c
    ├── m_map_avgjg.c
    ├── m_map_cut.c
    ├── m_ndcg.c
    ├── m_ndcg_cut.c
    ├── m_ndcg_p.c
    ├── m_ndcg_rel.c
    ├── m_num_nonrel_judged_ret.c
    ├── m_num_q.c
    ├── m_num_rel.c
    ├── m_num_rel_ret.c
    ├── m_num_ret.c
    ├── m_prefs_avgjg.c
    ├── m_prefs_avgjg_Rnonrel.c
    ├── m_prefs_avgjg_Rnonrel_ret.c
    ├── m_prefs_avgjg_imp.c
    ├── m_prefs_avgjg_ret.c
    ├── m_prefs_num_prefs_ful.c
    ├── m_prefs_num_prefs_ful_ret.c
    ├── m_prefs_num_prefs_poss.c
    ├── m_prefs_pair.c
    ├── m_prefs_pair_imp.c
    ├── m_prefs_pair_ret.c
    ├── m_prefs_simp.c
    ├── m_prefs_simp_imp.c
    ├── m_prefs_simp_ret.c
    ├── m_recall.c
    ├── m_recip_rank.c
    ├── m_rel_P.c
    ├── m_relstring.c
    ├── m_runid.c
    ├── m_set_F.c
    ├── m_set_P.c
    ├── m_set_map.c
    ├── m_set_recall.c
    ├── m_set_rel_P.c
    ├── m_success.c
    ├── m_utility.c
    ├── m_yaap.c
    ├── meas_acc.c
    ├── meas_avg.c
    ├── meas_init.c
    ├── meas_print_final.c
    ├── meas_print_single.c
    ├── measures.c
    ├── sysfunc.h
    ├── test
    │   ├── out.test
    │   ├── out.test.a
    │   ├── out.test.aq
    │   ├── out.test.aqZ
    │   ├── out.test.aqc
    │   ├── out.test.aqcM
    │   ├── out.test.aql
    │   ├── out.test.meas_params
    │   ├── out.test.prefs
    │   ├── out.test.qrels_jg
    │   ├── out.test.qrels_prefs
    │   ├── prefs.rank20
    │   ├── prefs.results.test
    │   ├── prefs.test
    │   ├── qrels.123
    │   ├── qrels.rel_level
    │   ├── qrels.test
    │   ├── results.test
    │   ├── results.trunc
    │   └── zscores_file
    ├── trec_eval
    ├── trec_eval.c
    ├── trec_eval.dSYM
    │   └── Contents
    │       ├── Info.plist
    │       └── Resources
    │           └── DWARF
    │               └── trec_eval
    ├── trec_eval.h
    ├── trec_format.h
    └── utility_pool.c

39 directories, 188 files
```


## Running command

run `bash execute.sh` in the terminal .You could see the process from maven packaging,program execution, and evaluation.In ' execute.sh',I remove previous generated files such as "outputa1-s2-f2.txt".Executing mavn cleanning and packaging is the next step.Lastly,running `java -jar target/crandproject-1.0-SNAPSHOT.jar`  command is to comiple the project.

## Command for evalutation


echo "=== Customised analyzer(large stopword removal with 173 stopwords), VSM scoring, title ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa2-s1-f1.txt

Here we only extract precision after 5 documents and recall

## Requirement

| Configuration name   | Version of configuration |
|----------------------|--------------------------|
| Java version         | JDK 17                   |
| Maven version        | 3.9.4                    |
| Lucene version       | 8.1.0                    |
| GCC version          | 9.4.0                    |


## Stopwords source website

https://www.ranks.nl/stopwords
