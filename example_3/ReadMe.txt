Problem statement: We will use the movie datasets here. The datasets are located under /tmp/HW_3_Data/partition (the file names are 2009, 2010 and 2011) in the Local Unix System. Please use this folder and don’t copy to any other folder on the server. The path contains three files for the partitioned years 2009, 2010 and 2011. The datasets are semi-colon(;) separated and each line has the following 3 columns MovieID;Title;Genres

Requirement:
Using Hive script, 
i.  create one table partitioned by year. (show the create table command) 
ii. load data from local unix directory (specified in the dataset) using three insert commands. 
iii. create a Hive query that selects all columns from the table for the virtual column year of 2009).


How to execute?
hive -f example_3.hive