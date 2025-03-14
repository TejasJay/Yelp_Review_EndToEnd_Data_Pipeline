-- Create table if it doesn’t exist
CREATE EXTERNAL TABLE IF NOT EXISTS yelp_reviews_csv (
    review_id STRING,
    user_id STRING,
    business_id STRING,
    stars FLOAT,
    useful INT,
    funny INT,
    cool INT,
    text STRING,
    date_ STRING
)
ROW FORMAT DELIMITED 
FIELDS TERMINATED BY ',' 
STORED AS TEXTFILE
LOCATION '/yelp_data/flume_csv/';

-- Insert new data from JSON table to CSV table
INSERT OVERWRITE TABLE yelp_reviews_csv 
SELECT * FROM yelp_reviews_json;
