#!/bin/bash
while true; do
    echo "Starting Sqoop export..."
    sqoop export \
    --connect jdbc:mysql://localhost:3306/yelp_db \
    --username root --password '<yourSQLpassword>' \
    --table yelp_reviews_csv \
    --export-dir /yelp_data/flume_csv \
    --input-fields-terminated-by ',' \
    --lines-terminated-by '\n' \
    --num-mappers 1 \
    --update-key review_id \
    --update-mode allowinsert
    echo "Export complete. Waiting 5 minutes before next run..."
    sleep 60  # Wait for 5 minutes before running again
done
