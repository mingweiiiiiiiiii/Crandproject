rm -f output*.txt

mvn clean

mvn package


java -jar target/crandproject-1.0-SNAPSHOT.jar
echo "=== standard analyzer, VSM scoring, Title ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa1-s1-f1.txt
echo "=== standard analyzer, VSM scoring, Descrpton ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall ./output/cranqrel_corrctedVerion ./outputa1-s1-f2.txt
echo "=== standard analyzer, VSM scoring, TITLE + Descrpton ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall ./output/cranqrel_corrctedVerion ./outputa1-s1-f3.txt
echo "=== standard analyzer, bm25 scoring, Title ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa1-s2-f1.txt
echo "=== standard analyzer, bm25 scoring, Descrpton ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa1-s2-f2.txt
echo "=== standard analyzer, bm25 scoring, TITLE + Descrpton ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa1-s2-f3.txt
echo "=== standard analyzer, LMDirechet scoring  title ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa1-s3-f1.txt
echo "=== standard analyzer, LMDirechet scoring  Descrpton ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa1-s3-f2.txt
echo "=== standard analyzer, LMDirechet scoring TITLE+ Descrpton ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa1-s3-f3.txt



echo "=== Customised analyzer(large stopword removal with 173 stopwords), VSM scoring, title ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa2-s1-f1.txt
echo "=== Customised analyzer(large stopword removal with 173 stopwords), VSM scoring, Descrpton ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa2-s1-f2.txt
echo "=== Customised analyzer(large stopword removal with 173 stopwords), VSM scoring, title + Descrpton ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa2-s1-f3.txt
echo "=== Customised analyzer(large stopword removal with 173 stopwords), BM25 scoring,  title ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa2-s2-f1.txt
echo "=== Customised analyzer(large stopword removal with 173 stopwords), BM25 scoring,  Descrpton ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa2-s2-f2.txt
echo "=== Customised analyzer(large stopword removal with 173 stopwords), BM25 scoring, title + Descrpton ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa2-s2-f3.txt
echo "=== Customised analyzer((large stopword removal with 173 stopwords), LMDirechet scoring, title ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa2-s3-f1.txt
echo "=== Customised analyzer((large stopword removal with 173 stopwords), LMDirechet scoring, Descrpton ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa2-s3-f2.txt
echo "=== Customised analyzer(large stopword removal with 173 stopwords), LMDirechet scoring, title + Descrpton ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa2-s3-f3.txt



echo "=== Customised analyzer(large stopword removal with 495 stopwords), VSM scoring, Title ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa3-s1-f1.txt
echo "=== Customised analyzer(large stopword removal with 495 stopwords), VSM scoring, Descrpton ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa3-s1-f2.txt
echo "=== Customised analyzer(large stopword removal with 495 stopwords), VSM scoring, title + Descrpton ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa3-s1-f3.txt
echo "=== Customised analyzer(large stopword removal with 495 stopwords), BM25 scoring,  Title ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall ./output/cranqrel_corrctedVerion ./outputa3-s2-f1.txt
echo "=== Customised analyzer(large stopword removal with 495 stopwords), BM25 scoring,  Descrpton ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa3-s2-f2.txt
echo "=== Customised analyzer(large stopword removal with 495 stopwords), BM25 scoring, title + Descrpton ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa3-s2-f3.txt
echo "=== Customised analyzer((large stopword removal with 495 stopwords), LMDirechet scoring, Title ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa3-s3-f1.txt
echo "=== Customised analyzer((large stopword removal with 495 stopwords), LMDirechet scoring, Descrpton ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall ./output/cranqrel_corrctedVerion ./outputa3-s3-f2.txt
echo "=== Customised analyzer(large stopword removal with 495 stopwords), LMDirechet scoring, title + Descrpton ==="
./trec_eval-9.0.7/trec_eval -m P.5 -m set_recall  ./output/cranqrel_corrctedVerion ./outputa3-s3-f3.txt


#Finishing program animation
java ./src/main/java/org/example/Empty.java


