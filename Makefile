DIR=~/my_java_projects/algorithms
RES=$(DIR)/src/main/resources
LIB=~/my_java_projects/algs4-master/target/classes
TRG=target/classes
EX=com.maxdsc.chapter
e=9
a=
c=1_3
a_1_22_23=$(RES)/tinyAllowlist.txt < $(RES)/tinyText.txt 99
FILES=$(RES)/tinyAllowlist.txt < $(RES)/tinyText.txt
LARGE_FILES=~/my_java_projects/res_algorithms/largeAllowlist.txt < ~/my_java_projects/res_algorithms/largeText.txt

ex: compile
	java -cp $(LIB):$(TRG) $(EX)$(c).Exercise_$(e) $(a)
	
run:
	java -cp $(LIB):$(TRG) $(EX)$(c).Exercise_$(e) $(a)

compile:
	mvn compile

